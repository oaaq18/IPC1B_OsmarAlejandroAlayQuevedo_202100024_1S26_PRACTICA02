package Practica02;
import Practica02.Controlador.ControladorMenu;
import Practica02.Vista.MenuVista;

public class Practica02 {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            MenuVista menu = new MenuVista();
            new ControladorMenu(menu);  
            menu.setVisible(true);
        });
    }
}