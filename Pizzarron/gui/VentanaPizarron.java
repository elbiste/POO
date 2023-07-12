package Pizzarron.gui;

import Pizzarron.exception.DrawingException;
import Pizzarron.model.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class VentanaPizarron extends JFrame {
    private static final int TOOL_UNSELLECT= -1;
    private static final int TOOL_CIRCLE=1;
    private static final int TOOL_TRIANGLE=2;
    private static final int TOOL_SQUARE=3;
    private static final int TOOL_RECTANGLE=4;
    private static final int TOOL_POLYGON=5;
    private static final int TOOL_TEXT=6;
    private static final int TOOL_IMAGE=7;
    private static final int TOOL_PENCIL=8;
    private static final int TOOL_LINE=9;
    private static final int TOOL_SELECT=10;

    private static final int DRAWING_ACTIVE = 1;
    private static final int DRAWING_INACTIVE = 2;
    private JPanel toolPanel;
    private JPanel dasboardPanel;
    private JPanel logPanel;

    private JButton btnCircle;
    private JButton btnTriangle;
    private JButton btnSquare;
    private JButton btnRentangle;
    private JButton btnPolygon;
    private JButton btnText;
    private JButton btnImage;
    private JButton btnPencil;
    private JButton btnLine;
    private JButton btnSelect;

    private int  selectedTool;
    private int drawingState;

    private Figura pencilTemp;
    public VentanaPizarron(){

        intitComponents();
        selectedTool = TOOL_UNSELLECT;
        drawingState = DRAWING_INACTIVE;
    }
   private void intitComponents(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        instatiateComponents();
        buildLayout();
        initializeListener();

        setVisible(true);
   }

   private void initializeListener(){
       btnCircle.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               selectedTool = TOOL_CIRCLE;
           }
       });
       btnTriangle.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               selectedTool=TOOL_TRIANGLE;
           }
       });
       btnSquare.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               selectedTool=TOOL_SQUARE;
           }
       });
       btnRentangle.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               selectedTool=TOOL_RECTANGLE;
           }
       });
       btnPolygon.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               selectedTool=TOOL_POLYGON;
           }
       });
       btnText.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               selectedTool=TOOL_TEXT;
           }
       });
       btnImage.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               selectedTool=TOOL_IMAGE;
           }
       });
       btnPencil.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               selectedTool=TOOL_PENCIL;
           }
       });
       btnLine.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               selectedTool=TOOL_LINE;
           }
       });
       btnSelect.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               selectedTool=TOOL_SELECT;
           }
       });
       dasboardPanel.addMouseListener(new MouseListener() {
           @Override
           public void mouseClicked(MouseEvent e) {
               if(drawingState == DRAWING_ACTIVE){
                   Figura figura = getFigure(e.getX(), e.getY());
               }
           }

           @Override
           public void mousePressed(MouseEvent e) {
               if(drawingState == DRAWING_ACTIVE && selectedTool == TOOL_PENCIL){
                   pencilTemp = getFigure(e.getX(), e.getY());
               }
           }

           @Override
           public void mouseReleased(MouseEvent e) {
               if(drawingState == DRAWING_ACTIVE && selectedTool == TOOL_PENCIL){
                   pencilTemp = null;
               }
           }

           @Override
           public void mouseEntered(MouseEvent e) {
                //System.out.println("Entró dashboard");
               drawingState = DRAWING_ACTIVE;
           }

           @Override
           public void mouseExited(MouseEvent e) {
                //System.out.println("Salió de dashboard");
               drawingState = DRAWING_INACTIVE;
           }
       });
       dasboardPanel.addMouseMotionListener(new MouseMotionListener() {
           @Override
           public void mouseDragged(MouseEvent e) {
               if (drawingState == DRAWING_ACTIVE && selectedTool == TOOL_PENCIL){
                   Pencil pencil = (Pencil) pencilTemp;
                   pencil.addPoint(e.getX(), e.getY());
                   pencil.paint(dasboardPanel.getGraphics());
               }
           }

           @Override
           public void mouseMoved(MouseEvent e) {

           }
       });
   }

   public Figura getFigure(int x, int y){
        Figura figura = null;
        String mensaje;
       try{
           figura = getFigureDraw(x, y);
           figura.paint(dasboardPanel.getGraphics());
           mensaje= "Se dibujo una figura";
       } catch (DrawingException e1){
           mensaje="Exception";
       } finally {

       }
       return figura;
   }
   private Figura getFigureDraw(int x, int y) throws DrawingException{
        Figura figura = null;
        if(selectedTool == TOOL_UNSELLECT){
            throw new DrawingException();
        } else if (selectedTool == TOOL_CIRCLE){
            figura = Circle.getDefault(x, y);
        } else if (selectedTool == TOOL_IMAGE){
            throw new DrawingException();
        } else if (selectedTool == TOOL_LINE){
            figura = Line.getDefault(x,y);
        } else if (selectedTool == TOOL_PENCIL){
            figura = Pencil.getDefault(x, y);
        } else if (selectedTool == TOOL_POLYGON){
            figura = Poligono.getDefault(x, y);
        } else if (selectedTool == TOOL_RECTANGLE){
            figura = Rectangulo.getDefault(x,y);
        } else if (selectedTool == TOOL_SELECT){
            throw new DrawingException();
        } else if (selectedTool == TOOL_SQUARE){
            figura = Cuadrado.getDefault(x, y);
        } else if (selectedTool == TOOL_TEXT){
            figura = Text.getDefault(x, y);
        } else if (selectedTool == TOOL_TRIANGLE){
            figura = Triangulo.getDefault(x, y);
        }
        return figura;
   }

   private void buildLayout(){
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        toolPanel.setLayout(new GridLayout(5,2));
        toolPanel.add(btnCircle);
       toolPanel.add(btnTriangle);
       toolPanel.add(btnSquare);
       toolPanel.add(btnRentangle);
       toolPanel.add(btnPolygon);
       toolPanel.add(btnText);
       toolPanel.add(btnText);
       toolPanel.add(btnImage);
       toolPanel.add(btnPencil);
       toolPanel.add(btnLine);
       toolPanel.add(btnSelect);
        pane.add(toolPanel,BorderLayout.WEST);
        pane.add(dasboardPanel,BorderLayout.CENTER);
        pane.add(logPanel, BorderLayout.SOUTH);
   }

   private void instatiateComponents(){
       toolPanel = new JPanel();
       dasboardPanel = new JPanel();
       dasboardPanel.setBackground(Color.WHITE);
       logPanel = new JPanel();
       try{
       File file = new File("/Users/sysadmin/Downloads/iconos/circle.png");
       Image image = ImageIO.read(file);
       image = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
       btnCircle = new JButton(new ImageIcon(image));
       btnTriangle = new JButton("TR");
       btnSquare = new JButton("CU");
       btnRentangle = new JButton("RE");
       btnPolygon = new JButton("PO");
       btnText = new JButton("TE");
       btnImage = new JButton("IM");
       btnPencil = new JButton("LA");
       btnLine = new JButton("LI");
       btnSelect= new JButton("SE");
        } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }
}
