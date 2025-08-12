/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author alexs
 */
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


public class Informacion extends javax.swing.JFrame {

     private final JFXPanel jfxPanel = new JFXPanel();
    private MediaPlayer oracleVid; // 


    public Informacion() {
        initComponents();
         createscene();
        setTitle("CREDITOS");

        setResizable(false);
        setLocationRelativeTo(null);

        JPanelVideo.setLayout(new BorderLayout());
        JPanelVideo.add(jfxPanel, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);

        // Iniciar al mostrarse, detener/limpiar al cerrar
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                Platform.runLater(() -> {
                    if (oracleVid != null) {
                        oracleVid.play();
                    }
                });
            }

            @Override
            public void windowClosing(WindowEvent e) {
                Platform.runLater(() -> {
                    if (oracleVid != null) {
                        oracleVid.stop();
                        oracleVid.dispose();
                    }
                });
            }

            @Override
            public void windowClosed(WindowEvent e) {
                Platform.runLater(() -> {
                    if (oracleVid != null) {
                        oracleVid.stop();
                        oracleVid.dispose();
                    }
                });
            }
        });
    }

    private void createscene() {
        Platform.runLater(() -> {
            File file = new File("/Users/dahery/Desktop/ultimo_proyecto/ULTIMA_VERSION/Cinemania_VERSIONPRINCIPAL/CineManiaCreditos_grupo3.mp4");
            oracleVid = new MediaPlayer(new Media(file.toURI().toString()));
            MediaView mv = new MediaView(oracleVid);

            jfxPanel.setScene(new Scene(new Group(mv)));
            oracleVid.setVolume(1.0);
            oracleVid.setCycleCount(MediaPlayer.INDEFINITE);
            // oracleVid.play();  // <-- IMPORTANTE: YA NO se reproduce aquí
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botHome = new javax.swing.JButton();
        JPanelVideo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1.png"))); // NOI18N
        botHome.setBorderPainted(false);
        botHome.setContentAreaFilled(false);
        botHome.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2.png"))); // NOI18N
        botHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botHomeActionPerformed(evt);
            }
        });
        jPanel1.add(botHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 90, 70));

        JPanelVideo.setLayout(new java.awt.BorderLayout());
        jPanel1.add(JPanelVideo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 580, 340));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/informacion_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 530));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botHomeActionPerformed
     this.dispose();
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
            java.util.logging.Logger.getLogger(Informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelVideo;
    private javax.swing.JButton botHome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
