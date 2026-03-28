package Practica02.Controlador;

import Practica02.Vista.VistaCarrera;
import Modelo.Corredor;
import Modelo.Partida;
import Modelo.Premios;
import Practica02.Vista.PanelPista;
import java.util.Random;

public class ControladorCarrera {
    private Partida partida;
    private VistaCarrera vista;
    private PanelPista panel;
    private Corredor jugador;
    private Corredor computadora;
    private Random rnd = new Random();
    private Premios[] premios;;
    private boolean carreraTerminada = false;
    private ReportesControlador reportesControlador;

    public ControladorCarrera(VistaCarrera vista,ReportesControlador reportesControlador) {
        this.vista = vista;
        this.reportesControlador=reportesControlador;
        asignarAcciones();
    }

    private void asignarAcciones() {
        vista.getBotonRegresar().addActionListener(e -> regresar());
    }

    public void prepararCarrera(Corredor jugador, Corredor computadora) {
        
        this.jugador = jugador;
        this.computadora = computadora;
        int numero = rnd.nextInt(2);
        int Xaleatoria = rnd.nextInt(200);
        jugador.setOnLlegadaMeta(() -> terminarCarrera(jugador));
        computadora.setOnLlegadaMeta(() -> terminarCarrera(computadora));
        jugador.resetear(50);      //carril superior
        computadora.resetear(150); //carril inferior
        computadora.setPosicionY(120);
        
        // Mostrar datos del jugador en la vista
        vista.setNombreJugador(jugador.getNombre());
        vista.setEscobaJugador(jugador.getEscoba());
        vista.setTextoCasa(jugador.getCasa());
        vista.setPuntaje(String.valueOf(jugador.getPuntos()));
       
        generarPremios();
        jugador.setPremios(premios);
        computadora.setPremios(premios);
        vista.getPista().setPremios(premios);
        
     
        // Asignar el repaint como onMove
        Runnable repintar = () -> vista.getPista().repaint();
        jugador.setOnMove(repintar);
        computadora.setOnMove(repintar);
        //premios
        
    
        vista.getPista().setPremios(premios);
        //fin premios
        // Decirle al panel quienes corren
        vista.getPista().setCorredores(jugador, computadora);
        
        vista.getPista().repaint();
    }
    
    private void terminarCarrera(Corredor ganador) {
        if (carreraTerminada) return; // si ya terminó no hacer nada
            carreraTerminada = true;

            // Detener ambos corredores
            jugador.setEnCarrera(false);
            computadora.setEnCarrera(false);
            // Guardar la partida
            Partida partida = new Partida(
                jugador.getNombre(),
                computadora.getNombre(),
                jugador.getEscoba(),
                jugador.getPuntos(),
                computadora.getPuntos(),
                ganador.getNombre()
            );
            reportesControlador.guardarPartida(partida);
            // Mostrar ganador en la vista
            javax.swing.SwingUtilities.invokeLater(() -> {javax.swing.JOptionPane.showMessageDialog(
                    vista,
                    "¡" + ganador.getNombre() + " gano la carrera\n" +
                    "Puntos: " + ganador.getPuntos(),
                    "fin de la carrera",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE
            );
        });
    }
    
    private void generarPremios() {
            premios = new Premios[5];
            Runnable repintar = () -> vista.getPista().repaint();
            int[] carriles = {50, 120};

            for (int i = 0; i < 5; i++) {
                int random = (int) (Math.random() * 10);
                String tipo;
                if (random < 1) {
                    tipo = Premios.SNITCH;
                } else if (random < 5) {
                    tipo = Premios.BLUDGER;
                } else {
                    tipo = Premios.QUAFFLE;
                }
                int posX = 100 + (i * 70) + (int) (Math.random() * 30);
                int posY = carriles[(int) (Math.random() * 2)];
                premios[i] = new Premios(tipo, 0, posX, posY, repintar);
        }
    }


    public void iniciarCarrera() {
        Thread hiloJugador = new Thread(jugador);
        Thread hiloComputadora = new Thread(computadora);
        hiloJugador.start();
        hiloComputadora.start();
    }

    private void regresar() {
        // Detener los hilos
         
        jugador.setEnCarrera(false);
        computadora.setEnCarrera(false);
        // Cerrar la ventana
        vista.dispose();
    }

    public VistaCarrera getVista() {
        return vista;
    }
    
    public void llenarPremios(Premios premios){
        //this.premios = premios;
        //premios= new Premios(Nombre, 0, 0, 0, 0, premios);
    }
  
    
}