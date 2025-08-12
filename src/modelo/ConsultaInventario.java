/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author alexs
 */
public class ConsultaInventario extends Conexion {

    PreparedStatement ps = null;
    String sentenciaSQL;
    ResultSet rs = null;
    InventarioPOO invPOO;

    public boolean crear(InventarioPOO invPOO) {
        Connection con = getConexion();
        sentenciaSQL = "INSERT INTO movimientos_inventario (id ,descripcion, movimiento, cantidad, motivo, fecha, vencimiento, estado)VALUES (?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, invPOO.getCodigo());
            ps.setString(2, invPOO.getDescripcioninv());
            ps.setString(3, invPOO.getTipoMove());
            ps.setInt(4, invPOO.getCantidadinv());
            ps.setString(5, invPOO.getMotivo());
            ps.setString(6, invPOO.getFecha());
            ps.setString(7, invPOO.getVencimiento());
            ps.setString(8, invPOO.getEstado());
            ps.execute();
            JOptionPane.showMessageDialog(null, "INVENTARIO GUARDADO EXITOSAMENTE.CONBD");
            return true;
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.print(ex.getMessage());
            }
        }
    }

    //LEER PRODUCTOS QUE NO TIENEN INVENTARIO 
    public ArrayList<InventarioPOO> leerTodosSinInv() {
        ArrayList noInventario = new ArrayList();
        Connection con = getConexion();
        sentenciaSQL = "SELECT p.id, p.descripcion, p.proveedor, p.stockMin, p.stockMax FROM productos p LEFT JOIN movimientos_inventario e ON p.id = e.id WHERE e.cantidad IS NULL;";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                invPOO = new InventarioPOO();
                invPOO.setCodigo(rs.getInt("p.id"));
                invPOO.setDescripcioninv(rs.getString("p.descripcion"));
                invPOO.setProveedor(rs.getString("p.proveedor"));
                invPOO.setStockMin(rs.getInt("p.stockMin"));
                invPOO.setStockMax(rs.getInt("p.stockMax"));
                noInventario.add(invPOO);
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO LEER DATOS" + ex.getMessage());
        }
        return noInventario;
    }

    //METODO LEER INVENTARIO
    public ArrayList<InventarioPOO> leerTodosInventario() {
        ArrayList Inventario = new ArrayList();
        Connection con = getConexion();
        sentenciaSQL = "SELECT * FROM movimientos_inventario WHERE estado='Activo' AND cantidad>=1";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                invPOO = new InventarioPOO();
                invPOO.setCodigo(rs.getInt("id"));
                invPOO.setDescripcioninv(rs.getString("descripcion"));
                invPOO.setTipoMove(rs.getString("movimiento"));
                invPOO.setCantidadinv(rs.getInt("cantidad"));
                invPOO.setFecha(rs.getString("fecha"));
                invPOO.setMotivo(rs.getString("motivo"));
                invPOO.setVencimiento(rs.getString("vencimiento"));
                Inventario.add(invPOO);
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO LEER DATOS" + ex.getMessage());
        }
        return Inventario;
    }

    public boolean leerproducto(InventarioPOO invPOO) {
        Connection con = getConexion();
        sentenciaSQL = "SELECT * FROM productos WHERE id=? AND estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, invPOO.getCodigo());
            rs = ps.executeQuery();
            if (rs.next()) {
                invPOO.setCodigo(rs.getInt("id"));
                invPOO.setDescripcioninv(rs.getString("descripcion"));
                invPOO.setStockMin(rs.getInt("stockMin"));
                invPOO.setStockMax(rs.getInt("stockMax"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO LEER DATOS" + ex.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.print(ex.getMessage());
            }
        }
    }

    public boolean leerInventario(InventarioPOO invPOO) {
        Connection con = getConexion();
        sentenciaSQL = "SELECT * FROM movimientos_inventario WHERE id=? AND estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, invPOO.getCodigo());
            rs = ps.executeQuery();
            if (rs.next()) {
                invPOO.setCodigo(rs.getInt("id"));
                invPOO.setDescripcioninv(rs.getString("descripcion"));
                //invPOO.setStockMin(rs.getInt("stockMin"));
                //invPOO.setStockMax(rs.getInt("stockMax"));
                invPOO.setCantidadinv(rs.getInt("cantidad"));
                invPOO.setTipoMove(rs.getString("movimiento"));
                invPOO.setMotivo(rs.getString("motivo"));
                invPOO.setFecha(rs.getString("fecha"));
                invPOO.setVencimiento(rs.getString("vencimiento"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO LEER DATOS" + ex.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.print(ex.getMessage());
            }
        }
    }

    public boolean actualizarInv(InventarioPOO inv) {
        Connection con = getConexion();
        sentenciaSQL = "UPDATE movimientos_inventario SET movimiento=?,cantidad=?, motivo=?, fecha=?, vencimiento=? WHERE id=?";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, inv.getTipoMove());
            ps.setInt(2, inv.getCantidadinv());
            ps.setString(3, inv.getMotivo());
            ps.setString(4, inv.getFecha());
            ps.setString(5, inv.getVencimiento());
            ps.setInt(6, inv.getCodigo());

            ps.execute();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR: " + ex.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.print(ex.getMessage());
            }
        }
    }

    public boolean eliminarInvetario(InventarioPOO inv) {
        Connection con = getConexion();
        sentenciaSQL = "UPDATE movimientos_inventario SET estado=? WHERE id =?";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, inv.getEstado());
            ps.setInt(2, inv.getCodigo());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR INVENTARIO - CONBD" + ex.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.print(ex.getMessage());
            }
        }
    }

}
