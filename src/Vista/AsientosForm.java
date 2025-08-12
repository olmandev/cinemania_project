/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vista;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.ItemVentaPOO;

/**
 *
 * @author alexs
 */
public class AsientosForm extends javax.swing.JDialog {

    private String asientosSeleccionado = "";

    public AsientosForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public String obtenerAsiento() {
        return asientosSeleccionado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AsientosPanel = new javax.swing.JPanel();
        C2 = new javax.swing.JToggleButton();
        A1 = new javax.swing.JToggleButton();
        C1 = new javax.swing.JToggleButton();
        A2 = new javax.swing.JToggleButton();
        B3 = new javax.swing.JToggleButton();
        B2 = new javax.swing.JToggleButton();
        B1 = new javax.swing.JToggleButton();
        A3 = new javax.swing.JToggleButton();
        C3 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        botAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AsientosPanel.setBackground(new java.awt.Color(0, 0, 0));
        AsientosPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/activo.png"))); // NOI18N
        C2.setBorderPainted(false);
        C2.setContentAreaFilled(false);
        C2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inactivo.png"))); // NOI18N
        C2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inactivo.png"))); // NOI18N
        AsientosPanel.add(C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 205, 125, 180));

        A1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/activo.png"))); // NOI18N
        A1.setBorderPainted(false);
        A1.setContentAreaFilled(false);
        A1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inactivo.png"))); // NOI18N
        A1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inactivo.png"))); // NOI18N
        A1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A1ActionPerformed(evt);
            }
        });
        AsientosPanel.add(A1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 130, 190));

        C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/activo.png"))); // NOI18N
        C1.setBorderPainted(false);
        C1.setContentAreaFilled(false);
        C1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inactivo.png"))); // NOI18N
        C1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inactivo.png"))); // NOI18N
        C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C1ActionPerformed(evt);
            }
        });
        AsientosPanel.add(C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 125, 190));

        A2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/activo.png"))); // NOI18N
        A2.setBorderPainted(false);
        A2.setContentAreaFilled(false);
        A2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inactivo.png"))); // NOI18N
        A2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inactivo.png"))); // NOI18N
        A2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A2ActionPerformed(evt);
            }
        });
        AsientosPanel.add(A2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 125, 170));

        B3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/activo.png"))); // NOI18N
        B3.setBorderPainted(false);
        B3.setContentAreaFilled(false);
        B3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inactivo.png"))); // NOI18N
        B3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inactivo.png"))); // NOI18N
        AsientosPanel.add(B3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 405, 125, 170));

        B2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/activo.png"))); // NOI18N
        B2.setBorderPainted(false);
        B2.setContentAreaFilled(false);
        B2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inactivo.png"))); // NOI18N
        B2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inactivo.png"))); // NOI18N
        AsientosPanel.add(B2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 125, 170));

        B1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/activo.png"))); // NOI18N
        B1.setBorderPainted(false);
        B1.setContentAreaFilled(false);
        B1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inactivo.png"))); // NOI18N
        B1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inactivo.png"))); // NOI18N
        AsientosPanel.add(B1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 125, 180));

        A3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/activo.png"))); // NOI18N
        A3.setBorderPainted(false);
        A3.setContentAreaFilled(false);
        A3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inactivo.png"))); // NOI18N
        A3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inactivo.png"))); // NOI18N
        A3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A3ActionPerformed(evt);
            }
        });
        AsientosPanel.add(A3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 405, 125, 170));

        C3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/activo.png"))); // NOI18N
        C3.setBorderPainted(false);
        C3.setContentAreaFilled(false);
        C3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inactivo.png"))); // NOI18N
        C3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inactivo.png"))); // NOI18N
        AsientosPanel.add(C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 405, 125, 170));

        jLabel1.setFont(new java.awt.Font("Rockwell Condensed", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("C");
        AsientosPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 560, 80, 40));

        jLabel2.setFont(new java.awt.Font("Rockwell Condensed", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("1");
        AsientosPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 50, 80));

        jLabel3.setFont(new java.awt.Font("Rockwell Condensed", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("3");
        AsientosPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 80, 80));

        jLabel4.setFont(new java.awt.Font("Rockwell Condensed", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("A");
        AsientosPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 560, 80, 40));

        jLabel5.setText("jLabel1");
        AsientosPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 560, 80, 40));

        jLabel6.setFont(new java.awt.Font("Rockwell Condensed", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("B");
        AsientosPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, 80, 40));

        jLabel7.setDisplayedMnemonic('2');
        jLabel7.setFont(new java.awt.Font("Rockwell Condensed", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("2");
        AsientosPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 80, 80));

        botAceptar.setFont(new java.awt.Font("Rockwell Condensed", 1, 18)); // NOI18N
        botAceptar.setText("ACEPTAR");
        botAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAceptarActionPerformed(evt);
            }
        });
        AsientosPanel.add(botAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 550, 120, 50));

        getContentPane().add(AsientosPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void A2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_A2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_A2ActionPerformed

    private void A1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_A1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_A1ActionPerformed

    private void C1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_C1ActionPerformed

    private void A3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_A3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_A3ActionPerformed

    private void botAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAceptarActionPerformed
        //String AA1, AA2, AA3, AB1, AB2, AB3, AC1, AC2, AC3;
        //String asientos;
        ArrayList<String> seleccionados = new ArrayList<>();

        if (A1.isSelected()) {
            seleccionados.add("AA1");
        }
        if (A2.isSelected()) {
            seleccionados.add("AA2");
        }
        if (A3.isSelected()) {
            seleccionados.add("AA3");
        }
        if (B1.isSelected()) {
            seleccionados.add("AB1");
        }
        if (B2.isSelected()) {
            seleccionados.add("AB2");
        }
        if (B3.isSelected()) {
            seleccionados.add("AB3");
        }
        if (C1.isSelected()) {
            seleccionados.add("AC1");
        }
        if (C2.isSelected()) {
            seleccionados.add("AC2");
        }
        if (C3.isSelected()) {
            seleccionados.add("AC3");
        }

        asientosSeleccionado = String.join(", ", seleccionados);
        this.dispose();
    }//GEN-LAST:event_botAceptarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AsientosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsientosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsientosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsientosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AsientosForm dialog = new AsientosForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JToggleButton A1;
    public javax.swing.JToggleButton A2;
    public javax.swing.JToggleButton A3;
    private javax.swing.JPanel AsientosPanel;
    public javax.swing.JToggleButton B1;
    public javax.swing.JToggleButton B2;
    public javax.swing.JToggleButton B3;
    public javax.swing.JToggleButton C1;
    public javax.swing.JToggleButton C2;
    public javax.swing.JToggleButton C3;
    public javax.swing.JButton botAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
