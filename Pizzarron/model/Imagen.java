package Pizzarron.model;

import javax.swing.*;
import java.awt.*;

public class Imagen extends Figura{
    private static final Color TEXT_COLOR   = Color.BLACK;
    private static String DEFAULT_TEXT = "spiderman";
    private static Image IMAGE;
    private String imagen;
    protected Imagen(int x, int y) {
        super(x, y);
        fillColor = TEXT_COLOR;
        imagen = new ImageIcon("circle.png").getImage().toString();


    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(borderColor);

    }
}
