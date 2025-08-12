/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.Principal;
import Vista.Proveedores_CRUD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ConsultaProveedor;
import modelo.ProveedorPOO;

/**
 *
 * @author alexs
 */
public class ProveedorControlador implements ActionListener {

    private ProveedorPOO prove;
    private Proveedores_CRUD form;
    private ConsultaProveedor conBD;
    private Principal formprin;
    private Object datos_P[] = new Object[3];
    DefaultTableModel modelo_P;
    private ImageIcon icono;
    private String dirimagen;
    private String cambio = "no";

    public ProveedorControlador(ProveedorPOO prove, Proveedores_CRUD form, ConsultaProveedor conBD, Principal formprin) {
        this.prove = prove;
        this.form = form;
        this.formprin = formprin;
        this.conBD = conBD;
        this.icono = new ImageIcon("src/imagenes/sinPerfil2.jpg");
        this.form.botCrear.addActionListener(this);
        this.form.botLeer.addActionListener(this);
        this.form.botLimpiar.addActionListener(this);
        this.form.botBuscarC.addActionListener(this);
        this.form.botActualizar.addActionListener(this);
        this.form.botEliminar.addActionListener(this);
        this.form.botHome.addActionListener(this);
        this.form.botFoto.addActionListener(this);
        this.form.botcamara.addActionListener(this);
    }

    public void llenarTabla() {
        modelo_P = (DefaultTableModel) form.tblProveedores.getModel();
        int numRegistros = conBD.leerTodos().size();
        for (int i = 0; i < numRegistros; i++) {
            datos_P[0] = conBD.leerTodos().get(i).getCodigo_P();
            datos_P[1] = conBD.leerTodos().get(i).getNombre_P();
            datos_P[2] = conBD.leerTodos().get(i).getContacto();
            modelo_P.addRow(datos_P);
        }
        form.tblProveedores.setModel(modelo_P);
    }

    public void limpiar() {
        form.jtfCodigo.setText("0");
        form.jtfNombre.setText(null);
        form.jtfNombre.requestFocus();
        form.jtfContacto.setText(null);
        form.lblFoto.setText(null);
        form.lblFoto.setIcon(icono);
        int fila = form.tblProveedores.getRowCount();
        for (int i = fila - 1; i >= 0; i--) {
            modelo_P.removeRow(i);
        }
    }
    private void abrircamara() {
    Vista.CamaraForm camara = new Vista.CamaraForm(null, true);
    camara.setLocationRelativeTo(null); 
    camara.setVisible(true);          
}

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == form.botCrear) {

            if (form.jtfCodigo.getText().isEmpty()
                    || form.jtfNombre.getText().isEmpty()
                    || form.jtfContacto.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "LLENE LOS DATOS CORRECTAMENTE");
                return;
            }
            prove.setCodigo_P(Integer.parseInt(form.jtfCodigo.getText()));
            prove.setNombre_P(form.jtfNombre.getText());
            prove.setContacto(form.jtfContacto.getText());
            prove.setEstado_P("Activo");
            if (conBD.crear(prove)) {
                JOptionPane.showMessageDialog(null, "PROVEEDOR CREADO CORRECTAMENTE- CONT");
                llenarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUDO CREAR PROVEEDOR - CONT");
            }
        }

        if (e.getSource() == form.botLeer) {
            limpiar();
            llenarTabla();
        }

        if (e.getSource() == form.botBuscarC) {
            prove.setCodigo_P(Integer.parseInt(form.jtfCodigo.getText()));
            if (conBD.leerCliente(prove)) {
                JOptionPane.showMessageDialog(null, "PROVEEDOR ENCONTRADO - CONTR");
                form.jtfNombre.setText(prove.getNombre_P());
                form.jtfContacto.setText(prove.getContacto());
                form.lblFoto.setIcon(form.tamanioImagen(prove.getFoto()));
                dirimagen = prove.getFoto();
            } else {
                JOptionPane.showMessageDialog(null, "PROVEEDOR NO ENCONTRADO - CONTR");
            }
        }

        if (e.getSource() == form.botLimpiar) {
            limpiar();
        }

        if (e.getSource() == form.botActualizar) {

            if (form.jtfCodigo.getText().isEmpty()
                    || form.jtfNombre.getText().isEmpty()
                    || form.jtfContacto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "LLENE LOS DATOS CORRECTAMENTE");
                return;
            }
            prove.setCodigo_P(Integer.parseInt(form.jtfCodigo.getText()));
            prove.setNombre_P(form.jtfNombre.getText());
            prove.setContacto(form.jtfContacto.getText());
            if (cambio.equals("no")) {
                prove.setFoto(dirimagen);
            }
            prove.setEstado_P("Activo");
            if (conBD.actualizarCliente(prove)) {
                JOptionPane.showMessageDialog(null, "PROVEEDOR ACTUALIZADO PROVEEDOR - CONT");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUDO ACTUALIZAR PROVEEDOR - CONT");
                //limpiar();
            }
        }

        if (e.getSource() == form.botEliminar) {
            prove.setCodigo_P(Integer.parseInt(form.jtfCodigo.getText()));
            if (conBD.eliminarCliente(prove)) {
                JOptionPane.showMessageDialog(null, "PROVEEDOR ELIMINADO CORRECTAMENTE - CONT");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR PROVEEDOR - CONT");
                //limpiar();
            }
        }

        if (e.getSource() == form.botHome) {
            form.dispose();
            formprin.setVisible(true);
        }

        if (e.getSource() == form.botFoto) {
            form.buscarImagen();
            prove.setFoto(form.direccionImagen);
            cambio = "si";
        }
        if (e.getSource() == form.botcamara) {
    abrircamara();
}
    }

}
