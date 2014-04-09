package antgame.gui;

import antgame.ant.color.ColorBlack;
import antgame.ant.color.ColorRed;
import antgame.model.World;
import antgame.world.worldTokens.TerrainToken;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.Stack;
import javax.imageio.*;
import javax.swing.JPanel;
import mainPackage.GameEngine;
import org.imgscalr.Scalr;

/**
 * World (Hexagon game board) GUI Panel.
 * This class contains the game's main draw method and code.
 *
 * @author Jonathan Dilks <jay-to-the-dee@users.noreply.github.com>
 */
public final class WorldPanel extends JPanel
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

    private World world;
    private TerrainToken[] worldtokens;
    private BufferedImage antScaledRotate60;
    private BufferedImage antScaledRotate120;
    private BufferedImage antScaledRotate180;
    private BufferedImage antScaledRotate240;
    private BufferedImage antScaledRotate300;
    private BufferedImage bantScaled;
    private BufferedImage bantImg;
    private BufferedImage fantImg;
    private BufferedImage fbantImg;
    private BufferedImage bantScaledRotate60;
    private BufferedImage bantScaledRotate300;
    private BufferedImage bantScaledRotate240;
    private BufferedImage bantScaledRotate180;
    private BufferedImage bantScaledRotate120;
    private BufferedImage rfantImg;
    private BufferedImage bfantImg;
    private BufferedImage rfantScaled;
    private BufferedImage rfantScaledRotate180;
    private BufferedImage rfantScaledRotate120;
    private BufferedImage rfantScaledRotate240;
    private BufferedImage rfantScaledRotate300;
    private BufferedImage bfantScaled;
    private BufferedImage bfantScaledRotate120;
    private BufferedImage bfantScaledRotate60;
    private BufferedImage bfantScaledRotate180;
    private BufferedImage bfantScaledRotate240;
    private BufferedImage bfantScaledRotate300;
    private BufferedImage rfantScaledRotate60;

    /**
     * Constructs a WorldPanel and displays it
     */
    public WorldPanel()
    {
        loadImages();
        setPreferredSize(currentTotalGridSize());
        this.repaint();
    }

    public void loadWorld() throws NullPointerException
    {
        this.world = GameEngine.getCurrentWorld();
        worldtokens = world.getWorldTokens();
    }

    private void loadImages()
    {
        try
        {
            //antImg = ImageIO.read(getClass().getResource("/resources/images/Sprites/Ant_rotate_0.png"));
            antImg = ImageIO.read(new File("resources/images/Sprites/Ant/rant.png"));
            bantImg = ImageIO.read(new File("resources/images/Sprites/Ant/bant.png"));
            rfantImg = ImageIO.read(new File("resources/images/Sprites/Ant/rfant.png"));
            bfantImg = ImageIO.read(new File("resources/images/Sprites/Ant/bfant.png"));
            rockImg = ImageIO.read(new File("resources/images/Sprites/Rock/Rock_c.png"));
            foodImg = ImageIO.read(new File("resources/images/Sprites/Food/Food_c.png"));
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

        antScaled = Scalr.resize(antImg, Scalr.Method.SPEED, (int) (0.6 * hexagonSize));
        bantScaled = Scalr.resize(bantImg, Scalr.Method.SPEED, (int) (0.6 * hexagonSize));
        rfantScaled = Scalr.resize(rfantImg, Scalr.Method.SPEED, (int) (0.6 * hexagonSize));
        bfantScaled = Scalr.resize(bfantImg, Scalr.Method.SPEED, (int) (0.6 * hexagonSize));
        rockScaled = Scalr.resize(rockImg, Scalr.Method.SPEED, (int) (1. * hexagonSize));
        foodScaled = Scalr.resize(foodImg, Scalr.Method.SPEED, (int) (.8 * hexagonSize));

        AffineTransform tx = new AffineTransform();

        tx.rotate(60.0 * Math.PI / 180.0, antScaled.getWidth(), antScaled.getHeight());

        AffineTransformOp op60 = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

        tx.rotate(60.0 * Math.PI / 180.0, antScaled.getWidth(), antScaled.getHeight());

        AffineTransformOp op120 = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

        tx.rotate(60.0 * Math.PI / 180.0, antScaled.getWidth(), antScaled.getHeight());
        AffineTransformOp op180 = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

        tx.rotate(60.0 * Math.PI / 180.0, antScaled.getWidth(), antScaled.getHeight());
        AffineTransformOp op240 = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

        tx.rotate(60.0 * Math.PI / 180.0, antScaled.getWidth(), antScaled.getHeight());
        AffineTransformOp op300 = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

        antScaledRotate60 = op60.filter(antScaled, null);

        antScaledRotate120 = op120.filter(antScaled, null);

        antScaledRotate180 = op180.filter(antScaled, null);

        antScaledRotate240 = op240.filter(antScaled, null);

        antScaledRotate300 = op300.filter(antScaled, null);

        bantScaledRotate60 = op60.filter(bantScaled, null);

        bantScaledRotate120 = op120.filter(bantScaled, null);

        bantScaledRotate180 = op180.filter(bantScaled, null);

        bantScaledRotate240 = op240.filter(bantScaled, null);

        bantScaledRotate300 = op300.filter(bantScaled, null);

        antScaledRotate60 = op60.filter(antScaled, null);

        rfantScaledRotate60 = op60.filter(rfantScaled, null);
        rfantScaledRotate120 = op120.filter(rfantScaled, null);

        rfantScaledRotate180 = op180.filter(rfantScaled, null);

        rfantScaledRotate240 = op240.filter(rfantScaled, null);

        rfantScaledRotate300 = op300.filter(rfantScaled, null);

        bfantScaledRotate60 = op60.filter(bfantScaled, null);
        bfantScaledRotate120 = op120.filter(bfantScaled, null);

        bfantScaledRotate180 = op180.filter(bfantScaled, null);

        bfantScaledRotate240 = op240.filter(bfantScaled, null);

        bfantScaledRotate300 = op300.filter(bfantScaled, null);

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

        try
        {
            loadWorld();
        }
        catch (NullPointerException e)
        {
            //We have nothing to draw then - so don't
            return;
        }

        if (antImg == null || rockImg == null || foodImg == null)
        {
            //Workaround needed to make GUI builder work - doesnt affect actual running
            return;
        }

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

                TerrainToken token = (TerrainToken) worldtokens[j + i * (world.getWidth())];

                /* Call method to fill in chemical markers/ anthill/ general 
                 background color */
                paintCellBackground(g2d, token, hexagonShape);

                g2d.setColor(java.awt.Color.BLACK);

                if (token.hasFood())
                {
                    g2d.drawImage(foodScaled, null, 0, 0);
                }
                if (token.isRocky())
                {
                    g2d.drawImage(rockScaled, null, 0, 0);

                }
                else if (token.hasAnt())
                {
                    dirrect = token.getAnt().getDirection();//getDirection

                    if (token.getAnt().isHasFood())
                    { //.isHasFood
                        if (token.hasFood())
                        {
                            if (token.getAnt().getColour() instanceof ColorRed)
                            {//.getColour
                                switch (dirrect)
                                {
                                    case 0:
                                        g2d.drawImage(rfantScaled, null, 0, 0);
                                        break;
                                    case 1:
                                        g2d.drawImage(rfantScaledRotate60, null, 0, 0);
                                        break;
                                    case 2:
                                        g2d.drawImage(rfantScaledRotate120, null, 0, 0);
                                        break;
                                    case 3:
                                        g2d.drawImage(rfantScaledRotate180, null, 0, 0);
                                        break;
                                    case 4:
                                        g2d.drawImage(rfantScaledRotate240, null, 0, 0);
                                        break;
                                    case 5:
                                        g2d.drawImage(rfantScaledRotate300, null, 0, 0);
                                        break;
                                }
                            }
                            else
                            {
                                switch (dirrect)
                                {
                                    case 0:
                                        g2d.drawImage(bfantScaled, null, 0, 0);
                                        break;
                                    case 1:
                                        g2d.drawImage(bfantScaledRotate60, null, 0, 0);
                                        break;
                                    case 2:
                                        g2d.drawImage(bfantScaledRotate120, null, 0, 0);
                                        break;
                                    case 3:
                                        g2d.drawImage(bfantScaledRotate180, null, 0, 0);
                                        break;
                                    case 4:
                                        g2d.drawImage(bfantScaledRotate240, null, 0, 0);
                                        break;
                                    case 5:
                                        g2d.drawImage(bfantScaledRotate300, null, 0, 0);
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
                                        g2d.drawImage(bfantScaled, null, 0, 0);
                                        break;
                                    case 1:
                                        g2d.drawImage(bfantScaledRotate60, null, 0, 0);
                                        break;
                                    case 2:
                                        g2d.drawImage(bfantScaledRotate120, null, 0, 0);
                                        break;
                                    case 3:
                                        g2d.drawImage(bfantScaledRotate180, null, 0, 0);
                                        break;
                                    case 4:
                                        g2d.drawImage(bfantScaledRotate240, null, 0, 0);
                                        break;
                                    case 5:
                                        g2d.drawImage(bfantScaledRotate300, null, 0, 0);
                                        break;
                                }

                            }
                            else
                            {
                                switch (dirrect)
                                {
                                    case 0:
                                        g2d.drawImage(rfantScaled, null, 0, 0);
                                        break;
                                    case 1:
                                        g2d.drawImage(rfantScaledRotate60, null, 0, 0);
                                        break;
                                    case 2:
                                        g2d.drawImage(rfantScaledRotate120, null, 0, 0);
                                        break;
                                    case 3:
                                        g2d.drawImage(rfantScaledRotate180, null, 0, 0);
                                        break;
                                    case 4:
                                        g2d.drawImage(rfantScaledRotate240, null, 0, 0);
                                        break;
                                    case 5:
                                        g2d.drawImage(rfantScaledRotate300, null, 0, 0);
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
                                    g2d.drawImage(bantScaled, null, 0, 0);
                                    break;
                                case 1:
                                    g2d.drawImage(bantScaledRotate60, null, 0, 0);
                                    break;
                                case 2:
                                    g2d.drawImage(bantScaledRotate120, null, 0, 0);
                                    break;
                                case 3:
                                    g2d.drawImage(bantScaledRotate180, null, 0, 0);
                                    break;
                                case 4:
                                    g2d.drawImage(bantScaledRotate240, null, 0, 0);
                                    break;
                                case 5:
                                    g2d.drawImage(bantScaledRotate300, null, 0, 0);
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

                else
                {

                }

                //g2d.draw(hexagonShape);
                g2d.translate(hexagonSize, 0);
            }
            g2d.translate(-hexagonSize * columns, 0);
        }
    }

    private void paintCellBackground(Graphics2D g2d, TerrainToken token, GeneralPath hexagonShape)
    {
        //Draw rate debug changing colours
        //g2d.setColor(new Color(Color.HSBtoRGB((float) i / rows, 1 - (float) Math.random(), 1)));
        //Pretty colours
        //g2d.setColor(new Color(Color.HSBtoRGB((float) i / rows * j / columns, 1, 1)));
        //Functional colours
        //g2d.setColor(new Color(Color.HSBtoRGB((float) i / rows, 1 - (float) j / columns, 1)));
        //g2d.fill(hexagonShape);

        if (token.isAnthill())
        {
            if (token.getAnthillColor() instanceof antgame.ant.color.ColorBlack)
            {
                g2d.setColor(ColourScheme.blackAnthillColor);
            }
            else
            {
                g2d.setColor(ColourScheme.redAnthillColor);
            }
            g2d.fill(hexagonShape);

        }
        else if (token.getMarkers().getBlackAntsmarker().gotAnyMarkers() || token.getMarkers().getRedAntsmarker().gotAnyMarkers())
        {
            paintChemicalMarkers(g2d, token);
        }

    }

    private void paintChemicalMarkers(Graphics2D g2d, TerrainToken token)
    {
        GeneralPath[] segmentPaths;

        //LEFT: BLACK ANTS
        Stack<java.awt.Color> blackColors = getChemicalMarkerColors(token.getMarkers().getBlackAntsmarker().getMarkers(), ColourScheme.blackAntChemicalColors);
        if (blackColors.size() > 0)
        {
            segmentPaths = HexagonSegmentation.getSegments(hexagonSize, blackColors.size());
            for (GeneralPath segmentPath : segmentPaths)
            {
                g2d.setColor(blackColors.pop());
                g2d.fill(segmentPath);
            }
        }

        g2d.scale(-1, 1);
        g2d.translate(-hexagonSize, 0);

        //RIGHT: RED ANTS
        Stack<java.awt.Color> redColors = getChemicalMarkerColors(token.getMarkers().getRedAntsmarker().getMarkers(), ColourScheme.redAntChemicalColors);
        if (redColors.size() > 0)
        {
            segmentPaths = HexagonSegmentation.getSegments(hexagonSize, redColors.size());
            for (GeneralPath segmentPath : segmentPaths)
            {
                g2d.setColor(redColors.pop());
                g2d.fill(segmentPath);
            }
        }

        g2d.scale(-1, 1);
        g2d.translate(-hexagonSize, 0);
    }

    private Stack<java.awt.Color> getChemicalMarkerColors(boolean[] markers, java.awt.Color[] colourLookup)
    {
        Stack<java.awt.Color> colors = new Stack<>();

        for (int i = 0; i < markers.length; i++)
        {
            if (markers[i] == true)
            {
                colors.addElement(colourLookup[i]);
            }
        }

        return colors;
    }
}
