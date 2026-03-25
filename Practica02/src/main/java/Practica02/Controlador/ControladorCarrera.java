package Practica02.Controlador;

import Practica02.Vista.PanelPista;
import Modelo.Corredor;

public class ControladorCarrera {
    private PanelPista Panel;
    private Corredor Jugador;
    private Corredor Computadora;
    

    public ControladorCarrera(PanelPista Panel) {
        this.Panel = Panel;
        
    }

    public PanelPista getPanel() {
        return Panel;
    }

    public Corredor getJugador() {
        return Jugador;
    }

    public Corredor getComputadora() {
        return Computadora;
    }
    
    public void prepararCarrera(Corredor jugador, Corredor oponente){
        Runnable repintarVista = () -> Panel.repaint();
       
        Panel.setCorredores(jugador, oponente);
        Panel.repaint();
        javax.swing.JFrame ventana = new javax.swing.JFrame();
        ventana.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 200);
        ventana.setLocationRelativeTo(null); // Lo centra
    }
    
    public void iniciarCarrera(Corredor jugador, Corredor oponente){
    //iniciar los hilos de cada jugador
     Thread hiloJugador=new Thread(jugador);
     Thread hiloComputadora=new Thread(oponente);
     
     hiloComputadora.start();
     hiloJugador.start();
     
    }
    public void ventanaJugar(Corredor jugador, Corredor oponente){
        this.Jugador = jugador;
        this.Computadora = oponente;

        //crear la ventana
        javax.swing.JFrame ventana = new javax.swing.JFrame("Carrera de Escobas");
        ventana.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 300);
        ventana.setLocationRelativeTo(null);

        //crear el panel
        PanelPista pista = new PanelPista();
        ventana.add(pista);
        ventana.setVisible(true); 

        // Asignar el repaint como onMove ANTES de iniciar hilos
        Runnable repintar = () -> pista.repaint();
        jugador.setOnMove(repintar);
        oponente.setOnMove(repintar);
        oponente.setPosicionY(200);
        // Decirle al panel quienes corren
        pista.setCorredores(jugador, oponente);
        pista.repaint();

        // Iniciar los hilos
        new Thread(jugador).start();
        new Thread(oponente).start();
    }
}