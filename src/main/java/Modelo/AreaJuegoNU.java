package Modelo;

import Controlador.ControladorPrincipal;
import java.awt.Graphics;
import java.util.ArrayList;
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
public class AreaJuegoNU {

    private ControladorPrincipal controlP;
    private Corn corn;

    private ArrayList<EnemigoNU> arregloEnemys;
    private ArrayList<DisparoCorn> arregloDisparos;
    private ArrayList<VidaEnemiga> arregloVidaE;
    private ArrayList<PowerUp> arregloPowerUps;
    private ArrayList<Laser> arregloLaser;

    private DisparoCorn bala;
    private Laser laser;

    private int puntaje;
    private int enemigosEliminados;
    private int dañoBalas;

    private boolean jugando;

    public AreaJuegoNU(ControladorPrincipal controlP) {
        this.controlP = controlP;

        corn = new Corn(new ImageIcon("./src/main/resources/IMG/Personaje Principal Poses/personaje_base_derecha.png"), 34, 641, 100, 50);

        arregloDisparos = new ArrayList<DisparoCorn>();
        arregloEnemys = new ArrayList<EnemigoNU>();
        arregloVidaE = new ArrayList<VidaEnemiga>();
        arregloPowerUps = new ArrayList<PowerUp>();
        arregloLaser = new ArrayList<Laser>();

        llenarArregloEnemys();
        llenarArregloVidaE();
        llenarArregloPowerUps();

        puntaje = 0;
        enemigosEliminados = 0;
        dañoBalas = 10;

        jugando = true;

    }

    //METODOS QUE RETORNAN DATOS IMPORTANTES
    public Corn getCorn() {
        return corn;
    }

    public EnemigoNU getEnemys(int indice) { //OBTENER UN ENEMIGO DEL ARREGLO
        return arregloEnemys.get(indice);
    }

    public VidaEnemiga getVidasE(int indice) {
        return arregloVidaE.get(indice);
    }

    public DisparoCorn getDisparo(int indice) {
        return arregloDisparos.get(indice);
    }

