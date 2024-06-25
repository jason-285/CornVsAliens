package Controlador;

import Vista.PanelNU;
import Modelo.AreaJuegoNU;
import Vista.GUINU;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
public class ControladorNU implements KeyListener {

    private PanelNU panelNU;
    private AreaJuegoNU areaj;
    private GUINU guiNU;
    private ControladorPrincipal controlP;

    private long disparoTimer = System.nanoTime();
    private long disparoDelay = 200;

    private int municionDisparada;

    public ControladorNU(PanelNU panelNU, GUINU guiNU, ControladorPrincipal controlP) {
        this.panelNU = panelNU;
        this.guiNU = guiNU;
        this.controlP = controlP;
        areaj = new AreaJuegoNU(controlP);

        municionDisparada = 0;

    }

    public void setMunicionDisparada() {
        municionDisparada = 0;
    }

    public int getMunicionDisparada() {
        return municionDisparada;
    }

    public void disparoCorn() {
        long elapsed = (System.nanoTime() - disparoTimer) / 1000000;

        if (elapsed > disparoDelay) {
            areaj.getCorn().setDisparo(true);
            areaj.getCorn().setImagen(new ImageIcon("./src/main/resources/IMG/Personaje Principal Poses/personaje_base_derecha.png"));
            areaj.añadirDisparo();
            areaj.getCorn().setMunicion(areaj.getCorn().getMunicion() - 1);
            panelNU.actializarConteoMunicion("X" + String.valueOf(areaj.getCorn().getMunicion()));
            municionDisparada++;

            disparoTimer = System.nanoTime();
        }
    }

    public void dibujar(Graphics g) {
        areaj.dibujar(g);
        panelNU.repaint();
    }

    public AreaJuegoNU getAreaJuego() {
        return areaj;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (String.valueOf(e.getKeyChar()).equalsIgnoreCase("D")) {
            areaj.getCorn().setDerecha(true);
            //System.out.println("Escuche D");

        } else if (String.valueOf(e.getKeyChar()).equalsIgnoreCase("A")) {
            areaj.getCorn().setIzquierda(true);
           //System.out.println("Escuche A");

        } else if (String.valueOf(e.getKeyChar()).equalsIgnoreCase("W")) {
            areaj.getCorn().setArriba(true);
            //System.out.println("Escuche W");

        } else if (String.valueOf(e.getKeyChar()).equalsIgnoreCase("S")) {
            areaj.getCorn().setAbajo(true);
            //System.out.println("Escuche S");

        } else if (e.getKeyCode() == 32) { 
            if (areaj.getCorn().getMunicion() > 0) {
                disparoCorn();
            }

        } else if (e.getKeyCode() == 27) {
            controlP.getGUIMenu().setVisible(true);
            //guiNU.pausarHilos();  //INESTABLE   
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (String.valueOf(e.getKeyChar()).equalsIgnoreCase("D")) {
            areaj.getCorn().setDerecha(false);
            areaj.getCorn().setImagen(new ImageIcon("./src/main/resources/IMG/Personaje Principal Poses/personaje_base_derecha.png"));

        } else if (String.valueOf(e.getKeyChar()).equalsIgnoreCase("A")) {
            areaj.getCorn().setIzquierda(false);
            areaj.getCorn().setImagen(new ImageIcon("./src/main/resources/IMG/Personaje Principal Poses/personaje_base_derecha.png"));

        } else if (String.valueOf(e.getKeyChar()).equalsIgnoreCase("W")) {
            areaj.getCorn().setArriba(false);
            areaj.getCorn().setImagen(new ImageIcon("./src/main/resources/IMG/Personaje Principal Poses/personaje_base_derecha.png"));

        } else if (String.valueOf(e.getKeyChar()).equalsIgnoreCase("S")) {
            areaj.getCorn().setAbajo(false);
            areaj.getCorn().setImagen(new ImageIcon("./src/main/resources/IMG/Personaje Principal Poses/personaje_base_derecha.png"));
        }
    }
}
