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
public class HiloMoviminetoEnemigoNU extends Thread {

    private PanelNU panel;
    private AreaJuegoNU areaj;
    private ControladorPrincipal controlP;

    public HiloMoviminetoEnemigoNU(PanelNU panel, AreaJuegoNU areaj, ControladorPrincipal contorlP) {
        this.panel = panel;
        this.areaj = areaj;
    }

    @Override
    public void run() {
        while(areaj.cantidadEnemigos()>0){
            try {
                for (int i = 0; i < areaj.cantidadEnemigos(); i++) {
                    areaj.getEnemys(i).mover();
                    areaj.getVidasE(i).mover();
                    areaj.isColisionCuerpos(i);
                    areaj.pierde(i);
                    areaj.actualizarVidaEnemigo(i);
                    panel.actualizarBarraVida(areaj.getCorn().getVida()); //PUEDE QUE ESTE NO SEA NECESARIO
                    areaj.consecuenciaMorir();


                }
                sleep(35);
            } catch (Exception e) {
            }
        }
    }
    
}
