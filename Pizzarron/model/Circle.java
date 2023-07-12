package Pizzarron.model;

import java.awt.*;

public class Circle extends Figura {
    private static final int DEFAULT_RADIUS = 40;
    private static final Color DEFAULT_BORDER_COLOR = new Color(0,0,0);
    private static final Color DEFAULT_FILL_COLOR = Color.YELLOW;
    private int radius;

    protected Circle(int x, int y){
        super(x, y);
        this.fillColor = DEFAULT_FILL_COLOR;
        this.borderColor = DEFAULT_BORDER_COLOR;
        this.radius = DEFAULT_RADIUS;
    }

    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.borderColor);
        g2d.drawOval(this.x, this.y, this.radius, this.radius);
        g2d.setColor(this.fillColor);
        g2d.fillOval(this.x, this.y, this.radius, this.radius);
    }

    public static Circle getDefault(int x, int y){
        return new Circle(x, y);
    }
}
