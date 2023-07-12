package Pizzarron.model;

import java.awt.*;

public class Poligono  extends Figura{
    private static final int DEFAULT_HEIGHT= 100;
    private static final Color DEFAULT_BORDER_COLOR= Color.BLACK;
    private static final Color DEFAULT_FILL_COLOR= Color.GREEN;
    private int height;

    protected Poligono(int x, int y) {
        super(x, y);
        height = DEFAULT_HEIGHT;
        borderColor = DEFAULT_BORDER_COLOR;
        fillColor = DEFAULT_FILL_COLOR;

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(borderColor);
        int[] xPoints = {150, 250,350};
        int[] yPoints = {300, 150, 350};
        g2d.drawPolygon(xPoints,yPoints, height);
        g2d.setColor(this.fillColor);
        g2d.fillPolygon(xPoints, yPoints, height);

    }
    public static Poligono getDefault(int x, int y){
        return new Poligono(x, y);
    }


    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        this.height = height;
    }
}

