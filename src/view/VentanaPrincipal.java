/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.io.IOException;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author jefer
 */
public class VentanaPrincipal extends JFrame {

    private static final ImagenFondo IMAGEN_FONDO = new ImagenFondo();
    private static int ANCHO = 400, ALTO = 300;
    private static final Border BORDE = BorderFactory.createSoftBevelBorder(1, Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.BLUE);

    public VentanaPrincipal() {
        definirPropiedades();
        inicializarComponentes();
    }

    private void definirPropiedades() {
        this.setTitle("Matrices Dispersas");
        this.setIconImage(new ImageIcon(VentanaPrincipal.class.getResource("/recursos/icono.png")).getImage());
        this.setUndecorated(true);
        this.setLayout(null);
        this.setSize(ANCHO, ALTO);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setContentPane(IMAGEN_FONDO);
        this.requestFocus();
        this.getRootPane().setBorder(BORDE);
        this.getContentPane().setLayout(null);
//        this.setVisible(true);
    }

    private void inicializarComponentes() {
    }

    public void addPaneles(JPanel... paneles) {
        for (JPanel panel : paneles) {
            this.add(panel);
        }
    }
    
    public static int getANCHO() {
        return ANCHO;
    }

    public static void setANCHO(int aANCHO) {
        ANCHO = aANCHO;
    }

    public static int getALTO() {
        return ALTO;
    }

    public static void setALTO(int aALTO) {
        ALTO = aALTO;
    }
}

////////////////////////////////////////////////////////
////////////Cambia el fondo//////////////////
//////////////////////////////////////////////////////
class ImagenFondo extends JPanel {

    private Image imagen;

    @Override
    public void paint(Graphics g) {
        try {
            imagen = ImageIO.read(ImagenFondo.class.getResource("/recursos/fondo.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(ImagenFondo.class.getName()).log(Level.SEVERE, null, ex);
        }
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
        setOpaque(false);
        super.paint(g);
    }

}
///////////////////////////////////////////////////////////////////////
////////////////////////////////////////
