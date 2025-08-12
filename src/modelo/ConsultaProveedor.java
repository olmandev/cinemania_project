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
public class ConsultaProveedor extends Conexion {

    PreparedStatement ps = null;
    String sentenciaSQL;
    ResultSet rs = null;
    ProveedorPOO prove;

    public boolean crear(ProveedorPOO prove) {
        Connection con = getConexion();
        sentenciaSQL = "INSERT INTO proveedores (id, nombre , contacto,foto, estado) VALUES(?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, prove.getCodigo_P());
            ps.setString(2, prove.getNombre_P());
            ps.setString(3, prove.getContacto());
            ps.setString(4, prove.getFoto());
            ps.setString(5, prove.getEstado_P());
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

    //METODO LEER TODOS LOS CLIENTES 
    public ArrayList<ProveedorPOO> leerTodos() {
        ArrayList proveedores = new ArrayList();
        Connection con = getConexion();
        sentenciaSQL = "SELECT * FROM proveedores WHERE estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                prove = new ProveedorPOO();
                prove.setCodigo_P(rs.getInt(1));
                prove.setNombre_P(rs.getString(2));
                prove.setContacto(rs.getString(3));
                proveedores.add(prove);
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO LEER LOS DATOS" + ex);
        }
        return proveedores;
    }

    public boolean leerCliente(ProveedorPOO prove) {
        Connection con = getConexion();
        sentenciaSQL = "SELECT * FROM proveedores WHERE id =? AND estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, prove.getCodigo_P());
            rs = ps.executeQuery();
            if (rs.next()) {
                prove.setCodigo_P(rs.getInt(1));
                prove.setNombre_P(rs.getString(2));
                prove.setContacto(rs.getString(3));
                prove.setFoto(rs.getString(4));
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

    public boolean actualizarCliente(ProveedorPOO prove) {
        Connection con = getConexion();
        sentenciaSQL = "UPDATE proveedores SET nombre=?,contacto=?, foto=? WHERE id=?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, prove.getNombre_P());
            ps.setString(2, prove.getContacto());
            ps.setString(3, prove.getFoto());
            ps.setInt(4, prove.getCodigo_P());
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

    public boolean eliminarCliente(ProveedorPOO prove) {
        Connection con = getConexion();
        sentenciaSQL = "UPDATE proveedores SET estado = ? WHERE id=?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, "Inactivo");
            ps.setInt(2, prove.getCodigo_P());
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

}
