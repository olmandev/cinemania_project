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
public class ConsultaPelicula extends Conexion {

    PreparedStatement ps = null;
    String sentenciaSQL;
    ResultSet rs = null;
    PeliculaPOO peli;

    public boolean crearPelicula(PeliculaPOO peli) {
        Connection con = getConexion();
        sentenciaSQL = "INSERT INTO peliculas(id, titulo, duracion, clasificacion, imagen, estado) VALUES(?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, peli.getCodigo());
            ps.setString(2, peli.getTitulo());
            ps.setString(3, peli.getDuracion());
            ps.setString(4, peli.getClasificacion());
            ps.setString(5, peli.getImagen());
            ps.setString(6, peli.getEstado());
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

    public ArrayList<PeliculaPOO> leerTodos() {
        ArrayList peliculas = new ArrayList();
        Connection con = getConexion();
        sentenciaSQL = "SELECT * FROM peliculas WHERE estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                peli = new PeliculaPOO();
                peli.setCodigo(rs.getInt(1));
                peli.setTitulo(rs.getString(2));
                peli.setDuracion(rs.getString(3));
                peli.setClasificacion(rs.getString(4));

                peliculas.add(peli);
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO LEER LOS DATOS" + ex);
        }
        return peliculas;
    }

    public boolean actualizarPelicula(PeliculaPOO peli) {
        Connection con = getConexion();
        sentenciaSQL = "UPDATE peliculas SET titulo=?,duracion=?, clasificacion=?, imagen=? WHERE id=?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, peli.getTitulo());
            ps.setString(2, peli.getDuracion());
            ps.setString(3, peli.getClasificacion());
            ps.setString(4, peli.getImagen());
            ps.setInt(5, peli.getCodigo());
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

    public boolean eliminarPelicula(PeliculaPOO peli) {
        Connection con = getConexion();
        sentenciaSQL = "UPDATE peliculas SET estado = ? WHERE id=?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, "Inactivo");
            ps.setInt(2, peli.getCodigo());
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

    public boolean leerPelicula(PeliculaPOO peli) {
        Connection con = getConexion();
        sentenciaSQL = "SELECT * FROM peliculas WHERE id =? AND estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, peli.getCodigo());
            rs = ps.executeQuery();
            if (rs.next()) {
                peli.setCodigo(rs.getInt(1));
                peli.setTitulo(rs.getString(2));
                peli.setDuracion(rs.getString(3));
                peli.setClasificacion(rs.getString(4));
                peli.setImagen(rs.getString(5));
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

    public boolean leerPeliculaTitulo(PeliculaPOO peli) {
        Connection con = getConexion();
        sentenciaSQL = "SELECT * FROM peliculas WHERE titulo=? AND estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, peli.getTitulo());
            rs = ps.executeQuery();
            if (rs.next()) {
                peli.setCodigo(rs.getInt("id"));
                peli.setTitulo(rs.getString("titulo"));
                peli.setDuracion(rs.getString("duracion"));
                peli.setClasificacion(rs.getString("clasificacion"));
                peli.setImagen(rs.getString("imagen"));
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
}
