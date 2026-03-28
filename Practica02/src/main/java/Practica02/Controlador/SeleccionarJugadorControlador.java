
package Practica02.Controlador;
import Practica02.Vista.VistaSeleccionarJugador;
import Modelo.Corredor;

public class SeleccionarJugadorControlador {
    private VistaSeleccionarJugador vistaPrepararCarrera;
     private AgregarJugadorControlador personajeControlador;

    public SeleccionarJugadorControlador(VistaSeleccionarJugador vistaPrepararCarrera,AgregarJugadorControlador personajeControlador) {
        this.vistaPrepararCarrera = vistaPrepararCarrera;
        this.personajeControlador = personajeControlador;
    }
    
    
    public VistaSeleccionarJugador getVistaPrepararCarrera() {
        return vistaPrepararCarrera;
    }
    
    public void llenarCorredores (String Corredores[]){
        vistaPrepararCarrera.llennarCombo(Corredores);
    }
    
    public Corredor getCorredor(String nombre) {
    String soloNombre = nombre;
    return personajeControlador.buscarPorNombre(soloNombre);
}
    
    
}
