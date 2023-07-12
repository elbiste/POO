package Pizzarron.model;

import java.awt.*;

public class Text extends  Figura{
    private static final Color TEXT_COLOR   = Color.BLACK;
    private static String DEFAULT_TEXT = "spiderman";
    private String value;
    protected Text(int x, int y) {
        super(x, y);
        fillColor = TEXT_COLOR;
        value = DEFAULT_TEXT;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(fillColor);
        g2d.setFont(new Font("Ink Free", Font.BOLD,50));
        g2d.drawString(value, this.x, this.y);
    }

    public static Text getDefault(int x, int y){
        return new Text(x, y);
    }
    public String getString(){
        return value;
    }
    public void setSring(String value){
        this.value = value;
    }

    public void setValue(String value){
        this.value = value;
    }
}
