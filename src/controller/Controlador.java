/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.*;
import javax.swing.*;
import model.ClienteDTO;
import view.*;

/**
 *
 * @author jefer
 */
public class Controlador implements ActionListener, KeyListener {

    VentanaPrincipal ventanaPrincipal;
    PanelMenuPrincipal panelMenuPrincipal;
    PanelInsercion panelInsercion;
    PanelEliminacion panelEliminacion;
    PanelModificacion panelModificacion;
    PanelBusqueda panelBusqueda;
    PanelConsulta panelConsulta;
    JPanel panelActual;

    private ClienteDTO dto;

    public Controlador() {
        inicializarComponentes();
        asignarOyentes();
    }

    private void inicializarComponentes() {

        ventanaPrincipal = new VentanaPrincipal();
        dto = new ClienteDTO();

        panelMenuPrincipal = new PanelMenuPrincipal(20, 20, VentanaPrincipal.getANCHO() - 47, VentanaPrincipal.getALTO() - 47);
        panelInsercion = new PanelInsercion(20, 20, VentanaPrincipal.getANCHO() - 47, VentanaPrincipal.getALTO() - 47);
        panelEliminacion = new PanelEliminacion(20, 20, VentanaPrincipal.getANCHO() - 47, VentanaPrincipal.getALTO() - 47);
        panelModificacion = new PanelModificacion(20, 20, VentanaPrincipal.getANCHO() - 47, VentanaPrincipal.getALTO() - 47);
        panelBusqueda = new PanelBusqueda(20, 20, VentanaPrincipal.getANCHO() - 47, VentanaPrincipal.getALTO() - 47);
        panelConsulta = new PanelConsulta(20, 20, VentanaPrincipal.getANCHO() - 47, VentanaPrincipal.getALTO() - 47);
        ventanaPrincipal.addPaneles(panelMenuPrincipal,
                panelInsercion, panelEliminacion,
                panelModificacion, panelBusqueda, panelConsulta);

        panelMenuPrincipal.setVisible(true);
        ventanaPrincipal.setVisible(true);
        panelActual = panelMenuPrincipal;
    }

    private void asignarOyentes() {

        ventanaPrincipal.addKeyListener(this);
        panelMenuPrincipal.addKeyListener(this);

        panelInsercion.addKeyListener(this);
        asignarOyentesBotones(panelInsercion.getBotonIngresar());
        asignarOyentesBotones(panelInsercion.getBotonRegresar());

        panelEliminacion.addKeyListener(this);
        asignarOyentesBotones(panelEliminacion.getBotonEliminar());
        asignarOyentesBotones(panelEliminacion.getBotonRegresar());

        panelModificacion.addKeyListener(this);
        asignarOyentesBotones(panelModificacion.getBotonModificar());
        asignarOyentesBotones(panelModificacion.getBotonRegresar());

        panelBusqueda.addKeyListener(this);
        asignarOyentesCampos(panelBusqueda.getCampoBuscar());
        asignarOyentesBotones(panelBusqueda.getBotonRegresar());
        asignarOyentesBotones(panelBusqueda.getBotonTodos());

        panelConsulta.addKeyListener(this);
        asignarOyentesBotones(panelConsulta.getBotonRegresar());

        for (JButton componente : panelMenuPrincipal.getBotones()) {
            asignarOyentesBotones(componente);
        }

        for (JTextField componente : panelInsercion.getCamposIngreso()) {
            asignarOyentesCampos(componente);
        }

        for (JTextField componente : panelEliminacion.getCamposIngreso()) {
            asignarOyentesCampos(componente);
        }

        for (JTextField componente : panelModificacion.getCamposIngreso()) {
            asignarOyentesCampos(componente);
        }

        for (JButton componente : panelBusqueda.getBotonesIngreso()) {
            asignarOyentesBotones(componente);
        }

    }

    private void asignarOyentesBotones(JButton boton) {
        boton.addKeyListener(this);
        boton.addActionListener(this);
    }

    private void asignarOyentesCampos(JTextField campo) {
        campo.addKeyListener(this);
        campo.addActionListener(this);
    }

    private void cambiarPaneles(JPanel panelOut, JPanel panelIn) {
        panelActual = panelIn;
        panelOut.setVisible(false);
        panelIn.setVisible(true);
        panelIn.requestFocus();
        panelIn.getComponent(0).requestFocus();
//        (panelInsercion.getCamposIngreso()[0]).requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == (panelMenuPrincipal.getBotones()[0])) {
            cambiarPaneles(panelActual, panelInsercion);
        }

