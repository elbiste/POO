package Pizzarron.model;
import java.awt.*;

public class Triangulo extends Figura{

    private  static final int DEFAULT_WIDTH= 120;
    private static final int DEFAULT_HEIGHT= 100;
    private static final Color DEFAULT_BORDER_COLOR= Color.BLACK;
    private static final Color DEFAULT_FILL_COLOR= Color.GREEN;

    private int width;
    private int height;
    protected Triangulo(int x, int y) {
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
        g2d.drawPolygon(new int[]{12,32,4}, new int[]{12,32,45}, this.width);
        g2d.setColor(this.fillColor);
        g2d.fillPolygon(new int[]{23,43,54}, new int[]{23,32,343}, this.width);
    }
    public static Triangulo getDefault(int x, int y){
        return new Triangulo(x, y);
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
