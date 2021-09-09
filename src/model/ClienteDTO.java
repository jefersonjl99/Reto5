/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.conexion.*;

/**
 *
 * @author jefer
 */
public class ClienteDTO {

    private ClienteDAO clienteDao;
    private ConexionDB conexionDB;

    public ClienteDTO() {
        this.conexionDB = new ConexionDB();
        this.clienteDao = new ClienteDAO(conexionDB);
    }

    public ClienteDAO getClienteDao() {
        return clienteDao;
    }

    public void setClienteDao(ClienteDAO estudiante_dao) {
        this.clienteDao = estudiante_dao;
    }

    public ConexionDB getConexionDB() {
        return conexionDB;
    }
    
}
