package Pizzarron.model;

import java.awt.*;

public class Rectangulo extends Figura{
    private  static final int DEFAULT_WIDTH= 250;
    private static final int DEFAULT_HEIGHT= 100;
    private static final Color DEFAULT_BORDER_COLOR= Color.BLACK;
    private static final Color DEFAULT_FILL_COLOR= Color.RED;
    private int width;
    private int height;
    protected Rectangulo(int x, int y){
        super(x, y);
        width = DEFAULT_WIDTH;
        height = DEFAULT_HEIGHT;
        borderColor = DEFAULT_BORDER_COLOR;
        fillColor = DEFAULT_FILL_COLOR;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d. setColor(borderColor);
        g2d.drawRect(this.x, this.y, this.width, this.height);
        g2d.setColor(this.fillColor);
        g2d.fillRect(this.x+1, this.y+1, this.width-1, this.height-1);
    }
    public static Rectangulo getDefault(int x, int y){
        return new Rectangulo(x, y);
    }

    public int getDefaultWidth(){
        return width;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        this.height = height;
    }

}
