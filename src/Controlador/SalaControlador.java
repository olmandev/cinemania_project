/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.Salas_CRUD;
import Vista.Principal;
import modelo.ConsultaSalas;
import modelo.SalasPOO;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SalaControlador implements ActionListener {

    private SalasPOO sala;
    private Salas_CRUD formSala;
    private Principal formPrin;
    private ConsultaSalas daoSala;
    private DefaultTableModel modelo;
    private Object[] datos = new Object[5];

    public SalaControlador(SalasPOO sala, Salas_CRUD formSala, ConsultaSalas daoSala, Principal formPrin) {
        this.sala = sala;
        this.formSala = formSala;
        this.formPrin = formPrin;
        this.daoSala = daoSala;

        formSala.botCrearSala.addActionListener(this);
        formSala.botLeerSala.addActionListener(this);
        formSala.botActualizarSala.addActionListener(this);
        formSala.botBuscarC.addActionListener(this);
        formSala.botBuscarT.addActionListener(this);
        formSala.botEliminarSala.addActionListener(this);
        formSala.botLimpiarSala.addActionListener(this);
        formSala.botHome.addActionListener(this);
    }

    private void llenarTabla() {
        modelo = (DefaultTableModel) formSala.tblSala.getModel();
        modelo.setRowCount(0);
        List<SalasPOO> lista = daoSala.listarSalasActivas();
        for (SalasPOO s : lista) {
            datos[0] = s.getId();
            datos[1] = s.getNombre();
            datos[2] = s.getCapacidad();
            datos[3] = s.getTipo();
            datos[4] = s.getEstado();
            modelo.addRow(datos);
        }
        formSala.tblSala.setModel(modelo);
    }

    private void limpiarForm() {
        formSala.jtfCodigoSala.setText("0");
        formSala.jtfNombreSala.setText("");
        formSala.jtfCapacidadSal.setText("");
        formSala.jtfTipo.setText("");
        int filas = modelo.getRowCount();
        for (int i = filas -1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formSala.botCrearSala) {
            if (formSala.jtfNombreSala.getText().isEmpty()
                    || formSala.jtfCapacidadSal.getText().isEmpty()
                    || formSala.jtfTipo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "COMPLETE LOS CAMPOS OBLIGATORIOS");
                return;
            }
            sala.setNombre(formSala.jtfNombreSala.getText().trim());
            sala.setCapacidad(Integer.parseInt(formSala.jtfCapacidadSal.getText().trim()));
            sala.setTipo(formSala.jtfTipo.getText().trim());
            sala.setEstado("activo");
            if (daoSala.crearSala(sala)) {
                JOptionPane.showMessageDialog(null, "SALA CREADA CORRECTAMENTE");
                limpiarForm();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL CREAR SALA", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == formSala.botLeerSala) {
            llenarTabla();
        }

        if (e.getSource() == formSala.botActualizarSala) {
            if (formSala.jtfCodigoSala.getText().isEmpty()
                    || formSala.jtfNombreSala.getText().isEmpty()
                    || formSala.jtfCapacidadSal.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "COMPLETE LOS CAMPOS PARA ACTUALIZAR");
                return;
            }
            sala.setId(Integer.parseInt(formSala.jtfCodigoSala.getText().trim()));
            sala.setNombre(formSala.jtfNombreSala.getText().trim());
            sala.setCapacidad(Integer.parseInt(formSala.jtfCapacidadSal.getText().trim()));
            sala.setTipo(formSala.jtfTipo.getText().trim());
            sala.setEstado("activo");
            if (daoSala.actualizarSala(sala)) {
                JOptionPane.showMessageDialog(null, "SALA ACTUALIZADA CORRECTAMENTE");
                limpiarForm();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR SALA", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == formSala.botBuscarC) {
            if (formSala.jtfCodigoSala.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "INGRESE ID PARA BUSCAR");
                return;
            }
            int id = Integer.parseInt(formSala.jtfCodigoSala.getText().trim());
            SalasPOO s = daoSala.buscarSalaPorId(id);
            if (s != null) {
                formSala.jtfNombreSala.setText(s.getNombre());
                formSala.jtfCapacidadSal.setText(String.valueOf(s.getCapacidad()));
                formSala.jtfTipo.setText(s.getTipo());
                JOptionPane.showMessageDialog(null, "SALA ENCONTRADA");
            } else {
                JOptionPane.showMessageDialog(null, "SALA NO ENCONTRADA POR ID");
            }
        }

        if (e.getSource() == formSala.botBuscarT) {
            String nombre = formSala.jtfNombreSala.getText().trim();
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(null, "INGRESE NOMBRE PARA BUSCAR");
                return;
            }
            SalasPOO s = daoSala.buscarSalaPorNombre(nombre);
            if (s != null) {
                formSala.jtfCodigoSala.setText(String.valueOf(s.getId()));
                formSala.jtfCapacidadSal.setText(String.valueOf(s.getCapacidad()));
                formSala.jtfTipo.setText(s.getTipo());
                JOptionPane.showMessageDialog(null, "SALA ENCONTRADA POR NOMBRE");
            } else {
                JOptionPane.showMessageDialog(null, "SALA NO ENCONTRADA POR NOMBRE");
            }
        }

        if (e.getSource() == formSala.botEliminarSala) {
            if (formSala.jtfCodigoSala.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "INGRESE ID PARA ELIMINAR");
                return;
            }
            sala.setId(Integer.parseInt(formSala.jtfCodigoSala.getText().trim()));
            if (daoSala.eliminarSala(sala.getId())) {
                JOptionPane.showMessageDialog(null, "SALA DESCATIVADA (inactivo)");
                limpiarForm();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL DESACTIVAR SALA", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == formSala.botLimpiarSala) {
            limpiarForm();
        }

        if (e.getSource() == formSala.botHome) {
            formSala.dispose();
            formPrin.setVisible(true);
        }
    }
}

