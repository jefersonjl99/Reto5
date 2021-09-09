/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author jefer
 */
public class Panel extends JPanel {

    protected static final Color COLOR = new Color(51, 51, 55);
    protected static final Color COLOR1 = new Color(1, 153, 194);
    protected static final Font FUENTE = new Font("TimesRoman", Font.BOLD, 8);
    protected static final Border BORDE = BorderFactory.createSoftBevelBorder(1, Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.BLUE);

    public Panel(int Xi, int Yi, int Xf, int Yf) {
        definirPropiedades(Xi, Yi, Xf, Yf);
    }

    protected final void definirPropiedades(int Xi, int Yi, int Xf, int Yf) {
        this.setBackground(COLOR);
        this.setForeground(COLOR1);
        this.setBounds(Xi, Yi, Xf, Yf);
        this.setBorder(BORDE);
        this.setLayout(null);
        this.setVisible(false);
        this.requestFocus();
    }

    protected void anadirCaracteristicasCampos(JTextField campo) {
        campo.setBackground(COLOR1);
        campo.setForeground(Color.BLACK);
        campo.setBorder(BORDE);
        campo.requestFocus();
        campo.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                Object o = e.getSource();
                if (o instanceof JTextField) {
                    JTextField field_in_num_monedas = (JTextField) o;
                    field_in_num_monedas.setSelectionStart(0);
                    field_in_num_monedas.setSelectionEnd(field_in_num_monedas.getText().length());
                    field_in_num_monedas.setBackground(Color.BLACK);
                    field_in_num_monedas.setForeground(COLOR1);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                Object o = e.getSource();
                if (o instanceof JTextField) {
                    JTextField field_in_num_monedas = (JTextField) o;
                    field_in_num_monedas.setBackground(COLOR1);
                    field_in_num_monedas.setForeground(Color.BLACK);
                }
            }
        });
    }

    protected void anadirCaracteristicasBotones(JButton componente) {
        componente.setCursor(new Cursor(Cursor.HAND_CURSOR));
        componente.setForeground(COLOR1);
        componente.setBackground(COLOR);
        componente.setBorder(BORDE);
        componente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                Object o = arg0.getSource();
                if (o instanceof JButton) {
                    JButton boton = (JButton) o;

                    boton.setBackground((COLOR1));
                    boton.setForeground((COLOR));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Object o = e.getSource();
                if (o instanceof JButton) {
                    JButton boton = (JButton) o;
                    boton.setBackground((COLOR));
                    boton.setForeground((COLOR1));
                }
            }
        });
        componente.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                Object o = e.getSource();
                if (o instanceof JButton) {
                    JButton boton = (JButton) o;

                    boton.setBackground((COLOR1));
                    boton.setForeground((COLOR));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                Object o = e.getSource();
                if (o instanceof JButton) {
                    JButton boton = (JButton) o;

                    boton.setBackground((COLOR));
                    boton.setForeground((COLOR1));
                }
            }
        });
    }
}
