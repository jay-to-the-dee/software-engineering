package antgame.gui;

import antgame.world.worldTokens.TerrainToken;
import antgame.model.World;
import antgame.ant.color.ColorBlack;
import antgame.ant.color.ColorRed;
import antgame.world.worldTokens.Token;
import antgame.world.worldTokens.WorldToken;
import antgame.world.textworldgenerator.GenRandomMap;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.*;
import javax.swing.JPanel;
import org.imgscalr.Scalr;
import static org.imgscalr.Scalr.*;

/**
 * World (Hexagon game board) GUI Panel.
 * This class contains the game's main draw method and code.
 *
 * @author Jonathan Dilks <jay-to-the-dee@users.noreply.github.com>
 */
public class WorldPanel extends JPanel
{
    private static final int STROKE_WIDTH = 1;
    private int rows;
    private int columns;
    //Zoom fields
    private int hexagonSize;
    private float singleSideSize;
    private BufferedImage antImg;
    private BufferedImage rockImg;
    private BufferedImage antScaled;
    private BufferedImage rockScaled;
    private int dirrect;
    private BufferedImage foodImg;
    private BufferedImage foodScaled;
    private final World world;
    private final List<TerrainToken> worldtokens;

    public WorldPanel()
    {
        //addMouseMotionListener(this);
        //addMouseListener(this);
        loadImages();
        GenRandomMap newWorld = new GenRandomMap(150);
        world = newWorld.createWorld();
        worldtokens = world.getWorldTokens();
        setPreferredSize(currentTotalGridSize());
        this.repaint();
    }

    public void loadImages()
    {
        try
        {
            //antImg = ImageIO.read(getClass().getResource("/resources/images/Sprites/Ant_rotate_0.png"));
            antImg = ImageIO.read(new File("resources/images/Sprites/Ant/Ant_rotate_0.png"));
            rockImg = ImageIO.read(new File("resources/images/Sprites/Rock/Rock_No_Boundary.png"));
            foodImg = ImageIO.read(new File("resources/images/Sprites/Food/Food_No_Boundary.png"));
        }
        catch (IOException e)
        {
            System.out.println("Image not found.");
        }
    }

