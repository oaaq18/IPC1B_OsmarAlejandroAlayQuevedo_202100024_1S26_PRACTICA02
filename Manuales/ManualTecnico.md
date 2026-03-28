# Manual Técnico — Carrera de Escobas
**Curso:** Introducción a la Programación y Computación 1 — USAC  
**Lenguaje:** Java | **IDE:** NetBeans | **Patrón:** MVC

---
---

**Estudiante:** Osmar Alejandro Alay Quevedo  
**Carné:** 202100024  
**Sección:** B  
**Fecha:** 27/03/2025

---

## 1. Arquitectura del Sistema

El proyecto sigue el patrón **Modelo-Vista-Controlador (MVC)**:

| Capa | Paquete | Responsabilidad |
|------|---------|-----------------|
| Modelo | `Modelo` | Datos y lógica de negocio |
| Vista | `Practica02.Vista` | Interfaces gráficas (Swing) |
| Controlador | `Practica02.Controlador` | Comunicación entre modelo y vista |

---

## 2. Estructura de Paquetes

```
Practica02/
├── Modelo/
│   ├── Corredor.java
│   ├── Premios.java
│   └── Partida.java
├── Practica02/
│   ├── Vista/
│   │   ├── MenuVista.java
│   │   ├── VistaAgregarJugador.java
│   │   ├── VistaSeleccionarJugador.java
│   │   ├── VistaCarrera.java
│   │   └── PanelPista.java
│   └── Controlador/
│       ├── ControladorMenu.java
│       ├── AgregarJugadorControlador.java
│       ├── SeleccionarJugadorControlador.java
│       ├── ControladorCarrera.java
│       └── ReportesControlador.java
```

---

## 3. Clases del Modelo

### `Corredor` — implements `Runnable`
Representa a un jugador en la carrera.

| Campo | Tipo | Descripción |
|-------|------|-------------|
| `Nombre` | String | Nombre del jugador |
| `PosicionX` | int | Posición horizontal (avance en pista) |
| `PosicionY` | int | Posición vertical (carril) |
| `tiempoDescanso` | int | Delay en ms entre cada movimiento |
| `EnCarrera` | boolean | Controla el ciclo del hilo |
| `puntos` | int | Puntos acumulados |
| `premios` | Premios[] | Referencia al arreglo de premios de la pista |
| `OnMove` | Runnable | Callback para repintar la vista |
| `LlegaraMeta` | Runnable | Callback al llegar a X=500 |

**Método `run()`:** Avanza 5px por ciclo, detecta colisiones con premios, llama `OnMove` y duerme `tiempoDescanso` ms.

### `Premios` — implements `Runnable`
Objetos coleccionables en la pista.

| Constante | Efecto |
|-----------|--------|
| `SNITCH ("S")` | +150 pts, mueve corredor a meta |
| `BLUDGER ("B")` | +200 ms de penalización |
| `QUAFFLE ("Q")` | +10 pts |

**Detección de colisión:** `colision(Corredor c)` compara bounding boxes de 30×30 (corredor) y 20×20 (premio).

### `Partida`
POJO que guarda el resultado de una carrera: jugador, oponente, escoba, puntos y ganador.

---

## 4. Clases del Controlador

### `AgregarJugadorControlador`
- Gestiona un arreglo `Corredor[10]`.
- Valida nombre no vacío y sin duplicados.
- Asigna delay según escoba: Nimbus 2000 → 300ms, Nimbus 2001 → 200ms, Saeta de Fuego → 100ms.

### `SeleccionarJugadorControlador`
- Llena el `JComboBox` con nombres de corredores registrados.
- Devuelve el `Corredor` seleccionado por nombre.

### `ControladorCarrera`
- Recibe jugador y oponente, los resetea y configura callbacks `OnMove` y `LlegaraMeta`.
- Crea arreglo de `Premios[]` con posiciones aleatorias.
- Lanza hilos con `new Thread(corredor).start()`.
- Al detectar llegada a meta, guarda `Partida` en `ReportesControlador`.

### `ControladorMenu`
- Punto central de coordinación: instancia todas las vistas y controladores.
- Gestiona flujo: Menú → Agregar Jugador → Seleccionar Jugador → Carrera → Historial.

### `ReportesControlador`
- Arreglo `Partida[50]` con contador `total`.
- Métodos: `guardarPartida()`, `getPartidas()`, `getTotal()`.

---

## 5. Clases de la Vista

### `PanelPista` — extends `JPanel`
- Sobreescribe `paintComponent(Graphics g)`.
- Dibuja jugador (rectángulo rojo), computadora (óvalo azul), premios (óvalo por tipo) y línea de meta en X=500.
- Se actualiza llamando `repaint()` desde el callback `OnMove`.

### `VistaCarrera` — extends `JFrame`
- Contiene `PanelPista` embebido como componente.
- Expone métodos: `setNombreJugador()`, `setEscobaJugador()`, `setTextoPuntaje()`, `setTextoCasa()`.
- Botones: Pausa (`jButton1`), Regresar (`BotonRegresar`).

### Otras vistas
- `MenuVista`: Botones Jugar, Agregar, Historial, Salir.
- `VistaAgregarJugador`: Campos Nombre, ComboBox Escoba y Casa.
- `VistaSeleccionarJugador`: ComboBox de jugadores registrados, botón Jugar.

---

## 6. Manejo de Hilos

- Cada `Corredor` se ejecuta en su propio `Thread`.
- Para evitar acumulación de hilos entre carreras, se guardan referencias y se llama `join()` antes de lanzar nuevos hilos.
- El callback `OnMove` llama `SwingUtilities.invokeLater(() -> panel.repaint())` para actualizar la UI desde el hilo de cada corredor de forma segura.

---

## 7. Dependencias

| Biblioteca | Uso |
|-----------|-----|
| Java Swing | Interfaz gráfica |
| JFreeChart | Gráficas de puntajes |
| iTextPDF | Generación de reportes PDF |

---

## 8. Flujo de Ejecución

```
main()
  └─ MenuVista.setVisible(true)
       └─ ControladorMenu
            ├─ Agregar Jugador → AgregarJugadorControlador
            ├─ Jugar → SeleccionarJugadorControlador
            │             └─ ControladorCarrera.prepararCarrera()
            │                  └─ Thread(jugador).start()
            │                  └─ Thread(oponente).start()
            │                       └─ Al llegar meta → guardarPartida()
            └─ Historial → ReportesControlador.getPartidas()
```