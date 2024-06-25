package Controlador;

import Vista.PanelNU;
import Modelo.AreaJuegoNU;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jason
 */
public class HiloDisparoNU extends Thread {

    private AreaJuegoNU areaj;
    private PanelNU panel;

    private long moverTimer = System.nanoTime();
    private long moverDelay = 380;
    
    public HiloDisparoNU(AreaJuegoNU areaj, PanelNU panel) {
        this.areaj = areaj;
        this.panel = panel;
    }
    
    public void detenerCorn() {
        if (areaj.getCorn().getDisparo()) {
            long elapsed = (System.nanoTime() - moverTimer) / 1000000;

            if (elapsed > moverDelay) {
                areaj.getCorn().setDisparo(false);
                moverTimer = System.nanoTime();
            }
        }
    }

    @Override
    public void run() {
        while (areaj.getCorn().getVida() > 0) {
            try {
                detenerCorn();
                areaj.getCorn().mover();
                if (areaj.getCantidadDisparos() >= 1) {
                    for (int i = 0; i < areaj.getCantidadDisparos(); i++) {
                        areaj.getDisparo(i).mover();
                        areaj.removerDisparo(i);
                        areaj.isColisionBala();
                        panel.actualizarPuntaje(areaj.getPuntaje());
                    }
                }
                sleep(25);
            } catch (Exception e) {
            }

        }
    }
}
