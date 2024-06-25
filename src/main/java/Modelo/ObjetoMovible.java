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
public class ObjetoMovible {
    ImageIcon imagen;
    int x;
    int y;

    public ObjetoMovible(ImageIcon imagen, int x, int y) {
        this.imagen = imagen;
        this.x = x;
        this.y = y;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void pintarImagen(Graphics g){
        imagen.paintIcon(null, g, x, y);
    }
    
    public Rectangle getHitbox(){
        return new Rectangle(x,y,imagen.getIconWidth(),imagen.getIconHeight());
    }
    
    public void mover(){
        
    }
}
