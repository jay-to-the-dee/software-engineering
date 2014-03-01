package antgame.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import javax.swing.JPanel;

/**
 * Hexagon GUI Panel
 *
 * @author Jonathan Dilks
 */
public class WorldPanel extends JPanel
{
    private static final int STROKE_WIDTH = 1;
    private int rows;
    private int columns;
    //Zoom fields
    private int hexagonSize;

    public WorldPanel()
    {
        //addMouseMotionListener(this);
        //addMouseListener(this);

        setPreferredSize(currentTotalGridSize());
        this.repaint();
    }

    public void setHexagonSize(int hexagonSize)
    {
        this.hexagonSize = hexagonSize;

        forceRedraw();
    }

    public void setRowsAndColumns(Dimension dimension)
    {
        this.rows = (int) dimension.getHeight();
        this.columns = (int) dimension.getWidth();

        forceRedraw();
    }

    public void forceRedraw()
    {
        setPreferredSize(currentTotalGridSize());
        this.repaint();
        this.revalidate();
    }

    private Dimension currentTotalGridSize()
    {
        return new Dimension(
                (hexagonSize * columns) + (hexagonSize / 2) + STROKE_WIDTH, //X - Perfect
                (int) ((hexagonSize * rows * (1 - (Math.sqrt(3) / 6))) + (hexagonSize * (1 - (Math.sqrt(3) / 3)))) //Y - Almost perfect
        );
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

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        GeneralPath hexagonShape = hexagonPath(hexagonSize);

        //Makes it look pretty - but too laggy for good framerate :(
        //g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
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
                //Draw rate debug changing colours
                //g2d.setColor(new Color(Color.HSBtoRGB((float) i / rows, 1 - (float) Math.random(), 1)));
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
}
