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
import modelo.LoginPOO;

/**
 *
 * @author alexs
 */
public class ConsultaLogin extends Conexion {

    PreparedStatement ps = null;
    String sentenciaSQL;
    ResultSet rs = null;
    LoginPOO log;

    public boolean crearLogin(LoginPOO log) {
        Connection con = getConexion();
        sentenciaSQL = "INSERT INTO usuarios (id, nombre, apellido, usuario, contrasena,rol, estado) VALUES (?,?,?,?,?,?,?) ";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, log.getCodigo());
            ps.setString(2, log.getNombre());
            ps.setString(3, log.getApellido());
            ps.setString(4, log.getUsuario());
            ps.setString(5, log.getContrasena());
            ps.setString(6, log.getRol());
            ps.setString(7, log.getEstado());
            ps.execute();
            JOptionPane.showMessageDialog(null, "USUARIO AGREGADO CORRECTAMENTE .CONBD");
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

    public boolean actualizarUsuario(LoginPOO log) {
        Connection con = getConexion();
        sentenciaSQL = "UPDATE usuarios SET nombre=?,apellido=?, usuario=?, contrasena=?, rol=? WHERE id=?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, log.getNombre());
            ps.setString(2, log.getApellido());
            ps.setString(3, log.getUsuario());
            ps.setString(4, log.getContrasena());
            ps.setString(5, log.getRol());
            ps.setInt(6, log.getCodigo());
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

    public ArrayList<LoginPOO> leerTodos() {
        ArrayList usuarios = new ArrayList();
        Connection con = getConexion();
        sentenciaSQL = "SELECT * FROM usuarios WHERE estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                log = new LoginPOO();
                log.setCodigo(rs.getInt(1));
                log.setNombre(rs.getString(2));
                log.setApellido(rs.getString(3));
                log.setUsuario(rs.getString(4));
                log.setContrasena(rs.getString(5));
                log.setRol(rs.getString(6));
                usuarios.add(log);
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO LEER LOS DATOS" + ex);
        }
        return usuarios;
    }

    public boolean leerUsuario(LoginPOO log) {
        Connection con = getConexion();
        sentenciaSQL = "SELECT * FROM usuarios WHERE id =? AND estado = 'Activo' ";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, log.getCodigo());
            rs = ps.executeQuery();
            if (rs.next()) {
                log.setCodigo(rs.getInt(1));
                log.setNombre(rs.getString(2));
                log.setApellido(rs.getString(3));
                log.setUsuario(rs.getString(4));
                log.setContrasena(rs.getString(5));
                log.setRol(rs.getString(6));
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

    public boolean eliminarUsuario(LoginPOO log) {
        Connection con = getConexion();
        sentenciaSQL = "UPDATE usuarios SET estado = ? WHERE id=?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, "Inactivo");
            ps.setInt(2, log.getCodigo());
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

    public boolean AccesoporRol(LoginPOO log) {
        Connection con = getConexion();
        sentenciaSQL = "SELECT  FROM usuarios WHERE usuario =? AND contrasena=?";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, log.getUsuario());
            ps.setString(2, log.getContrasena());
            rs = ps.executeQuery();

            if (rs.next()) {
                log.setRol(rs.getString("rol"));
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL CAPTURAR ROL");
            return false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    public boolean LoginValidacion(LoginPOO usuario) {
        Connection con = getConexion();
        sentenciaSQL = "SELECT * FROM usuarios WHERE usuario=? AND contrasena=? AND estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getContrasena());
            rs = ps.executeQuery();

            if (rs.next()) {
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setRol(rs.getString("rol"));
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL INCIAR SESION " + ex.getMessage());
            return false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}
