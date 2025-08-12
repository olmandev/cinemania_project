/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vista;

import Controlador.VentaControlador;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ItemVentaPOO;

/**
 *
 * @author alexs
 */
public class Tienda extends javax.swing.JDialog {

    ArrayList<ItemVentaPOO> obtenerDatos;

    public Tienda(java.awt.Frame parent, boolean modal) {
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
        Tiendita = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        botAgregar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        chPalomitas = new javax.swing.JCheckBox();
        jsPalomita = new javax.swing.JSpinner();
        jLabel28 = new javax.swing.JLabel();
        chHambur = new javax.swing.JCheckBox();
        jsHamburge = new javax.swing.JSpinner();
        chHD = new javax.swing.JCheckBox();
        jsHD = new javax.swing.JSpinner();
        jLabel30 = new javax.swing.JLabel();
        chPizza = new javax.swing.JCheckBox();
        jsPizza = new javax.swing.JSpinner();
        jLabel31 = new javax.swing.JLabel();
        chNachos = new javax.swing.JCheckBox();
        jsNachos = new javax.swing.JSpinner();
        jLabel32 = new javax.swing.JLabel();
        chEnsalada = new javax.swing.JCheckBox();
        jLabel29 = new javax.swing.JLabel();
        jsEnsalada = new javax.swing.JSpinner();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        chkSnicker = new javax.swing.JCheckBox();
        jsSnicker = new javax.swing.JSpinner();
        jLabel22 = new javax.swing.JLabel();
        chkTwix = new javax.swing.JCheckBox();
        jsTwix = new javax.swing.JSpinner();
        jLabel23 = new javax.swing.JLabel();
        chkOreo = new javax.swing.JCheckBox();
        jsOreo = new javax.swing.JSpinner();
        jLabel24 = new javax.swing.JLabel();
        chkRol = new javax.swing.JCheckBox();
        jsRolCanela = new javax.swing.JSpinner();
        jLabel25 = new javax.swing.JLabel();
        chkDona = new javax.swing.JCheckBox();
        jsDona = new javax.swing.JSpinner();
        jLabel26 = new javax.swing.JLabel();
        chkPretzel = new javax.swing.JCheckBox();
        jsPretzel = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        chkGranita = new javax.swing.JCheckBox();
        chkCoca = new javax.swing.JCheckBox();
        chkPepsi = new javax.swing.JCheckBox();
        chkAgua = new javax.swing.JCheckBox();
        chkGatorade = new javax.swing.JCheckBox();
        chkMilkshake = new javax.swing.JCheckBox();
        jsAgua = new javax.swing.JSpinner();
        jsGranita = new javax.swing.JSpinner();
        jsPepsi = new javax.swing.JSpinner();
        jsCoca = new javax.swing.JSpinner();
        jsGatorade = new javax.swing.JSpinner();
        jsMilkshake = new javax.swing.JSpinner();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        chkChilidogsCombo = new javax.swing.JCheckBox();
        jsChilidogCOmbo = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        chkPalomitaNac = new javax.swing.JCheckBox();
        jsPalomitaNach = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        chk2Nachos = new javax.swing.JCheckBox();
        js2Nachos = new javax.swing.JSpinner();
        jLabel18 = new javax.swing.JLabel();
        chkPalomitaSnick = new javax.swing.JCheckBox();
        jsPalomitaSnick = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();
        chkNachoRfresco = new javax.swing.JCheckBox();
        jsNachoRfresco = new javax.swing.JSpinner();
        jLabel20 = new javax.swing.JLabel();
        chk2Refreso = new javax.swing.JCheckBox();
        js2Refrescos = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tiendita.setBackground(new java.awt.Color(204, 0, 0));
        Tiendita.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botAgregar.setFont(new java.awt.Font("Rockwell Condensed", 1, 18)); // NOI18N
        botAgregar.setText("AGREGAR");
        botAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(botAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 560, 120, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/clqueta1.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 680, 70));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/claqueta2.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 680, 70));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/palomitas.png"))); // NOI18N
        jLabel27.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 140, 130));

        chPalomitas.setBackground(new java.awt.Color(204, 0, 0));
        chPalomitas.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        chPalomitas.setForeground(new java.awt.Color(255, 255, 255));
        chPalomitas.setText("PALOMITAS L. 28.00");
        chPalomitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chPalomitasActionPerformed(evt);
            }
        });
        jPanel2.add(chPalomitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 180, -1));

        jsPalomita.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel2.add(jsPalomita, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 130, 30));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hamburguesa.png"))); // NOI18N
        jLabel28.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 140, 130));

        chHambur.setBackground(new java.awt.Color(204, 0, 0));
        chHambur.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        chHambur.setForeground(new java.awt.Color(255, 255, 255));
        chHambur.setText("HAMBURGUESA L. 49.00");
        jPanel2.add(chHambur, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 170, -1));

        jsHamburge.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel2.add(jsHamburge, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 130, 30));

        chHD.setBackground(new java.awt.Color(204, 0, 0));
        chHD.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        chHD.setForeground(new java.awt.Color(255, 255, 255));
        chHD.setText("HOTDOG L. 70.00");
        jPanel2.add(chHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 150, -1));

        jsHD.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel2.add(jsHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 130, 30));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pizza.png"))); // NOI18N
        jLabel30.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 140, 130));

        chPizza.setBackground(new java.awt.Color(204, 0, 0));
        chPizza.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        chPizza.setForeground(new java.awt.Color(255, 255, 255));
        chPizza.setText("PORCION DE PIZZA L. 49.00");
        jPanel2.add(chPizza, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 470, 210, -1));

        jsPizza.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel2.add(jsPizza, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 500, 130, 30));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nachos.png"))); // NOI18N
        jLabel31.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 140, 130));

        chNachos.setBackground(new java.awt.Color(204, 0, 0));
        chNachos.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        chNachos.setForeground(new java.awt.Color(255, 255, 255));
        chNachos.setText("NACHOS L. 77.00");
        jPanel2.add(chNachos, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 140, -1));

        jsNachos.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel2.add(jsNachos, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 130, 30));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ensalada.png"))); // NOI18N
        jLabel32.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, 140, 130));

        chEnsalada.setBackground(new java.awt.Color(204, 0, 0));
        chEnsalada.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        chEnsalada.setForeground(new java.awt.Color(255, 255, 255));
        chEnsalada.setText("ENSALADA L. 84.00");
        jPanel2.add(chEnsalada, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 470, 140, -1));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hotdog.png"))); // NOI18N
        jLabel29.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 140, 130));

        jsEnsalada.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel2.add(jsEnsalada, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 500, 130, 30));

        Tiendita.addTab("COMIDAS", jPanel2);

        jPanel4.setBackground(new java.awt.Color(204, 0, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/clqueta1.png"))); // NOI18N
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 680, 70));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/clqueta1.png"))); // NOI18N
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 680, 70));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/snicker.png"))); // NOI18N
        jLabel21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 140, 130));

        chkSnicker.setBackground(new java.awt.Color(204, 0, 0));
        chkSnicker.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        chkSnicker.setForeground(new java.awt.Color(255, 255, 255));
        chkSnicker.setText("SNICKER L. 14.00");
        chkSnicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSnickerActionPerformed(evt);
            }
        });
        jPanel4.add(chkSnicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 130, -1));

        jsSnicker.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel4.add(jsSnicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 130, 30));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/twix.png"))); // NOI18N
        jLabel22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 140, 130));

        chkTwix.setBackground(new java.awt.Color(204, 0, 0));
        chkTwix.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        chkTwix.setForeground(new java.awt.Color(255, 255, 255));
        chkTwix.setText("TWIX L. 16.80");
        jPanel4.add(chkTwix, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 130, -1));

        jsTwix.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel4.add(jsTwix, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 130, 30));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/galletaOreo.png"))); // NOI18N
        jLabel23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 140, 130));

        chkOreo.setBackground(new java.awt.Color(204, 0, 0));
        chkOreo.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        chkOreo.setForeground(new java.awt.Color(255, 255, 255));
        chkOreo.setText("GALLETA OREO L. 14.00");
        jPanel4.add(chkOreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 170, -1));

        jsOreo.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel4.add(jsOreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 130, 30));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rolcanela.png"))); // NOI18N
        jLabel24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 140, 130));

        chkRol.setBackground(new java.awt.Color(204, 0, 0));
        chkRol.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        chkRol.setForeground(new java.awt.Color(255, 255, 255));
        chkRol.setText("ROL DE CANELA L. 16.80");
        jPanel4.add(chkRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, 170, -1));

        jsRolCanela.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel4.add(jsRolCanela, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 500, 130, 30));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dona.png"))); // NOI18N
        jLabel25.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 140, 130));

        chkDona.setBackground(new java.awt.Color(204, 0, 0));
        chkDona.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        chkDona.setForeground(new java.awt.Color(255, 255, 255));
        chkDona.setText("DONA  L. 21.00");
        jPanel4.add(chkDona, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 130, -1));

        jsDona.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel4.add(jsDona, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 130, 30));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pretzel.png"))); // NOI18N
        jLabel26.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 140, 130));

        chkPretzel.setBackground(new java.awt.Color(204, 0, 0));
        chkPretzel.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        chkPretzel.setForeground(new java.awt.Color(255, 255, 255));
        chkPretzel.setText("PRETZEL  L. 21.00");
        jPanel4.add(chkPretzel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 470, 170, -1));

        jsPretzel.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel4.add(jsPretzel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 500, 130, 30));

        Tiendita.addTab("SNACKS", jPanel4);

        jPanel3.setBackground(new java.awt.Color(204, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/clqueta1.png"))); // NOI18N
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 690, 70));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/clqueta1.png"))); // NOI18N
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 680, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/granita.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, 140, 130));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/coca.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 140, 130));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pepsi.png"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 140, 130));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agua.png"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 140, 130));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/gatorade.png"))); // NOI18N
        jLabel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 140, 130));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/milkshake.png"))); // NOI18N
        jLabel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 140, 130));

        chkGranita.setBackground(new java.awt.Color(204, 0, 0));
        chkGranita.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        chkGranita.setForeground(new java.awt.Color(255, 255, 255));
        chkGranita.setText("GRANITA L. 49.00");
        jPanel3.add(chkGranita, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 470, 130, -1));

        chkCoca.setBackground(new java.awt.Color(204, 0, 0));
        chkCoca.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        chkCoca.setForeground(new java.awt.Color(255, 255, 255));
        chkCoca.setText("COCACOLA L. 28.00");
        chkCoca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCocaActionPerformed(evt);
            }
        });
        jPanel3.add(chkCoca, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 150, -1));

        chkPepsi.setBackground(new java.awt.Color(204, 0, 0));
        chkPepsi.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        chkPepsi.setForeground(new java.awt.Color(255, 255, 255));
        chkPepsi.setText("PEPSI   L. 25.00");
        jPanel3.add(chkPepsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 130, -1));

        chkAgua.setBackground(new java.awt.Color(204, 0, 0));
        chkAgua.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        chkAgua.setForeground(new java.awt.Color(255, 255, 255));
        chkAgua.setText("AGUA  L. 21.00");
        jPanel3.add(chkAgua, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 130, -1));

        chkGatorade.setBackground(new java.awt.Color(204, 0, 0));
        chkGatorade.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        chkGatorade.setForeground(new java.awt.Color(255, 255, 255));
        chkGatorade.setText("GATORADE L. 42.00");
        jPanel3.add(chkGatorade, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 160, -1));

        chkMilkshake.setBackground(new java.awt.Color(204, 0, 0));
        chkMilkshake.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        chkMilkshake.setForeground(new java.awt.Color(255, 255, 255));
        chkMilkshake.setText("MILKSHAKE L. 98.00");
        jPanel3.add(chkMilkshake, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 470, 150, -1));

        jsAgua.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel3.add(jsAgua, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 130, 30));

        jsGranita.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel3.add(jsGranita, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 500, 130, 30));

        jsPepsi.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel3.add(jsPepsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 130, 30));

        jsCoca.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel3.add(jsCoca, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 130, 30));

        jsGatorade.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel3.add(jsGatorade, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 130, 30));

        jsMilkshake.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel3.add(jsMilkshake, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 500, 130, 30));

        Tiendita.addTab("BEBIDAS", jPanel3);

        jPanel5.setBackground(new java.awt.Color(204, 0, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/clqueta1.png"))); // NOI18N
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 680, 70));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/clqueta1.png"))); // NOI18N
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 680, 70));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/chilidos.png"))); // NOI18N
        jLabel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 140, 130));

        chkChilidogsCombo.setBackground(new java.awt.Color(204, 0, 0));
        chkChilidogsCombo.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        chkChilidogsCombo.setForeground(new java.awt.Color(255, 255, 255));
        chkChilidogsCombo.setText("2 CHILIDOGS L. 182.00");
        chkChilidogsCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkChilidogsComboActionPerformed(evt);
            }
        });
        jPanel5.add(chkChilidogsCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jsChilidogCOmbo.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel5.add(jsChilidogCOmbo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 130, 30));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/PalomitaNachos.png"))); // NOI18N
        jLabel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 140, 130));

        chkPalomitaNac.setBackground(new java.awt.Color(204, 0, 0));
        chkPalomitaNac.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        chkPalomitaNac.setForeground(new java.awt.Color(255, 255, 255));
        chkPalomitaNac.setText("PALOMITAS + NACHOS L.224.00");
        jPanel5.add(chkPalomitaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 210, -1));

        jsPalomitaNach.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel5.add(jsPalomitaNach, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 130, 30));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2nachos.png"))); // NOI18N
        jLabel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 140, 130));

        chk2Nachos.setBackground(new java.awt.Color(204, 0, 0));
        chk2Nachos.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        chk2Nachos.setForeground(new java.awt.Color(255, 255, 255));
        chk2Nachos.setText("2 NACHOS COMPLETOS L. 210.00");
        jPanel5.add(chk2Nachos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 220, -1));

        js2Nachos.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel5.add(js2Nachos, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 130, 30));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/PalomitaSnicker.png"))); // NOI18N
        jLabel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 140, 130));

        chkPalomitaSnick.setBackground(new java.awt.Color(204, 0, 0));
        chkPalomitaSnick.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        chkPalomitaSnick.setForeground(new java.awt.Color(255, 255, 255));
        chkPalomitaSnick.setText("PALOMITAS + SNICKER L.168.00");
        jPanel5.add(chkPalomitaSnick, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 220, -1));

        jsPalomitaSnick.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel5.add(jsPalomitaSnick, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 500, 130, 30));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/NachoRefresco.png"))); // NOI18N
        jLabel19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 140, 130));

        chkNachoRfresco.setBackground(new java.awt.Color(204, 0, 0));
        chkNachoRfresco.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        chkNachoRfresco.setForeground(new java.awt.Color(255, 255, 255));
        chkNachoRfresco.setText("NACHOS + REFRESCO L.  168.00");
        jPanel5.add(chkNachoRfresco, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 220, -1));

        jsNachoRfresco.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel5.add(jsNachoRfresco, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 130, 30));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2RefrescosHotdgo.png"))); // NOI18N
        jLabel20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 140, 130));

        chk2Refreso.setBackground(new java.awt.Color(204, 0, 0));
        chk2Refreso.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        chk2Refreso.setForeground(new java.awt.Color(255, 255, 255));
        chk2Refreso.setText("2 REFRESOS Y UN HOTDOG L.175.00");
        jPanel5.add(chk2Refreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 470, 240, -1));

        js2Refrescos.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel5.add(js2Refrescos, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 500, 130, 30));

        Tiendita.addTab("COMBOS", jPanel5);

        jPanel1.add(Tiendita, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 710, 650));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkCocaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCocaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkCocaActionPerformed

    private void chkChilidogsComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkChilidogsComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkChilidogsComboActionPerformed

    private void chkSnickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSnickerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkSnickerActionPerformed

    private void chPalomitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chPalomitasActionPerformed

        if (chPalomitas.isSelected()) {
            jsPalomita.setEnabled(true);
        } else {
            jsPalomita.setEnabled(false);
        }
    }//GEN-LAST:event_chPalomitasActionPerformed

    private void botAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAgregarActionPerformed
        double subtotal = 0;
        double total = 0;
        double isv;
        ItemVentaPOO item;
        obtenerDatos = new ArrayList<ItemVentaPOO>();
        if (chPalomitas.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) jsPalomita.getValue();
            subtotal += 28 * cantidad;
            item.setNombre("Palomita");
            item.setCantidad(1);
            item.setPrecioUnitario(28.00);
            item.setTipo("comida");
            item.setTotal(subtotal);
            for (int i = 1; i <= cantidad; i++) {
                obtenerDatos.add(item);
            }
        }
        if (chHD.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) jsHD.getValue();
            subtotal += 70 * cantidad;
            item.setNombre("Hot Dogs");
            item.setCantidad(1);
            item.setPrecioUnitario(70.00);
            item.setTipo("comida");
            item.setTotal(subtotal);
            for (int i = 1; i <= cantidad; i++) {
                obtenerDatos.add(item);
            }
        }
        if (chNachos.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) jsNachos.getValue();
            subtotal += 77 * cantidad;
            item.setNombre("Nachos");
            item.setCantidad(1);
            item.setPrecioUnitario(77.00);
            item.setTipo("comida");
            item.setTotal(subtotal);
            for (int i = 1; i <= cantidad; i++) {
                obtenerDatos.add(item);
            }
        }
        if (chHambur.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) jsHamburge.getValue();
            subtotal += 49 * cantidad;
            item.setNombre("Hamburguesa");
            item.setCantidad(1);
            item.setPrecioUnitario(49.00);
            item.setTipo("comida");
            item.setTotal(subtotal);
            for (int i = 1; i <= cantidad; i++) {
                obtenerDatos.add(item);
            }
        }
        if (chPizza.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) jsPizza.getValue();
            subtotal += 49 * cantidad;
            item.setNombre("Porcion de Pizza");
            item.setCantidad(1);
            item.setPrecioUnitario(49.00);
            item.setTipo("comida");
            item.setTotal(subtotal);
            for (int i = 1; i <= cantidad; i++) {
                obtenerDatos.add(item);
            }
        }
        if (chEnsalada.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) jsEnsalada.getValue();
            subtotal += 84 * cantidad;
            item.setNombre("Ensalada");
            item.setCantidad(1);
            item.setPrecioUnitario(84.00);
            item.setTipo("comida");
            item.setTotal(subtotal);
            for (int i = 1; i <= cantidad; i++) {
                obtenerDatos.add(item);
            }
        }
        ////PRODUCTOS : BEBIDAS ////////
          
          if (chkCoca.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) jsCoca.getValue();
            subtotal += 28 * cantidad;
            item.setNombre("COCA COLA");
            item.setCantidad(1);
            item.setPrecioUnitario(28.00);
            item.setTipo("BEBIDA");
            item.setTotal(subtotal);
            for (int i = 1; i <= cantidad; i++) {
                obtenerDatos.add(item);
            }
        }
        if (chkPepsi.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) jsPepsi.getValue();
            subtotal += 25 * cantidad;
            item.setNombre("PEPSI");
            item.setCantidad(1);
            item.setPrecioUnitario(25.00);
            item.setTipo("BEBIDA");
            item.setTotal(subtotal);
            for (int i = 1; i <= cantidad; i++) {
                obtenerDatos.add(item);
            }
        }
        if (chkAgua.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) jsAgua.getValue();
            subtotal += 21 * cantidad;
            item.setNombre("AGUA");
            item.setCantidad(1);
            item.setPrecioUnitario(21.00);
            item.setTipo("BEBIDA");
            item.setTotal(subtotal);
            for (int i = 1; i <= cantidad; i++) {
                obtenerDatos.add(item);
            }
        }
        if (chkGatorade.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) jsGatorade.getValue();
            subtotal += 42 * cantidad;
            item.setNombre("GATORADE");
            item.setCantidad(1);
            item.setPrecioUnitario(42.00);
            item.setTipo("BEBIDA");
            item.setTotal(subtotal);
            for (int i = 1; i <= cantidad; i++) {
                obtenerDatos.add(item);
            }
        }
        if (chkMilkshake.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) jsMilkshake.getValue();
            subtotal += 98 * cantidad;
            item.setNombre("MILKSHAKE");
            item.setCantidad(1);
            item.setPrecioUnitario(98.00);
            item.setTipo("BEBIDA");
            item.setTotal(subtotal);
            for (int i = 1; i <= cantidad; i++) {
                obtenerDatos.add(item);
            }
        }
        if (chkGranita.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) jsGranita.getValue();
            subtotal += 49 * cantidad;
            item.setNombre("GRANITA");
            item.setCantidad(1);
            item.setPrecioUnitario(84.00);
            item.setTipo("BEBIDA");
            item.setTotal(subtotal);
            for (int i = 1; i <= cantidad; i++) {
                obtenerDatos.add(item);
            }
        }

        //PRODUCTO: SNACKS //
        if (chkSnicker.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) jsSnicker.getValue();
            subtotal += 14 * cantidad;
            item.setNombre("SNICKER");
            item.setCantidad(1);
            item.setPrecioUnitario(14.00);
            item.setTipo("SNACK");
            item.setTotal(subtotal);
            for (int i = 1; i <= cantidad; i++) {
                obtenerDatos.add(item);
            }
        }
        if (chkOreo.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) jsOreo.getValue();
            subtotal += 14 * cantidad;
            item.setNombre("GALLETA OREO");
            item.setCantidad(1);
            item.setPrecioUnitario(14.00);
            item.setTipo("SNACK");
            item.setTotal(subtotal);
            for (int i = 1; i <= cantidad; i++) {
                obtenerDatos.add(item);
            }
        }
        if (chkDona.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) jsDona.getValue();
            subtotal += 21 * cantidad;
            item.setNombre("DONA");
            item.setCantidad(1);
            item.setPrecioUnitario(21.00);
            item.setTipo("SNACK");
            item.setTotal(subtotal);
            for (int i = 1; i <= cantidad; i++) {
                obtenerDatos.add(item);
            }
        }
        if (chkTwix.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) jsTwix.getValue();
            subtotal += 16.80 * cantidad;
            item.setNombre("TWIX");
            item.setCantidad(1);
            item.setPrecioUnitario(16.80);
            item.setTipo("SNACK");
            item.setTotal(subtotal);
            for (int i = 1; i <= cantidad; i++) {
                obtenerDatos.add(item);
            }
        }
        if (chkRol.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) jsRolCanela.getValue();
            subtotal += 16.80 * cantidad;
            item.setNombre("ROL DE CANELA");
            item.setCantidad(1);
            item.setPrecioUnitario(16.80);
            item.setTipo("SNACK");
            item.setTotal(subtotal);
            for (int i = 1; i <= cantidad; i++) {
                obtenerDatos.add(item);
            }
        }
        if (chkPretzel.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) jsPretzel.getValue();
            subtotal += 21 * cantidad;
            item.setNombre("PRETZEL");
            item.setCantidad(1);
            item.setPrecioUnitario(21.00);
            item.setTipo("SNACK");
            item.setTotal(subtotal);
            for (int i = 1; i <= cantidad; i++) {
                obtenerDatos.add(item);
            }
        }

        //PRODUCTO : COMBOS //
        if (chkChilidogsCombo.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) jsChilidogCOmbo.getValue();
            subtotal += 182 * cantidad;
            item.setNombre("2 CHILIDOGS");
            item.setCantidad(1);
            item.setPrecioUnitario(182.00);
            item.setTipo("COMBO");
            item.setTotal(subtotal);
            for (int i = 1; i <= cantidad; i++) {
                obtenerDatos.add(item);
            }
        }
        if (chk2Nachos.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) js2Nachos.getValue();
            subtotal += 210 * cantidad;
            item.setNombre("2 NACHOS");
            item.setCantidad(1);
            item.setPrecioUnitario(210.00);
            item.setTipo("COMBO");
            item.setTotal(subtotal);
            for (int i = 1; i <= cantidad; i++) {
                obtenerDatos.add(item);
            }
        }
        if (chkNachoRfresco.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) jsNachoRfresco.getValue();
            subtotal += 168 * cantidad;
            item.setNombre("NACHOS + REFRESCO");
            item.setCantidad(1);
            item.setPrecioUnitario(168.00);
            item.setTipo("COMBO");
            item.setTotal(subtotal);
            for (int i = 1; i <= cantidad; i++) {
                obtenerDatos.add(item);
            }
        }
        if (chkPalomitaNac.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) jsPalomitaNach.getValue();
            subtotal += 224 * cantidad;
            item.setNombre("PALOMITAS + NACHOS");
            item.setCantidad(1);
            item.setPrecioUnitario(224.00);
            item.setTipo("COMBO");
            item.setTotal(subtotal);
            for (int i = 1; i <= cantidad; i++) {
                obtenerDatos.add(item);
            }
        }
        if (chkPalomitaSnick.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) jsPalomitaSnick.getValue();
            subtotal += 168 * cantidad;
            item.setNombre("PALOMITAS  + SNICKER ");
            item.setCantidad(1);
            item.setPrecioUnitario(168.00);
            item.setTipo("COMBO");
            item.setTotal(subtotal);
            for (int i = 1; i <= cantidad; i++) {
                obtenerDatos.add(item);
            }
        }
        if (chk2Refreso.isSelected()) {
            item = new ItemVentaPOO();
            int cantidad = (int) js2Refrescos.getValue();
            subtotal += 175 * cantidad;
            item.setNombre("2 REFRESCOS + 1 HOTDOG");
            item.setCantidad(1);
            item.setPrecioUnitario(175.00);
            item.setTipo("COMBO");
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
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tienda dialog = new Tienda(new javax.swing.JFrame(), true);
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
    private javax.swing.JTabbedPane Tiendita;
    public javax.swing.JButton botAgregar;
    public javax.swing.JCheckBox chEnsalada;
    public javax.swing.JCheckBox chHD;
    public javax.swing.JCheckBox chHambur;
    public javax.swing.JCheckBox chNachos;
    public javax.swing.JCheckBox chPalomitas;
    public javax.swing.JCheckBox chPizza;
    public javax.swing.JCheckBox chk2Nachos;
    public javax.swing.JCheckBox chk2Refreso;
    public javax.swing.JCheckBox chkAgua;
    public javax.swing.JCheckBox chkChilidogsCombo;
    public javax.swing.JCheckBox chkCoca;
    public javax.swing.JCheckBox chkDona;
    public javax.swing.JCheckBox chkGatorade;
    public javax.swing.JCheckBox chkGranita;
    public javax.swing.JCheckBox chkMilkshake;
    public javax.swing.JCheckBox chkNachoRfresco;
    public javax.swing.JCheckBox chkOreo;
    public javax.swing.JCheckBox chkPalomitaNac;
    public javax.swing.JCheckBox chkPalomitaSnick;
    public javax.swing.JCheckBox chkPepsi;
    public javax.swing.JCheckBox chkPretzel;
    public javax.swing.JCheckBox chkRol;
    public javax.swing.JCheckBox chkSnicker;
    public javax.swing.JCheckBox chkTwix;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    public javax.swing.JSpinner js2Nachos;
    public javax.swing.JSpinner js2Refrescos;
    public javax.swing.JSpinner jsAgua;
    public javax.swing.JSpinner jsChilidogCOmbo;
    public javax.swing.JSpinner jsCoca;
    public javax.swing.JSpinner jsDona;
    public javax.swing.JSpinner jsEnsalada;
    public javax.swing.JSpinner jsGatorade;
    public javax.swing.JSpinner jsGranita;
    public javax.swing.JSpinner jsHD;
    public javax.swing.JSpinner jsHamburge;
    public javax.swing.JSpinner jsMilkshake;
    public javax.swing.JSpinner jsNachoRfresco;
    public javax.swing.JSpinner jsNachos;
    public javax.swing.JSpinner jsOreo;
    public javax.swing.JSpinner jsPalomita;
    public javax.swing.JSpinner jsPalomitaNach;
    public javax.swing.JSpinner jsPalomitaSnick;
    public javax.swing.JSpinner jsPepsi;
    public javax.swing.JSpinner jsPizza;
    public javax.swing.JSpinner jsPretzel;
    public javax.swing.JSpinner jsRolCanela;
    public javax.swing.JSpinner jsSnicker;
    public javax.swing.JSpinner jsTwix;
    // End of variables declaration//GEN-END:variables
}
