/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AreaJuegoNU;
import Vista.PanelNU;
import javax.swing.ImageIcon;

/**
 *
 * @author Jason
 */
public class HiloMovimientoPowerUps extends Thread {

    private AreaJuegoNU areaj;
    private PanelNU panelNU;

    public HiloMovimientoPowerUps(AreaJuegoNU areaj, PanelNU panelNU) {
        this.areaj = areaj;
        this.panelNU = panelNU;
    }

    public ImageIcon cambiarIconoMunicion() {
        if (areaj.getDañoBalas() == 10) {
            return new ImageIcon("./src/main/resources/IMG/Iconos Munición y Vida/municion_pesada_icono.png");
        }
        return new ImageIcon("./src/main/resources/IMG/Iconos Munición y Vida/municion_ligera_icono.png");
    }

    @Override
    public void run() {
        while (areaj.getCorn().getVida() > 0) {
            try {
                for (int i = 0; i < areaj.getCantidadPowerups(); i++) {
                    areaj.getPowerUp(i).mover();
                    areaj.isColisionPowerUp(i);
                    panelNU.actializarConteoMunicion("X" + areaj.getCorn().getMunicion());
                    panelNU.actualizarBarraVida(areaj.getCorn().getVida());
                    panelNU.actualizarMunicion(cambiarIconoMunicion());
                    panelNU.actualizarPuntaje(areaj.getPuntaje());
                }
                sleep(25);
            } catch (Exception e) {
            }
        }
    }
}
