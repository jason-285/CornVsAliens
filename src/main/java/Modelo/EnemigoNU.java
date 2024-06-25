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
public class EnemigoNU extends ObjetoMovible{
    
    private int vida;
    private int tipo;

    public EnemigoNU(ImageIcon imagen, int x, int y, int vida, int tipo) {
        super(imagen, x, y);
        this.vida = vida;
        this.tipo=tipo;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public void pintarImagen(Graphics g) {
        imagen.paintIcon(null, g, x, y);
    }
    
    @Override
    public Rectangle getHitbox() {
        return new Rectangle(x+75, y+97, 114, 144);
    }
    
    @Override
    public void mover() {
        x-=2;
    }
    
}
