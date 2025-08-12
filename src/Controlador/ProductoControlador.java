/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.Inventario_CRUD;
import Vista.Principal;
import Vista.Productos_CRUD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ConsultaProducto;
import modelo.ProductoPOO;

/**
 *
 * @author alexs
 */
public class ProductoControlador implements ActionListener {

    private ProductoPOO produ;
    private Productos_CRUD formprodu;
    public ConsultaProducto conBDProdu;
    private Principal formprin;
    private Object datos[] = new Object[9];
    private Inventario_CRUD forminv;
    DefaultTableModel modelo;
    private ImageIcon icono;
    private String dirImagen;
    private String cambio = "no";

    public ProductoControlador(ProductoPOO produ, Productos_CRUD formprodu, ConsultaProducto conBDProdu, Principal formprin, Inventario_CRUD forminv) {
        this.produ = produ;
        this.formprodu = formprodu;
        this.conBDProdu = conBDProdu;
        this.forminv = forminv;
        this.formprin = formprin;
        this.icono = new ImageIcon("src/imagenes/sinPerfil2.jpg");
        this.formprodu.botCalcular.addActionListener(this);
        this.formprodu.botCrear.addActionListener(this);
        this.formprodu.botLeer.addActionListener(this);
        this.formprodu.botLimpiar.addActionListener(this);
        this.formprodu.botBuscarC.addActionListener(this);
        this.formprodu.botBuscarT.addActionListener(this);
        this.formprodu.botActualizar.addActionListener(this);
        this.formprodu.botEliminar.addActionListener(this);
        this.formprodu.botInventario.addActionListener(this);
        this.formprodu.botHome.addActionListener(this);
        this.formprodu.botImagen.addActionListener(this);
    }

    public void llenarTabla() {
        modelo = (DefaultTableModel) formprodu.tblProductos.getModel();
        int nRegistros = conBDProdu.leerTodos().size();
        for (int i = 0; i < nRegistros; i++) {
            datos[0] = conBDProdu.leerTodos().get(i).getCodigo();
            datos[1] = conBDProdu.leerTodos().get(i).getDescripcion();
            datos[2] = conBDProdu.leerTodos().get(i).getCosto();
            datos[3] = conBDProdu.leerTodos().get(i).getPrecio();
            datos[4] = conBDProdu.leerTodos().get(i).getUtilidad();
            datos[5] = conBDProdu.leerTodos().get(i).getProveedor();
            datos[6] = conBDProdu.leerTodos().get(i).getStockMin();
            datos[7] = conBDProdu.leerTodos().get(i).getStockMax();
            datos[8] = conBDProdu.leerTodos().get(i).getTipo();
            modelo.addRow(datos);
        }
        formprodu.tblProductos.setModel(modelo);
    }

    public void limpiar() {
        formprodu.jtfCodigo.setText("0");
        formprodu.jtfNombre.setText(null);
        formprodu.jtfCosto.setText(null);
        formprodu.jtfPrecio.setText(null);
        formprodu.cbxProveedores.setSelectedItem(null);
        formprodu.cbxTipo.setSelectedItem(null);
        formprodu.jtfStockMax.setText(null);
        formprodu.jtfStockMin.setText(null);
        formprodu.lblFoto.setIcon(icono);
        int fila = formprodu.tblProductos.getRowCount();
        for (int i = fila - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == formprodu.botCrear) {
            if (formprodu.jtfCodigo.getText().isEmpty()
                    || formprodu.jtfNombre.getText().isEmpty()
                    || formprodu.jtfCosto.getText().isEmpty()
                    || formprodu.jtfPrecio.getText().isEmpty()
                    || formprodu.jtfStockMin.getText().isEmpty()
                    || formprodu.jtfStockMax.getText().isEmpty()
                    || formprodu.cbxProveedores.getSelectedItem() == null
                    || formprodu.cbxTipo.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "LLENE LOS DATOS CORRECTAMENTE");
                return;
            }
            produ.setCodigo(Integer.parseInt(formprodu.jtfCodigo.getText()));
            produ.setDescripcion(formprodu.jtfNombre.getText());
            produ.setCosto(Double.parseDouble(formprodu.jtfCosto.getText()));
            produ.setPrecio(Double.parseDouble(formprodu.jtfPrecio.getText()));
            double costo = Double.parseDouble(formprodu.jtfCosto.getText());
            double precio = Double.parseDouble(formprodu.jtfPrecio.getText());
            produ.setUtilidad(precio - costo);
            produ.setProveedor(formprodu.cbxProveedores.getSelectedItem().toString());
            produ.setStockMax(Integer.parseInt(formprodu.jtfStockMax.getText()));
            produ.setStockMin(Integer.parseInt(formprodu.jtfStockMin.getText()));
            produ.setTipo(formprodu.cbxTipo.getSelectedItem().toString());
            produ.setEstado("Activo");
            if (conBDProdu.crear(produ)) {
                JOptionPane.showMessageDialog(null, "PRODUCTO CREADO CORRECTAMENTE - CONT");
                llenarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUDO CREAR PRODUCTO - CONT");
            }
        }

        if (e.getSource() == formprodu.botLeer) {
            llenarTabla();
        }

