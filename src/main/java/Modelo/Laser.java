/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Jason
 */
public class Laser extends ObjetoMovible{
    private int daño;

    public Laser(ImageIcon imagen, int x, int y, int daño) {
        super(imagen, x, y);
        this.daño = daño;
    }
    
    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }
    
    @Override
    public void pintarImagen(Graphics g) {
        imagen.paintIcon(null, g, x, y);
    }
    
    @Override
    public Rectangle getHitbox(){
        return new Rectangle(x,y,imagen.getIconWidth(),imagen.getIconHeight());
    }
    
    @Override
    public void mover(){
            x-=7;
    }
    
}
