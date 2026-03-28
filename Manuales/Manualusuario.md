# Manual de Usuario — Carrera de Escobas
**Curso:** Introducción a la Programación y Computación 1 — USAC

---

## ¿Qué es Carrera de Escobas?

Es un juego de carreras inspirado en el mundo de Harry Potter. Dos jugadores compiten en una pista, recogiendo premios mágicos como la Snitch Dorada, el Bludger y la Quaffle, mientras avanzan hacia la meta.

---

**Estudiante:** Osmar Alejandro Alay Quevedo  
**Carné:** 202100024  
**Sección:** B  
**Fecha:** 27/03/2025

---

## 1. Menú Principal

![Menú Principal](1menu.png)

Al iniciar la aplicación verás el menú con las siguientes opciones:

| Botón | Función |
|-------|---------|
| **Jugar** | Inicia el proceso para comenzar una carrera |
| **Agregar Jugador** | Permite registrar nuevos jugadores |
| **Historial de Partidas** | Muestra los resultados de partidas anteriores |
| **Salir** | Cierra la aplicación |

> **Nota:** Debes tener al menos **2 jugadores registrados** antes de poder jugar.

---

## 2. Agregar Jugador

![Agregar Jugador](2agregar.png)

Para registrar un jugador:

1. Escribe el **nombre** del jugador en el campo correspondiente.
2. Selecciona la **escoba** de la lista:
   - *Nimbus 2000* — velocidad baja
   - *Nimbus 2001* — velocidad media
   - *Saeta de Fuego* — velocidad alta
3. Selecciona la **casa** de Hogwarts (Gryffindor, Slytherin, Hufflepuff, Ravenclaw).
4. Presiona **Agregar**.

**Validaciones:**
- El nombre no puede estar vacío.
- No se permiten nombres repetidos.
- Se pueden registrar hasta **10 jugadores**.

Cuando el jugador se agregue correctamente, los campos se limpiarán automáticamente.

---

## 3. Seleccionar Jugador

![Seleccionar Jugador](3seleccionarjugador.png)

Al presionar **Jugar** en el menú:

1. Se abrirá esta pantalla con la lista de jugadores registrados.
2. Selecciona tu jugador del **menú desplegable**.
3. Presiona **Jugar** para iniciar la carrera.

> El oponente se selecciona **automáticamente** de forma aleatoria entre los demás jugadores registrados.

---

## 4. La Carrera

![Partida en curso](4partdia.png)

Esta es la pantalla principal del juego. Aquí verás:

**Panel de información (izquierda):**
- Nombre del jugador seleccionado.
- Escoba utilizada.
- Casa de Hogwarts.
- Puntaje acumulado en tiempo real.

**Pista de carrera:**
- 🟥 **Rectángulo rojo** — Tu jugador.
- 🔵 **Óvalo azul** — El oponente (computadora).
- 🟡 **Óvalo amarillo (S)** — Snitch Dorada: +150 puntos, te lleva directo a la meta.
- 🔴 **Óvalo rojo (B)** — Bludger: penalización de velocidad.
- 🟠 **Óvalo naranja (Q)** — Quaffle: +10 puntos.
- **Línea negra vertical** — La meta (posición X=500).

**Botones:**
- **Pausa** — Detiene temporalmente la carrera.
- **Regresar y terminar** — Finaliza la carrera y vuelve al menú.

---

## 5. Fin de Partida

![Fin de partida](5finpartida.png)

Cuando alguno de los dos jugadores llega a la meta:

- Se muestra un mensaje indicando el **ganador**.
- Se despliegan los **puntajes finales** de ambos jugadores.
- La partida queda **guardada automáticamente** en el historial.

Después del mensaje puedes regresar al menú para jugar de nuevo.

---

## 6. Historial de Partidas

![Historial](6historialpartida.png)

Desde el menú principal, presiona **Historial de Partidas** para ver un resumen de todas las carreras jugadas:

- Nombre del jugador y sus puntos.
- Nombre del oponente y sus puntos.
- Escoba utilizada por el jugador.
- Nombre del ganador.

> Si no se ha jugado ninguna partida aún, aparecerá un mensaje indicándolo.

---

## Tabla de Premios

| Premio | Símbolo | Color | Efecto |
|--------|---------|-------|--------|
| Snitch Dorada | S | Amarillo | +150 pts y fin de carrera |
| Bludger | B | Rojo | Penalización de velocidad |
| Quaffle | Q | Naranja | +10 puntos |

---

## Velocidades por Escoba

| Escoba | Velocidad |
|--------|-----------|
| Saeta de Fuego | ⚡ Rápida |
| Nimbus 2001 | 🧹 Media |
| Nimbus 2000 | 🧹 Lenta |
