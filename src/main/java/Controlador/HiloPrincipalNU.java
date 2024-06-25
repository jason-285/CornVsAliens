package Controlador;

import Modelo.AreaJuegoNU;
import Vista.PanelNU;
import Modelo.Corn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jason
 */
public class HiloPrincipalNU extends Thread {

    //DECLARACION DE VARIABLES
    private Timer t;
    private int m, s, cs;
    private ActionListener acciones;
    private PanelNU panel;
    private Corn corn;
    private AreaJuegoNU areaj;

    public HiloPrincipalNU(PanelNU panel, Corn corn, AreaJuegoNU areaj) {
        this.acciones = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cs++;
                if (cs == 100) {
                    cs = 0;
                    s++;
                }
                if (s == 60) {
                    s = 0;
                    m++;
                }
            }
        };
        this.panel = panel;
        this.corn = corn;
        this.areaj = areaj;
        t = new Timer(10, acciones);
        t.start();
    }

    public String aumerntarCronometro() {
        if (s < 10) {
            return m + ":" + 0 + s;
        }

        return m + ":" + s;
    }

    public String cambiarEstadoWaves() {
        String holeada = "";
        if (m == 0 && s >= 1 && s < 3) {
            holeada = "HOLEADA 1";
        } else if (m == 0 && s >= 53 && s < 55) {
            holeada = "HOLEADA 2";
        } else if (m == 2 && s >= 1 && s < 3) {
            holeada = "HOLEADA 3";
        }

        return holeada;
    }
    
    public String holeadaExitosa(){
        String exito="";
        if(areaj.getEnemigosEliminados()==8){
            if(m==0 && s<41){
                exito="HOLEADA EXITOSA, PREPARATE";
            }
        }else if(areaj.getEnemigosEliminados()==18){
            if(m==1 && s<59){
                exito="HOLEADA EXITOSA, PREPARATE";
            }
        }
        return exito;
    }
    

    @Override
    public void run() {
        while (corn.getVida() > 0) {
            try {
                panel.actualizarTiempo(aumerntarCronometro());
                panel.actualizarHoleada(cambiarEstadoWaves());
                panel.actualizarHoleadaexitosa(holeadaExitosa());
                areaj.gane();
            } catch (Exception e) {
            }
        }
    }
}
