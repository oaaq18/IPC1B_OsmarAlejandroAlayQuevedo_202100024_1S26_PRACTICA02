package Practica02.Controlador;

import Practica02.Vista.PanelPista;
import Modelo.Corredor;

public class ContoladorCarrera {
    private PanelPista Panel;
    private Corredor Jugador;
    private Corredor Computadora;

    public ContoladorCarrera(PanelPista Panel) {
        this.Panel = Panel;
    }
  
    public void prepararCarrera(){
        Runnable repintarVista = () -> Panel.repaint();
        
        Jugador = new Corredor("Fernando", 1000, 50,15,  repintarVista);
        Computadora = new Corredor("Chatio", 2000, 150,30, repintarVista );
        
        Panel.setCorredores(Jugador, Computadora);
        Panel.repaint();
    }
    
    public void iniciarCarrera(){
    //iniciar los hilos de cada jugador
     Thread hiloJugador=new Thread(Jugador);
     Thread hiloComputadora=new Thread(Computadora);
     
     hiloComputadora.start();
     hiloJugador.start();
     
    }
}