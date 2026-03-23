package Practica02.Vista;
import Modelo.Corredor;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class PanelPista extends JPanel{
    private Corredor jugador;
    private Corredor Computadora;

    public void setCorredores(Corredor jugador, Corredor Computadora) {
        this.jugador = jugador;
        this.Computadora = Computadora;
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        //dibujarjugador
        if (jugador!=null) {
            g.setColor(Color.RED);  
            g.fillRect(jugador.getPosicionX(), jugador.getPosicionY(), 30, 30);
            g.drawString(jugador.getNombre(), jugador.getPosicionX(), jugador.getPosicionY()-5);//dubujar nombre
        }
        //dubujar computadora
        if (Computadora!= null) {
            g.setColor(Color.BLUE);
             g.fillRect(Computadora.getPosicionX(), Computadora.getPosicionY(), 30, 30);
             g.drawString(Computadora.getNombre(), Computadora.getPosicionX(), Computadora.getPosicionY()-5);
        }
        //LINEA DE META
        g.setColor(Color.BLACK);
        g.drawLine(500, 0, 500, getWidth());
    }
    
}
