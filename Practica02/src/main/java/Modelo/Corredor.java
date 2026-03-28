
package Modelo;

import javax.swing.JOptionPane;
import Modelo.Premios;

public class Corredor implements Runnable{

    private String Nombre;
    private int PosicionX;
    private int PosicionY;
    private int tiempoDescanso;
    private boolean EnCarrera;
    private Runnable OnMove;
    private int puntos;
    private int tiempoDescansOriginal;  //el el momento que se aplica el delay de un premio se debe guardar el original para que no guarde el efecto
    private Premios[] premios; 
    private String casa;
    private String Escoba;
    private Runnable LlegaraMeta; // para verificar si llega a x500
    
    public Corredor(String Nombre,String casa, String Escoba, int tiempoDescanso, int PosicionY, int PosicionX, Runnable OnMove) {
        this.Nombre = Nombre;
        this.Escoba=Escoba;
        this.casa = casa;
        this.PosicionY = PosicionY;
        this.PosicionX = 10;
        this.tiempoDescanso = tiempoDescanso;
        this.EnCarrera = true;
        this.OnMove = OnMove;
        this.puntos = 0;
        this.tiempoDescansOriginal = tiempoDescanso;
    }
    public void setOnLlegadaMeta(Runnable LlegarMeta) {
        this.LlegaraMeta = LlegarMeta;
    }
    public void setPremios(Premios[] premios) {
        this.premios = premios;
    }
    public void sumarPuntos(int puntos){
        this.puntos+=puntos;
    }
    public int getPuntos() {
        return puntos;
    }
    
    public void aplicarPenalizacion(int delay) {
        this.tiempoDescanso += delay;
    }
    
    public void resetear(int posicionY) {
        this.PosicionX = 10;
        this.PosicionY = posicionY;
        this.EnCarrera = true;
    }
    public void setEnCarrera(boolean enCarrera) {
        this.EnCarrera = enCarrera;
    }

    public void setPosicionY(int PosicionY) {
        this.PosicionY = PosicionY;
    }

    public void setPosicionX(int PosicionX) {
        this.PosicionX = PosicionX;
    }
    
    //getters
    public int getTiempoDescanso() {
        return tiempoDescanso;
    }
    
    public String getNombre() {
        return Nombre;
    }
    
    public int getPosicionX() {
        return PosicionX;
    }

    public int getPosicionY() {
        return PosicionY;
    }
    
    public void setOnMove(Runnable onMove) {
        this.OnMove = onMove;
    }

    public String getCasa() {
        return casa;
    }

    public String getEscoba() {
        return Escoba;
    }
    
    
    @Override
    public void run() {
        while(EnCarrera && PosicionX<500){
            PosicionX+=5;
            // Verificar colision con premios
            if (premios != null) {
            for (Premios p : premios) {
                if (p != null && p.colision(this)) {
                    p.efecto(this);
                    // Si fue snitch termina la carrera
                    if (p.getTipo().equals(Premios.SNITCH)) {
                        EnCarrera = false;
                    }
                }
                }
            }
            if (OnMove != null) {
                OnMove.run();
            }
            try {
                Thread.sleep(tiempoDescanso);
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, "Error en el Thread");
            }
            // Cuando sale del while, llegó a la meta o fue detenido
            if (PosicionX >= 500 && LlegaraMeta != null) {
                LlegaraMeta.run(); // avisar que llegó
            }
        }
    }
    
}
