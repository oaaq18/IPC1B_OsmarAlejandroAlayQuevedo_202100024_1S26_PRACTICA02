package Practica02.Controlador;
import Practica02.Vista.MenuVista;
import Practica02.Vista.VistaAgregarJugador;
import Practica02.Vista.VistaSeleccionarJugador;
import Practica02.Vista.PanelPista;
import Practica02.Vista.VistaCarrera;
import Modelo.Corredor;
import Modelo.Partida;
public class ControladorMenu {
    private MenuVista vistaMenu;
    private AgregarJugadorControlador personajeControlador;
    private SeleccionarJugadorControlador preprarCarrera;
    private ControladorCarrera controladorCarrera;
    private PanelPista panel;
    private ReportesControlador reportesControlador;
    
    
    public ControladorMenu(MenuVista vista) {
        VistaAgregarJugador vistaAgregar = new VistaAgregarJugador();
        VistaSeleccionarJugador vistaPreparar = new VistaSeleccionarJugador();
        PanelPista panel = new PanelPista();
        VistaCarrera vistaCarrera = new VistaCarrera();
        this.vistaMenu = vista;
        this.reportesControlador = new ReportesControlador();
        this.personajeControlador = new AgregarJugadorControlador(vistaAgregar, 10);
        this.preprarCarrera = new SeleccionarJugadorControlador(vistaPreparar, personajeControlador);
        this.controladorCarrera = new ControladorCarrera(vistaCarrera, reportesControlador);
        Accciones();
       
    }
    private void Accciones() {
        vistaMenu.getBotonAgregar().addActionListener(e -> abrirAgregarJugador());
        vistaMenu.getBotonJugar().addActionListener(e -> verificarYJugar());
        vistaMenu.getBotonSalir().addActionListener(e -> System.exit(0));
        vistaMenu.getBotonHistorialDePartidas().addActionListener(e -> mostrarHistorial());
        
    }
    //vista que ya existe en el controlador de agregar jugador
    
     private void abrirAgregarJugador() {
        personajeControlador.getVista().setVisible(true);
    }
     // Validacion: necesita al menos 2 jugadores para jugar
    private void verificarYJugar() {
        
        if (personajeControlador.getTotal() < 2) {
            vistaMenu.mostrarMensaje( "ERROR: necesitas al menos 2 jugadores para jugar.\n" + "Jugadores registrados: " + personajeControlador.getTotal());
            return;
        }
        //abruir y jigar
        ///vistaMenu.mostrarMensaje("Iniciando carrera");
        
        String[] nombres = personajeControlador.getNombresJugadores();//obtener los datos del vector
        preprarCarrera.llenarCorredores(nombres);                     //mandarle los datos al combo de la vista
        preprarCarrera.getVistaPrepararCarrera().getBotonJugar()
        .addActionListener(e -> iniciarCarrera());
        preprarCarrera.getVistaPrepararCarrera().setVisible(true);
        
    }
    private void iniciarCarrera() {
         //obtener jugador seleccionado
        String seleccionado = preprarCarrera.getVistaPrepararCarrera().getJugadorSeleccionad();
        
        //buscar el corredor 
        Corredor jugador = preprarCarrera.getCorredor(seleccionado);

        //elegir oponente aleatorio
        Corredor oponente = personajeControlador.obtenerAleatorio(seleccionado);

        // preparar la carrera
        controladorCarrera.prepararCarrera(jugador, oponente);

        //mostrar ventana de carrera
        controladorCarrera.getVista().setVisible(true);

        //iniciar hilos
        controladorCarrera.iniciarCarrera();

        //cerrar preparar carrera
        preprarCarrera.getVistaPrepararCarrera().dispose();
    }
    private void mostrarHistorial() {
        if (reportesControlador.getTotal() == 0) {
            vistaMenu.mostrarMensaje("No hay partidas registradas aún.");
            return;
        }

        StringBuilder sb = new StringBuilder("Historial de partidas:\n\n");
        Partida[] partidas = reportesControlador.getPartidas();

        for (int i = 0; i < reportesControlador.getTotal(); i++) {
            sb.append("Partida ").append(i + 1).append(":\n");
            sb.append("  Jugador:  ").append(partidas[i].getNombreJugador())
              .append(" (").append(partidas[i].getPuntosJugador()).append(" pts)\n");
            sb.append("  Oponente: ").append(partidas[i].getNombreOponente())
              .append(" (").append(partidas[i].getPuntosOponente()).append(" pts)\n");
            sb.append("  Escoba:   ").append(partidas[i].getEscobaJugador()).append("\n");
            sb.append("  Ganador:  ").append(partidas[i].getGanador()).append("\n");
            sb.append("─────────────────\n");
        }

        javax.swing.JOptionPane.showMessageDialog(
            vistaMenu,
            sb.toString(),
            "Historial de Partidas",
            javax.swing.JOptionPane.INFORMATION_MESSAGE
        );
    }
    
}
