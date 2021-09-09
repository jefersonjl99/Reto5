/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.conexion;

/**
 *
 * @author jefer
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private Connection conexion = null;

    public void EstableciendoConexion() {
        String url = "jdbc:mysql://localhost:3306/ecodosruedas";
        String usuario = "root";
        String contrasena = "12345p";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url, usuario, contrasena);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en la conexion...\nError: "+e.getMessage());
        }
    }

    public void cerrandoConexion() {
        try {
            conexion.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Problema al cerrar");
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

}
