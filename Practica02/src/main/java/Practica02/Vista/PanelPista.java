package Practica02.Vista;
import Modelo.Corredor;
import Modelo.Premios;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class PanelPista extends JPanel{
    private Corredor jugador;
    private Corredor Computadora;
    private Premios premios;
    
    
    public PanelPista() {
        setPreferredSize(new java.awt.Dimension(600, 200));
        setBackground(Color.WHITE);
    }
    public void setPremios(Premios premios) {
        this.premios = premios;
    }
    
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
             g.fillOval(Computadora.getPosicionX(), Computadora.getPosicionY(), 30, 30);
             g.drawString(Computadora.getNombre(), Computadora.getPosicionX(), Computadora.getPosicionY()-5);
        }
        if (premios != null && premios.premioActivo()) {
            g.setColor(Color.YELLOW);
            g.fillOval(premios.getPosicionX(), premios.getPosicionY(), 20, 20);
            g.setColor(Color.BLACK);
            g.drawString(premios.getTipo(), premios.getPosicionX(), premios.getPosicionY() - 5);
        }
        //LINEA DE META
        g.setColor(Color.BLACK);
        g.drawLine(500, 0, 500, getWidth());
    }
    
}
