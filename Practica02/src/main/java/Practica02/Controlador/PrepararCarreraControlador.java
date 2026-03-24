
package Practica02.Controlador;
import Practica02.Vista.VistaPrepararCarrera;
import Modelo.Corredor;

public class PrepararCarreraControlador {
    private VistaPrepararCarrera vistaPrepararCarrera;
     private AgregarJugadorControlador personajeControlador;

    public PrepararCarreraControlador(VistaPrepararCarrera vistaPrepararCarrera,AgregarJugadorControlador personajeControlador) {
        this.vistaPrepararCarrera = vistaPrepararCarrera;
        this.personajeControlador = personajeControlador;
    }
    
    
    public VistaPrepararCarrera getVistaPrepararCarrera() {
        return vistaPrepararCarrera;
    }
    
    public void llenarCorredores (String Corredores[]){
        vistaPrepararCarrera.llennarCombo(Corredores);
    }
    public Corredor getCorredor(String nombre) {
    // El nombre viene como "Fernando - Nimbus 2000", solo nos interesa la parte antes del " - "
    String soloNombre = nombre;
    return personajeControlador.buscarPorNombre(soloNombre);
}
    
    
}
