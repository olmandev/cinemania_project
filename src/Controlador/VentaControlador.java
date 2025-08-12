/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.AsientosForm;
import Vista.Boletos;
import Vista.Principal;
import Vista.Tienda;
import Vista.Ventas_CRUD;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ConsultaInventario;
import modelo.ConsultaVenta;
import modelo.ItemVentaPOO;
import modelo.VentaPOO;

/**
 *
 * @author alexs
 */
public class VentaControlador implements ActionListener {

    private Ventas_CRUD formVent;
    private Principal formprin;
    private ConsultaVenta conBDVent;
    private Boletos formB;
    private ItemVentaPOO item;
    private AsientosForm formA;
    private Tienda formT;
    private ConsultaInventario conBDinv;
    private VentaPOO vent;
    private Object items[] = new Object[5];
    DefaultTableModel modeloItems;
    private Object datos[] = new Object[12];
    DefaultTableModel modelo;
    private ArrayList<ItemVentaPOO> listaItems = new ArrayList<>();

    public VentaControlador(Ventas_CRUD formvent, Principal formprin, ConsultaVenta conBDVent, VentaPOO vent, Boletos formB, AsientosForm formA, Tienda formT, ItemVentaPOO item) {
        this.vent = vent;
        this.item = item;
        this.formVent = formvent;
        this.formprin = formprin;
        this.formA = formA;
        this.formB = formB;
        this.formT = formT;
        this.conBDVent = conBDVent;
        this.formVent.botAsientos.addActionListener(this);
        this.formVent.botBoletos.addActionListener(this);
        this.formVent.botProducto.addActionListener(this);
        this.formVent.botCrear.addActionListener(this);
        this.formVent.botLeer.addActionListener(this);
        this.formVent.botEliminar.addActionListener(this);
        this.formVent.botLimpiar.addActionListener(this);
        this.formVent.botGenerar.addActionListener(this);
        this.formVent.botHome.addActionListener(this);
  
        this.formVent.botBuscarVent.addActionListener(this);
        this.formVent.botProducto.setEnabled(false);
        this.formVent.chkProduc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean seleccionado = formvent.chkProduc.isSelected();
                formVent.botProducto.setEnabled(true);
            }
        });
        formVent.jtfCantidadPagar.setEnabled(false);
        formVent.rdEfectivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formVent.jtfCantidadPagar.setEnabled(true);
            }
        });
        formVent.rdTarjeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formVent.jtfCantidadPagar.setEnabled(false);
            }
        });
    }

    private void llenarVentas() {
        modelo = (DefaultTableModel) formVent.tblFactura.getModel();
        modelo.setRowCount(0);

        for (VentaPOO vent : conBDVent.leerVentas()) {
            datos[0] = vent.getCodigo();
            datos[1] = vent.getCliente();
            datos[2] = vent.getPelicula();
            datos[3] = vent.getSala();
            datos[4] = vent.getAsiento();
            datos[5] = vent.getSubtotal();
            datos[6] = vent.getIsv();
            datos[7] = vent.getTotal();
            datos[8] = vent.getMetodo();
            datos[9] = vent.getCantidadpagar();
            datos[10] = vent.getCambio();
            datos[11] = vent.getFecha();
            modelo.addRow(datos);
        }
    }

    private void llenarItems() {
        modelo = (DefaultTableModel) formVent.tblItems.getModel();
        modelo.setRowCount(0);

        for (ItemVentaPOO item : listaItems) {
            items[0] = item.getNombre();
            items[1] = item.getTipo();
            items[2] = item.getCantidad();
            items[3] = item.getPrecioUnitario();
            items[4] = item.getTotal();
            modelo.addRow(items);
        }

    }

    public void agregarItems(ItemVentaPOO item) {
        DefaultTableModel model = (DefaultTableModel) formVent.tblItems.getModel();
        modelo.addRow(new Object[]{
            item.getNombre(),
            item.getTipo(),
            item.getCantidad(),
            item.getPrecioUnitario(),
        });
        listaItems.add(item);
        recalcularTotales();
    }

    public void calcular() {
        double subtotal = 0;
        double total = 0;
        double isv;
        if (formT.chPalomitas.isSelected()) {
            int cantidad = (int) formT.jsPalomita.getValue();
            subtotal += 28 * cantidad;
        }
        if (formT.chHD.isSelected()) {
            int cantidad = (int) formT.jsHD.getValue();
            subtotal += 70 * cantidad;
        }
        if (formT.chNachos.isSelected()) {
            int cantidad = (int) formT.jsNachos.getValue();
            subtotal += 77 * cantidad;
        }
        if (formT.chHambur.isSelected()) {
            int cantidad = (int) formT.jsHamburge.getValue();
            subtotal += 49 * cantidad;
        }
        if (formT.chPizza.isSelected()) {
            int cantidad = (int) formT.jsPizza.getValue();
            subtotal += 49 * cantidad;
        }
        if (formT.chEnsalada.isSelected()) {
            int cantidad = (int) formT.jsEnsalada.getValue();
            subtotal += 84 * cantidad;
        }
        //BEBIDAS//

        if (formT.chkCoca.isSelected()) {
            int cantidad = (int) formT.jsCoca.getValue();
            subtotal += 28 * cantidad;
        }
        if (formT.chkPepsi.isSelected()) {
            int cantidad = (int) formT.jsPepsi.getValue();
            subtotal += 25 * cantidad;
        }
        if (formT.chkAgua.isSelected()) {
            int cantidad = (int) formT.jsAgua.getValue();
            subtotal += 21 * cantidad;
        }
        if (formT.chkGatorade.isSelected()) {
            int cantidad = (int) formT.jsGatorade.getValue();
            subtotal += 42 * cantidad;
        }
        if (formT.chkMilkshake.isSelected()) {
            int cantidad = (int) formT.jsMilkshake.getValue();
            subtotal += 98 * cantidad;
        }
        if (formT.chkGranita.isSelected()) {
            int cantidad = (int) formT.jsGranita.getValue();
            subtotal += 49 * cantidad;
        }

        //SNACKS//
        if (formT.chkSnicker.isSelected()) {
            int cantidad = (int) formT.jsSnicker.getValue();
            subtotal += 14 * cantidad;
        }
        if (formT.chkOreo.isSelected()) {
            int cantidad = (int) formT.jsOreo.getValue();
            subtotal += 14 * cantidad;
        }
        if (formT.chkDona.isSelected()) {
            int cantidad = (int) formT.jsDona.getValue();
            subtotal += 21 * cantidad;
        }
        if (formT.chkTwix.isSelected()) {
            int cantidad = (int) formT.jsTwix.getValue();
            subtotal += 16.80 * cantidad;
        }
        if (formT.chkRol.isSelected()) {
            int cantidad = (int) formT.jsRolCanela.getValue();
            subtotal += 16.80 * cantidad;
        }
        if (formT.chkPretzel.isSelected()) {
            int cantidad = (int) formT.jsPretzel.getValue();
            subtotal += 21 * cantidad;
        }

        //COMBOS//
        if (formT.chkChilidogsCombo.isSelected()) {
            int cantidad = (int) formT.jsChilidogCOmbo.getValue();
            subtotal += 182 * cantidad;
        }
        if (formT.chk2Nachos.isSelected()) {
            int cantidad = (int) formT.js2Nachos.getValue();
            subtotal += 210 * cantidad;
        }
        if (formT.chkNachoRfresco.isSelected()) {
            int cantidad = (int) formT.jsNachoRfresco.getValue();
            subtotal += 168 * cantidad;
        }
        if (formT.chkPalomitaNac.isSelected()) {
            int cantidad = (int) formT.jsPalomitaNach.getValue();
            subtotal += 224 * cantidad;
        }
        if (formT.chkPalomitaSnick.isSelected()) {
            int cantidad = (int) formT.jsPalomitaSnick.getValue();
            subtotal += 168 * cantidad;
        }
        if (formT.chk2Refreso.isSelected()) {
            int cantidad = (int) formT.js2Refrescos.getValue();
            subtotal += 175 * cantidad;
        }

        //BOLETOS//
        if (formB.chkRegular2DA.isSelected()) {
            int cantidad = (int) formB.js2Dadulto.getValue();
            subtotal += 110 * cantidad;
        }
        if (formB.chkRegular2DN.isSelected()) {
            int cantidad = (int) formB.js2DNino.getValue();
            subtotal += 90 * cantidad;
        }
        if (formB.chkRegular3DA.isSelected()) {
            int cantidad = (int) formB.js3DAdulto.getValue();
            subtotal += 190 * cantidad;
        }
        if (formB.chkRegular3DN.isSelected()) {
            int cantidad = (int) formB.js3Dnino.getValue();
            subtotal += 160 * cantidad;
        }
        isv = subtotal * 0.15;
        formVent.jtfSubtotal.setText(Double.toString(subtotal));
        formVent.jtfISV.setText(String.format("%.2f", isv));
        total = subtotal + isv;
        formVent.jtfTotalPagar.setText(Double.toString(total));
    }

    public void recalcularTotales() {
        double subtotal = 0;
        for (ItemVentaPOO item : listaItems) {
            subtotal += item.getPrecioUnitario() * item.getCantidad();
        }

        double isv = subtotal * 0.15;
        double total = subtotal + isv;
        formVent.jtfSubtotal.setText(String.format("%.2f", subtotal));
        formVent.jtfISV.setText(String.format("%.2f", isv));
        formVent.jtfTotalPagar.setText(String.format("%.2f", total));
        formVent.jtfCantidadPagar.setText(String.format("%.2f", total));
    }

    private void limpiarVentas() {
        formVent.jtfCodigo.setText("0");
        formVent.jtfCliente.setText(null);
        formVent.cbxPelicula.setSelectedItem(null);
        formVent.cbxSala.setSelectedItem(null);
        formVent.jtfSubtotal.setText(null);
        formVent.jtfISV.setText(null);
        formVent.jtfAsientos.setText(null);
        formVent.jtfTotalPagar.setText(null);
        formVent.rdEfectivo.setSelected(false);
        formVent.rdTarjeta.setSelected(false);
        formVent.jtfCantidadPagar.setText(null);
        formVent.jtfCambio.setText(null);
        formVent.jtfFecha.setText(null);
        int fila = formVent.tblFactura.getRowCount();
        for (int i = fila - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
        int fila2 = formVent.tblItems.getRowCount();
        for (int i = fila2 - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
        listaItems.clear();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == formVent.botCrear) {
            if (formVent.jtfCliente.getText().isEmpty()
                    || formVent.cbxPelicula.getSelectedItem() == null
                    || formVent.cbxSala.getSelectedItem() == null
                    || formVent.jtfFecha.getText().isEmpty()
                    || formVent.jtfCantidadPagar.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "SELECCIONE TODOS LOS CAMPOS");
                return;
            }
            if (listaItems.isEmpty()) {
                JOptionPane.showMessageDialog(null, "DEBE AGREGAR UN PRODUCTO O BOLETO");
                return;
            }
            // vent.setCodigo(Integer.parseInt(formVent.jtfCodigo.getText()));
            vent.setCliente(formVent.jtfCliente.getText());
            vent.setPelicula(formVent.cbxPelicula.getSelectedItem().toString());
            vent.setSala(formVent.cbxSala.getSelectedItem().toString());
            vent.setAsiento(formVent.jtfAsientos.getText());
            vent.setSubtotal(Double.valueOf(formVent.jtfSubtotal.getText()));
            vent.setIsv(Double.valueOf(formVent.jtfISV.getText()));
            vent.setTotal(Double.valueOf(formVent.jtfTotalPagar.getText()));
            String metodoPago = "";
            if (formVent.rdEfectivo.isSelected()) {
                metodoPago = "EFECTIVO";
            } else if (formVent.rdTarjeta.isSelected()) {
                metodoPago = "TARJETA";
            } else {
                JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN METODO DE PAGO");
                return;
            }
            vent.setMetodo(metodoPago);
            vent.setCantidadpagar(Double.valueOf(formVent.jtfCantidadPagar.getText()));
            vent.setCambio(Double.valueOf(formVent.jtfCambio.getText()));
            vent.setFecha(formVent.jtfFecha.getText());
            vent.setEstado("Activo");

            int idVentaCreada = conBDVent.crearVenta(vent);
            if (idVentaCreada > 0) {
                boolean detalleGuardado = conBDVent.crearDetalle(idVentaCreada, formVent.tblItems);
                if (detalleGuardado) {
                    JOptionPane.showMessageDialog(null, "VENTA Y PRODUCTOS GUARDADOS CORRECTAMENTE");
                    ventaPDF pdf = new ventaPDF();
                    pdf.datosFactura(idVentaCreada);
                    pdf.generarFactura();
                }else {
                        JOptionPane.showMessageDialog(null, "VENTA CREADO CORRECTAMENTE/ERROR AL GUARDAR PRODUCTO - CONT");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "NO SE PUDO CREAR VENTA - CONT");
                }
            }

            if (e.getSource() == formVent.botGenerar) {
                try {

                    if (formVent.botonesMetodoPago.getSelection() == null) {
                        JOptionPane.showMessageDialog(null, "SELECCIONE UN METODO DE PAGO");
                        return;
                    }
                    //  formVent.jtfCantidadPagar.setEnabled(false);
                    String metodo = formVent.rdEfectivo.isSelected() ? "Efectivo" : "Tarjeta";
                    double total = Double.parseDouble(formVent.jtfTotalPagar.getText());

                    if (metodo.equals("Efectivo")) {
                        formVent.jtfCantidadPagar.setEnabled(true);
                        if (formVent.jtfCantidadPagar.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "INGRESE LA CANTIDAD");
                            return;
                        }
                        double cantidadPagar = Double.parseDouble(formVent.jtfCantidadPagar.getText());
                        if (cantidadPagar < total) {
                            JOptionPane.showMessageDialog(null, "LA CANTIDAD INGRESADA ES MENOR ");
                            return;
                        }
                        double cambio = cantidadPagar - total;
                        formVent.jtfCambio.setText(String.format("%.2f", cambio));
                    } else {
                        formVent.jtfCantidadPagar.setText(String.format("%.2f", total));
                        formVent.jtfCantidadPagar.setEnabled(false);
                        formVent.jtfCambio.setText("0.00");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "VERIFIQUE LOS CAMPOS DE VALOR NUMERICOS SEAN CORRECTOS");
                }
            }

            if (e.getSource() == formVent.botBuscarVent) {

                vent.setCodigo(Integer.parseInt(formVent.jtfCodigo.getText()));
                if (conBDVent.buscarVenta(vent)) {
                    JOptionPane.showMessageDialog(null, "VENTA ENCONTRADO - VENTACONTR");
                    formVent.jtfCliente.setText(vent.getCliente());
                    formVent.cbxPelicula.setSelectedItem(vent.getPelicula());
                    formVent.cbxSala.setSelectedItem(vent.getSala());
                    formVent.jtfAsientos.setText(vent.getAsiento());
                    formVent.jtfSubtotal.setText(String.format("%.2f", vent.getSubtotal()));
                    formVent.jtfISV.setText(String.format("%.2f", vent.getIsv()));
                    formVent.jtfTotalPagar.setText(String.format("%.2f", vent.getTotal()));
                    formVent.jtfCantidadPagar.setText(String.format("%.2f", vent.getCantidadpagar()));
                    formVent.jtfCambio.setText(String.format("%.2f", vent.getCambio()));
                    formVent.jtfFecha.setText(vent.getFecha());

                    listaItems.clear();
                    listaItems.addAll(conBDVent.buscarDetalle(vent.getCodigo()));
                    llenarItems();
                    //recalcularTotales();
                } else {
                    JOptionPane.showMessageDialog(null, "VENTA NO ENCONTRADA ");
                }
            }

            if (e.getSource() == formVent.botEliminar) {
                int fila = formVent.tblItems.getSelectedRow();
                if (fila != -1) {
                    DefaultTableModel modelo = (DefaultTableModel) formVent.tblItems.getModel();
                    modelo.removeRow(fila);
                    listaItems.remove(fila);
                    recalcularTotales();
                } else {
                    JOptionPane.showMessageDialog(null, "SELECCIONE UNA FILA PARA ELIMINAR");
                }

            }
            if (e.getSource() == formVent.botLeer) {
                llenarVentas();
            }
            if (e.getSource() == formVent.botLimpiar) {
                limpiarVentas();
            }

            if (e.getSource() == formT.botAgregar) {
                calcular();
                formT.dispose();
            }
           

            if (e.getSource() == formVent.botAsientos) {
                formA.setVisible(true);
                formA.setLocationRelativeTo(null);
                String seleccion = formA.obtenerAsiento();
                if (!seleccion.isEmpty()) {
                    formVent.jtfAsientos.setText(seleccion);
                }
            }
            if (e.getSource() == formVent.botBoletos) {
                formB.setVisible(true);
                listaItems.addAll(formB.obtenerProductos());
                calcular();
                llenarItems();

            }
            if (e.getSource() == formVent.botProducto) {
                formT.setVisible(true);
                listaItems.addAll(formT.obtenerProductos());
                calcular();
                llenarItems();
            }

            if (e.getSource() == formVent.botHome) {
                formVent.dispose();
                formprin.setVisible(true);
            }
        }

    }
