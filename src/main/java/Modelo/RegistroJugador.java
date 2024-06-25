/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Jason
 */
public class RegistroJugador {
    private ArrayList<Jugador> arregloJugadores;
    private File archivo;
    private JSONObject baseJSONJugadores;

    public RegistroJugador() {
        arregloJugadores = new ArrayList<Jugador>();
        archivo = new File("jugadores.json");

    }
    
    public Jugador getJugador(int indice) {
        return arregloJugadores.get(indice);
    }
    
    public int getCantidadJugadores() {
        return arregloJugadores.size();
    }
    
    public void crearJugador(String nombre, String duracion, int puntaje, int balasDiparadas, int enemigosEliminados) {
        Jugador jugador = new Jugador();
        jugador.setNombre(nombre);
        jugador.setDuracion(duracion);
        jugador.setPuntaje(puntaje);
        jugador.setBalasDiparadas(balasDiparadas);
        jugador.setEnemigosEliminados(enemigosEliminados);
        arregloJugadores.add(jugador);
        escribirJSON();
        System.out.println("Se ha creado un jugador");

    }

    public void eliminarJugador() {
        for (int i = 0; i < arregloJugadores.size(); i++) {
            arregloJugadores.remove(i);
        }
        escribirJSON();
    }

    public void escribirJSON() {
        JSONArray jsonArregloJugadores = new JSONArray();
        baseJSONJugadores = new JSONObject();
        for (Jugador jugador : arregloJugadores) {
            JSONObject objJSONJugador = new JSONObject();
            objJSONJugador.put("nombre", jugador.getNombre());
            objJSONJugador.put("duracion", jugador.getDuracion());
            objJSONJugador.put("puntaje", jugador.getPuntaje());
            objJSONJugador.put("balas", jugador.getBalasDiparadas());
            objJSONJugador.put("enemigos", jugador.getEnemigosEliminados());

            jsonArregloJugadores.add(objJSONJugador);
        }
        baseJSONJugadores.put("Lista Jugadores", jsonArregloJugadores);

        try {
            FileWriter archivoEscribe = new FileWriter(archivo);
            archivoEscribe.write(baseJSONJugadores.toJSONString());
            archivoEscribe.flush();
            archivoEscribe.close();
            System.out.println("Se creo el archivo");
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void leerJSON() {
        arregloJugadores = new ArrayList<Jugador>(); //Ojo con esto
        JSONParser parser = new JSONParser();
        try {
            FileReader archivoLeer = new FileReader(archivo);
            Object obj = parser.parse(archivoLeer);
            baseJSONJugadores = (JSONObject) obj;

            JSONArray arregloJSON = (JSONArray) baseJSONJugadores.get("Lista Jugadores");
            for (Object object : arregloJSON) {
                JSONObject objJugador = (JSONObject) object;
                Jugador jugador = new Jugador();
                jugador.setNombre(objJugador.get("nombre").toString());
                jugador.setDuracion(objJugador.get("duracion").toString());
                jugador.setPuntaje(Integer.parseInt(objJugador.get("puntaje").toString()));
                jugador.setBalasDiparadas(Integer.parseInt(objJugador.get("balas").toString()));
                jugador.setEnemigosEliminados(Integer.parseInt(objJugador.get("enemigos").toString()));
                arregloJugadores.add(jugador);
            }

        } catch (FileNotFoundException ex) {
            System.err.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.err.println("Error al leer");
        } catch (org.json.simple.parser.ParseException ex) {
            ex.printStackTrace();
        }
    }

    public String[][] getDatosTabla() { //Lo usamos para cargar la matriz
        leerJSON();
        String[][] matrizTabla = new String[arregloJugadores.size()][Jugador.ETIQUETAS_JUGADOR.length];
        for (int f = 0; f < arregloJugadores.size(); f++) {
            for (int c = 0; c < matrizTabla[0].length; c++) {
                matrizTabla[f][c] = arregloJugadores.get(f).setDatosJugador(c);
            }
        }
        return matrizTabla;
    }

}
