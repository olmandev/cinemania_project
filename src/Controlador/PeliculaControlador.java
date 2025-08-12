/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.Peliculas_CRUD;
import Vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ConsultaPelicula;
import modelo.PeliculaPOO;

/**
 *
 * @author alexs
 */
public class PeliculaControlador implements ActionListener {

    private PeliculaPOO peli;
    private Peliculas_CRUD formpeli;
    private Principal formprin;
    private ConsultaPelicula conBDPeli;
    private Object datos[] = new Object[4];
    DefaultTableModel modelo;
    private ImageIcon icono;
    private String dirImagen;
    private String cambio = "no";

    public PeliculaControlador(PeliculaPOO peli, Peliculas_CRUD formpeli, ConsultaPelicula conBDPeli, Principal formprin) {

        this.peli = peli;
        this.formpeli = formpeli;
        this.formprin = formprin;
        this.conBDPeli = conBDPeli;
        this.formpeli.botCrear.addActionListener(this);
        this.icono = new ImageIcon("src/imagenes/sinPerfil2.jpg");
        this.formpeli.botLeer.addActionListener(this);
        this.formpeli.botLimpiar.addActionListener(this);
        this.formpeli.botActualizar.addActionListener(this);
        this.formpeli.botBuscarC.addActionListener(this);
        this.formpeli.botBuscarT.addActionListener(this);
        this.formpeli.botEliminar1.addActionListener(this);
        this.formpeli.botImagen.addActionListener(this);
        this.formpeli.botHome.addActionListener(this);
    }

    public void llenarTabla() {
        modelo = (DefaultTableModel) formpeli.tblPeliculas.getModel();
        int numRegistros = conBDPeli.leerTodos().size();
        for (int i = 0; i < numRegistros; i++) {
            datos[0] = conBDPeli.leerTodos().get(i).getCodigo();
            datos[1] = conBDPeli.leerTodos().get(i).getTitulo();
            datos[2] = conBDPeli.leerTodos().get(i).getDuracion();
            datos[3] = conBDPeli.leerTodos().get(i).getClasificacion();
            modelo.addRow(datos);
        }
        formpeli.tblPeliculas.setModel(modelo);
    }

    public void limpiarForm() {
        formpeli.jtfCodigo.setText("0");
        formpeli.jtfTitulo.setText(null);
        formpeli.jtfTitulo.requestFocus();
        //formpeli.jtfClasificacion.setText(null);
        formpeli.jtfDuracion.setText(null);
        formpeli.lblFoto.setIcon(icono);
        int fila = formpeli.tblPeliculas.getRowCount();
        for (int i = fila - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == formpeli.botCrear) {

            if (formpeli.jtfCodigo.getText().isEmpty()
                    || formpeli.jtfTitulo.getText().isEmpty()
                    || formpeli.jtfDuracion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "COMPLETE TODOS LOS CAMPOS ");
                return;
            }
            peli.setCodigo(Integer.parseInt(formpeli.jtfCodigo.getText()));
            peli.setTitulo(formpeli.jtfTitulo.getText());
            peli.setDuracion(formpeli.jtfDuracion.getText());
            peli.setClasificacion((String) formpeli.jcbClasificacion.getSelectedItem());
            peli.setEstado("Activo");
            if (conBDPeli.crearPelicula(peli)) {
                JOptionPane.showMessageDialog(null, "PELICULA CREADA CORRECTAMENTE - CONT");
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUDO CREAR PELICULA - CONT");
            }
        }

        if (e.getSource() == formpeli.botLeer) {
            limpiarForm();
            llenarTabla();
        }

        if (e.getSource() == formpeli.botActualizar) {
            if (formpeli.jtfCodigo.getText().isEmpty()
                    || formpeli.jtfTitulo.getText().isEmpty()
                    //|| formpeli.jtfClasificacion.getText().isEmpty()
                    || formpeli.jtfDuracion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "COMPLETE TODOS LOS CAMPOS ");
                return;
            }
            peli.setCodigo(Integer.parseInt(formpeli.jtfCodigo.getText()));
            peli.setTitulo(formpeli.jtfTitulo.getText());
            peli.setDuracion(formpeli.jtfDuracion.getText());
            //peli.setClasificacion(formpeli.jtfClasificacion.getText());
            if (cambio.equals("no")) {
                peli.setImagen(dirImagen);
            }
            peli.setEstado("Activo");
            if (conBDPeli.actualizarPelicula(peli)) {
                JOptionPane.showMessageDialog(null, "PELICULA ACTUALIZADA CORRECTAMENTE - CONT");
                limpiarForm();
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUDO ACTUALIZAR PELICULA - CONT");
                //limpiar();
            }
        }
        if (e.getSource() == formpeli.botEliminar1) {
            peli.setCodigo(Integer.parseInt(formpeli.jtfCodigo.getText()));
            if (conBDPeli.eliminarPelicula(peli)) {
                JOptionPane.showMessageDialog(null, "PELICULA ELIMINADO CORRECTAMENTE - CONT");
                limpiarForm();
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINADO PELICULA - CONT");
                //limpiar();
            }
        }

        if (e.getSource() == formpeli.botBuscarC) {
            peli.setCodigo(Integer.parseInt(formpeli.jtfCodigo.getText()));
            if (conBDPeli.leerPelicula(peli)) {
                JOptionPane.showMessageDialog(null, "PELICULA ENCONTRADO - CONTR");
                formpeli.jtfTitulo.setText(peli.getTitulo());
                formpeli.jtfDuracion.setText(peli.getDuracion());
                //formpeli.jtfClasificacion.setText(peli.getClasificacion());
                formpeli.lblFoto.setIcon(formpeli.tamanioImagen(peli.getImagen()));
                dirImagen = peli.getImagen();
            } else {
                JOptionPane.showMessageDialog(null, "PELICULAD NO ENCONTRADA - CONTR");
            }
        }

        if (e.getSource() == formpeli.botBuscarT) {
            peli.setTitulo((formpeli.jtfTitulo.getText()));
            if (conBDPeli.leerPeliculaTitulo(peli)) {
                formpeli.jtfCodigo.setText(String.valueOf(peli.getCodigo()));
                formpeli.jtfDuracion.setText(peli.getDuracion());
                //formpeli.jtfClasificacion.setText(peli.getClasificacion());
                formpeli.lblFoto.setIcon(formpeli.tamanioImagen(peli.getImagen()));
                dirImagen = peli.getImagen();
            } else {
                JOptionPane.showMessageDialog(null, "PRODUCTO NO ENCONTRADO POR DESCRIPCION");
            }
        }

        if (e.getSource() == formpeli.botImagen) {
            formpeli.buscarImagen();
            peli.setImagen(formpeli.direccionImagen);
            cambio = "si";
        }

        if (e.getSource() == formpeli.botLimpiar) {
            limpiarForm();
        }
        if (e.getSource() == formpeli.botHome) {
            formpeli.dispose();
            formprin.setVisible(true);
        }

    }

}
