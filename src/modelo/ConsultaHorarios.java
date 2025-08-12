/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.Time;
import java.time.LocalTime;
import javax.swing.JComboBox;

/**
 *
 * @author andrea
 */
public class ConsultaHorarios extends Conexion {

    PreparedStatement ps = null;
    String sentenciaSQL;
    ResultSet rs = null;
    HorariosPOO hor;

    public boolean crearHorario(HorariosPOO hor) {
        Connection con = getConexion();

        try {
            // 1️⃣ Obtener duración de la película
            String sqlDuracion = "SELECT duracion FROM peliculas WHERE titulo = ?";
            PreparedStatement psDur = con.prepareStatement(sqlDuracion);
            psDur.setString(1, hor.getPelicula());
            ResultSet rsDur = psDur.executeQuery();

            if (!rsDur.next()) {
                JOptionPane.showMessageDialog(null, "No se encontró la duración de la película");
                return false;
            }
            // Obtener la duración como Time y convertir a minutos totales
            Time duracionTime = rsDur.getTime("duracion");
            long duracionMillis = duracionTime.getTime();
            int duracionMin = (int) (duracionMillis / (60 * 1000)) % (60 * 60 * 24);
            System.out.println("Duración en minutos: " + duracionMin);

            // 2️⃣ Calcular hora fin
            LocalTime horaFin = hor.getHoraI().plusMinutes(duracionMin);

            // 3️⃣ Validar que la sala esté libre
            String sqlCheck = """
                SELECT * FROM horarios
                WHERE sala = ? AND dia = ?
                  AND NOT (hora_fin <= ? OR hora_inicio >= ?)
            """;
            PreparedStatement psCheck = con.prepareStatement(sqlCheck);
            psCheck.setString(1, hor.getSala());
            psCheck.setString(2, hor.getDia());
            psCheck.setTime(3, Time.valueOf(hor.getHoraI())); // hora nueva inicio
            psCheck.setTime(4, Time.valueOf(horaFin));        // hora nueva fin
            ResultSet rsCheck = psCheck.executeQuery();

            if (rsCheck.next()) {
                JOptionPane.showMessageDialog(null, "⚠ La sala ya está ocupada en ese horario");
                return false;
            }

            // 4️⃣ Insertar el nuevo horario
            sentenciaSQL = """
                INSERT INTO horarios(pelicula, sala, dia, hora_inicio, hora_fin, estado)
                VALUES(?,?,?,?,?,?)
            """;
            PreparedStatement psInsert = con.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, hor.getPelicula());
            psInsert.setString(2, hor.getSala());
            psInsert.setString(3, hor.getDia());
            psInsert.setTime(4, Time.valueOf(hor.getHoraI()));
            psInsert.setTime(5, Time.valueOf(horaFin));
            psInsert.setString(6, hor.getEstado());
            psInsert.executeUpdate();

            ResultSet generatedKeys = psInsert.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idGenerado = generatedKeys.getInt(1);
                System.out.println("ID generado: " + idGenerado);
            }

            JOptionPane.showMessageDialog(null, "Horario creado correctamente - BD");
            return true;

        } catch (SQLException ex) {
            System.out.println("Error al crear horarioo: " + ex.getMessage());
            return false;

        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexión: " + ex.getMessage());
            }
        }
    }


    public boolean eliminarHorario(int idHorario) {
        Connection con = getConexion();
        String sql = "UPDATE horarios SET estado = 'Inactivo' WHERE id_horario = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idHorario);

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                JOptionPane.showMessageDialog(null, "Horario desactivado correctamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el horario para eliminar");
                return false;
            }

        } catch (SQLException ex) {
            System.out.println("Error al eliminar horario: " + ex.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexión: " + ex.getMessage());
            }
        }
    }

    public boolean actualizarHorario(HorariosPOO hor) {
        Connection con = getConexion();
        String sql = "UPDATE horarios SET pelicula = ?, sala = ?, dia = ?, hora_inicio = ?, hora_fin = ?, estado = ? WHERE id_horario = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, hor.getPelicula());
            ps.setString(2, hor.getSala());
            ps.setString(3, hor.getDia());
            ps.setTime(4, Time.valueOf(hor.getHoraI()));
            ps.setTime(5, Time.valueOf(hor.getHoraF()));
            ps.setString(6, hor.getEstado());
            ps.setInt(7, hor.getIdHorario());

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                JOptionPane.showMessageDialog(null, "Horario actualizado correctamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el horario para actualizar");
                return false;
            }

        } catch (SQLException ex) {
            System.out.println("Error al actualizar horario: " + ex.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexión: " + ex.getMessage());
            }
        }
    }

    public ArrayList<String> obtenerNombresPeliculas() {
        ArrayList<String> nombresPeliculas = new ArrayList<>();
        Connection con = getConexion();
        sentenciaSQL = "SELECT titulo FROM peliculas WHERE estado = 'Activo'";
        
        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                nombresPeliculas.add(rs.getString("titulo"));
            }

            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo obtener los nombres de películas: " + ex);
        }

        return nombresPeliculas;
    }

    public ArrayList<String> obtenerNombresSalas() {
        ArrayList<String> nombresSalas = new ArrayList<>();
        Connection con = getConexion();
        sentenciaSQL = "SELECT nombre FROM salas";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                nombresSalas.add(rs.getString("nombre"));
            }

            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo obtener los nombres de salas: " + ex);
        }

        return nombresSalas;
    }

    public int obtenerDuracionPorTitulo(String titulo) {
        int duracionEnMinutos = 0;
        Connection con = getConexion();
        sentenciaSQL = "SELECT duracion FROM peliculas WHERE titulo = ?";

        try {

            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, titulo);
            rs = ps.executeQuery();

            if (rs.next()) {
                String duracionStr = rs.getString("duracion");
                LocalTime duracion = LocalTime.parse(duracionStr);
                duracionEnMinutos = duracion.getHour() * 60 + duracion.getMinute();
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return duracionEnMinutos;
    }
    


    public ArrayList<HorariosPOO> leerTodos() {
        ArrayList horarios = new ArrayList();
        Connection con = getConexion();
        sentenciaSQL = "SELECT * FROM horarios WHERE estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                hor = new HorariosPOO();
                hor.setIdHorario(rs.getInt(1));
                hor.setPelicula(rs.getString(2));
                hor.setSala(rs.getString(3));
                hor.setDia(rs.getString(4));
                hor.setHoraI(rs.getTime(5).toLocalTime());
                hor.setHoraF(rs.getTime(6).toLocalTime());
                horarios.add(hor);
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO LEER LOS DATOS" + ex);
        }
        return horarios;
    }

}
