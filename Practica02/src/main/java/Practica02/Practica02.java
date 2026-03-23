package Practica02;
import Practica02.Vista.MenuVista;

public class Practica02 {

    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(() -> {
        new MenuVista().setVisible(true); 
    });
    }
}