    public PowerUp getPowerUp(int indice) {
        return arregloPowerUps.get(indice);
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getEnemigosEliminados() {
        return enemigosEliminados;
    }

    public int getCantidadDisparos() {
        int disparos = 0;
        for (int i = 0; i < arregloDisparos.size(); i++) {
            disparos++;
        }
        return disparos;
    }

    public int getCantidadPowerups() {
        return arregloPowerUps.size();
    }

    public int getDañoBalas() {
        return dañoBalas;
    }

    public int cantidadEnemigos() {     //OBTENER LA CANTIDAD DE ENEMIGOS
        return arregloEnemys.size();
    }

    public int cantidadVidaEnemigos() {
        return arregloVidaE.size();
    }

    //METODOS PARA LLENAR ARREGLO Y AGREGAR OBJETOS
    public void llenarArregloEnemys() {
        EnemigoNU enemy;
        //Enemigos tipo 1                                                                                                                                                                                                                                                                              
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien1/a.gif"), 2353, (int) (Math.random() * 218) + 475, 100, 1));
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien1/a.gif"), 11064, (int) (Math.random() * 218) + 475, 100, 1));
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien1/a.gif"), 6950, (int) (Math.random() * 218) + 475, 100, 1));
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien1/a.gif"), 4218, (int) (Math.random() * 218) + 475, 100, 1));
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien1/a.gif"), 2786, (int) (Math.random() * 218) + 475, 100, 1));
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien1/a.gif"), 7516, (int) (Math.random() * 218) + 475, 100, 1));
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien1/a.gif"), 9765, (int) (Math.random() * 218) + 475, 100, 1));
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien1/a.gif"), 3652, (int) (Math.random() * 218) + 475, 100, 1));
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien1/a.gif"), 12296, (int) (Math.random() * 218) + 475, 100, 1));
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien1/a.gif"), 8082, (int) (Math.random() * 218) + 475, 100, 1));
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien1/a.gif"), 11730, (int) (Math.random() * 218) + 475, 100, 1));
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien1/a.gif"), 5851, (int) (Math.random() * 218) + 475, 100, 1));

        //Enemigos tipo 2
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien2/b.gif"), 10631, (int) (Math.random() * 218) + 475, 100, 2));
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien2/b.gif"), 12862, (int) (Math.random() * 218) + 475, 100, 2));
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien2/b.gif"), 1920, (int) (Math.random() * 218) + 475, 100, 2));
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien2/b.gif"), 5418, (int) (Math.random() * 218) + 475, 100, 2));
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien2/b.gif"), 3319, (int) (Math.random() * 218) + 475, 100, 2));
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien2/b.gif"), 8365, (int) (Math.random() * 218) + 475, 100, 2));
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien2/b.gif"), 6284, (int) (Math.random() * 218) + 475, 100, 2));
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien2/b.gif"), 13528, (int) (Math.random() * 218) + 475, 100, 2));
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien2/b.gif"), 12013, (int) (Math.random() * 218) + 475, 100, 2));
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien2/b.gif"), 10198, (int) (Math.random() * 218) + 475, 100, 2));

        //Enemigos tipo 3
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien3/c.gif"), 2986, (int) (Math.random() * 218) + 475, 100, 3));
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien3/c.gif"), 3935, (int) (Math.random() * 218) + 475, 100, 3));
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien3/c.gif"), 6617, (int) (Math.random() * 218) + 475, 100, 3));
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien3/c.gif"), 13079, (int) (Math.random() * 218) + 475, 100, 3));
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien3/c.gif"), 10897, (int) (Math.random() * 218) + 475, 100, 3));
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien3/c.gif"), 7233, (int) (Math.random() * 218) + 475, 100, 3));
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien3/c.gif"), 13345, (int) (Math.random() * 218) + 475, 100, 3));
        arregloEnemys.add(enemy = new EnemigoNU(new ImageIcon("./src/main/resources/IMG/Aliens Poses/Alien3/c.gif"), 7799, (int) (Math.random() * 218) + 475, 100, 3));
    }

    public void llenarArregloVidaE() {
        VidaEnemiga vidaE;
        for (int i = 0; i < arregloEnemys.size(); i++) {
            arregloVidaE.add(vidaE = new VidaEnemiga(new ImageIcon("./src/main/resources/IMG/Iconos Munición y Vida/vida_enemigo_100_1.png"), arregloEnemys.get(i).getX(), arregloEnemys.get(i).getY() - 24, arregloEnemys.get(i)));
        }
    }

    public void llenarArregloPowerUps() {
        PowerUp pUp;

        //PowerUp tipo 1
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_municion_pesada.png"), (int) (Math.random() * 648) + 180, -83, 1));
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_municion_pesada.png"), (int) (Math.random() * 648) + 180, -1055, 1));
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_municion_pesada.png"), (int) (Math.random() * 648) + 180, -2027, 1));
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_municion_pesada.png"), (int) (Math.random() * 648) + 180, -2999, 1));
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_municion_pesada.png"), (int) (Math.random() * 648) + 180, -3971, 1));
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_municion_pesada.png"), (int) (Math.random() * 648) + 180, -4943, 1));
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_municion_pesada.png"), (int) (Math.random() * 648) + 180, -5915, 1));
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_municion_pesada.png"), (int) (Math.random() * 648) + 180, -6887, 1));
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_municion_pesada.png"), (int) (Math.random() * 648) + 180, -7859, 1));
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_municion_pesada.png"), (int) (Math.random() * 648) + 180, -8831, 1));
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_municion_pesada.png"), (int) (Math.random() * 648) + 180, -9803, 1));
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_municion_pesada.png"), (int) (Math.random() * 648) + 180, -10775, 1));

        //PowerUp tipo 2
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_municion_ligera.png"), (int) (Math.random() * 648) + 180, -11747, 2));
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_municion_ligera.png"), (int) (Math.random() * 648) + 180, -12719, 2));
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_municion_ligera.png"), (int) (Math.random() * 648) + 180, -13691, 2));
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_municion_ligera.png"), (int) (Math.random() * 648) + 180, -14663, 2));
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_municion_ligera.png"), (int) (Math.random() * 648) + 180, -15635, 2));
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_municion_ligera.png"), (int) (Math.random() * 648) + 180, -16607, 2));
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_municion_ligera.png"), (int) (Math.random() * 648) + 180, -17579, 2));
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_municion_ligera.png"), (int) (Math.random() * 648) + 180, -18551, 2));
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_municion_ligera.png"), (int) (Math.random() * 648) + 180, -19523, 2));

        //PowerUp tipo 3
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_vida.png"), (int) (Math.random() * 648) + 180, -2027, 3));
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_vida.png"), (int) (Math.random() * 648) + 180, -4943, 3));
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_vida.png"), (int) (Math.random() * 648) + 180, -7859, 3));
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_vida.png"), (int) (Math.random() * 648) + 180, -10775, 3));
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_vida.png"), (int) (Math.random() * 648) + 180, -13691, 3));
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_vida.png"), (int) (Math.random() * 648) + 180, -16607, 3));
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_vida.png"), (int) (Math.random() * 648) + 180, -19523, 3));
        arregloPowerUps.add(pUp = new PowerUp(new ImageIcon("./src/main/resources/IMG/PoweUp/powerup_vida.png"), (int) (Math.random() * 648) + 180, -22439, 3));

    }

    public void añadirDisparo() {
        arregloDisparos.add(bala = new DisparoCorn(new ImageIcon("./src/main/resources/IMG/municion y laser/municion_personaje.png"), corn.getX() + 128, corn.getY() + 169, dañoBalas, 2));
        controlP.getCargadorSonidos().reproducirSonido("./src/main/resources/SFX/Disparos/sonido_disparo_corn.wav", controlP.getVolSo());
        //System.out.println("Se crea disparo");
    }

    public void añadirLaser() {
        controlP.getCargadorSonidos().reproducirSonido("./src/main/resources/SFX/Disparos/sonido_laser.wav", controlP.getVolSo());
        for (int i = 0; i < arregloEnemys.size(); i++) {

            if (arregloEnemys.get(i).getTipo() == 1 && arregloEnemys.get(i).getX() < 1920) {
                arregloLaser.add(laser = new Laser(new ImageIcon("./src/main/resources/IMG/municion y laser/laser_enemy1.png"), arregloEnemys.get(i).getX(), arregloEnemys.get(i).getY() + 156, 10));

            } else if (arregloEnemys.get(i).getTipo() == 2 && arregloEnemys.get(i).getX() < 1920) {
                arregloLaser.add(laser = new Laser(new ImageIcon("./src/main/resources/IMG/municion y laser/laser_enemy2.png"), arregloEnemys.get(i).getX(), arregloEnemys.get(i).getY() + 160, 20));

            } else if (arregloEnemys.get(i).getTipo() == 3 && arregloEnemys.get(i).getX() < 1920) {
                arregloLaser.add(laser = new Laser(new ImageIcon("./src/main/resources/IMG/municion y laser/laser_enemy3.png"), arregloEnemys.get(i).getX(), arregloEnemys.get(i).getY() + 162, 30));
            }

        }
    }

    //METODOS PARA REMOVER O ACTUALIZAR DATOS Y OBJETOS
    public void removerDisparo(int indice) {
        if (arregloDisparos.get(indice).getX() >= 1920) {
            arregloDisparos.remove(indice);

            //System.out.println("Se elimina disparo");
        }
    }

    public void actualizarVidaEnemigo(int i) {
        if (arregloVidaE.get(i).getEnemy().getVida() == 100) {
            arregloVidaE.get(i).setImagen(new ImageIcon("./src/main/resources/IMG/Iconos Munición y Vida/vida_enemigo_100_1.png"));
        } else if (arregloVidaE.get(i).getEnemy().getVida() == 90) {
            arregloVidaE.get(i).setImagen(new ImageIcon("./src/main/resources/IMG/Iconos Munición y Vida/vida_enemigo_90_1.png"));
        } else if (arregloVidaE.get(i).getEnemy().getVida() == 80) {
            arregloVidaE.get(i).setImagen(new ImageIcon("./src/main/resources/IMG/Iconos Munición y Vida/vida_enemigo_80_1.png"));
        } else if (arregloVidaE.get(i).getEnemy().getVida() == 70) {
            arregloVidaE.get(i).setImagen(new ImageIcon("./src/main/resources/IMG/Iconos Munición y Vida/vida_enemigo_70_1.png"));
        } else if (arregloVidaE.get(i).getEnemy().getVida() == 60) {
            arregloVidaE.get(i).setImagen(new ImageIcon("./src/main/resources/IMG/Iconos Munición y Vida/vida_enemigo_60_1.png"));
        } else if (arregloVidaE.get(i).getEnemy().getVida() == 50) {
            arregloVidaE.get(i).setImagen(new ImageIcon("./src/main/resources/IMG/Iconos Munición y Vida/vida_enemigo_50_1.png"));
        } else if (arregloVidaE.get(i).getEnemy().getVida() == 40) {
            arregloVidaE.get(i).setImagen(new ImageIcon("./src/main/resources/IMG/Iconos Munición y Vida/vida_enemigo_40_1.png"));
        } else if (arregloVidaE.get(i).getEnemy().getVida() == 30) {
            arregloVidaE.get(i).setImagen(new ImageIcon("./src/main/resources/IMG/Iconos Munición y Vida/vida_enemigo_30_1.png"));
        } else if (arregloVidaE.get(i).getEnemy().getVida() == 20) {
            arregloVidaE.get(i).setImagen(new ImageIcon("./src/main/resources/IMG/Iconos Munición y Vida/vida_enemigo_20_1.png"));
        } else if (arregloVidaE.get(i).getEnemy().getVida() == 10) {
            arregloVidaE.get(i).setImagen(new ImageIcon("./src/main/resources/IMG/Iconos Munición y Vida/vida_enemigo_10_1.png"));
        }
    }

    public void moverLasers() {
        for (int i = 0; i < arregloLaser.size(); i++) {
            arregloLaser.get(i).mover();

        }
    }

    public void dibujar(Graphics g) {
        for (int i = 0; i < arregloDisparos.size(); i++) {
            arregloDisparos.get(i).pintarImagen(g);
        }

        for (int i = 0; i < arregloPowerUps.size(); i++) { //AQUI PINTO TODOS LOS POWER UPS DEL JUEGO
            arregloPowerUps.get(i).pintarImagen(g);
        }

        for (int i = 0; i < arregloLaser.size(); i++) {
            arregloLaser.get(i).pintarImagen(g);
        }

        corn.pintarImagen(g);

        for (int i = 0; i < arregloEnemys.size(); i++) {
            arregloEnemys.get(i).pintarImagen(g);
        }

        for (int i = 0; i < arregloVidaE.size(); i++) {
            arregloVidaE.get(i).pintarImagen(g);
        }

    }

    //METODOS QUE DETECTAN Y CONTROLAN COLISIONES
    public void isColisionCuerpos(int indice) {
        if (arregloEnemys.get(indice).getHitbox().intersects(corn.getHitbox())) {
            muerteCorn();
        }
    }

    public boolean isColisionBala() {
        for (int i = 0; i < arregloDisparos.size(); i++) {
            for (int j = 0; j < arregloEnemys.size(); j++) {

                if (arregloDisparos.get(i).getHitbox().intersects(arregloEnemys.get(j).getHitbox())) {
                    controlP.getCargadorSonidos().reproducirSonido("./src/main/resources/SFX/Avisos/sonido_impactoEnemigo.wav", controlP.getVolSo());
                    //System.out.println("Hay colision bala");

                    if (arregloDisparos.get(i).getDaño() == 10) {
                        arregloEnemys.get(j).setVida(arregloEnemys.get(j).getVida() - 10);
                        //System.out.println("Se inflinge daño de 10");

                        arregloDisparos.remove(i);
                        //System.out.println("Se remueve disparo");

                    } else if (arregloDisparos.get(i).getDaño() == 20) {
                        arregloEnemys.get(j).setVida(arregloEnemys.get(j).getVida() - 20);
                        //System.out.println("Se inflinge daño de 20");

                        arregloDisparos.remove(i);
                        //System.out.println("Se remueve disparo");

                    }

                    if (arregloEnemys.get(j).getVida() <= 0) {
                        int tipo = arregloEnemys.get(j).getTipo();

                        if (tipo == 1) {
                            puntaje += 200;
                            enemigosEliminados++;
                            //System.out.println("Se suman 200");

                        } else if (tipo == 2) {
                            puntaje += 500;
                            enemigosEliminados++;
                            //System.out.println("Se suman 500");

                        } else if (tipo == 3) {
                            puntaje += 1000;
                            enemigosEliminados++;
                            //System.out.println("Se suman 1000");
                        }

                        controlP.getCargadorSonidos().reproducirSonido("./src/main/resources/SFX/Avisos/sonido_muerteEnemy.wav", controlP.getVolSo());
                        arregloEnemys.remove(j);
                        arregloVidaE.remove(j);
                        //System.out.println("Se remueve enemigo");
                    }

                    return true;
                }
            }
        }
        return false;
    }

    public void isColisionPowerUp(int indice) {
        for (int i = 0; i < arregloEnemys.size(); i++) {
            if (arregloEnemys.get(i).getHitbox().intersects(arregloPowerUps.get(indice).getHitbox())) {
                arregloPowerUps.remove(indice);

            }
        }

        if (arregloPowerUps.get(indice).getHitbox().intersects(corn.getHitbox())) {
            if (arregloPowerUps.get(indice).getTipo() == 1) {
                corn.setMunicion(corn.getMunicion() + 15);
                arregloPowerUps.remove(indice);

            } else if (arregloPowerUps.get(indice).getTipo() == 2) {
                corn.setMunicion(corn.getMunicion() + 10);
                dañoBalas = 20;
                arregloPowerUps.remove(indice);

            } else if (arregloPowerUps.get(indice).getTipo() == 3) {
                if (corn.getVida() < 100) {
                    corn.setVida(corn.getVida() + 10);
                    arregloPowerUps.remove(indice);

                } else if (corn.getVida() == 100) {
                    puntaje += 100;
                }
                arregloPowerUps.remove(indice);
            }
            controlP.getCargadorSonidos().reproducirSonido("./src/main/resources/SFX/Avisos/sonido_colisionPUP.wav", controlP.getVolSo());
        }

    }

    public void isColisionLasers() {
        for (int i = 0; i < arregloLaser.size(); i++) {
            if (arregloLaser.get(i).getHitbox().intersects(corn.getHitbox())) {
                controlP.getCargadorSonidos().reproducirSonido("./src/main/resources/SFX/Avisos/sonido_impactoCorn.wav", controlP.getVolSo());

                if (arregloLaser.get(i).getDaño() == 10) {
                    corn.setVida(corn.getVida() - 10);

                } else if (arregloLaser.get(i).getDaño() == 20) {
                    corn.setVida(corn.getVida() - 20);

                } else if (arregloLaser.get(i).getDaño() == 30) {
                    corn.setVida(corn.getVida() - 30);
                }

                if (corn.getVida() <= 0) {
                    muerteCorn();
                }

                arregloLaser.remove(i);

            } else if (arregloLaser.get(i).getX() <= 0) {
                arregloLaser.remove(i);
            }

        }
    }

    //METODOS QUE CONTROLAN EL FINAL DEL NIVEL
    public void consecuenciaMorir() {
        if (!jugando) {
            for (int i = 0; i < arregloLaser.size(); i++) {
                arregloLaser.remove(i);
            }
            for (int i = 0; i < arregloPowerUps.size(); i++) {
                arregloPowerUps.remove(i);
            }
            for (int i = 0; i < arregloDisparos.size(); i++) {
                arregloDisparos.remove(i);
            }

        }
    }

    public void gane() {
        if (enemigosEliminados == 30) {
            controlP.ventanaGanador();
            controlP.getCargadorSonidos().reproducirSonido("./src/main/resources/SFX/Avisos/sonido_ganar.wav", controlP.getVolSo());
            controlP.getCargadorSonidos().detenerMusica();
            controlP.getCargadorSonidos().reproducirMusica("./src/main/resources/SFX/Musica/musica_pog2.wav", controlP.getVolMu());

            for (int i = 0; i < arregloPowerUps.size(); i++) {
                arregloPowerUps.remove(i);
            }

            for (int i = 0; i < arregloLaser.size(); i++) {
                arregloLaser.remove(i);
            }

            for (int i = 0; i < arregloDisparos.size(); i++) {
                arregloDisparos.remove(i);
            }

            controlP.getGUINU().detenerHilosMuGa();
        }
    }

    public void pierde(int indice) {
        if (arregloEnemys.get(indice).getX() <= -50) {
            controlP.getGUIGO().setVisible(true);
            controlP.getGUINU().detenerHilosMuGa();
            jugando = false;
            consecuenciaMorir();
        }
    }

    public void muerteCorn() {
        controlP.getCargadorSonidos().reproducirSonido("./src/main/resources/SFX/Avisos/sonido_cron_daño.wav", controlP.getVolSo());
        controlP.getCargadorSonidos().detenerMusica();
        controlP.getCargadorSonidos().reproducirMusica("./src/main/resources/SFX/Musica/musica_pog.wav", controlP.getVolMu());
        corn.setVida(0);
        corn.setY(corn.getY() + 100);
        corn.setImagen(new ImageIcon("./src/main/resources/IMG/Personaje Principal Poses/personaje_muere7_derecha.png"));
        controlP.getGUIGO().setVisible(true);
        //System.out.println("Palmó corn");

        jugando = false;
    }

}
