/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vista;

import modelo.ConsultaVenta;

/**
 *
 * @author alexs
 */
public class Ventas_CRUD extends javax.swing.JDialog {

    String usuario;

    public Ventas_CRUD(java.awt.Frame parent, boolean modal, String user) {
        super(parent, modal);
        initComponents();
        this.usuario = user;
        jblUsuarioVentas.setText(usuario);
        jtfCodigo.setText("0");
        jtfCliente.requestFocus();


        cbxPelicula.addItem("SELECCIONE UNA PELICULA");
        cbxSala.addItem("SELECCIONE UNA SALA");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonesMetodoPago = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFactura = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItems = new javax.swing.JTable();
        jblUsuarioVentas = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botEliminar = new javax.swing.JButton();
        botLimpiar = new javax.swing.JButton();
        botCrear = new javax.swing.JButton();
        botLeer = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rdTarjeta = new javax.swing.JRadioButton();
        rdEfectivo = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jtfCambio = new javax.swing.JTextField();
        cbxSala = new javax.swing.JComboBox<>();
        cbxPelicula = new javax.swing.JComboBox<>();
        jtfCodigo = new javax.swing.JTextField();
        jtfSubtotal = new javax.swing.JTextField();
        jtfISV = new javax.swing.JTextField();
        jtfTotalPagar = new javax.swing.JTextField();
        jtfCantidadPagar = new javax.swing.JTextField();
        botBoletos = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        botProducto = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        botGenerar = new javax.swing.JButton();
        chkProduc = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        jtfCliente = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jtfFecha = new javax.swing.JFormattedTextField();
        botAsientos = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        botBuscarVent = new javax.swing.JButton();
        jtfAsientos = new javax.swing.JTextField();
        botHome = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "CLIENTE", "PELICULA", "SALA", "ASIENTOS", "SUB", "ISV ", "TOTAL", "METODO", "CANTIDAD", "CAMBIO", "FECHA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblFactura);
        if (tblFactura.getColumnModel().getColumnCount() > 0) {
            tblFactura.getColumnModel().getColumn(0).setResizable(false);
            tblFactura.getColumnModel().getColumn(1).setResizable(false);
            tblFactura.getColumnModel().getColumn(2).setResizable(false);
            tblFactura.getColumnModel().getColumn(3).setResizable(false);
            tblFactura.getColumnModel().getColumn(4).setResizable(false);
            tblFactura.getColumnModel().getColumn(5).setResizable(false);
            tblFactura.getColumnModel().getColumn(6).setResizable(false);
            tblFactura.getColumnModel().getColumn(7).setResizable(false);
            tblFactura.getColumnModel().getColumn(8).setResizable(false);
            tblFactura.getColumnModel().getColumn(9).setResizable(false);
            tblFactura.getColumnModel().getColumn(10).setResizable(false);
            tblFactura.getColumnModel().getColumn(11).setResizable(false);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 650, 260));

        tblItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCTO", "TIPO", "CANTIDAD", "PRECIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblItems);
        if (tblItems.getColumnModel().getColumnCount() > 0) {
            tblItems.getColumnModel().getColumn(0).setResizable(false);
            tblItems.getColumnModel().getColumn(1).setResizable(false);
            tblItems.getColumnModel().getColumn(2).setResizable(false);
            tblItems.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, 650, 200));

        jblUsuarioVentas.setFont(new java.awt.Font("Rockwell Condensed", 1, 18)); // NOI18N
        jblUsuarioVentas.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jblUsuarioVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 100, 30));

        jLabel11.setFont(new java.awt.Font("Rockwell Condensed", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("USUARIO:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 100, 40));

        jLabel2.setFont(new java.awt.Font("Rockwell Condensed", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TICKETMANIA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 230, 60));

        botEliminar.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        botEliminar.setText("ELIMINAR");
        jPanel1.add(botEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 610, 100, 50));

        botLimpiar.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        botLimpiar.setText("LIMPIAR");
        jPanel1.add(botLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 610, 100, 50));

        botCrear.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        botCrear.setText("CREAR");
        botCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCrearActionPerformed(evt);
            }
        });
        jPanel1.add(botCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 610, 100, 50));

        botLeer.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        botLeer.setText("LEER");
        jPanel1.add(botLeer, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 610, 100, 50));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0,150));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ISV 15%");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 50, 30));

        jLabel4.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CODIGO");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 30));

        jLabel7.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PELICULA");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 70, 30));

        jLabel5.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ASIENTOS");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 70, 30));

        jLabel6.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("METODO DE PAGO:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 120, 30));

        jLabel8.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DESEA PRODUCTO? ");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 130, 30));

        jLabel9.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("FECHA");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 70, 30));

        botonesMetodoPago.add(rdTarjeta);
        rdTarjeta.setFont(new java.awt.Font("Rockwell Condensed", 1, 12)); // NOI18N
        rdTarjeta.setForeground(new java.awt.Color(255, 255, 255));
        rdTarjeta.setText("TARJETA");
        rdTarjeta.setContentAreaFilled(false);
        jPanel2.add(rdTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, 90, -1));

        rdEfectivo.setBackground(new java.awt.Color(0, 0, 0));
        botonesMetodoPago.add(rdEfectivo);
        rdEfectivo.setFont(new java.awt.Font("Rockwell Condensed", 1, 12)); // NOI18N
        rdEfectivo.setForeground(new java.awt.Color(255, 255, 255));
        rdEfectivo.setText("EFECTIVO");
        rdEfectivo.setContentAreaFilled(false);
        rdEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdEfectivoActionPerformed(evt);
            }
        });
        jPanel2.add(rdEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, -1, -1));

        jLabel10.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("TOTAL A PAGAR:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 110, 30));

        jLabel12.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("CANTIDAD A PAGAR: ");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 140, 30));

        jtfCambio.setEditable(false);
        jtfCambio.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jPanel2.add(jtfCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 550, 190, 30));

        cbxSala.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbxSalaPopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel2.add(cbxSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 190, 30));

        cbxPelicula.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbxPeliculaPopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel2.add(cbxPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 190, 30));

        jtfCodigo.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jPanel2.add(jtfCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 190, 30));

        jtfSubtotal.setEditable(false);
        jtfSubtotal.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jPanel2.add(jtfSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 190, 30));

        jtfISV.setEditable(false);
        jtfISV.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jPanel2.add(jtfISV, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 190, 30));

        jtfTotalPagar.setEditable(false);
        jtfTotalPagar.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jPanel2.add(jtfTotalPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 190, 30));

        jtfCantidadPagar.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jPanel2.add(jtfCantidadPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 510, 190, 30));

        botBoletos.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        botBoletos.setText("CHOOSE");
        jPanel2.add(botBoletos, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, -1, -1));

        jLabel13.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("SUBTOTAL");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 70, 30));

        botProducto.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        botProducto.setText("CHOOSE");
        botProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botProductoActionPerformed(evt);
            }
        });
        jPanel2.add(botProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, -1, -1));

        jLabel14.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("BOLETOS");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 70, 30));

        botGenerar.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        botGenerar.setText("CAL");
        jPanel2.add(botGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, -1, -1));

        chkProduc.setFont(new java.awt.Font("Rockwell Condensed", 1, 18)); // NOI18N
        chkProduc.setForeground(new java.awt.Color(255, 255, 255));
        chkProduc.setText("SI");
        jPanel2.add(chkProduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 70, -1));

        jLabel16.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("NOMBRE CLIENTE");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 111, 30));

        jtfCliente.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jPanel2.add(jtfCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 190, 30));

        jLabel15.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("CAMBIO :");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 70, 30));

        jtfFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        jPanel2.add(jtfFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 590, 190, 30));

        botAsientos.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        botAsientos.setText("CHOOSE");
        botAsientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAsientosActionPerformed(evt);
            }
        });
        jPanel2.add(botAsientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, -1, -1));

        jLabel17.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("SALA");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 50, 30));

        botBuscarVent.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        botBuscarVent.setText("BUSC");
        jPanel2.add(botBuscarVent, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        jtfAsientos.setEditable(false);
        jtfAsientos.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jPanel2.add(jtfAsientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 190, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 440, 630));

        botHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1.png"))); // NOI18N
        botHome.setBorderPainted(false);
        botHome.setContentAreaFilled(false);
        botHome.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2.png"))); // NOI18N
        jPanel1.add(botHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 10, 90, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoooo3.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 720));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdEfectivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdEfectivoActionPerformed

    private void botProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botProductoActionPerformed

    private void botAsientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAsientosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botAsientosActionPerformed

    private void botCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCrearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botCrearActionPerformed

    private void cbxPeliculaPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbxPeliculaPopupMenuWillBecomeVisible
        cbxPelicula.removeAllItems();
        ConsultaVenta consulta = new ConsultaVenta();
        cbxPelicula.addItem("SELECCIONE UNA PELICULA");
        for (String titulo : consulta.obtenerNombresPeliculas()) {
            cbxPelicula.addItem(titulo);
        }
    }//GEN-LAST:event_cbxPeliculaPopupMenuWillBecomeVisible

    private void cbxSalaPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbxSalaPopupMenuWillBecomeVisible
        cbxSala.removeAllItems();
        ConsultaVenta consulta = new ConsultaVenta();
        cbxSala.addItem("SELECCIONE UNA SALA");
        for (String nombreSala : consulta.obtenerNombresSalas()) {
            cbxSala.addItem(nombreSala);
        }
    }//GEN-LAST:event_cbxSalaPopupMenuWillBecomeVisible

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
            java.util.logging.Logger.getLogger(Ventas_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Ventas_CRUD dialog = new Ventas_CRUD(new javax.swing.JFrame(), true, "ALX");
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
    public javax.swing.JButton botAsientos;
    public javax.swing.JButton botBoletos;
    public javax.swing.JButton botBuscarVent;
    public javax.swing.JButton botCrear;
    public javax.swing.JButton botEliminar;
    public javax.swing.JButton botGenerar;
    public javax.swing.JButton botHome;
    public javax.swing.JButton botLeer;
    public javax.swing.JButton botLimpiar;
    public javax.swing.JButton botProducto;
    public javax.swing.ButtonGroup botonesMetodoPago;
    public static javax.swing.JComboBox<String> cbxPelicula;
    public static javax.swing.JComboBox<String> cbxSala;
    public javax.swing.JCheckBox chkProduc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jblUsuarioVentas;
    public static javax.swing.JTextField jtfAsientos;
    public javax.swing.JTextField jtfCambio;
    public javax.swing.JTextField jtfCantidadPagar;
    public static javax.swing.JTextField jtfCliente;
    public javax.swing.JTextField jtfCodigo;
    public javax.swing.JFormattedTextField jtfFecha;
    public javax.swing.JTextField jtfISV;
    public javax.swing.JTextField jtfSubtotal;
    public static javax.swing.JTextField jtfTotalPagar;
    public javax.swing.JRadioButton rdEfectivo;
    public javax.swing.JRadioButton rdTarjeta;
    public javax.swing.JTable tblFactura;
    public static javax.swing.JTable tblItems;
    // End of variables declaration//GEN-END:variables
}
