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
import model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

//ACCESO AL CRUD
public class ClienteDAO {

    private ConexionDB conexionDB;

    public ClienteDAO(ConexionDB conexion) {
        this.conexionDB = conexion;
    }

    public boolean agregarCliente(String aliasName, String nombre, String apellido,
            String email, String celular, String contrasena, String nacimiento) {
        PreparedStatement ps;
        String sql = "INSERT INTO Cliente (aliasName,nombre,apellido,email,celular,contrasena,nacimiento) VALUES (?,?,?,?,?,?,?)";
        try {
            this.conexionDB.EstableciendoConexion();
            ps = this.conexionDB.getConexion().prepareStatement(sql);
            ps.setString(1, aliasName);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, email);
            ps.setString(5, celular);
            ps.setString(6, contrasena);
            ps.setString(7, nacimiento);

            int contador = ps.executeUpdate();
            if (contador > 0) {
                this.conexionDB.cerrandoConexion();
                return true;
            } else {
                this.conexionDB.cerrandoConexion();
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar el Cliente\nError: " + e.getMessage());
            return false;
        }
    }

    public Cliente buscarCliente(String aliasName) {
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT * FROM Cliente where aliasName = ?";
        Cliente clienteEncontrado = null;
        try {
            this.conexionDB.EstableciendoConexion();
            ps = this.conexionDB.getConexion().prepareStatement(sql);
            ps.setString(1, aliasName);
            rs = ps.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString(1);
                String apellido = rs.getString(2);
                String email = rs.getString(3);
                String celular = rs.getString(4);
                String contrasena = rs.getString(5);
                String nacimiento = rs.getString(6);

                clienteEncontrado = new Cliente(aliasName, nombre, apellido, email, celular, contrasena, nacimiento);

            }
            this.conexionDB.cerrandoConexion();
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Error al borrar cliente...\nError: " + e.getMessage());
            clienteEncontrado = null;
        }
        return clienteEncontrado;

    }

    public boolean eliminarCliente(String aliasName) {
        PreparedStatement ps;
        String sql = "DELETE FROM Cliente where aliasName = ?";
        try {
            this.conexionDB.EstableciendoConexion();
            ps = this.conexionDB.getConexion().prepareStatement(sql);
            ps.setString(1, aliasName);

            int contador = ps.executeUpdate();
            if (contador > 0) {
                this.conexionDB.cerrandoConexion();
                return true;
            } else {
                this.conexionDB.cerrandoConexion();
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente...\nError: " + e.getMessage());
            return false;
        }
    }

    public boolean modificarCliente(String aliasName, String nombre, String apellido,
            String email, String celular, String contrasena, String nacimiento) {
        PreparedStatement ps;
        String sql = "UPDATE Cliente SET nombre = ?, apellido = ? , email = ?, celular = ?, contrasena = ?, nacimiento = ? where aliasName = ?";
        try {
            this.conexionDB.EstableciendoConexion();
            ps = this.conexionDB.getConexion().prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, email);
            ps.setString(4, celular);
            ps.setString(5, contrasena);
            ps.setString(6, nacimiento);
            ps.setString(7, aliasName);

            int contador = ps.executeUpdate();
            if (contador > 0) {
                this.conexionDB.cerrandoConexion();
                return true;
            } else {
                this.conexionDB.cerrandoConexion();
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error en la modificacion...\nError: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Cliente> mostrarListado(String variable, String valor) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs = null;
        String sql = null;
        switch (variable) {
            case "AliasName":
                sql = "SELECT * FROM Cliente where AliasName = ?";
                break;
            case "Nombre":
                sql = "SELECT * FROM Cliente where nombre = ?";
                break;
            case "Apellido":
                sql = "SELECT * FROM Cliente where apellido = ?";
                break;
            case "Email":
                sql = "SELECT * FROM Cliente where email = ?";
                break;
            case "Celular":
                sql = "SELECT * FROM Cliente where celular = ?";
                break;
            case "Contrasena":
                sql = "SELECT * FROM Cliente where contrasena = ?";
                break;
            case "Nacimiento":
                sql = "SELECT * FROM Cliente where nacimiento = ?";
                break;
        }

        String listado = "";
        try {
            this.conexionDB.EstableciendoConexion();
            ps = this.conexionDB.getConexion().prepareStatement(sql);
            ps.setString(1, valor);
            rs = ps.executeQuery();
            System.out.println(ps.toString());
            while (rs.next()) {
                String aliasName = rs.getString(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String email = rs.getString(4);
                String celular = rs.getString(5);
                String contrasena = rs.getString(6);
                String nacimiento = rs.getString(7);
                Cliente aux = new Cliente(aliasName, nombre, apellido, email, celular, contrasena, nacimiento);
                clientes.add(aux);
            }

            for (Cliente cliente : clientes) {
//                System.out.println("cliente = " + cliente.toString());
                listado = listado.concat(cliente.toString() + "\n");
            }
            this.conexionDB.cerrandoConexion();
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Error al mostrar los clientes...\nError: " + e.getMessage());
            clientes = null;
            listado = "";
        }
        return clientes;
    }

    public ArrayList<Cliente> mostrarListado() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs = null;
        String sql = "SELECT * FROM Cliente";
        String listado = "";
        try {
            this.conexionDB.EstableciendoConexion();
            ps = this.conexionDB.getConexion().prepareStatement(sql);
            rs = ps.executeQuery();
//            System.out.println(ps.toString());
            while (rs.next()) {
                String aliasName = rs.getString(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String email = rs.getString(4);
                String celular = rs.getString(5);
                String contrasena = rs.getString(6);
                String nacimiento = rs.getString(7);
                Cliente aux = new Cliente(aliasName, nombre, apellido, email, celular, contrasena, nacimiento);
                clientes.add(aux);
            }

            for (Cliente cliente : clientes) {
//                System.out.println("cliente = " + cliente.toString());
                listado = listado.concat(cliente.toString() + "\n");
            }
            this.conexionDB.cerrandoConexion();
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Error al mostrar los clientes...\nError: " + e.getMessage());
            clientes = null;
            listado = "";
        }
        return clientes;
    }

}