        if (e.getSource() == formprodu.botBuscarC) {
            produ.setCodigo(Integer.parseInt(formprodu.jtfCodigo.getText()));
            if (conBDProdu.leerProudcto(produ)) {
                JOptionPane.showMessageDialog(null, "PRODUCTO ENCONTRADO - CONTR");
                formprodu.jtfNombre.setText(produ.getDescripcion());
                formprodu.jtfCosto.setText(String.format("%.2f", produ.getCosto()));
                formprodu.jtfPrecio.setText(String.format("%.2f", produ.getPrecio()));
                formprodu.jtfStockMin.setText(String.valueOf(produ.getStockMin()));
                formprodu.jtfStockMax.setText(String.valueOf(produ.getStockMax()));
                formprodu.cbxProveedores.setSelectedItem(String.valueOf(produ.getProveedor()));
                formprodu.cbxTipo.setSelectedItem(String.valueOf(produ.getTipo()));
                formprodu.lblFoto.setIcon(formprodu.tamanioImagen(produ.getFoto()));
                dirImagen = produ.getFoto();
            } else {
                JOptionPane.showMessageDialog(null, "PRODUCTO NO ENCONTRADO - CONTR");
            }
        }

        if (e.getSource() == formprodu.botBuscarT) {
            produ.setDescripcion((formprodu.jtfNombre.getText()));
            if (conBDProdu.leerProductoDes(produ)) {
                formprodu.jtfCodigo.setText(String.valueOf(produ.getCodigo()));
                formprodu.jtfCosto.setText(String.valueOf(produ.getCosto()));
                formprodu.jtfPrecio.setText(String.valueOf(produ.getPrecio()));
                formprodu.jtfStockMin.setText(String.valueOf(produ.getStockMin()));
                formprodu.jtfStockMax.setText(String.valueOf(produ.getStockMax()));
                formprodu.cbxProveedores.setSelectedItem(String.valueOf(produ.getProveedor()));
                formprodu.cbxTipo.setSelectedItem(String.valueOf(produ.getTipo()));
            } else {
                JOptionPane.showMessageDialog(null, "PRODUCTO NO ENCONTRADO POR DESCRIPCION");
            }
        }

        if (e.getSource() == formprodu.botCalcular) {
            try {
                double costo = Double.parseDouble(formprodu.jtfCosto.getText());
                double precio = costo + (costo * 0.40);
                formprodu.jtfPrecio.setText(String.format("%.2f", precio));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "COSTO INVALIDO");
            }
        }

        if (e.getSource() == formprodu.botLimpiar) {
            limpiar();
        }

        if (e.getSource() == formprodu.botActualizar) {

            if (formprodu.jtfCodigo.getText().isEmpty()
                    || formprodu.jtfNombre.getText().isEmpty()
                    || formprodu.jtfCosto.getText().isEmpty()
                    || formprodu.jtfPrecio.getText().isEmpty()
                    || formprodu.jtfStockMin.getText().isEmpty()
                    || formprodu.jtfStockMax.getText().isEmpty()
                    || formprodu.cbxProveedores.getSelectedItem() == null
                    || formprodu.cbxTipo.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "LLENE LOS DATOS CORRECTAMENTE");
                return;
            }
            produ.setCodigo(Integer.parseInt(formprodu.jtfCodigo.getText()));
            produ.setDescripcion(formprodu.jtfNombre.getText());
            produ.setCosto(Double.parseDouble(formprodu.jtfCosto.getText()));
            produ.setPrecio(Double.parseDouble(formprodu.jtfPrecio.getText()));
            double costo = Double.parseDouble(formprodu.jtfCosto.getText());
            double precio = Double.parseDouble(formprodu.jtfPrecio.getText());
            produ.setUtilidad(precio - costo);
            produ.setProveedor(formprodu.cbxProveedores.getSelectedItem().toString());
            produ.setStockMax(Integer.parseInt(formprodu.jtfStockMax.getText()));
            produ.setStockMin(Integer.parseInt(formprodu.jtfStockMin.getText()));
            produ.setProveedor(formprodu.cbxTipo.getSelectedItem().toString());
            produ.setEstado("Activo");

            if (conBDProdu.actualizarProducto(produ)) {
                JOptionPane.showMessageDialog(null, "CLIENTE ACTUALIZADO CORRECTAMENTE - CONT");
                limpiar();
                llenarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUDO ACTUALIZAR CLIENTE - CONT");
                //limpiar();
            }
        }

        if (e.getSource() == formprodu.botEliminar) {

                produ.setCodigo(Integer.parseInt(formprodu.jtfCodigo.getText()));
                produ.setEstado("Inactivo");
                if (conBDProdu.eliminarProducto(produ)) {
                    JOptionPane.showMessageDialog(null, "PRODUCTO ELIMINADO CORRECTAMENTE - CONT");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR PRODUCTO - CONT");
                    //limpiar();
                }
            }
        if (e.getSource() == formprodu.botImagen) {
            formprodu.buscarImagen();
            produ.setFoto(formprodu.direccionImagen);
            cambio = "si";
        }

        if (e.getSource() == formprodu.botInventario) {
            forminv.setVisible(true);
        }
        if (e.getSource() == formprodu.botHome) {
            formprodu.dispose();
            formprin.setVisible(true);
        }

    }

}
