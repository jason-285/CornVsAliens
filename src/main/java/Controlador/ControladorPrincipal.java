/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AreaJuegoNU;
import Modelo.CargadorSonidos;
import Modelo.Jugador;
import Modelo.RegistroJugador;
import Vista.GUIAjustes;
import Vista.GUIControles;
import Vista.GUIInfo;
import Vista.GUIMejoras;
import Vista.GUIMenu;
import Vista.GUINU;
import Vista.GUIObjetivos;
import Vista.GUIPresentacion;
import Vista.GUIPrincipal;
import Vista.GUIRegistro;
import Vista.GUISalirJ;
import Vista.GUISalirNivel;
import Vista.GUIStats;
import Vista.GUIGameOver;
import Vista.GUIGanador;
import Vista.PanelAjustes;
import Vista.PanelGanador;
import Vista.PanelNU;
import Vista.PanelPrincipal;
import Vista.PanelRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Jason
 */
public class ControladorPrincipal implements ActionListener {

    private GUIPresentacion guiP;
    private GUIPrincipal guiPri;
    private GUIRegistro guiR;
    private GUIControles guiC;
    private GUIObjetivos guiO;
    private GUIMejoras guiMJ;
    private GUINU guiNU;
    private GUIStats guiS;
    private GUIInfo guiI;
    private GUIAjustes guiA;
    private GUISalirJ guiSJ;
    private GUIMenu guiM;
    private GUISalirNivel guiSN;
    private GUIGameOver guiGO;
    private GUIGanador guiG;

    private PanelRegistro panelR;
    private PanelAjustes panelA;
    private PanelNU panelNU;
    private PanelGanador panelG;
    private PanelPrincipal panelPri;

    private ControladorNU controlNU;
    private AreaJuegoNU areaj;
    private CargadorSonidos cargadorS;
    private RegistroJugador registroJ;

    private float volMusica;
    private float volSonido;

    public ControladorPrincipal() {
        guiPri = new GUIPrincipal(this);
        guiR = new GUIRegistro(this);
        guiC = new GUIControles(this);
        guiO = new GUIObjetivos(this);
        guiMJ = new GUIMejoras(this);
        guiS = new GUIStats(this);
        guiI = new GUIInfo(this);
        guiA = new GUIAjustes(this);
        guiSJ = new GUISalirJ(this);
        guiM = new GUIMenu(this);
        guiSN = new GUISalirNivel(this);
        guiNU = new GUINU(this);
        guiGO = new GUIGameOver(this);
        guiG = new GUIGanador(this);

        panelR = guiR.getPanel();
        panelA = guiA.getPanel();
        panelNU = guiNU.getPanel();
        panelG = guiG.getPanel();
        panelPri = guiPri.getPanelP();

        controlNU = guiNU.getControlNU();
        areaj = controlNU.getAreaJuego();
        cargadorS = new CargadorSonidos();
        registroJ = new RegistroJugador();

        volMusica = 0.0f;
        volSonido = 0.0f;

    }

    public GUIMenu getGUIMenu() {
        return guiM;
    }

    public GUIGameOver getGUIGO() {
        return guiGO;
    }

    public GUINU getGUINU() {
        return guiNU;
    }

    public PanelNU getPanelNU() {
        return panelNU;
    }

    public CargadorSonidos getCargadorSonidos() {
        return cargadorS;
    }

    public float getVolMu() {
        return volMusica;
    }

    public float getVolSo() {
        return volSonido;
    }

