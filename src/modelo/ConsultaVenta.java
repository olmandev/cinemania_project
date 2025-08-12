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
import javax.swing.JTable;
import modelo.VentaPOO;

/**
 *
 * @author alexs
 */
public class ConsultaVenta extends Conexion {

    PreparedStatement ps = null;
    String sentenciaSQL;
    ResultSet rs = null;
    VentaPOO vent;

    public int crearVenta(VentaPOO vent) {
        Connection con = getConexion();
        sentenciaSQL = "INSERT INTO ventas (cliente, pelicula, sala,asiento, subtotal, isv, total, metodo_pago, cantidad_pagar, cambio,fecha, estado) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?,?,?,?)";
        try {
            ps = con.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, vent.getCliente());
            ps.setString(2, vent.getPelicula());
            ps.setString(3, vent.getSala());
            ps.setString(4, vent.getAsiento());
            ps.setDouble(5, vent.getSubtotal());
            ps.setDouble(6, vent.getIsv());
            ps.setDouble(7, vent.getTotal());
            ps.setString(8, vent.getMetodo());
            ps.setDouble(9, vent.getCantidadpagar());
            ps.setDouble(10, vent.getCambio());
            ps.setDate(11, java.sql.Date.valueOf(vent.getFecha())); 
            ps.setString(12, "Activo");
            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int idGenerado = generatedKeys.getInt(1);
                    vent.setCodigo(idGenerado);
                    return idGenerado;
                }
            }
            return -1;

        } catch (SQLException ex) {
            return -1;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.print(ex.getMessage());
            }

        }
    }

    public boolean crearDetalle(int idVenta, JTable tabla) {
        Connection con = getConexion();
        if (idVenta <= 0) {
            System.err.println("ID de venta inválido: " + idVenta);
            return false;
        }

        String verificarVenta = "SELECT COUNT(*) FROM ventas WHERE id_venta = ?";
        try {
            PreparedStatement psVerificar = con.prepareStatement(verificarVenta);
            psVerificar.setInt(1, idVenta);
            ResultSet rs = psVerificar.executeQuery();

            if (rs.next() && rs.getInt(1) == 0) {
                System.err.println("La venta con ID " + idVenta + " no existe en la base de datos");
                return false;
            }
            psVerificar.close();
        } catch (SQLException ex) {
            System.err.println("Error verificando venta: " + ex.getMessage());
            return false;
        }

        sentenciaSQL = "INSERT INTO detalle (id_venta, nombre_producto, tipo_producto, cantidad, precio_unitario) VALUES (?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sentenciaSQL);

            if (tabla.getRowCount() == 0) {
                System.out.println("NO HAY PRODUCTOS PARA GUARDAR");
                return false;
            }

            for (int i = 0; i < tabla.getRowCount(); i++) {
                ps.setInt(1, idVenta);
                ps.setString(2, tabla.getValueAt(i, 0).toString());
                ps.setString(3, tabla.getValueAt(i, 1).toString());
                ps.setInt(4, Integer.parseInt(tabla.getValueAt(i, 2).toString()));
                ps.setDouble(5, Double.parseDouble(tabla.getValueAt(i, 3).toString()));
                ps.addBatch();
            }

            int[] resultados = ps.executeBatch();

            boolean todoExitoso = true;
            for (int resultado : resultados) {
                if (resultado <= 0) {
                    todoExitoso = false;
                    break;
                }
            }

           /* if (todoExitoso) {
                System.out.println("Todos los productos se guardaron correctamente");
            }*/

            return todoExitoso;

        } catch (SQLException | NumberFormatException ex) {
            System.err.println("ERROR AL INSERTAR DETALLE: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println("ERROR AL CERRAR CONEXIÓN: " + ex.getMessage());
            }
        }
    }

    public ArrayList<VentaPOO> leerVentas() {
        ArrayList<VentaPOO> lista = new ArrayList<>();
        Connection con = getConexion();
        sentenciaSQL = "SELECT * FROM ventas WHERE estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                VentaPOO venta = new VentaPOO();
                venta.setCodigo(rs.getInt("id_venta"));
                venta.setCliente(rs.getString("cliente"));
                venta.setPelicula(rs.getString("pelicula"));
                venta.setSala(rs.getString("sala"));
                venta.setAsiento(rs.getString("asiento"));
                venta.setSubtotal(rs.getDouble("subTotal"));
                venta.setIsv(rs.getDouble("isv"));
                venta.setTotal(rs.getDouble("total"));
                venta.setMetodo(rs.getString("metodo_pago"));
                venta.setCantidadpagar(rs.getDouble("cantidad_pagar"));
                venta.setCambio(rs.getDouble("cambio"));
                java.sql.Date f = rs.getDate("fecha");
venta.setFecha(f != null ? f.toString() : null);
                lista.add(venta);
            }
        } catch (SQLException ex) {
            System.err.println("ERROR AL LEER VENTA " + ex.getMessage());
        }
        return lista;
    }

    public boolean eliminarVenta(VentaPOO vent) {
        Connection con = getConexion();
        sentenciaSQL = "UPDATE ventas SET estado = ? WHERE id_venta = ?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, "Inactivo");
            ps.setInt(2, vent.getCodigo());
            int resultado = ps.executeUpdate();
            return resultado > 0;
        } catch (SQLException ex) {
            System.err.println("ERROR AL ELIMINAR VENTA " + ex.getMessage());
            return false;
        }
    }

    public boolean buscarVenta(VentaPOO vent) {
        Connection con = getConexion();
        sentenciaSQL = "SELECT * FROM ventas WHERE id_venta=? AND estado = 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, vent.getCodigo());
            rs = ps.executeQuery();
            if (rs.next()) {
                vent.setCodigo(rs.getInt("id_venta"));
                vent.setCliente(rs.getString("cliente"));
                vent.setPelicula(rs.getString("pelicula"));
                vent.setSala(rs.getString("sala"));
                vent.setAsiento(rs.getString("asiento"));
                vent.setSubtotal(rs.getDouble("subtotal"));
                vent.setIsv(rs.getDouble("isv"));
                vent.setTotal(rs.getDouble("total"));
                vent.setMetodo(rs.getString("metodo_pago"));
                vent.setCantidadpagar(rs.getDouble("cantidad_pagar"));
                vent.setCambio(rs.getDouble("cambio"));
                java.sql.Date f = rs.getDate("fecha");
vent.setFecha(f != null ? f.toString() : null);
                return true;
            }
            return false;
        } catch (SQLException ex) {
            System.err.println("ERROR AL BUSCAR VENTA : " + ex.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "NO SE PUDIERON LEER LOS DATOS");
            }
        }
    }
    
    
 public ArrayList<ItemVentaPOO> buscarDetalle(int idVenta) {
        ArrayList<ItemVentaPOO> listaItems = new ArrayList<>();
        Connection con = getConexion();
        sentenciaSQL = "SELECT * FROM detalle WHERE id_venta = ? ";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, idVenta);
            rs = ps.executeQuery();

            while (rs.next()) {
                ItemVentaPOO item = new ItemVentaPOO();
                item.setNombre(rs.getString("nombre_producto"));
                item.setTipo(rs.getString("tipo_producto"));
                item.setCantidad(rs.getInt("cantidad"));
                item.setPrecioUnitario(rs.getDouble("precio_unitario"));
                listaItems.add(item);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR VENTA - CONBD");
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        return listaItems;
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
            JOptionPane.showMessageDialog(null, "NO SE PUDO OBTENER LA PELICULA " + ex);
        }

        return nombresPeliculas;
    }

    public ArrayList<String> obtenerNombresSalas() {
        ArrayList<String> nombresSalas = new ArrayList<>();
        Connection con = getConexion();
        sentenciaSQL = "SELECT nombre FROM salas WHERE estado = 'Activo'";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                nombresSalas.add(rs.getString("nombre"));
            }

            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO OBTENER LA SALA:  " + ex);
        }

        return nombresSalas;
    }
}
