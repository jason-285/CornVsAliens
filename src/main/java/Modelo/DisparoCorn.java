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
public class DisparoCorn extends ObjetoMovible{
    
    private int daño;
    private int tipoMunicion;

    public DisparoCorn(ImageIcon imagen, int x, int y, int daño, int tipoMunicion) {
        super(imagen, x, y);
        this.daño = daño;
        this.tipoMunicion = tipoMunicion;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    public int getTipoMunicion() {
        return tipoMunicion;
    }

    public void setTipoMunicion(int tipoMunicion) {
        this.tipoMunicion = tipoMunicion;
    }
    
    @Override
    public void pintarImagen(Graphics g) {
        imagen.paintIcon(null, g, x, y);
    }

    @Override
    public Rectangle getHitbox() {
        return new Rectangle(x, y, imagen.getIconWidth(), imagen.getIconHeight());
    }

    @Override
    public void mover() {
       x+=25;
    }
    
}
