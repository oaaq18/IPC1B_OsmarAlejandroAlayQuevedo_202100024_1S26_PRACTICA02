package Practica02.Controlador;
import Practica02.Vista.MenuVista;
import Practica02.Vista.VistaAgregarJugador;

public class ControladorMenu {
    private MenuVista vistaMenu;
    private AgregarJugadorControlador personajeControlador;
    
     public ControladorMenu(MenuVista vista) {
        this.vistaMenu = vista;
        VistaAgregarJugador vistaAgregar = new VistaAgregarJugador();
        this.personajeControlador = new AgregarJugadorControlador(vistaAgregar, 10);
       
    }
}
