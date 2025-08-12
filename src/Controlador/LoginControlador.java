/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.Login;
import Vista.Principal;
import Vista.Registro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ConsultaLogin;
import modelo.LoginPOO;

/**
 *
 * @author alexs
 */
public class LoginControlador implements ActionListener {

    private Login form;
    private Registro formR;
    private LoginPOO user;
    private Principal formprin;
    private ConsultaLogin conexion;
    private Object datos[] = new Object[5];
    DefaultTableModel modelo;

    public LoginControlador(Login form, LoginPOO user, ConsultaLogin conexion, Registro formR, Principal formprin) {
        this.form = form;
        this.user = user;
        this.formR = formR;
        this.formprin = formprin;
        this.conexion = conexion;
        this.form.botIniciar.addActionListener(this);
        this.form.botSalir.addActionListener(this);
        this.formR.botCrear.addActionListener(this);
        this.formR.botActualizar.addActionListener(this);
        this.formR.botLeer.addActionListener(this);
        this.formR.botEliminar.addActionListener(this);
        this.formR.botBuscarC.addActionListener(this);
        this.formR.botLimpiar.addActionListener(this);
    }

    private void validarLogin() {
        String usuario = form.jtfUsuarioLog.getText().trim();
        String contrasena = new String(form.jtfContrasenaLog.getPassword()).trim();

        if (usuario.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "PORFAVOR LLENE TODOS LOS DATOS :-)");
            return;
        }
        user.setUsuario(usuario);
        user.setContrasena(contrasena);

        if (conexion.LoginValidacion(user)) {
            String rol = user.getRol();
            JOptionPane.showMessageDialog(null, "¡BIENVENIDO, " + usuario + "\nRol: " + rol);
            form.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INCORRECTOS :-(");
        }
    }

    

    public void llenarTabla() {
        modelo = (DefaultTableModel) formR.jtblRegistro.getModel();
        int numRegistros = conexion.leerTodos().size();
        for (int i = 0; i < numRegistros; i++) {
            datos[0] = conexion.leerTodos().get(i).getCodigo();
            datos[1] = conexion.leerTodos().get(i).getNombre();
            datos[2] = conexion.leerTodos().get(i).getApellido();
            datos[3] = conexion.leerTodos().get(i).getUsuario();
            datos[4] = conexion.leerTodos().get(i).getRol();
            modelo.addRow(datos);
        }
        formR.jtblRegistro.setModel(modelo);
    }

    public void limpiarRegistro() {
        formR.jtfCodigo.setText("0");
        formR.jtfNombreLog2.setText(null);
        formR.jtfNombreLog2.requestFocus();
        formR.jtfApellidoLog.setText(null);
        formR.jtfUsuarioLog.setText(null);
        formR.jtfContrasena.setText(null);
        formR.cbxRoles.setSelectedIndex(0);
        int fila = formR.jtblRegistro.getRowCount();
        for (int i = fila - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == formR.botCrear) {
            if (formR.jtfCodigo.getText().isEmpty() || formR.jtfApellidoLog.getText().isEmpty() || formR.jtfUsuarioLog.getText().isEmpty()
                    || formR.jtfContrasena.getText().isEmpty() || formR.cbxRoles.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "COMPLETE TODOS LOS CAMPOS ");
                return;
            }

            user.setCodigo(Integer.parseInt(formR.jtfCodigo.getText()));
            user.setNombre(formR.jtfNombreLog2.getText());
            user.setApellido(formR.jtfApellidoLog.getText());
            user.setUsuario(formR.jtfUsuarioLog.getText());
            user.setContrasena(formR.jtfContrasena.getText());
            user.setRol(formR.cbxRoles.getSelectedItem().toString());
            user.setEstado("Activo");
            if (conexion.crearLogin(user)) {
                JOptionPane.showMessageDialog(null, "USUARIO CREADO CORRECTAMENTE - CONT");
                // llenarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUDO CREAR USUARIO - CONT");
            }

        }
        if (e.getSource() == formR.botActualizar) {
            user.setCodigo(Integer.parseInt(formR.jtfCodigo.getText()));
            user.setNombre(formR.jtfNombreLog2.getText());
            user.setApellido(formR.jtfApellidoLog.getText());
            user.setUsuario(formR.jtfUsuarioLog.getText());
            user.setContrasena(formR.jtfContrasena.getText());
            user.setRol(formR.cbxRoles.getSelectedItem().toString());
            user.setEstado("Activo");
            if (conexion.actualizarUsuario(user)) {
                JOptionPane.showMessageDialog(null, "CLIENTE ACTUALIZADO CORRECTAMENTE - CONT");
                limpiarRegistro();
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUDO ACTUALIZAR CLIENTE - CONT");
                //limpiar();
            }
        }

        if (e.getSource() == formR.botBuscarC) {
            user.setCodigo(Integer.parseInt(formR.jtfCodigo.getText()));
            if (conexion.leerUsuario(user)) {
                JOptionPane.showMessageDialog(null, "USUARIO ENCONTRADO - CONTR");
                formR.jtfNombreLog2.setText(user.getNombre());
                formR.jtfApellidoLog.setText(user.getApellido());
                formR.jtfUsuarioLog.setText(user.getUsuario());
                formR.jtfContrasena.setText(user.getContrasena());
                formR.cbxRoles.setSelectedItem(String.valueOf(user.getRol()));
            } else {
                JOptionPane.showMessageDialog(null, "USUARIO NO ENCONTRADO - CONTR");
            }
        }

        if (e.getSource() == formR.botLeer) {
            limpiarRegistro();
            llenarTabla();
        }

        if (e.getSource() == formR.botEliminar) {
            user.setCodigo(Integer.parseInt(formR.jtfCodigo.getText()));
            if (conexion.eliminarUsuario(user)) {
                JOptionPane.showMessageDialog(null, "USUARIO ELIMINADO CORRECTAMENTE - CONT");
                //limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINADO USUARIO - CONT");
                //limpiar();
            }
        }

        if (e.getSource() == formR.botLimpiar) {
            limpiarRegistro();
        }
        if (e.getSource() == form.botIniciar) {
            validarLogin();
        }
        if (e.getSource() == form.botSalir) {
            System.exit(0);
        }
    }

}
