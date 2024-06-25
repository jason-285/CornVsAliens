/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Jason
 */
public class GestionCeldas extends DefaultTableCellRenderer {
    private String tipo = "text";
    private Font normal = new Font("Milky Nice Clean", Font.PLAIN, 18);

    public GestionCeldas(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {

        Color colorFondo = new Color(191,151,64);
        Color colorFondoPorDefecto = new Color(191,151,64);
        Color colorFondoSeleccion = new Color(191,151,64);

        if (selected) {
            this.setBackground(colorFondoPorDefecto);
        } else {
            this.setBackground(new Color(191,151,64));
        }
        
        if (tipo.equals("texto")) {
            if (focused) {
                colorFondo = colorFondoSeleccion;
            } else {
                colorFondo = colorFondoPorDefecto;
            }
            this.setHorizontalAlignment(JLabel.CENTER);
            this.setText((String) value);
            this.setForeground(new Color(247,208,132)); 
            this.setBackground(new Color(191,151,64));
            this.setFont(normal);
            return this;
        }

        if (tipo.equals("numerico")) {
            if (focused) {
                colorFondo = colorFondoSeleccion;
            } else {
                colorFondo = colorFondoPorDefecto;
            }
            // System.out.println(value);
            this.setHorizontalAlignment(JLabel.CENTER);
            this.setText((String) value);
            this.setForeground(new Color(247,208,132)); 
            this.setBackground(new Color(191,151,64));
            this.setFont(normal);
            return this;
        }

        return this;
    }
}
