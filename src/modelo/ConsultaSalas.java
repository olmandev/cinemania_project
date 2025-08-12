/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ConsultaSalas extends Conexion {

    // Crear sala (versión mejorada)
    public boolean crearSala(SalasPOO sal) {
        String sql = "INSERT INTO salas(nombre, capacidad, tipo, estado) VALUES(?,?,?,?)";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sal.getNombre());
            ps.setInt(2, sal.getCapacidad());
            ps.setString(3, sal.getTipo());
            ps.setString(4, sal.getEstado());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sala creada correctamente");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear sala:\n" + ex.getMessage(),
                "Error BD", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Actualizar sala completa por id
    public boolean actualizarSala(SalasPOO sal) {
        String sql = "UPDATE salas SET nombre=?, capacidad=?, tipo=?, estado=? WHERE id=?";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sal.getNombre());
            ps.setInt(2, sal.getCapacidad());
            ps.setString(3, sal.getTipo());
            ps.setString(4, sal.getEstado());
            ps.setInt(5, sal.getId());
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException ex) {
            return false;
        }
    }

    // Buscar sala por id
    public SalasPOO buscarSalaPorId(int id) {
        String sql = "SELECT * FROM salas WHERE id = ?";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapearSala(rs);
                } else return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }

    // Buscar sala por nombre (exacto)
    public SalasPOO buscarSalaPorNombre(String nombre) {
        String sql = "SELECT * FROM salas WHERE nombre = ?";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapearSala(rs);
                } else return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }

    public List<SalasPOO> listarSalasActivas() {
        String sql = "SELECT * FROM salas WHERE estado = 'activo'";
        List<SalasPOO> lista = new ArrayList<>();
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(mapearSala(rs));
            }
        } catch (SQLException ex) {
        }
        return lista;
    }

    // "Eliminar" sala: set estado a 'inactivo'
    public boolean eliminarSala(int id) {
        String sql = "UPDATE salas SET estado = 'inactivo' WHERE id = ?";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException ex) {
            return false;
        }
    }

    // Método helper para mapear un ResultSet a SalasPOO
    private SalasPOO mapearSala(ResultSet rs) throws SQLException {
        SalasPOO s = new SalasPOO();
        s.setId(rs.getInt("id"));
        s.setNombre(rs.getString("nombre"));
        s.setCapacidad(rs.getInt("capacidad"));
        s.setTipo(rs.getString("tipo"));
        s.setEstado(rs.getString("estado"));
        return s;
    }
}



