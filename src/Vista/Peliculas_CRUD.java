/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vista;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author alexs
 */
public class Peliculas_CRUD extends javax.swing.JDialog {

    String usuario;
    public String direccionImagen;

    public Peliculas_CRUD(java.awt.Frame parent, boolean modal, String user) {
        super(parent, modal);
        initComponents();
        this.usuario = user;
        jlbUsuarioPeli.setText(usuario);
        jtfCodigo.setText("0");
        jtfTitulo.requestFocus();
    }

    
    public void buscarImagen() {
        //NOS PERMITE  A TRAVES DE UNA VENTANA SELECCIONAR UN ARCHIVO
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File("C:/imagenes"));//ESTABLECEMOS UNA RUTA DE LA CARPETA DE IMAGENES
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");//TIPOS DE EXTENSION DE LA IMAGEN
        file.addChoosableFileFilter(filter);
        int estado = file.showOpenDialog(this);
        //SI EL USUARIO DIO CLICK EN EL BOTON ACEPTAR
        if (estado == JFileChooser.APPROVE_OPTION) {
            //SELECCIONAMOS LA FOTO
            File selectedFile = file.getSelectedFile();
            //OBTENEMOS LA RUTA
            String path = selectedFile.getAbsolutePath();
            direccionImagen = path;
            //COLOCAMOS EL TAMAÑO DE LA IMAGEN IGUAL AL DE LA ETIQUETA
            lblFoto.setIcon(tamanioImagen(direccionImagen));
            //SI EL USUARIO DIO CLICK EN CANCELAR
        } else if (estado == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "NO SELECCIONO NINGUNA FOTO", "ATENCION", JOptionPane.WARNING_MESSAGE);
        }
    }
    
     public ImageIcon tamanioImagen(String DirImagen) {
        //INICIALIZAMOS LA IMAGEN
        ImageIcon FotoCliente = new ImageIcon(DirImagen);
        Image img = FotoCliente.getImage();
        //TOMAMOS EL ANCHO Y EL ALTO DE LA ETIQUETA Y ASI SE LO COLOCAMOS EN LA IMAGEN
        Image newImage = img.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlbUsuarioPeli = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        botHome = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfClasificacion = new javax.swing.JTextField();
        jtfCodigo = new javax.swing.JTextField();
        jtfTitulo = new javax.swing.JTextField();
        botBuscarT = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();
        botImagen = new javax.swing.JButton();
        botLimpiar = new javax.swing.JButton();
        botCrear = new javax.swing.JButton();
        botActualizar = new javax.swing.JButton();
        botLeer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPeliculas = new javax.swing.JTable();
        botBuscarC = new javax.swing.JButton();
        jtfDuracion = new javax.swing.JFormattedTextField();
        botEliminar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Rockwell Condensed", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PELICULAS");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 256, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LogoCinem.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 10, 380, 119));

        jlbUsuarioPeli.setFont(new java.awt.Font("Rockwell Condensed", 1, 18)); // NOI18N
        jlbUsuarioPeli.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jlbUsuarioPeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 140, 30));

        jLabel9.setFont(new java.awt.Font("Rockwell Condensed", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("USUARIO: ");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, 100, 30));

        botHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1.png"))); // NOI18N
        botHome.setBorderPainted(false);
        botHome.setContentAreaFilled(false);
        botHome.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2.png"))); // NOI18N
        botHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botHomeActionPerformed(evt);
            }
        });
        jPanel2.add(botHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 90, 70));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 940, 130));

        jPanel3.setBackground(new java.awt.Color(204, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TITULO");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 72, 30));

        jLabel4.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CODIGO");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 72, 30));

        jLabel5.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CLASIFICACION");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 102, 30));

        jLabel6.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("DURACION");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 89, 30));

        jtfClasificacion.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jPanel3.add(jtfClasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 220, 50));

        jtfCodigo.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        jPanel3.add(jtfCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 220, 50));

        jtfTitulo.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jPanel3.add(jtfTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 220, 50));

        botBuscarT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Lupa2.png"))); // NOI18N
        botBuscarT.setBorderPainted(false);
        jPanel3.add(botBuscarT, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 80, 60));

        lblFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 190, 200));

        botImagen.setText("IMAGEN");
        botImagen.setBorderPainted(false);
        jPanel3.add(botImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 140, 40));

        botLimpiar.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        botLimpiar.setText("LIMPIAR");
        botLimpiar.setBorderPainted(false);
        botLimpiar.setFocusPainted(false);
        botLimpiar.setFocusable(false);
        jPanel3.add(botLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 250, 160, 50));

        botCrear.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        botCrear.setText("CREAR");
        botCrear.setBorderPainted(false);
        botCrear.setFocusPainted(false);
        botCrear.setFocusable(false);
        jPanel3.add(botCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 160, 50));

        botActualizar.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        botActualizar.setText("ACTUALIZAR");
        botActualizar.setBorderPainted(false);
        botActualizar.setFocusPainted(false);
        botActualizar.setFocusable(false);
        jPanel3.add(botActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 70, 160, 50));

        botLeer.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        botLeer.setText("LEER");
        botLeer.setBorderPainted(false);
        botLeer.setFocusPainted(false);
        botLeer.setFocusable(false);
        jPanel3.add(botLeer, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 130, 160, 50));

        tblPeliculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "TITULO", "DURACION", "CLASIFICACION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPeliculas);
        if (tblPeliculas.getColumnModel().getColumnCount() > 0) {
            tblPeliculas.getColumnModel().getColumn(0).setResizable(false);
            tblPeliculas.getColumnModel().getColumn(1).setResizable(false);
            tblPeliculas.getColumnModel().getColumn(2).setResizable(false);
            tblPeliculas.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 890, 160));

        botBuscarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Lupa2.png"))); // NOI18N
        botBuscarC.setBorderPainted(false);
        jPanel3.add(botBuscarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 80, 60));

        try {
            jtfDuracion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel3.add(jtfDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 220, 60));

        botEliminar1.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        botEliminar1.setText("ELIMINAR");
        botEliminar1.setBorderPainted(false);
        botEliminar1.setFocusPainted(false);
        botEliminar1.setFocusable(false);
        jPanel3.add(botEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 190, 160, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 940, 480));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botHomeActionPerformed

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
            java.util.logging.Logger.getLogger(Peliculas_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Peliculas_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Peliculas_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Peliculas_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Peliculas_CRUD dialog = new Peliculas_CRUD(new javax.swing.JFrame(), true, "ALX");
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
    public javax.swing.JButton botActualizar;
    public javax.swing.JButton botBuscarC;
    public javax.swing.JButton botBuscarT;
    public javax.swing.JButton botCrear;
    public javax.swing.JButton botEliminar1;
    public javax.swing.JButton botHome;
    public javax.swing.JButton botImagen;
    public javax.swing.JButton botLeer;
    public javax.swing.JButton botLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel jlbUsuarioPeli;
    public javax.swing.JTextField jtfClasificacion;
    public javax.swing.JTextField jtfCodigo;
    public javax.swing.JFormattedTextField jtfDuracion;
    public javax.swing.JTextField jtfTitulo;
    public javax.swing.JLabel lblFoto;
    public javax.swing.JTable tblPeliculas;
    // End of variables declaration//GEN-END:variables
}