    public void setHexagonSize(int hexagonSize)
    {
        this.hexagonSize = hexagonSize;
        singleSideSize = (float) (hexagonSize / 2 / Math.cos(Math.toRadians(30)));

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
                (hexagonSize * columns) + (hexagonSize / 2) + STROKE_WIDTH,
                (int) ((int) (((singleSideSize * 2) - (Math.sqrt(3) / 6) * hexagonSize) * rows) + ((Math.sqrt(3) / 6) * hexagonSize) + STROKE_WIDTH * 2));
    }

    private static GeneralPath hexagonPath(int hexagonSize)
    {
        final float singleSideSize = (float) (hexagonSize / 2 / Math.cos(Math.toRadians(30)));

        GeneralPath path = new GeneralPath();
        path.moveTo(0, (Math.sqrt(3) / 6) * hexagonSize);
        path.lineTo(0.5 * hexagonSize, 0);
        path.lineTo(1 * hexagonSize, (Math.sqrt(3) / 6) * hexagonSize);
        path.lineTo(1 * hexagonSize, (singleSideSize * 2) - ((Math.sqrt(3) / 6) * hexagonSize));
        path.lineTo(0.5 * hexagonSize, singleSideSize * 2);
        path.lineTo(0, (singleSideSize * 2) - ((Math.sqrt(3) / 6) * hexagonSize));
        path.lineTo(0, (Math.sqrt(3) / 6) * hexagonSize);
        return path;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        GeneralPath hexagonShape = hexagonPath(hexagonSize);

        if (antImg == null || rockImg == null || foodImg == null)
        {
            //Needed to make GUI builder work
           return; 
        }

        antScaled = Scalr.resize(antImg, Scalr.Method.SPEED, (int) (1.5155 * hexagonSize));
        rockScaled = Scalr.resize(rockImg, Scalr.Method.SPEED, (int) (1.5155 * hexagonSize));
        foodScaled = Scalr.resize(foodImg, Scalr.Method.SPEED, (int) (1.5155 * hexagonSize));

        AffineTransform tx = new AffineTransform();
        tx.rotate(Math.PI / 3);
        AffineTransformOp op60 = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        tx.rotate(Math.PI / 3);
        AffineTransformOp op120 = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        tx.rotate(Math.PI / 3);
        AffineTransformOp op180 = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        tx.rotate(Math.PI / 3);
        AffineTransformOp op240 = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        tx.rotate(Math.PI / 3);
        AffineTransformOp op300 = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

        BufferedImage antScaledRotate60 = new BufferedImage(antScaled.getHeight(), antScaled.getWidth(), antScaled.getType());
        op60.filter(antScaled, antScaledRotate60);

        BufferedImage antScaledRotate120 = new BufferedImage(antScaled.getHeight(), antScaled.getWidth(), antScaled.getType());
        op120.filter(antScaled, antScaledRotate120);

        BufferedImage antScaledRotate180 = new BufferedImage(antScaled.getHeight(), antScaled.getWidth(), antScaled.getType());
        op180.filter(antScaled, antScaledRotate180);

        BufferedImage antScaledRotate240 = new BufferedImage(antScaled.getHeight(), antScaled.getWidth(), antScaled.getType());
        op240.filter(antScaled, antScaledRotate240);

        BufferedImage antScaledRotate300 = new BufferedImage(antScaled.getHeight(), antScaled.getWidth(), antScaled.getType());
        op300.filter(antScaled, antScaledRotate300);

        //Makes it look pretty - but too laggy for good framerate :(
        //g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        final BasicStroke stroke = new BasicStroke(STROKE_WIDTH, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g2d.setStroke(stroke);
        g2d.translate(hexagonSize * 0.5, 0); //It's easier to start here because the first row is offset indented in the -X direction
        for (int i = 0; i < rows; i++)
        {
            if (i != 0)
            {
                g2d.translate(0, (singleSideSize * 2) - (Math.sqrt(3) / 6) * hexagonSize);
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
                //g2d.setColor(new Color(Color.HSBtoRGB((float) i / rows, 1 - (float) j / columns, 1)));
                //g2d.fill(hexagonShape);
                g2d.setColor(Color.BLACK);

                TerrainToken token = (TerrainToken) worldtokens.get(j + i * (world.getWidth()));
                if (token.isRocky())
                {
                    g2d.drawImage(rockScaled, null, 0, 0);

                }
                else if (token.hasAnt())
                {

                    dirrect = token.getAnt().getDirection();//getDirection

                    if (token.hasAnt())
                    { //.isHasFood
                        if (token.hasFood())
                        {
                            if (token.getAnt().getColour() instanceof ColorRed)
                            {//.getColour
                                switch (dirrect)
                                {
                                    case 0:
                                        g2d.drawImage(antScaled, null, 0, 0);
                                        break;
                                    case 1:
                                        g2d.drawImage(antScaledRotate60, null, 0, 0);
                                        break;
                                    case 2:
                                        g2d.drawImage(antScaledRotate120, null, 0, 0);
                                        break;
                                    case 3:
                                        g2d.drawImage(antScaledRotate180, null, 0, 0);
                                        break;
                                    case 4:
                                        g2d.drawImage(antScaledRotate240, null, 0, 0);
                                        break;
                                    case 5:
                                        g2d.drawImage(antScaledRotate300, null, 0, 0);
                                        break;
                                }
                            }
                            else
                            {
                                switch (dirrect)
                                {
                                    case 0:
                                        g2d.drawImage(antScaled, null, 0, 0);
                                        break;
                                    case 1:
                                        g2d.drawImage(antScaledRotate60, null, 0, 0);
                                        break;
                                    case 2:
                                        g2d.drawImage(antScaledRotate120, null, 0, 0);
                                        break;
                                    case 3:
                                        g2d.drawImage(antScaledRotate180, null, 0, 0);
                                        break;
                                    case 4:
                                        g2d.drawImage(antScaledRotate240, null, 0, 0);
                                        break;
                                    case 5:
                                        g2d.drawImage(antScaledRotate300, null, 0, 0);
                                        break;
                                }
                            }
                        }
                        else
                        {
                            if (token.getAnt().getColour() instanceof ColorBlack)
                            {
                                switch (dirrect)
                                {
                                    case 0:
                                        g2d.drawImage(antScaled, null, 0, 0);
                                        break;
                                    case 1:
                                        g2d.drawImage(antScaledRotate60, null, 0, 0);
                                        break;
                                    case 2:
                                        g2d.drawImage(antScaledRotate120, null, 0, 0);
                                        break;
                                    case 3:
                                        g2d.drawImage(antScaledRotate180, null, 0, 0);
                                        break;
                                    case 4:
                                        g2d.drawImage(antScaledRotate240, null, 0, 0);
                                        break;
                                    case 5:
                                        g2d.drawImage(antScaledRotate300, null, 0, 0);
                                        break;
                                }

                            }
                            else
                            {
                                switch (dirrect)
                                {
                                    case 0:
                                        g2d.drawImage(antScaled, null, 0, 0);
                                        break;
                                    case 1:
                                        g2d.drawImage(antScaledRotate60, null, 0, 0);
                                        break;
                                    case 2:
                                        g2d.drawImage(antScaledRotate120, null, 0, 0);
                                        break;
                                    case 3:
                                        g2d.drawImage(antScaledRotate180, null, 0, 0);
                                        break;
                                    case 4:
                                        g2d.drawImage(antScaledRotate240, null, 0, 0);
                                        break;
                                    case 5:
                                        g2d.drawImage(antScaledRotate300, null, 0, 0);
                                        break;
                                }
                                //Draw red ant with food.
                            }
                        }
                    }
                    else
                    {
                        if (token.getAnt().getColour() instanceof ColorBlack)//not sure about the chosen colors here
                        {
                            switch (dirrect)
                            {
                                case 0:
                                    g2d.drawImage(antScaled, null, 0, 0);
                                    break;
                                case 1:
                                    g2d.drawImage(antScaledRotate60, null, 0, 0);
                                    break;
                                case 2:
                                    g2d.drawImage(antScaledRotate120, null, 0, 0);
                                    break;
                                case 3:
                                    g2d.drawImage(antScaledRotate180, null, 0, 0);
                                    break;
                                case 4:
                                    g2d.drawImage(antScaledRotate240, null, 0, 0);
                                    break;
                                case 5:
                                    g2d.drawImage(antScaledRotate300, null, 0, 0);
                                    break;
                            }
                            //Draw black ant.
                        }
                        else
                        {
                            switch (dirrect)
                            {
                                case 0:
                                    g2d.drawImage(antScaled, null, 0, 0);
                                    break;
                                case 1:
                                    g2d.drawImage(antScaledRotate60, null, 0, 0);
                                    break;
                                case 2:
                                    g2d.drawImage(antScaledRotate120, null, 0, 0);
                                    break;
                                case 3:
                                    g2d.drawImage(antScaledRotate180, null, 0, 0);
                                    break;
                                case 4:
                                    g2d.drawImage(antScaledRotate240, null, 0, 0);
                                    break;
                                case 5:
                                    g2d.drawImage(antScaledRotate300, null, 0, 0);
                                    break;
                            }
                            //Draw red ant.
                        }
                    }
                }
                else if (token.hasFood())
                {
                    g2d.drawImage(foodScaled, null, 0, 0);
                }
                else
                {

                }

                g2d.draw(hexagonShape);
                g2d.translate(hexagonSize, 0);
            }
            g2d.translate(-hexagonSize * columns, 0);
        }
    }
}