        if (e.getSource() == (panelMenuPrincipal.getBotones()[1])) {
            cambiarPaneles(panelActual, panelEliminacion);
        }

        if (e.getSource() == (panelMenuPrincipal.getBotones()[2])) {
            cambiarPaneles(panelActual, panelModificacion);
        }

        if (e.getSource() == (panelMenuPrincipal.getBotones()[3])) {
            cambiarPaneles(panelActual, panelBusqueda);
//            JOptionPane.showMessageDialog(null, dto.getClienteDao().mostrarListado());
        }

        if (e.getSource() == (panelInsercion.getBotonIngresar())) {
            if (dto.getClienteDao().agregarCliente(panelInsercion.getCamposIngreso()[0].getText(),
                    panelInsercion.getCamposIngreso()[1].getText(),
                    panelInsercion.getCamposIngreso()[2].getText(),
                    panelInsercion.getCamposIngreso()[3].getText(),
                    panelInsercion.getCamposIngreso()[4].getText(),
                    panelInsercion.getCamposIngreso()[5].getText(),
                    panelInsercion.getCamposIngreso()[6].getText())) { 
                panelInsercion.getInformacionSalida().setText("Se agregó el Cliente");
            } else {
                panelInsercion.getInformacionSalida().setText("No se agregó el Cliente"); 
            }
        }

        if (e.getSource() == (panelEliminacion.getBotonEliminar())) {
            if (dto.getClienteDao().eliminarCliente(panelEliminacion.getCamposIngreso()[0].getText())) {
                panelEliminacion.getInformacionSalida().setText("Se elimino el Cliente");
            } else {
                panelEliminacion.getInformacionSalida().setText("No se elimino el Cliente");
            }
        }

        if (e.getSource() == panelInsercion.getBotonRegresar()
                || e.getSource() == panelEliminacion.getBotonRegresar()
                || e.getSource() == panelModificacion.getBotonRegresar()
                || e.getSource() == panelBusqueda.getBotonRegresar()
                || e.getSource() == panelConsulta.getBotonRegresar()) {

            cambiarPaneles(panelActual, panelMenuPrincipal);
        }

        if (e.getSource() == panelConsulta.getBotonRegresar()) {
            cambiarPaneles(panelActual, panelBusqueda);
        }

        if (e.getSource() == (panelModificacion.getBotonModificar())) {
            if (dto.getClienteDao().modificarCliente(panelModificacion.getCamposIngreso()[0].getText(),
                    panelModificacion.getCamposIngreso()[1].getText(),
                    panelModificacion.getCamposIngreso()[2].getText(),
                    panelModificacion.getCamposIngreso()[3].getText(),
                    panelModificacion.getCamposIngreso()[4].getText(),
                    panelModificacion.getCamposIngreso()[5].getText(),
                    panelModificacion.getCamposIngreso()[6].getText())) {

                panelModificacion.getInformacionSalida().setText("Se actualizo el Cliente");
            } else {
                panelModificacion.getInformacionSalida().setText("No se actualizo el Cliente");
            }

        }

        if (e.getSource() == (panelBusqueda.getBotonesIngreso()[0])
                || e.getSource() == (panelBusqueda.getBotonesIngreso()[1])
                || e.getSource() == (panelBusqueda.getBotonesIngreso()[2])
                || e.getSource() == (panelBusqueda.getBotonesIngreso()[3])
                || e.getSource() == (panelBusqueda.getBotonesIngreso()[4])
                || e.getSource() == (panelBusqueda.getBotonesIngreso()[5])) {
            cambiarPaneles(panelActual, panelConsulta);
            panelConsulta.agregarDatos(dto.getClienteDao().mostrarListado(e.getActionCommand(),
                    panelBusqueda.getCampoBuscar().getText()));

        }

        if (e.getSource() == (panelBusqueda.getBotonTodos())) {
            cambiarPaneles(panelActual, panelConsulta);
            panelConsulta.agregarDatos(dto.getClienteDao().mostrarListado());

        }

        System.out.println(e.getActionCommand());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (KeyEvent.VK_ESCAPE == e.getKeyCode()) {
            System.exit(0);
        }

        Object o = e.getSource();
        if (o instanceof JButton) {
            JButton boton = (JButton) o;
            boton.doClick();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //no pasa nada
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //no pasa nada
    }

}
