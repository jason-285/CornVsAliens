/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Jason
 */
public class VidaEnemiga extends ObjetoMovible{
    
    private EnemigoNU enemy;

    public VidaEnemiga(ImageIcon imagen, int x, int y, EnemigoNU enemy) {
        super(imagen, x, y);
        this.enemy = enemy;
    }

    public EnemigoNU getEnemy() {
        return enemy;
    }

    public void setEnemy(EnemigoNU enemy) {
        this.enemy = enemy;
    }

    @Override
    public void pintarImagen(Graphics g) {
        imagen.paintIcon(null, g, x, y);
    }
    
    @Override
    public void mover() {
        x -= 2;
    }

    
}
