/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Jason
 */
public class CargadorSonidos {

    private AudioInputStream musica, sonido;
    private Clip clip, clip2;

    public CargadorSonidos() {
    }

    public void reproducirMusica(String ruta, float volumen) {
        try {
            musica = AudioSystem.getAudioInputStream(new File(ruta).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(musica);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-volumen); // Reduce volume by 10 decibels.
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException ex) {
            System.out.println("Error al reproducir");
        } catch (IOException ex) {
            System.out.println("Error al reproducir");
        } catch (LineUnavailableException ex) {
            System.out.println("Error al reproducir");
        }
    }

    public void reproducirSonido(String ruta, float volumen) {
        try {
            musica = AudioSystem.getAudioInputStream(new File(ruta).getAbsoluteFile());
            clip2 = AudioSystem.getClip();
            clip2.open(musica);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-volumen); // Reduce volume by 10 decibels.
                clip2.start();
        } catch (UnsupportedAudioFileException ex) {
            System.out.println("Error al reproducir");
        } catch (IOException ex) {
            System.out.println("Error al reproducir");
        } catch (LineUnavailableException ex) {
            System.out.println("Error al reproducir");
        }
    }

    public void detenerMusica() {
        clip.stop();
    }

    public void detenerSonido() {
        clip2.stop();
    }

}
