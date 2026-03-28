/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


public class Partida {
    private String nombreJugador;
    private String nombreOponente;
    private String escobaJugador;
    private int puntosJugador;
    private int puntosOponente;
    private String ganador;

    public Partida(String nombreJugador, String nombreOponente, String escobaJugador, int puntosJugador, int puntosOponente, String ganador) {
        this.nombreJugador = nombreJugador;
        this.nombreOponente = nombreOponente;
        this.escobaJugador = escobaJugador;
        this.puntosJugador = puntosJugador;
        this.puntosOponente = puntosOponente;
        this.ganador = ganador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public String getNombreOponente() {
        return nombreOponente;
    }

    public String getEscobaJugador() {
        return escobaJugador;
    }

    public int getPuntosJugador() {
        return puntosJugador;
    }

    public int getPuntosOponente() {
        return puntosOponente;
    }

    public String getGanador() {
        return ganador;
    }
    
    
    
}
