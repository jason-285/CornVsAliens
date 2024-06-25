/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorPrincipal;
import java.awt.Color;

/**
 *
 * @author Jason
 */
public class PanelObjetivos extends javax.swing.JPanel {

    /**
     * Creates new form PanelObjetivos
     */
    public PanelObjetivos() {
        initComponents();
        setBackground(new Color(0,0,0,0));
    }
    
    public void escuchar(ControladorPrincipal control){
        jBSiguiente.addActionListener(control);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBSiguiente = new javax.swing.JButton();
        jLControles = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Botones/boton_siguiente_unp.png"))); // NOI18N
        jBSiguiente.setActionCommand("SiguienteObjetivos");
        jBSiguiente.setContentAreaFilled(false);
        jBSiguiente.setPreferredSize(new java.awt.Dimension(144, 91));
        jBSiguiente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Botones/boton_siguiente_press.png"))); // NOI18N
        add(jBSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 570, -1, -1));

        jLControles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Ventanas/ventana_objetivos.png"))); // NOI18N
        add(jLControles, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBSiguiente;
    private javax.swing.JLabel jLControles;
    // End of variables declaration//GEN-END:variables
}
