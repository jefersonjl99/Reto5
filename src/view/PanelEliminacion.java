/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.*;
import javax.swing.*;
import static view.Panel.COLOR1;

/**
 *
 * @author jefer
 */
public class PanelEliminacion extends Panel {

    private JTextField[] camposIngreso;
    private JButton botonEliminar;
    private JButton botonRegresar;
    private JLabel informacionIngreso;
    private JLabel informacionSalida;

    public PanelEliminacion(int Xi, int Yi, int Xf, int Yf) {
        super(Xi, Yi, Xf, Yf);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        camposIngreso = new JTextField[1];

        for (int i = 0; i < camposIngreso.length; i++) {
            switch (i) {
                case 0:
                    camposIngreso[i] = new JTextField("Alias");
                    break;
            }

            camposIngreso[i].addKeyListener(new KeyListener() {
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
                        getBotonEliminar().doClick();
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                }
            });
            camposIngreso[i].setBounds(50, -35 + ((this.getHeight() / (camposIngreso.length + 2)) + 15) * (i + 1), 100, 20);
            anadirCaracteristicasCampos(camposIngreso[i]);
            this.add(camposIngreso[i]);
        }

        botonEliminar = new JButton("Eliminar");
        anadirCaracteristicasBotones(botonEliminar);
        botonEliminar.setBounds(200, this.getHeight() / 2 - 10, 100, 20);
        this.add(botonEliminar);

        botonRegresar = new JButton("Regresar");
        anadirCaracteristicasBotones(botonRegresar);
        botonRegresar.setBounds(200, this.getHeight() / 2 - 10 + 30, 100, 20);
        this.add(botonRegresar);

        informacionIngreso = new JLabel("<html>Ingrese el alias del cliente a eliminar,<p> luego pulse en eliminar:<html>");
        informacionIngreso.setForeground(COLOR1);
        informacionIngreso.setBounds(200, 50, 150, 60);
        this.add(informacionIngreso);

        informacionSalida = new JLabel("<html>EN ESPERA...<html>");
        informacionSalida.setForeground(COLOR1);
        informacionSalida.setBounds(200, this.getHeight() / 2 - 10 + 60, 150, 60);
        this.add(informacionSalida);
    }

    public JTextField[] getCamposIngreso() {
        return camposIngreso;
    }

    public void setCamposIngreso(JTextField[] camposIngreso) {
        this.camposIngreso = camposIngreso;
    }

    public JButton getBotonEliminar() {
        return botonEliminar;
    }

    public void setBotonEliminar(JButton botonEliminar) {
        this.botonEliminar = botonEliminar;
    }

    public JButton getBotonRegresar() {
        return botonRegresar;
    }

    public void setBotonRegresar(JButton botonRegresar) {
        this.botonRegresar = botonRegresar;
    }

    public JLabel getInformacionSalida() {
        return informacionSalida;
    }

    public void setInformacionSalida(JLabel informacionSalida) {
        this.informacionSalida = informacionSalida;
    }
}
