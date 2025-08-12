/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.Inventario_CRUD;
import Vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ConsultaInventario;
import modelo.ConsultaProducto;
import modelo.InventarioPOO;
import modelo.ProductoPOO;

/**
 *
 * @author alexs
 */
public class InventarioControlador implements ActionListener {

    private InventarioPOO invPOO;
    private Inventario_CRUD forminv;
    private Principal formprin;
    private ProductoPOO produPOO;
    private ConsultaProducto conBDprodu;
    private ConsultaInventario conBDinv;
    private Object datosProductos[] = new Object[5];
    private DefaultTableModel modeloProductos;
    private Object datosInventario[] = new Object[7];
    private DefaultTableModel modeloInventario;

    public InventarioControlador(InventarioPOO invPOO, Inventario_CRUD forminv, ConsultaInventario conBDinv, ConsultaProducto conBDprodu, ProductoPOO produPOO, Principal formprin) {
        this.invPOO = invPOO;
        this.forminv = forminv;
        this.formprin = formprin;
        this.conBDinv = conBDinv;
        this.produPOO = produPOO;
        this.conBDprodu = conBDprodu;
        this.forminv.botCrear.addActionListener(this);
        this.forminv.botLeer.addActionListener(this);
        this.forminv.botLimpiar.addActionListener(this);
        this.forminv.botBuscarC.addActionListener(this);
        this.forminv.botActualizar.addActionListener(this);
        this.forminv.botEliminar.addActionListener(this);
        this.forminv.botHome.addActionListener(this);
        this.forminv.jdcVencimiento.setEnabled(false);
        this.forminv.botBuscarINV.addActionListener(this);
        this.forminv.cbxSI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (forminv.cbxSI.isSelected()) {
                    forminv.jdcVencimiento.setEnabled(true);
                } else {
                    forminv.jdcVencimiento.setEnabled(false);
                    forminv.jdcVencimiento.setDate(null);
                }
            }
        });
    }

    public void llenarTablaProd() {
        modeloProductos = (DefaultTableModel) forminv.tblProductos.getModel();
        int nRegistros = conBDinv.leerTodosSinInv().size();
        for (int i = 0; i < nRegistros; i++) {
            datosProductos[0] = conBDinv.leerTodosSinInv().get(i).getCodigo();
            datosProductos[1] = conBDinv.leerTodosSinInv().get(i).getDescripcioninv();
            datosProductos[2] = conBDinv.leerTodosSinInv().get(i).getProveedor();
            datosProductos[3] = conBDinv.leerTodosSinInv().get(i).getStockMin();
            datosProductos[4] = conBDinv.leerTodosSinInv().get(i).getStockMax();
            modeloProductos.addRow(datosProductos);
        }
        forminv.tblProductos.setModel(modeloProductos);
    }

    public void llenarTablainv() {
        modeloInventario = (DefaultTableModel) forminv.tblInventario.getModel();
        int numRegistros = conBDinv.leerTodosInventario().size();
        for (int i = 0; i < numRegistros; i++) {
            datosInventario[0] = conBDinv.leerTodosInventario().get(i).getCodigo();
            datosInventario[1] = conBDinv.leerTodosInventario().get(i).getDescripcioninv();
            datosInventario[2] = conBDinv.leerTodosInventario().get(i).getTipoMove();
            datosInventario[3] = conBDinv.leerTodosInventario().get(i).getCantidadinv();
            datosInventario[4] = conBDinv.leerTodosInventario().get(i).getFecha();
            datosInventario[5] = conBDinv.leerTodosInventario().get(i).getMotivo();
            datosInventario[6] = conBDinv.leerTodosInventario().get(i).getVencimiento();
            modeloInventario.addRow(datosInventario);
        }
        forminv.tblInventario.setModel(modeloInventario);
    }

    public void limpiar() {
        forminv.jtfCodigo.setText("0");
        forminv.jtfMotivo.requestFocus();
        forminv.jtfMotivo.setText(null);
        forminv.jtfDescripcion.setText(null);
        forminv.jtfStockMin.setText(null);
        forminv.jtfStockMax.setText(null);
        forminv.jtfCantidad1.setText(null);
        forminv.cbxMove.setSelectedItem(null);
        forminv.cbxSI.setSelected(false);
        forminv.jdcFecha.setDate(null);
        forminv.jdcVencimiento.setDate(null);
        int fila = forminv.tblProductos.getRowCount();
        for (int i = fila - 1; i >= 0; i--) {
            modeloProductos.removeRow(i);
        }
        int fila2 = forminv.tblInventario.getRowCount();
        for (int i = fila2 - 1; i >= 0; i--) {
            modeloInventario.removeRow(i);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == forminv.botCrear) {
            
            if(forminv.jtfCantidad1 == null){
                JOptionPane.showMessageDialog(null, "COMPLETE TODOS LOS CAMPOS");
                return;
            }

            try {
                int cantidad = Integer.parseInt(forminv.jtfCantidad1.getText());
                int stockMax = Integer.parseInt(forminv.jtfStockMax.getText());
                //int codigo = Integer.parseInt(forminv.jtfCodigo.getText());
                if (cantidad < 1) {
                    JOptionPane.showMessageDialog(null, "LA CANTIDAD DEBE SER AL MENOS 1 ");
                    return;
                }
                if (cantidad > stockMax) {
                    JOptionPane.showMessageDialog(null, "LA CANTIDAD EXCEDE EL STOCK PERMITIDO");
                    return;
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                invPOO.setCodigo(Integer.parseInt(forminv.jtfCodigo.getText()));
                invPOO.setDescripcioninv(forminv.jtfDescripcion.getText());
                invPOO.setCantidadinv(Integer.parseInt(forminv.jtfCantidad1.getText()));
                invPOO.setTipoMove(forminv.cbxMove.getSelectedItem().toString());
                invPOO.setMotivo(forminv.jtfMotivo.getText());
                invPOO.setFecha(sdf.format(forminv.jdcFecha.getDate()));
                if (forminv.cbxSI.isSelected()) {
                    if (forminv.jdcVencimiento.getDate() != null) {
                        invPOO.setVencimiento(sdf.format(forminv.jdcVencimiento.getDate()));
                    } else {
                        JOptionPane.showMessageDialog(null, "DEBE INGRESAR LA FECHA DE VENCIMIENTO");
                        return;
                    }
                } else {
                    invPOO.setVencimiento(null);
                }

                invPOO.setEstado("Activo");

                if (conBDinv.crear(invPOO)) {
                    JOptionPane.showMessageDialog(null, "INVENTARIO CREADO CORRECTAMENTE ");
                    //limpiar();
                    llenarTablainv();
                    llenarTablaProd();
                } else {
                    JOptionPane.showMessageDialog(null, "NO SE PUDO CREAR INVENTARIO");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "VERIFIQUE LOS CAMPOS DE VALOR NUMERICOS SEAN CORRECTOS");
            }
        }

        if (e.getSource() == forminv.botActualizar) {

            try {
                int cantidad = Integer.parseInt(forminv.jtfCantidad1.getText());
                int stockMax = Integer.parseInt(forminv.jtfStockMax.getText());

                if (cantidad < 1) {
                    JOptionPane.showMessageDialog(null, "LA CANTIDAD DEBE SER AL MENOS 1");
                    return;
                }
                if (cantidad > stockMax) {
                    JOptionPane.showMessageDialog(null, "LA CANTIDAD EXCEDE EL STOCK PERMITIDO");
                    return;
                }

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                invPOO.setCantidadinv(cantidad);
                invPOO.setTipoMove(forminv.cbxMove.getSelectedItem().toString());
                invPOO.setMotivo(forminv.jtfMotivo.getText());
                invPOO.setFecha(sdf.format(forminv.jdcFecha.getDate()));
                invPOO.setVencimiento(sdf.format(forminv.jdcVencimiento.getDate()));
                invPOO.setCodigo(Integer.parseInt(forminv.jtfCodigo.getText()));

                if (conBDinv.actualizarInv(invPOO)) {
                    JOptionPane.showMessageDialog(null, "PRODUCTO ACTUALIZADO CORRECTAMENTE");
                    //limpiar();
                    llenarTablaProd();
                    llenarTablainv();
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "VERIFIQUE LOS CAMPOS DE VALOR NUMERICOS SEAN CORRECTOS");
            }
        }

        if (e.getSource() == forminv.botLeer) {
            llenarTablaProd();
            llenarTablainv();
        }

        if (e.getSource() == forminv.botEliminar) {
            invPOO.setCodigo(Integer.parseInt(forminv.jtfCodigo.getText()));
            invPOO.setEstado("Inactivo");
            if (conBDinv.eliminarInvetario(invPOO)) {
                JOptionPane.showMessageDialog(null, "INVENTARIO ELIMINADO CORRRECTAMENTE INV-CONT");
                limpiar();
                //llenarTablaProd();
                //llenarTablainv();
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR INVENTARIO INV-CONT");
                // limpiar();
            }
        }

        if (e.getSource() == forminv.botBuscarC) {
            invPOO.setCodigo(Integer.parseInt(forminv.jtfCodigo.getText()));

            if (conBDinv.leerproducto(invPOO)) {
                JOptionPane.showMessageDialog(null, "PRODUCTO ENCONTRADO  INV-CONTROL");
                forminv.jtfDescripcion.setText(invPOO.getDescripcioninv());
                forminv.jtfStockMin.setText(String.valueOf(invPOO.getStockMin()));
                forminv.jtfStockMax.setText(String.valueOf(invPOO.getStockMax()));
            } else {
                JOptionPane.showMessageDialog(null, "PRODUCTO NO ENCONTRADO INV-CONTROL");
            }

        }

        if (e.getSource() == forminv.botBuscarINV) {

            try {
                invPOO.setCodigo(Integer.parseInt(forminv.jtfCodigo.getText()));
                if (conBDinv.leerInventario(invPOO)) {
                    JOptionPane.showMessageDialog(null, "INVENTAEIO ENCONTRADO  INV-CONTROL");
                    forminv.jtfDescripcion.setText(invPOO.getDescripcioninv());
                    forminv.jtfCantidad1.setText(String.valueOf(invPOO.getCantidadinv()));
                    forminv.cbxMove.setSelectedItem(invPOO.getTipoMove());
                    forminv.jtfMotivo.setText(invPOO.getMotivo());

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    if (invPOO.getFecha() != null && !invPOO.getFecha().isEmpty()) {
                        java.util.Date fecha = sdf.parse(invPOO.getFecha());
                        forminv.jdcFecha.setDate(fecha);
                    }else{
                        forminv.jdcFecha.setDate(null);
                    }
                    if(invPOO.getVencimiento() != null && !invPOO.getVencimiento().isEmpty()){
                        java.util.Date venc = sdf.parse(invPOO.getVencimiento());
                        forminv.jdcVencimiento.setDate(venc);
                        forminv.cbxSI.setSelected(true);
                    }else{
                        forminv.jdcVencimiento.setDate(null);
                        forminv.cbxSI.setSelected(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "PRODUCTO NO ENCONTRADO INV-CONTROL");
                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null,"CODIGO INVALIDO");
            } catch (ParseException ex) {
                Logger.getLogger(InventarioControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (e.getSource() == forminv.botLimpiar) {
            limpiar();
        }

        if (e.getSource() == forminv.botHome) {
            forminv.dispose();
            formprin.setVisible(true);
        }

    }

}
