/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alexs
 */
public class Conexion {

    Connection c = null;
    private String db = "bd_cinemania_grupo3";
    private String user = "root";
    private String pass = "";
    private String url = "jdbc:mysql://localhost:3306/" + db;

    public Connection getConexion() {

        try {
            //DRIVER
            Class.forName("com.mysql.jdbc.Driver");
            //CONECTAMOS A LA BASE DE DATOS
            c = (Connection) DriverManager.getConnection(this.url, this.user, this.pass);
            System.out.println("CONEXION REALIZADA EXITOSAMENTE");

        } catch (ClassNotFoundException ex) {
            System.out.print("NO SE PUDO REALIZAR LA CONEXION" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("NO SE PUDO REALIZAR LA CONEXION" + ex.getMessage());
        }
        return c;
    }

    public static void main(String[] args) {
        Conexion con = new Conexion();
        con.getConexion();
    }
}


