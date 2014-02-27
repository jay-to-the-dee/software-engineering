package antgame.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.GeneralPath;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
 * Hexagon GUI Panel
 *
 * @author Jonathan Dilks
 */
public class HexagonPanel extends JPanel implements MouseWheelListener
{
    private static final int STROKE_WIDTH = 1;
    private final int rows = 150;
    private final int columns = 150;
    //Zoom fields
    private int hexagonSize = 20;
    //Mouse drag fields
    private boolean dragStart = true;
    private int startX;
    private int startY;
    private int X;
    private int Y;

    public HexagonPanel()
    {
        addMouseWheelListener(this);
        //addMouseMotionListener(this);
        //addMouseListener(this);

        setPreferredSize(currentTotalGridSize());
        this.repaint();
    }

    private static GeneralPath hexagonPath(int hexagonSize)
    {
        GeneralPath path = new GeneralPath();
        path.moveTo(0, (Math.sqrt(3) / 6) * hexagonSize);
        path.lineTo(0.5 * hexagonSize, 0);
        path.lineTo(1 * hexagonSize, (Math.sqrt(3) / 6) * hexagonSize);
        path.lineTo(1 * hexagonSize, (1 - (Math.sqrt(3) / 6)) * hexagonSize);
        path.lineTo(0.5 * hexagonSize, 1 * hexagonSize);
        path.lineTo(0, (1 - (Math.sqrt(3) / 6)) * hexagonSize);
        path.lineTo(0, (Math.sqrt(3) / 6) * hexagonSize);
        return path;
    }

    private Dimension currentTotalGridSize()
    {
        return new Dimension(
                (hexagonSize * columns) + (hexagonSize / 2) + STROKE_WIDTH, //X - Perfect
                (int) ((hexagonSize * rows * (1 - (Math.sqrt(3) / 6))) + (hexagonSize * (1 - (Math.sqrt(3) / 3)))) //Y - Almost perfect
        );
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        GeneralPath hexagonShape = hexagonPath(hexagonSize);
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        final BasicStroke stroke = new BasicStroke(STROKE_WIDTH, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g2d.setStroke(stroke);
        g2d.translate(hexagonSize * 0.5, 0); //It's easier to start here because the first row is offset indented in the -X direction
        for (int i = 0; i < rows; i++)
        {
            if (i != 0)
            {
                g2d.translate(0, (1 - (Math.sqrt(3) / 6)) * hexagonSize);
            }
            for (int j = 0; j < columns; j++)
            {
                if (j == 0)
                {
                    if (i % 2 == 0)
                    {
                        g2d.translate(-hexagonSize * 0.5, 0); //Even
                    }
                    else
                    {
                        g2d.translate(hexagonSize * 0.5, 0); //Odd
                    }
                }
                //Pretty colours
                //g2d.setColor(new Color(Color.HSBtoRGB((float) i / rows * j / columns, 1, 1)));
                //Functional colours
                g2d.setColor(new Color(Color.HSBtoRGB((float) i / rows, 1 - (float) j / columns, 1)));
                g2d.fill(hexagonShape);
                g2d.setColor(Color.BLACK);
                g2d.draw(hexagonShape);
                g2d.translate(hexagonSize, 0);
            }
            g2d.translate(-hexagonSize * columns, 0);
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e)
    {
        int notches = e.getWheelRotation();
        hexagonSize -= notches;
        setPreferredSize(currentTotalGridSize());
        this.repaint();
        this.revalidate();
    }

    /*@Override
    public void mouseDragged(MouseEvent e)
    {
        if (dragStart == true)
        {
            dragStart = false;
            this.setCursor(Cursor.getPredefinedCursor((Cursor.MOVE_CURSOR)));
        }
        else
        {
            X = e.getX() - startX;
            Y = e.getY() - startY;

            //  The following two lines are to reverse the movement. i want a hand tool behaviour,
            // so a drag to the right should actually move the canvas right... 
            X = X * -1;
            Y = Y * -1;

            /*
             JScrollPane currentScrollPane = scrollableHexagonPanel;
             JScrollBar horizontalScrollBar = currentScrollPane.getHorizontalScrollBar();
             JScrollBar verticalScrollBar = currentScrollPane.getVerticalScrollBar();

            
             // TODO Fix this buggy dragging code - temporarily disabled for now
             if (horizontalScrollBar.getValue() + X > horizontalScrollBar.getMinimum()
             && horizontalScrollBar.getValue() + horizontalScrollBar.getVisibleAmount() + X < horizontalScrollBar.getMaximum())
             {
             //horizontalScrollBar.setValue(horizontalScrollBar.getValue() + X);
             }

             if (verticalScrollBar.getValue() + Y > verticalScrollBar.getMinimum()
             && verticalScrollBar.getValue() + verticalScrollBar.getVisibleAmount() + Y < verticalScrollBar.getMaximum())
             {
             verticalScrollBar.setValue(verticalScrollBar.getValue() + Y);
             }
             
        }
        startX = e.getX();
        startY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        dragStart = true;
        this.setCursor(null);
    }
    */
}
