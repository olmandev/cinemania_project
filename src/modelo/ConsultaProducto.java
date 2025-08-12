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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author alexs
 */
public class ConsultaProducto extends Conexion {

    PreparedStatement ps = null;
    String sentenciaSQL;
    ResultSet rs = null;
    ProductoPOO produ;
    // InventarioPOO invPOO;

    public boolean crear(ProductoPOO produ) {
        Connection con = getConexion();
        sentenciaSQL = "INSERT INTO productos (id, descripcion , costo, precio, utilidad, proveedor, stockMin, stockMax,tipo,foto, estado) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, produ.getCodigo());
            ps.setString(2, produ.getDescripcion());
            ps.setDouble(3, produ.getCosto());
            ps.setDouble(4, produ.getPrecio());
            ps.setDouble(5, produ.getUtilidad());
            ps.setString(6, produ.getProveedor());
            ps.setInt(7, produ.getStockMin());
            ps.setInt(8, produ.getStockMax());
            ps.setString(9, produ.getTipo());
            ps.setString(10,produ.getFoto());
            ps.setString(11, produ.getEstado());
            ps.execute();
            JOptionPane.showMessageDialog(null, "DATOS INGREADOS COREECTAMENTE! - conBD");
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

    public ArrayList<ProductoPOO> leerTodos() {
        ArrayList productos = new ArrayList();
        Connection con = getConexion();
        sentenciaSQL = "SELECT * FROM productos WHERE estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                produ = new ProductoPOO();
                produ.setCodigo(rs.getInt(1));
                produ.setDescripcion(rs.getString(2));
                produ.setCosto(rs.getDouble(3));
                produ.setPrecio(rs.getDouble(4));
                produ.setUtilidad(rs.getDouble(5));
                produ.setProveedor(rs.getString(6));
                produ.setStockMin(rs.getInt(7));
                produ.setStockMax(rs.getInt(8));
                produ.setTipo(rs.getString(9));
                productos.add(produ);
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO LEER LOS DATOS - CONSPRODU" + ex);
        }
        return productos;
    }

    public boolean leerProudcto(ProductoPOO produ) {
        Connection con = getConexion();
        sentenciaSQL = "SELECT * FROM productos WHERE id =? AND estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, produ.getCodigo());
            rs = ps.executeQuery();
            if (rs.next()) {
                produ.setCodigo(rs.getInt("id"));
                produ.setDescripcion(rs.getString("descripcion"));
                produ.setCosto(rs.getDouble("costo"));
                produ.setPrecio(rs.getDouble("precio"));
                produ.setProveedor(rs.getString("proveedor"));
                produ.setStockMin(rs.getInt("stockMin"));
                produ.setStockMax(rs.getInt("StockMax"));
                produ.setTipo(rs.getString("tipo"));
                produ.setFoto(rs.getString("foto"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            System.out.print("NO SE PUDO LEER LOS DATOS" + ex.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.print(ex.getMessage());
            }
        }

    }

    public boolean leerProductoDes(ProductoPOO produ) {
        Connection con = getConexion();
        sentenciaSQL = "SELECT * FROM productos WHERE descripcion=?";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, produ.getDescripcion());
            rs = ps.executeQuery();
            if (rs.next()) {
                produ.setCodigo(rs.getInt("id"));
                produ.setDescripcion(rs.getString("descripcion"));
                produ.setCosto(rs.getDouble("costo"));
                produ.setPrecio(rs.getDouble("precio"));
                produ.setProveedor(rs.getString("proveedor"));
                produ.setStockMin(rs.getInt("stockMin"));
                produ.setStockMax(rs.getInt("stockMax"));
                produ.setTipo(rs.getString("tipo"));
                produ.setFoto(rs.getString("foto"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            System.out.println("ERROR BUSCAR POR NOMBRE: " + ex.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
            }
        }

    }

    public boolean actualizarProducto(ProductoPOO produ) {
        Connection con = getConexion();
        sentenciaSQL = "UPDATE productos SET descripcion=?,costo=?, precio=?, utilidad=?, proveedor=?, stockMin=?, stockMax=?, tipo=?, foto=? WHERE id=?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, produ.getDescripcion());
            ps.setDouble(2, produ.getCosto());
            ps.setDouble(3, produ.getPrecio());
            ps.setDouble(4, produ.getUtilidad());
            ps.setString(5, produ.getProveedor());
            ps.setInt(6, produ.getStockMin());
            ps.setInt(7, produ.getStockMax());
            ps.setString(8, produ.getTipo());
            ps.setString(9, produ.getFoto());
            ps.setInt(10, produ.getCodigo());
            ps.execute();
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS COREECTAMENTE! - conBD");
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

    public boolean eliminarProducto(ProductoPOO produ) {
        Connection con = getConexion();
        sentenciaSQL = "UPDATE productos SET estado = ? WHERE id=?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, "Inactivo");
            ps.setInt(2, produ.getCodigo());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "ESTADO CAMBIANDO A INACTIVO CORRECTAMENTE - conBD");
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
    
     public void CargarProveedores(JComboBox cbxProveedores) {
        Connection con = getConexion();
        sentenciaSQL = "SELECT nombre FROM proveedores WHERE estado = 'Activo' ";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();
            cbxProveedores.addItem("SELECCIONE UN PROVEEDOR");
            while (rs.next()) {
                cbxProveedores.addItem(rs.getString("nombre"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    }

}
