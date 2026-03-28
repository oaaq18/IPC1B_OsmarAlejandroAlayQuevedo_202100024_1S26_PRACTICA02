
package Modelo;

public class Premios implements Runnable{
    //tipos de premios
    public static final String SNITCH = "S";
    public static final String BLUDGER = "B";
    public static final String QUAFFLE = "Q";
    
    private String tipo;
    private int tiempoDescanso;
    private int PosicionX;
    private int PosicionY;
    private int Puntaje;
    private Runnable onMovePremio;
    boolean premioActivo=true; ;//verificar si fue racogido

    public Premios(String tipo, int tiempoDescanso, int PosicionX, int PosicionY, Runnable onMovePremio) {
        this.tipo = tipo;
        this.tiempoDescanso = tiempoDescanso;
        this.PosicionX = PosicionX;
        this.PosicionY = PosicionY;
        this.onMovePremio = onMovePremio;
        this.premioActivo= true;
    }
    
    public boolean premioActivo() {
        return premioActivo;
    }
    
     public boolean colision(Corredor corredor) {
        if (!premioActivo) return false;
        int cx = corredor.getPosicionX();
        int cy = corredor.getPosicionY();
        return cx + 30 >= PosicionX && cx <= PosicionX + 20
            && cy + 30 >= PosicionY && cy <= PosicionY + 20;
    }
    public void efecto(Corredor corredor) { // aplica el efecto del premio al jugador
        switch (tipo) {
            case SNITCH:
                corredor.sumarPuntos(150);
                corredor.setPosicionX(500); // lleva a la meta
                break;
            case BLUDGER:
                corredor.aplicarPenalizacion(2000); // 2 segundos extra
                break;
            case QUAFFLE:
                corredor.sumarPuntos(10);
                break;
        }
        premioActivo = false; // desactivar después de ser recogido
    }
    
    @Override
     public void run() {
        while (true) {
            try {

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }}
        }


    public String getTipo() {
        return tipo;
    }

    public int getPosicionX() {
        return PosicionX;
    }

    public int getPosicionY() {
        return PosicionY;
    }
    
}
