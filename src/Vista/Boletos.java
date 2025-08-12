/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vista;

import java.util.ArrayList;
import modelo.ItemVentaPOO;

/**
 *
 * @author alexs
 */
public class Boletos extends javax.swing.JDialog {

     ArrayList<ItemVentaPOO> obtenerDatos;

    public Boletos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public ArrayList<ItemVentaPOO> obtenerProductos() {
        return obtenerDatos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        js3Dnino = new javax.swing.JSpinner();
        js2Dadulto = new javax.swing.JSpinner();
        js2DNino = new javax.swing.JSpinner();
        js3DAdulto = new javax.swing.JSpinner();
        chkRegular3DN = new javax.swing.JCheckBox();
        chkRegular2DA = new javax.swing.JCheckBox();
        chkRegular2DN = new javax.swing.JCheckBox();
        chkRegular3DA = new javax.swing.JCheckBox();
        botAgregar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boleto.png"))); // NOI18N
        jLabel8.setText("jLabel8");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 70, 40));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boleto.png"))); // NOI18N
        jLabel9.setText("jLabel8");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 70, 40));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boleto.png"))); // NOI18N
        jLabel10.setText("jLabel8");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 70, 40));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boleto.png"))); // NOI18N
        jLabel11.setText("jLabel8");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 70, 40));

        js3Dnino.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel1.add(js3Dnino, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, 130, 40));

        js2Dadulto.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel1.add(js2Dadulto, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 130, 40));

        js2DNino.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel1.add(js2DNino, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 130, 40));

        js3DAdulto.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel1.add(js3DAdulto, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 130, 40));

        chkRegular3DN.setBackground(new java.awt.Color(204, 0, 0));
        chkRegular3DN.setFont(new java.awt.Font("Rockwell Condensed", 1, 18)); // NOI18N
        chkRegular3DN.setForeground(new java.awt.Color(255, 255, 255));
        chkRegular3DN.setText("REGULAR 3D NIÑO     L. 160.00");
        jPanel1.add(chkRegular3DN, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 270, 30));

        chkRegular2DA.setBackground(new java.awt.Color(204, 0, 0));
        chkRegular2DA.setFont(new java.awt.Font("Rockwell Condensed", 1, 18)); // NOI18N
        chkRegular2DA.setForeground(new java.awt.Color(255, 255, 255));
        chkRegular2DA.setText("REGULAR 2D ADULTO  L. 110.00 ");
        jPanel1.add(chkRegular2DA, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 270, 30));

        chkRegular2DN.setBackground(new java.awt.Color(204, 0, 0));
        chkRegular2DN.setFont(new java.awt.Font("Rockwell Condensed", 1, 18)); // NOI18N
        chkRegular2DN.setForeground(new java.awt.Color(255, 255, 255));
        chkRegular2DN.setText("REGULAR 2D NIÑO      L. 90.00");
        jPanel1.add(chkRegular2DN, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 270, 30));

        chkRegular3DA.setBackground(new java.awt.Color(204, 0, 0));
        chkRegular3DA.setFont(new java.awt.Font("Rockwell Condensed", 1, 18)); // NOI18N
        chkRegular3DA.setForeground(new java.awt.Color(255, 255, 255));
        chkRegular3DA.setText("REGULAR 3D ADULTO  L. 190.00");
        jPanel1.add(chkRegular3DA, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 270, 30));

        botAgregar.setFont(new java.awt.Font("Rockwell Condensed", 1, 18)); // NOI18N
        botAgregar.setText("AGREGAR");
        botAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(botAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 490, 150, 60));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(204, 0, 0));
        jLabel2.setFont(new java.awt.Font("Rockwell Condensed", 1, 58)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("B O L E T O S ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 360, 60));

        jLabel1.setBackground(new java.awt.Color(204, 0, 0));
        jLabel1.setFont(new java.awt.Font("Rockwell Condensed", 1, 58)); // NOI18N
        jLabel1.setText("B O L E T O S ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 360, 60));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 590, 80));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/marcoBoleto.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 650, 480));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAgregarActionPerformed
        double subtotal = 0;
        double total = 0;
        double isv;
         ItemVentaPOO item;
        obtenerDatos = new ArrayList<ItemVentaPOO>();
        
        if (chkRegular2DA.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) js2Dadulto.getValue();
            subtotal += 110 * cantidad;
            item.setNombre("BOLETO ADULTO");
            item.setCantidad(1);
            item.setPrecioUnitario(110.00);
            item.setTipo("2D");
            item.setTotal(subtotal);
            for (int i = 1; i <= cantidad; i++) {
                obtenerDatos.add(item);
            }
        }
          
        if (chkRegular2DN.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) js2DNino.getValue();
            subtotal += 90 * cantidad;
            item.setNombre("BOLETO NIÑO");
            item.setCantidad(1);
            item.setPrecioUnitario(90.00);
            item.setTipo("2D");
            item.setTotal(subtotal);
            for (int i = 1; i <= cantidad; i++) {
                obtenerDatos.add(item);
            }
        }
          
        if (chkRegular3DA.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) js3DAdulto.getValue();
            subtotal += 190 * cantidad;
            item.setNombre("BOLETO ADULTO");
            item.setCantidad(1);
            item.setPrecioUnitario(190.00);
            item.setTipo("3D");
            item.setTotal(subtotal);
            for (int i = 1; i <= cantidad; i++) {
                obtenerDatos.add(item);
            }
        }
        
        if (chkRegular3DN.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) js3Dnino.getValue();
            subtotal += 160 * cantidad;
            item.setNombre("BOLETO NIÑO");
            item.setCantidad(1);
            item.setPrecioUnitario(160.00);
            item.setTipo("3D");
            item.setTotal(subtotal);
            for (int i = 1; i <= cantidad; i++) {
                obtenerDatos.add(item);
            }
        }
        
        this.dispose();
    }//GEN-LAST:event_botAgregarActionPerformed

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
            java.util.logging.Logger.getLogger(Boletos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Boletos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Boletos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Boletos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Boletos dialog = new Boletos(new javax.swing.JFrame(), true);
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
    public javax.swing.JButton botAgregar;
    public javax.swing.JCheckBox chkRegular2DA;
    public javax.swing.JCheckBox chkRegular2DN;
    public javax.swing.JCheckBox chkRegular3DA;
    public javax.swing.JCheckBox chkRegular3DN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JSpinner js2DNino;
    public javax.swing.JSpinner js2Dadulto;
    public javax.swing.JSpinner js3DAdulto;
    public javax.swing.JSpinner js3Dnino;
    // End of variables declaration//GEN-END:variables
}
