/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.Horarios_CRUD;
import Vista.Principal;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ConsultaHorarios;
import modelo.ConsultaPelicula;
import modelo.HorariosPOO;

public class HorariosControlador implements ActionListener {

    private HorariosPOO horario;
    private Horarios_CRUD formHorario;
    private ConsultaHorarios con;
    private ConsultaPelicula conP;
    private Principal formPrin;
    private Object[] datos = new Object[6];
    DefaultTableModel modelo;

    public HorariosControlador(HorariosPOO horario, Horarios_CRUD formHorario, ConsultaHorarios con, ConsultaPelicula conP, Principal formPrin) {
        this.horario = horario;
        this.formHorario = formHorario;
        this.con = con;
        this.conP = conP;
        this.formPrin = formPrin;
        this.formHorario.botCrear.addActionListener(this);
        this.formHorario.botLeer.addActionListener(this);
        this.formHorario.botEliminar.addActionListener(this);
        this.formHorario.botActualizar.addActionListener(this);
        this.formHorario.botLimpiar.addActionListener(this);
        this.formHorario.botHome.addActionListener(this);
    }

    private void llenarTabla() {
        modelo = (DefaultTableModel) formHorario.tblHorarios.getModel();
        modelo.setRowCount(0);
        List<HorariosPOO> lista = con.leerTodos();
        for (HorariosPOO p : lista) {
            datos[0] = p.getIdHorario();
            datos[1] = p.getPelicula();
            datos[2] = p.getSala();
            datos[3] = p.getDia();
            datos[4] = p.getHoraI();
            datos[5] = p.getHoraF();

            modelo.addRow(datos);
        }
        formHorario.tblHorarios.setModel(modelo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == formHorario.botCrear) {
            if (formHorario.jtfId.getText().isEmpty()
                    || formHorario.jcbPelicula.getSelectedItem() == null
                    || formHorario.jcbSala.getSelectedItem() == null
                    || formHorario.jcbDia.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "COMPLETE TODOS LOS CAMPOS CORRECTAMENTE");
                return;
            }
            String peliculaSeleccionada = (String) formHorario.jcbPelicula.getSelectedItem();
            String salaSeleccionada = (String) formHorario.jcbSala.getSelectedItem();
            if (peliculaSeleccionada.equals("SELECCIONE UNA PELICULA") || salaSeleccionada.equals("SELECCIONE UNA SALA")) {
                JOptionPane.showMessageDialog(null, "SELECCIONE UNA PELICUA/SALA CORRECTA");
                return;
            }

            try {

                String pelicula = formHorario.jcbPelicula.getSelectedItem().toString();
                String sala = formHorario.jcbSala.getSelectedItem().toString();
                String dia = formHorario.jcbDia.getSelectedItem().toString();

                horario.setPelicula(pelicula);
                horario.setSala(sala);
                horario.setDia(dia);

                Date horaDate = (Date) formHorario.jsHora.getValue();
                LocalTime horaInicio = horaDate.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalTime();
                horario.setHoraI(horaInicio);

                int duracionMin = con.obtenerDuracionPorTitulo(pelicula);
                LocalTime horaFinal = horaInicio.plusMinutes(duracionMin);
                horario.setHoraF(horaFinal);

                horario.setEstado("Activo");

                if (con.crearHorario(horario)) {
                    JOptionPane.showMessageDialog(null, "HORARIO CREADO CORRECTAMENTE - CONTROLADOR");
                } else {
                    JOptionPane.showMessageDialog(null, "NO SE PUDO CREAR EL HORARIO - CONTROLADOR");
                }

            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(null, "Error al crear el horario: " + ex.getMessage());
            }
        }

        if (e.getSource() == formHorario.botActualizar) {
            if (formHorario.jtfId.getText().isEmpty()
                    || formHorario.jcbPelicula.getSelectedItem() == null
                    || formHorario.jcbSala.getSelectedItem() == null
                    || formHorario.jcbDia.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "COMPLETE TODOS LOS CAMPOS");
                return;
            }

            try {
                int id = Integer.parseInt(formHorario.jtfId.getText());
                String pelicula = formHorario.jcbPelicula.getSelectedItem().toString();
                String sala = formHorario.jcbSala.getSelectedItem().toString();
                String dia = formHorario.jcbDia.getSelectedItem().toString();

                horario.setIdHorario(id);
                horario.setPelicula(pelicula);
                horario.setSala(sala);
                horario.setDia(dia);

                Date horaDate = (Date) formHorario.jsHora.getValue();
                LocalTime horaInicio = horaDate.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalTime();
                horario.setHoraI(horaInicio);

                int duracionMin = con.obtenerDuracionPorTitulo(pelicula);
                LocalTime horaFinal = horaInicio.plusMinutes(duracionMin);
                horario.setHoraF(horaFinal);

                horario.setEstado("Activo");

                if (con.actualizarHorario(horario)) {
                    JOptionPane.showMessageDialog(null, "HORARIO ACTUALIZADO CORRECTAMENTE");
                } else {
                    JOptionPane.showMessageDialog(null, "NO SE PUDO ACTUALIZAR EL HORARIO");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al actualizar el horario: " + ex.getMessage());
            }
        }
        if (e.getSource() == formHorario.botEliminar) {
            if (formHorario.jtfId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "INGRESE EL ID DEL HORARIO A ELIMINAR");
                return;
            }

            try {
                int id = Integer.parseInt(formHorario.jtfId.getText());

                int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar este horario?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    if (con.eliminarHorario(id)) {
                        JOptionPane.showMessageDialog(null, "HORARIO ELIMINADO (estado = Inactivo)");
                    } else {
                        JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR EL HORARIO");
                    }
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al eliminar el horario: " + ex.getMessage());
            }
        }

        if (e.getSource() == formHorario.botLeer) {
            llenarTabla();
        }
        if (e.getSource() == formHorario.botHome) {
            formHorario.dispose();
            formPrin.setVisible(true);
        }
    }
}
