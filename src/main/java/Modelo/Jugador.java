/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Jason
 */
public class Jugador {

    private String nombre, duracion;
    private int puntaje, balasDiparadas, enemigosEliminados;

    public static final String[] ETIQUETAS_JUGADOR  = {"Nombre", "Duracion", "Puntaje", "Balas", "Enemigos", "Calif."};

    public Jugador() {
    }
    
    public String getCalificacion(int puntaje){
        String calificacion="";
        if(puntaje>=15400){
            calificacion= "S";
        }else if(puntaje>=13000){
            calificacion= "A";
        }else if(puntaje>=10000){
            calificacion= "B";
        }else if(puntaje>=8000){
            calificacion= "C";
        }else if(puntaje>=5000){
            calificacion= "D";
        }else if(puntaje>=2500){
            calificacion= "E";
        }else if(puntaje>=0){
            calificacion= "F";
        }
        
        return calificacion;
    }
            
    public String setDatosJugador(int indice) {
        switch (indice) {
            case 0:
                return getNombre();
            case 1:
                return getDuracion();
            case 2:
                return String.valueOf(getPuntaje());
            case 3:
                return String.valueOf(getBalasDiparadas());
            case 4:
                return String.valueOf(getEnemigosEliminados());
            case 5:
                return getCalificacion(puntaje);
        }
        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getBalasDiparadas() {
        return balasDiparadas;
    }

    public void setBalasDiparadas(int balasDiparadas) {
        this.balasDiparadas = balasDiparadas;
    }

    public int getEnemigosEliminados() {
        return enemigosEliminados;
    }

    public void setEnemigosEliminados(int enemigosEliminados) {
        this.enemigosEliminados = enemigosEliminados;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", duracion=" + duracion + ", puntaje=" + puntaje + ", balasDiparadas=" + balasDiparadas + ", enemigosEliminados=" + enemigosEliminados + '}';
    }

}
