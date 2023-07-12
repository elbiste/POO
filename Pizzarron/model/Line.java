package Pizzarron.model;

import java.awt.*;

public class Line extends Figura{
    private static final Color TEXT_COLOR  = Color.BLACK;
    private static final int DEFAULT_SIDE = 100;
    private int side;

    protected Line(int x, int y) {
        super(x, y);
        this.fillColor = TEXT_COLOR;
        this.side= DEFAULT_SIDE;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(this.x, this.y, this.side, this.side);

    }
    public int getSide(){
        return side;
    }
    public void setSide(int side){
        this.side = side;
    }
    public static Line getDefault( int x, int y){
        return new Line(x, y);
    }
}
