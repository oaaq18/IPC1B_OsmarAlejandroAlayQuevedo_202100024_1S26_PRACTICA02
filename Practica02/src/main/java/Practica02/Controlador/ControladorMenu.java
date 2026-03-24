package Practica02.Controlador;
import Practica02.Vista.MenuVista;
import Practica02.Vista.VistaAgregarJugador;
import Practica02.Vista.VistaPrepararCarrera;
import Practica02.Vista.PanelPista;
import Modelo.Corredor;
public class ControladorMenu {
    private MenuVista vistaMenu;
    private AgregarJugadorControlador personajeControlador;
    private PrepararCarreraControlador preprarCarrera;
    private ContoladorCarrera controladorCarrera;
    private PanelPista panel;
    
    
    public ControladorMenu(MenuVista vista) {
        VistaAgregarJugador vistaAgregar = new VistaAgregarJugador();
        VistaPrepararCarrera vistaPreparar = new VistaPrepararCarrera();
        PanelPista panel = new PanelPista();
        this.vistaMenu = vista;
        this.personajeControlador = new AgregarJugadorControlador(vistaAgregar, 10);
        this.preprarCarrera = new PrepararCarreraControlador(vistaPreparar, personajeControlador);
        this.controladorCarrera = new ContoladorCarrera(panel);
        Accciones();
       
    }
    private void Accciones() {
        vistaMenu.getBotonAgregar().addActionListener(e -> abrirAgregarJugador());
        vistaMenu.getBotonJugar().addActionListener(e -> verificarYJugar());
        vistaMenu.getBotonSalir().addActionListener(e -> System.exit(0));
        
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
        // Obtener el nombre seleccionado del combo
        String seleccionado = preprarCarrera.getVistaPrepararCarrera().getJugadorSeleccionad();

        // Buscar el corredor real
        Corredor jugador = preprarCarrera.getCorredor(seleccionado);

        // Elegir oponente aleatorio distinto al jugador
        Corredor oponente = personajeControlador.obtenerAleatorio();

        // Preparar y arrancar la carrera
        controladorCarrera.prepararCarrera(jugador, oponente);
        controladorCarrera.getPanel().setVisible(true);
        controladorCarrera.iniciarCarrera();

        // Cerrar la ventana de preparar
        preprarCarrera.getVistaPrepararCarrera().dispose();
    }
    
}
