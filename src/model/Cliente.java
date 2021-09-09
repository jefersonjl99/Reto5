/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jefer
 */
public class Cliente {

    private String aliasName;
    private String nombre;
    private String apellido;
    private String email;
    private String celular;
    private String contrasena;
    private String nacimiento;

    public Cliente(String aliasName, String nombre, String apellido) {
        this.aliasName = aliasName;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Cliente(String aliasName, String nombre, String apellido,
            String email, String celular, String contrasena, String nacimiento) {
        this.aliasName = aliasName;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.celular = celular;
        this.contrasena = contrasena;
        this.nacimiento = nacimiento;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nAlias: ").append(aliasName);
        sb.append("\nNombre: ").append(nombre);
        sb.append("\nApellido: ").append(apellido);
        sb.append("\nEmail: ").append(email);
        sb.append("\nCelular: ").append(celular);
        sb.append("\nContraseña: ").append(contrasena);
        sb.append("\nFechaNacimiento: ").append(nacimiento);
        return sb.toString();
    }

}
