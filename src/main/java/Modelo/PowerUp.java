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
public class PowerUp extends ObjetoMovible{
    private int tipo;

    public PowerUp(ImageIcon imagen, int x, int y, int tipo) {
        super(imagen, x, y);
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public Rectangle getHitbox(){
        return new Rectangle(x+5,y+5,imagen.getIconWidth()-10,imagen.getIconHeight()-10);
    }
    
    @Override
    public void pintarImagen(Graphics g){
        imagen.paintIcon(null, g, x, y);
    }
    
    @Override
    public void mover(){
        if(y<890){
            y+=2;
        }
    }
    
}
