
package Modelo;

import javax.swing.JOptionPane;


public class Corredor implements Runnable{

    private String Nombre;
    private int PosicionX;
    private int PosicionY;
    private int tiempoDescanso;
    private boolean EnCarrera;
    private Runnable OnMove;

    public Corredor(String Nombre, int tiempoDescanso, int PosicionY, int PosicionX, Runnable OnMove) {
        this.Nombre = Nombre;
        this.PosicionY = PosicionY;
        this.PosicionX = 10;
        this.tiempoDescanso = tiempoDescanso;
        this.EnCarrera = true;
        this.OnMove = OnMove;
    }

    public void setPosicionY(int PosicionY) {
        this.PosicionY = PosicionY;
    }
    
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
    
    @Override
    public void run() {
        while(EnCarrera && PosicionX<500){
            PosicionX+=5;
            if (OnMove != null) {
                OnMove.run();
            }
            try {
                Thread.sleep(tiempoDescanso);
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, "Error en el Thread");
            }
        }
    }
    
}
