
package Practica02.Controlador;
import Modelo.Corredor;
import Practica02.Vista.VistaAgregarJugador;

public class AgregarJugadorControlador {
    private Corredor[] corredores;
    private int total;//total de jugadores agregados
    private VistaAgregarJugador vista;

    public AgregarJugadorControlador(VistaAgregarJugador vista, int capacidad) {
        this.corredores = new Corredor[capacidad]; // usa la capacidad que le pasas
        this.total = 0;
        this.vista = vista;
        acciones();
    }
    //botones
    private void acciones() {
        vista.getBotonAgregar().addActionListener(e -> guardarPersonaje());
    }
    
    private void guardarPersonaje() {
        // 1. Leer datos de la vista
        String nombre = vista.getNombre();
        String casa   = vista.getCasa();
        String escoba = vista.getEscoba();

        //Validar que no este vaco
        if (nombre.isEmpty()) {
            vista.mostrarMensaje("El nombre no puede estar vacio.");
            return;
        }
        //Convertir escoba 
        int delay = obtenerDelay(escoba);

        // crear el corredor
        Corredor nuevo = new Corredor(nombre, delay, 100, 10, null);

        //Intentar agregar al vector
        if (agregarCorredor(nuevo)) {
            vista.mostrarMensaje("Jugador \"" + nombre + "\" agregado correctamente");
            vista.limpiarCampos();
        } else {
            vista.mostrarMensaje("ERROR: lista llena o nombre repetido");
        }
    }
        
    private int obtenerDelay(String escoba) {
        switch (escoba) {
            case "Nimbus 2000":    return 3000;
            case "Nimbus 2001":    return 2000;
            case "Saeta de Fuego": return 1000;
            default:               return 3000;
        }
    }
    
    private boolean agregarCorredor(Corredor c) {
        if (total >= corredores.length) {
            return false; // vector lleno
        }
        if (existeNombre(c.getNombre())) {
            return false; // nombre duplicado
        }
        corredores[total] = c;
        total++;
        return true;
    }
    
    private boolean existeNombre(String nombre) {
        for (int i = 0; i < total; i++) {
            if (corredores[i].getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }
    
    
}
