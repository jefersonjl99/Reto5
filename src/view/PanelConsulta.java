/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Cliente;

/**
 *
 * @author jefer
 */
public class PanelConsulta extends Panel {

    private JScrollPane scroll;
    private JTable tabla;
    private JButton botonRegresar;
    DefaultTableModel modelo;

    public PanelConsulta(int Xi, int Yi, int Xf, int Yf) {
        super(Xi, Yi, Xf, Yf);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        botonRegresar = new JButton("Regresar");
        anadirCaracteristicasBotones(botonRegresar);
        botonRegresar.setBounds(this.getWidth() - 105, this.getHeight() - 25, 100, 20);
        this.add(botonRegresar);

        String[] columnas = {"Alias", "Nombre", "Apellido", "Email", "Celular", "Contraseña", "FechaNacimiento"};
        tabla = new JTable();
        modelo = new DefaultTableModel();
        scroll = new JScrollPane(tabla);

        modelo.setColumnIdentifiers(columnas);

        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.setFillsViewportHeight(true);
        tabla.setBackground(COLOR);
        tabla.setForeground(COLOR1);
        tabla.setBorder(BORDE);
        tabla.getTableHeader().setForeground(COLOR);
        tabla.getTableHeader().setBackground(COLOR1);
        tabla.getTableHeader().setBorder(BORDE);
        tabla.getTableHeader().setFont(FUENTE);

        tabla.setModel(modelo);

//        this.agregarDatos(modelo);
        scroll.setBounds(0, 0, this.getWidth(), this.getHeight() - 30);
        this.add(scroll);

    }

    public void agregarDatos(ArrayList<Cliente> clientes) {
        // Borramos todas las filas en la tabla
        modelo.setRowCount(0);

        // Creamos los datos de una fila de la tabla
        Object[] datosFila = new Object[7];

        // agregamos esos datos
//        modelo.addRow(datosFila);
        // Agregamos MUCHOS mas datos
        for (Cliente cliente : clientes) {

            datosFila[0] = cliente.getAliasName();
            datosFila[1] = cliente.getNombre();
            datosFila[2] = cliente.getApellido();
            datosFila[3] = cliente.getEmail();
            datosFila[4] = cliente.getCelular();
            datosFila[5] = cliente.getContrasena();
            datosFila[6] = cliente.getNacimiento();
            modelo.addRow(datosFila);

        }
    }

    public JButton getBotonRegresar() {
        return botonRegresar;
    }

    public void setBotonRegresar(JButton botonRegresar) {
        this.botonRegresar = botonRegresar;
    }

}
