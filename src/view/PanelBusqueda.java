/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import static view.Panel.COLOR1;

/**
 *
 * @author jefer
 */
public class PanelBusqueda extends Panel {

    private JButton[] botonesIngreso;
    private JTextField campoBuscar;
    private JButton botonRegresar;
    private JButton botonTodos;
    private JLabel informacionIngreso;
    private JLabel informacionSalida;

    public PanelBusqueda(int Xi, int Yi, int Xf, int Yf) {
        super(Xi, Yi, Xf, Yf);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        botonesIngreso = new JButton[7];

        for (int i = 0; i < botonesIngreso.length; i++) {
            switch (i) {
                case 0:
                    botonesIngreso[i] = new JButton("AliasName");
                    break;
                case 1:
                    botonesIngreso[i] = new JButton("Nombre");
                    break;
                case 2:
                    botonesIngreso[i] = new JButton("Apellido");
                    break;
                case 3:
                    botonesIngreso[i] = new JButton("Email");
                    break;
                case 4:
                    botonesIngreso[i] = new JButton("Celular");
                    break;
                case 5:
                    botonesIngreso[i] = new JButton("Contraseña");
                    break;
                case 6:
                    botonesIngreso[i] = new JButton("Nacimiento");
                    break;
            }

            botonesIngreso[i].addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char caracter = e.getKeyChar();

                    // Verificar si la tecla pulsada no es un digito
                    if (((caracter < '0')
                            || (caracter > '9'))
                            && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
                        e.consume();  // ignorar el evento de teclado
                    }
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    if (KeyEvent.VK_ENTER == e.getKeyCode()) {
                        botonesIngreso[0].doClick();
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                }
            });
            botonesIngreso[i].setBounds(50, -20 + ((this.getHeight() / (botonesIngreso.length + 2)) + 5) * (i + 1), 100, 20);
            anadirCaracteristicasBotones(botonesIngreso[i]);
            this.add(botonesIngreso[i]);
        }

        campoBuscar = new JTextField("Buscar");
        anadirCaracteristicasCampos(campoBuscar);
        campoBuscar.setBounds(200, this.getHeight() / 2 - 10, 100, 20);
        this.add(campoBuscar);

        botonRegresar = new JButton("Regresar");
        anadirCaracteristicasBotones(botonRegresar);
        botonRegresar.setBounds(200, this.getHeight() / 2 - 10 + 30, 100, 20);
        this.add(botonRegresar);

        botonTodos = new JButton("Consultar Todos");
        anadirCaracteristicasBotones(botonTodos);
        botonTodos.setBounds(200, this.getHeight() / 2 - 10 + 60, 100, 20);
        this.add(botonTodos);

        informacionIngreso = new JLabel("<html>Ingrese el dato del cliente a buscar,<p> luego pulse segun corresponda al dato para buscar:<html>");
        informacionIngreso.setForeground(COLOR1);
        informacionIngreso.setBounds(200, 10, 150, 100);
        this.add(informacionIngreso);

        informacionSalida = new JLabel("<html>EN ESPERA...<html>");
        informacionSalida.setForeground(COLOR1);
        informacionSalida.setBounds(200, this.getHeight() / 2 - 10 + 60, 150, 60);
        this.add(informacionSalida);
    }

    public JButton[] getBotonesIngreso() {
        return botonesIngreso;
    }

    public void setBotonesIngreso(JButton[] botonesIngreso) {
        this.botonesIngreso = botonesIngreso;
    }

    public JTextField getCampoBuscar() {
        return campoBuscar;
    }

    public void setCampoBuscar(JTextField campoBuscar) {
        this.campoBuscar = campoBuscar;
    }

    public JButton getBotonRegresar() {
        return botonRegresar;
    }

    public void setBotonRegresar(JButton botonRegresar) {
        this.botonRegresar = botonRegresar;
    }

    public JButton getBotonTodos() {
        return botonTodos;
    }

    public void setBotonTodos(JButton botonTodos) {
        this.botonTodos = botonTodos;
    }

    public JLabel getInformacionSalida() {
        return informacionSalida;
    }

    public void setInformacionSalida(JLabel informacionSalida) {
        this.informacionSalida = informacionSalida;
    }
    
    

}
