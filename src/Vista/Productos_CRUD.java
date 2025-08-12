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
import modelo.ConsultaProducto;

/**
 *
 * @author alexs
 */
public class Productos_CRUD extends javax.swing.JDialog {

    String usuario;
    ConsultaProducto cargarProveedores = new ConsultaProducto();
    public String direccionImagen;

    public Productos_CRUD(java.awt.Frame parent, boolean modal, String user) {
        super(parent, modal);
        initComponents();
        this.usuario = user;
        jlbUsuariopRODU.setText(usuario);
        jtfCodigo.setText("0");
        jtfNombre.requestFocus();
        cargarProveedores.CargarProveedores(cbxProveedores);
    }

    public void buscarImagen() {
        //NOS PERMITE  A TRAVES DE UNA VENTANA SELECCIONAR UN ARCHIVO
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File("C:/imagenesProductos"));//ESTABLECEMOS UNA RUTA DE LA CARPETA DE IMAGENES
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
        jlbUsuariopRODU = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        botHome = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();
        jtfNombre = new javax.swing.JTextField();
        jtfPrecio = new javax.swing.JTextField();
        botBuscarT = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();
        botImagen = new javax.swing.JButton();
        botLimpiar = new javax.swing.JButton();
        botCrear = new javax.swing.JButton();
        botActualizar = new javax.swing.JButton();
        botLeer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        botBuscarC = new javax.swing.JButton();
        botEliminar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jtfCosto = new javax.swing.JTextField();
        botInventario = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jtfStockMin = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtfStockMax = new javax.swing.JTextField();
        cbxTipo = new javax.swing.JComboBox<>();
        botCalcular = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cbxProveedores = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Rockwell Condensed", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PRODUCTOS");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 256, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LogoCinem.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 10, 380, 119));

        jlbUsuariopRODU.setFont(new java.awt.Font("Rockwell Condensed", 1, 18)); // NOI18N
        jlbUsuariopRODU.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jlbUsuariopRODU, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 90, 100, 30));

        jLabel9.setFont(new java.awt.Font("Rockwell Condensed", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("USUARIO: ");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, 100, 30));

        botHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1.png"))); // NOI18N
        botHome.setBorderPainted(false);
        botHome.setContentAreaFilled(false);
        botHome.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2.png"))); // NOI18N
        jPanel2.add(botHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, 90, 70));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 980, 130));

        jPanel3.setBackground(new java.awt.Color(204, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DESCRIPCION");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 80, 30));

        jLabel4.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CODIGO");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 72, 30));

        jLabel5.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PROVEEDOR");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 102, 30));

        jLabel6.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PRECIO");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 60, 30));

        jtfCodigo.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jPanel3.add(jtfCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 220, 50));

        jtfNombre.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jPanel3.add(jtfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 220, 50));

        jtfPrecio.setEditable(false);
        jtfPrecio.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jPanel3.add(jtfPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 70, 50));

        botBuscarT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        botBuscarT.setBorderPainted(false);
        jPanel3.add(botBuscarT, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 60, 50));

        lblFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 190, 200));

        botImagen.setText("IMAGEN");
        botImagen.setBorderPainted(false);
        jPanel3.add(botImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 140, 40));

        botLimpiar.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        botLimpiar.setText("LIMPIAR");
        botLimpiar.setBorderPainted(false);
        jPanel3.add(botLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 250, 160, 50));

        botCrear.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        botCrear.setText("CREAR");
        botCrear.setBorderPainted(false);
        jPanel3.add(botCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 160, 50));

        botActualizar.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        botActualizar.setText("ACTUALIZAR");
        botActualizar.setBorderPainted(false);
        jPanel3.add(botActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 70, 160, 50));

        botLeer.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        botLeer.setText("LEER");
        botLeer.setBorderPainted(false);
        jPanel3.add(botLeer, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 130, 160, 50));

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION", "COSTO", "PRECIO", "UTILIDAD", "PROVEEDOR", "STOCK MIN", "STOCK MAX", "TIPO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProductos);
        if (tblProductos.getColumnModel().getColumnCount() > 0) {
            tblProductos.getColumnModel().getColumn(0).setResizable(false);
            tblProductos.getColumnModel().getColumn(1).setResizable(false);
            tblProductos.getColumnModel().getColumn(2).setResizable(false);
            tblProductos.getColumnModel().getColumn(3).setResizable(false);
            tblProductos.getColumnModel().getColumn(4).setResizable(false);
            tblProductos.getColumnModel().getColumn(5).setResizable(false);
            tblProductos.getColumnModel().getColumn(6).setResizable(false);
            tblProductos.getColumnModel().getColumn(7).setResizable(false);
            tblProductos.getColumnModel().getColumn(8).setResizable(false);
        }

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 960, 160));

        botBuscarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        botBuscarC.setBorderPainted(false);
        jPanel3.add(botBuscarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 60, 50));

        botEliminar.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        botEliminar.setText("ELIMINAR");
        botEliminar.setBorderPainted(false);
        jPanel3.add(botEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 190, 160, 50));

        jLabel7.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("COSTO");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 89, 30));

        jtfCosto.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jPanel3.add(jtfCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 70, 50));

        botInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inventario.png"))); // NOI18N
        botInventario.setBorderPainted(false);
        jPanel3.add(botInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 60, 50));

        jLabel8.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TIPO");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 60, 30));

        jtfStockMin.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jPanel3.add(jtfStockMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 70, 50));

        jLabel10.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("STOCK Max");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 80, 30));

        jtfStockMax.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jPanel3.add(jtfStockMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 70, 50));

        cbxTipo.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE EL TIPO", "BEBIDA ", "COMIDA", "DULCE", "COMBO", " " }));
        jPanel3.add(cbxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 220, 50));

        botCalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calcular.png"))); // NOI18N
        botCalcular.setBorderPainted(false);
        jPanel3.add(botCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 60, 50));

        jLabel11.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("STOCK Min");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 89, 30));

        cbxProveedores.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        cbxProveedores.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbxProveedoresPopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel3.add(cbxProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 220, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 980, 540));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxProveedoresPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbxProveedoresPopupMenuWillBecomeVisible
        cbxProveedores.removeAllItems();
        cargarProveedores.CargarProveedores(cbxProveedores);
    }//GEN-LAST:event_cbxProveedoresPopupMenuWillBecomeVisible

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
            java.util.logging.Logger.getLogger(Productos_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Productos_CRUD dialog = new Productos_CRUD(new javax.swing.JFrame(), true, "ALX");
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
    public javax.swing.JButton botCalcular;
    public javax.swing.JButton botCrear;
    public javax.swing.JButton botEliminar;
    public javax.swing.JButton botHome;
    public javax.swing.JButton botImagen;
    public javax.swing.JButton botInventario;
    public javax.swing.JButton botLeer;
    public javax.swing.JButton botLimpiar;
    public javax.swing.JComboBox<String> cbxProveedores;
    public javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel jlbUsuariopRODU;
    public javax.swing.JTextField jtfCodigo;
    public javax.swing.JTextField jtfCosto;
    public javax.swing.JTextField jtfNombre;
    public javax.swing.JTextField jtfPrecio;
    public javax.swing.JTextField jtfStockMax;
    public javax.swing.JTextField jtfStockMin;
    public javax.swing.JLabel lblFoto;
    public javax.swing.JTable tblProductos;
    // End of variables declaration//GEN-END:variables
}
