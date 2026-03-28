package Practica02.Vista;
import Modelo.Corredor;
import Modelo.Premios;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class PanelPista extends JPanel{
    private Corredor jugador;
    private Corredor Computadora;
    private Premios[] premios;;
    
    
    public PanelPista() {
        setPreferredSize(new java.awt.Dimension(600, 200));
        setBackground(Color.WHITE);
    }
    public void setPremios(Premios[] premios) {
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
        if (premios != null) {
            for (Premios p : premios) {
                if (p != null && p.premioActivo()) {
                    // color según tipo
                    switch (p.getTipo()) {
                        case Premios.SNITCH:  g.setColor(java.awt.Color.YELLOW); break;
                        case Premios.BLUDGER: g.setColor(java.awt.Color.RED);    break;
                        case Premios.QUAFFLE: g.setColor(java.awt.Color.ORANGE); break;
                    }
                    g.fillOval(p.getPosicionX(), p.getPosicionY(), 20, 20);
                    g.setColor(java.awt.Color.BLACK);
                    g.drawString(p.getTipo(), p.getPosicionX(), p.getPosicionY() - 3);
                }
            }
        }
        //LINEA DE META
        g.setColor(Color.BLACK);
        g.drawLine(500, 0, 500, getWidth());
    }
    
}
