
package Practica02.Controlador;

import Modelo.Partida;

public class ReportesControlador {
    private Partida[] partidas;
    private int total;

    public ReportesControlador() {
        this.partidas =new Partida[50];
        this.total = 0;
    }
    public int getTotal() {
        return total;
    }
    public void guardarPartida(Partida partida) {
        if (total < partidas.length) {
            partidas[total] = partida;
            total++;
        }
    }
    //devolver las partidas guardadas
    public Partida[] getPartidas() {
        return partidas;
    }
    
          
}
