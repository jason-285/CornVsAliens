package Modelo;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jason
 */
public class Corn extends ObjetoMovible {

    private int vida;
    private int municion;
    private boolean arriba;
    private boolean abajo;
    private boolean izquierda;
    private boolean derecha;
    private boolean disparo;

    public Corn(ImageIcon imagen, int x, int y, int vida, int municion) {
        super(imagen, x, y);
        this.vida = vida;
        this.municion = municion;

        disparo = false;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getMunicion() {
        return municion;
    }

    public void setMunicion(int municion) {
        this.municion = municion;
    }

    public boolean isArriba() {
        return arriba;
    }

    public void setArriba(boolean arriba) {
        this.arriba = arriba;
    }

    public boolean isAbajo() {
        return abajo;
    }

    public void setAbajo(boolean abajo) {
        this.abajo = abajo;
    }

    public boolean isIzquierda() {
        return izquierda;
    }

    public void setIzquierda(boolean izquierda) {
        this.izquierda = izquierda;
    }

    public boolean isDerecha() {
        return derecha;
    }

    public void setDerecha(boolean derecha) {
        this.derecha = derecha;
    }

    public boolean getDisparo() {
        return disparo;
    }

    public void setDisparo(boolean disparo) {
        this.disparo = disparo;
    }

    public boolean municionDisponible() {
        if (municion < 0) {
            return true;
        }
        return false;
    }

    @Override
    public void pintarImagen(Graphics g) {
        imagen.paintIcon(null, g, x, y);
    }

    @Override
    public Rectangle getHitbox() {
        return new Rectangle(x + 40, y + 135, 84, 69);
    }

    @Override
    public void mover() {
        if (!disparo) {
            if (derecha) {
                if (x <= 1778) {
                    imagen = new ImageIcon("./src/main/resources/IMG/Personaje Principal Poses/personaje_caminando_derecha.gif");
                    x += 8;
                }
            }
            if (izquierda) {
                if (x >= 0) {
                    imagen = new ImageIcon("./src/main/resources/IMG/Personaje Principal Poses/cam_izq.gif");
                    x -= 8;
                }
            }
            if (arriba) {
                if (y >= 526) {
                    y -= 8;
                }
            }
            if (abajo) {
                if (y <= 713) {
                    y += 8;
                }
            }
        }
    }

}
