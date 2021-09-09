/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;

/**
 *
 * @author jefer
 */
public class PanelMenuPrincipal extends Panel {

    private JButton[] botones;

    public PanelMenuPrincipal(int Xi, int Yi, int Xf, int Yf) {
        super(Xi, Yi, Xf, Yf);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        botones = new JButton[4];

        for (int i = 0; i < botones.length; i++) {
            switch (i) {
                case 0:
                    botones[i] = new JButton("Insertar");
                    break;
                case 1:
                    botones[i] = new JButton("Eliminar");
                    break;
                case 2:
                    botones[i] = new JButton("Modificar");
                    break;
                case 3:
                    botones[i] = new JButton("Consultar");
                    break;
            }
            botones[i].setBounds(this.getWidth() / 2 - 100 / 2, (this.getHeight() / (botones.length + 2)) * (i + 1), 100, 20);
            anadirCaracteristicasBotones(botones[i]);
            this.add(botones[i]);
        }
    }

    public JButton[] getBotones() {
        return botones;
    }

    public void setBotones(JButton[] botones) {
        this.botones = botones;
    }

}