    public void ventanaGanador() {
        guiG.setVisible(true);
        cargadorS.reproducirSonido("./src/main/resources/SFX/Avisos/sonido_ ganar.wav", volSonido);
        panelG.setJTNickNameG(panelNU.getNickname(), panelNU.getJtPuntaje());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "Jugar":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_ boton_jugar.wav", volSonido);
                cargadorS.detenerMusica();
                cargadorS.reproducirMusica("./src/main/resources/SFX/Musica/musica_inicio.wav", volMusica);
                guiPri.setVisible(true);
                //guiP.setVisible(false);
                break;

            //COMANDOS QUE RESPONDEN A JUGAR
            case "PlayPrincipal":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botones.wav", volSonido);
                cargadorS.reproducirSonido("./src/main/resources/SFX/Avisos/sonido_popup.wav", volSonido);
                guiR.setVisible(true);
                panelPri.desactivarBotones(1);
                break;

            case "CheckRegistro":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botones.wav", volSonido);
                cargadorS.reproducirSonido("./src/main/resources/SFX/Avisos/sonido_popup.wav", volSonido);
                guiC.setVisible(true);
                guiR.dispose();
                panelNU.actualizarNickName(panelR.getJTNickName());
                panelR.limpiar();
                break;

            case "SalirRegistro":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botonExit.wav", volSonido);
                cargadorS.reproducirSonido("./src/main/resources/SFX/Avisos/sonido_Salir.wav", volSonido);
                guiR.dispose();
                panelR.limpiar();
                panelPri.activarBotones();
                break;

            case "SiguienteControles":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botones.wav", volSonido);
                cargadorS.reproducirSonido("./src/main/resources/SFX/Avisos/sonido_popup.wav", volSonido);
                guiO.setVisible(true);
                guiC.setVisible(false);
                break;

            case "SiguienteObjetivos":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botones.wav", volSonido);
                cargadorS.reproducirSonido("./src/main/resources/SFX/Avisos/sonido_popup.wav", volSonido);
                guiMJ.setVisible(true);
                guiO.setVisible(false);
                break;

            case "SiguienteMejoras":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botones.wav", volSonido);
                cargadorS.reproducirSonido("./src/main/resources/SFX/Avisos/sonido_popup.wav", volSonido);
                cargadorS.detenerMusica();
                cargadorS.reproducirMusica("./src/main/resources/SFX/Musica/musica_niveluno.wav", volMusica);
                guiNU.setVisible(true);
                guiNU.iniciarHilos();
                guiMJ.setVisible(false);
                panelPri.activarBotones();
                break;

            case "PlayMenu":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botones.wav", volSonido);
                guiM.dispose();
                break;

            case "StatsMenu":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botones.wav", volSonido);
                cargadorS.reproducirSonido("./src/main/resources/SFX/Avisos/sonido_popup.wav", volSonido);
                guiS.setVisible(true);
                break;

            case "AjustesMenu":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botones.wav", volSonido);
                cargadorS.reproducirSonido("./src/main/resources/SFX/Avisos/sonido_popup.wav", volSonido);
                guiA.setVisible(true);
                break;

            case "SalirMenu":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botones.wav", volSonido);
                cargadorS.reproducirSonido("./src/main/resources/SFX/Avisos/sonido_popup.wav", volSonido);
                guiSN.setVisible(true);
                guiM.setVisible(false);
                break;

            case "CheckSalirNivel":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botones.wav", volSonido);
                cargadorS.detenerMusica();
                cargadorS.reproducirMusica("./src/main/resources/SFX/Musica/musica_inicio.wav", volMusica);
                guiNU.detenerHilosSalir();
                guiNU.dispose();
                registroJ.crearJugador(panelNU.getNickname(), panelNU.getTiempo(), areaj.getPuntaje(), controlNU.getMunicionDisparada(), areaj.getEnemigosEliminados());
                guiPri.setVisible(true);
                break;

            case "ExitSalirNivel":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botonExit.wav", volSonido);
                cargadorS.reproducirSonido("./src/main/resources/SFX/Avisos/sonido_Salir.wav", volSonido);
                guiSN.dispose();
                guiM.setVisible(true);
                break;

            case "Reinicio":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botones.wav", volSonido);
                guiGO.setVisible(false);

                break;

            case "SalirGO":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botones.wav", volSonido);
                cargadorS.detenerMusica();
                cargadorS.reproducirMusica("./src/main/resources/SFX/Musica/musica_inicio.wav", volMusica);
                guiNU.dispose();
                guiGO.dispose();
                guiNU.detenerHilosSalir();
                registroJ.crearJugador(panelNU.getNickname(), panelNU.getTiempo(), areaj.getPuntaje(), controlNU.getMunicionDisparada(), areaj.getEnemigosEliminados());
                guiPri.setVisible(true);
                break;

            case "SalirGanador":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botones.wav", volSonido);
                cargadorS.detenerMusica();
                cargadorS.reproducirMusica("./src/main/resources/SFX/Musica/musica_inicio.wav", volMusica);
                guiG.dispose();
                guiNU.dispose();
                registroJ.crearJugador(panelNU.getNickname(), panelNU.getTiempo(), areaj.getPuntaje(), controlNU.getMunicionDisparada(), areaj.getEnemigosEliminados());
                guiPri.setVisible(true);
                break;

            //COMANDOS QUE RESPONDEN A STATS
            case "StatsPrincipal":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botones.wav", volSonido);
                cargadorS.reproducirSonido("./src/main/resources/SFX/Avisos/sonido_popup.wav", volSonido);
                guiS.getPanelStats().setDatosTabla(registroJ.getDatosTabla(), Jugador.ETIQUETAS_JUGADOR);
                guiS.setVisible(true);
                panelPri.desactivarBotones(2);
                break;

            case "DeleteStats":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botones.wav", volSonido);
                registroJ.eliminarJugador();
                guiS.getPanelStats().setDatosTabla(registroJ.getDatosTabla(), Jugador.ETIQUETAS_JUGADOR);
                break;

            case "ExitStats":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botonExit.wav", volSonido);
                cargadorS.reproducirSonido("./src/main/resources/SFX/Avisos/sonido_Salir.wav", volSonido);
                guiS.dispose();
                panelPri.activarBotones();
                break;

            //COMANDOS QUE RESPONDEN A INFO
            case "Info":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botones.wav", volSonido);
                cargadorS.reproducirSonido("./src/main/resources/SFX/Avisos/sonido_popup.wav", volSonido);
                guiI.setVisible(true);
                panelPri.desactivarBotones(3);
                break;

            case "SalirInfo":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botonExit.wav", volSonido);
                cargadorS.reproducirSonido("./src/main/resources/SFX/Avisos/sonido_Salir.wav", volSonido);
                guiI.dispose();
                panelPri.activarBotones();
                break;

            //COMANDOS QUE RESPONDEN A AJUSTES
            case "AjustesPrincipal":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botones.wav", volSonido);
                cargadorS.reproducirSonido("./src/main/resources/SFX/Avisos/sonido_popup.wav", volSonido);
                guiA.setVisible(true);
                panelPri.desactivarBotones(4);
                break;

            case "SalirAjustes":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botonExit.wav", volSonido);
                cargadorS.reproducirSonido("./src/main/resources/SFX/Avisos/sonido_Salir.wav", volSonido);
                guiA.setVisible(false);
                panelPri.activarBotones();
                break;

            case "MMusica":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botones.wav", volSonido);
                panelA.mutearMusica();
                panelA.setTVolumenMusica("0");
                volMusica = 50.0F;
                break;

            case "UMMusica":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botones.wav", volSonido);
                panelA.desmutearMusica();
                panelA.setTVolumenMusica("100");
                volMusica = 0.0F;
                break;

            case "MSonidos":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botones.wav", volSonido);
                panelA.mutearSonidos();
                panelA.setTVolumenSonido("0");
                volSonido = 50.0F;
                break;

            case "UMSonidos":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botones.wav", volSonido);
                panelA.desmutearSonidos();
                panelA.setTVolumenSonido("100");
                volSonido = 0.0F;
                break;

            case "VUMusica":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botonesVolumen.wav", volSonido);
                if (volMusica > 0.0f) {
                    volMusica -= 12.5f;
                }
                if (panelA.getTVolumenMusica().equalsIgnoreCase("0")) {
                    panelA.setTVolumenMusica("25");
                } else if (panelA.getTVolumenMusica().equalsIgnoreCase("25")) {
                    panelA.setTVolumenMusica("50");
                } else if (panelA.getTVolumenMusica().equalsIgnoreCase("50")) {
                    panelA.setTVolumenMusica("75");
                } else if (panelA.getTVolumenMusica().equalsIgnoreCase("75")) {
                    panelA.setTVolumenMusica("100");
                }
                break;

            case "VDMusica":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botonesVolumen.wav", volSonido);
                if (volMusica < 50.0f) {
                    volMusica += 12.5f;
                }
                if (panelA.getTVolumenMusica().equalsIgnoreCase("100")) {
                    panelA.setTVolumenMusica("75");
                } else if (panelA.getTVolumenMusica().equalsIgnoreCase("75")) {
                    panelA.setTVolumenMusica("50");
                } else if (panelA.getTVolumenMusica().equalsIgnoreCase("50")) {
                    panelA.setTVolumenMusica("25");
                } else if (panelA.getTVolumenMusica().equalsIgnoreCase("25")) {
                    panelA.setTVolumenMusica("0");
                }
                break;

            case "VUSonidos":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botonesVolumen.wav", volSonido);
                if (volSonido > 0.0f) {
                    volSonido -= 12.5f;
                }

                if (panelA.getTVolumenSonidos().equalsIgnoreCase("0")) {
                    panelA.setTVolumenSonido("25");
                } else if (panelA.getTVolumenSonidos().equalsIgnoreCase("25")) {
                    panelA.setTVolumenSonido("50");
                } else if (panelA.getTVolumenSonidos().equalsIgnoreCase("50")) {
                    panelA.setTVolumenSonido("75");
                } else if (panelA.getTVolumenSonidos().equalsIgnoreCase("75")) {
                    panelA.setTVolumenSonido("100");
                }
                break;

            case "VDSonidos":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botonesVolumen.wav", volSonido);
                if (volSonido < 50.0f) {
                    volSonido += 12.5f;
                }
                if (panelA.getTVolumenSonidos().equalsIgnoreCase("100")) {
                    panelA.setTVolumenSonido("75");
                } else if (panelA.getTVolumenSonidos().equalsIgnoreCase("75")) {
                    panelA.setTVolumenSonido("50");
                } else if (panelA.getTVolumenSonidos().equalsIgnoreCase("50")) {
                    panelA.setTVolumenSonido("25");
                } else if (panelA.getTVolumenSonidos().equalsIgnoreCase("25")) {
                    panelA.setTVolumenSonido("0");
                }
                break;

            //COMANDOS QUE RESPONDEN A SALIR
            case "SalirPrincipal":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botones.wav", volSonido);
                cargadorS.reproducirSonido("./src/main/resources/SFX/Avisos/sonido_popup.wav", volSonido);
                guiSJ.setVisible(true);
                panelPri.desactivarBotones(5);
                break;
                
            case "CheckSalirPrincipal":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botones.wav", volSonido);
                System.exit(0);
                panelPri.activarBotones();
                break;
                
            case "ExitSalirPrincipal":
                cargadorS.reproducirSonido("./src/main/resources/SFX/Botones/sonido_botonExit.wav", volSonido);
                cargadorS.reproducirSonido("./src/main/resources/SFX/Avisos/sonido_Salir.wav", volSonido);
                guiSJ.dispose();
                panelPri.activarBotones();
                break;

        }
    }

}
