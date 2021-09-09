/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author jefer
 */
public class PanelInsercion extends Panel {

    private JTextField[] camposIngreso;
    private JButton botonIngresar;
    private JButton botonRegresar;
    private JLabel informacionIngreso;
    private JLabel informacionSalida;

    public PanelInsercion(int Xi, int Yi, int Xf, int Yf) {
        super(Xi, Yi, Xf, Yf);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        camposIngreso = new JTextField[7];

        for (int i = 0; i < camposIngreso.length; i++) {
            switch (i) {
                case 0:
                    camposIngreso[i] = new JTextField("Alias");
                    break;
                case 1:
                    camposIngreso[i] = new JTextField("Nombre");
                    break;
                case 2:
                    camposIngreso[i] = new JTextField("Apellido");
                    break;
                case 3:
                    camposIngreso[i] = new JTextField("Email");
                    break;
                case 4:
                    camposIngreso[i] = new JTextField("Celular");
                    break;
                case 5:
                    camposIngreso[i] = new JTextField("Contraseña");
                    break;
                case 6:
                    camposIngreso[i] = new JTextField("FechaNacimiento");
                    break;
            }

            camposIngreso[i].addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    if (KeyEvent.VK_ENTER == e.getKeyCode()) {
                        getBotonIngresar().doClick();
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                }
            });
            camposIngreso[i].setBounds(50, -20 + ((this.getHeight() / (camposIngreso.length + 2)) + 5) * (i + 1), 100, 20);
            anadirCaracteristicasCampos(camposIngreso[i]);
            this.add(camposIngreso[i]);
        }

        botonIngresar = new JButton("Ingresar");
        anadirCaracteristicasBotones(botonIngresar);
        botonIngresar.setBounds(200, this.getHeight() / 2 - 10, 100, 20);
        this.add(botonIngresar);

        botonRegresar = new JButton("Regresar");
        anadirCaracteristicasBotones(botonRegresar);
        botonRegresar.setBounds(200, this.getHeight() / 2 - 10 + 30, 100, 20);
        this.add(botonRegresar);

        informacionIngreso = new JLabel("<html>Ingrese los datos segun corresponda,<p> luego pulse en insertar:<html>");
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

    public JButton getBotonIngresar() {
        return botonIngresar;
    }

    public void setBotonIngresar(JButton botonIngresar) {
        this.botonIngresar = botonIngresar;
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
