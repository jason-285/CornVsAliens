/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AreaJuegoNU;

/**
 *
 * @author Jason
 */
public class HiloLaserEnemys extends Thread {

    private AreaJuegoNU areaj;

    private long disparoTimer = System.nanoTime();
    private long disparoDelay = 3000;

    public HiloLaserEnemys(AreaJuegoNU areaj) {
        this.areaj = areaj;
    }

    public void disparoEnemy() {
        long elapsed = (System.nanoTime() - disparoTimer) / 1000000;

        if (elapsed > disparoDelay) {
            areaj.añadirLaser();
            disparoTimer = System.nanoTime();
        }
    }

    @Override
    public void run() {
        while (areaj.getCorn().getVida() > 0) {
            try {
                disparoEnemy();
                areaj.moverLasers();
                areaj.isColisionLasers();
                sleep(25);
            } catch (Exception e) {
            }
        }
    }

}
