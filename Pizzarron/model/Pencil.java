package Pizzarron.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Pencil extends  Figura{
    private  static final int DEFAULT_WIDTH= 1;
    private static final int DEFAULT_HEIGHT= 1;
    private static final Color DEFAULT_BORDER_COLOR= Color.BLACK;
    private static final Color DEFAULT_FILL_COLOR= Color.BLACK;
    private List<Point> points;
    protected Pencil(int x, int y) {
        super(x, y);
        borderColor = DEFAULT_BORDER_COLOR;
        fillColor = DEFAULT_FILL_COLOR;
        stroke = DEFAULT_WIDTH;
        points = new ArrayList<Point>();
        points.add(new Point(x, y));
    }

    @Override
    public void paint(Graphics g) {
        if(points.size()>2){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(borderColor);
        Point a = points.get(0);
        for(int i=1; i<= points.size()-1; i++){
            Point b = points.get(i);
            g2d.drawLine((int)a.getX(), (int)a.getY(), (int)b.getX(), (int) b.getY());
            a = b;
            }
        }
    }
    public  static  Pencil getDefault(int x, int y){
        return new Pencil(x, y);
    }
    public void addPoint(int x, int y){
        points.add(new Point(x, y));
    }
    public List<Point> getPoints(){
        return points;
    }
    public void setPoints(List<Point> points){
        this.points = points;
    }
}
