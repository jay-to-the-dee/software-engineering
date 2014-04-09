package antgame.gui;

import antgame.ant.color.ColorBlack;
import antgame.ant.color.ColorRed;
import antgame.model.World;
import antgame.world.worldTokens.TerrainToken;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
    private BufferedImage bantImg60;
    private BufferedImage bantImg120;
    private BufferedImage bantImg180;
    private BufferedImage bantImg240;
    private BufferedImage bantImg400;
    private BufferedImage bantImg300;
    private BufferedImage bfantImg60;
    private BufferedImage bfantImg120;
    private BufferedImage bfantImg180;
    private BufferedImage bfantImg240;
    private BufferedImage bfantImg300;
    private BufferedImage rfantImg60;
    private BufferedImage rfantImg120;
    private BufferedImage rfantImg180;
    private BufferedImage rfantImg240;
    private BufferedImage rfantImg300;
    private BufferedImage antImg60;
    private BufferedImage antImg120;
    private BufferedImage antImg180;
    private BufferedImage antImg240;
    private BufferedImage antImg300;

    /**
     * Constructs a WorldPanel and displays it
     */
    public WorldPanel()
    {
        loadImages();
        setPreferredSize(currentTotalGridSize());
        this.repaint();
    }

    private void loadWorld() throws NullPointerException
    {
        this.world = GameEngine.getCurrentWorld();
        worldtokens = world.getWorldTokens();
    }

    private void loadImages()
    {
        try
        {
            //antImg = ImageIO.read(getClass().getResource("/resources/images/Sprites/Ant_rotate_0.png"));
            antImg = ImageIO.read(new File("resources/images/Sprites/Ant/ranten.png"));
            antImg60 = ImageIO.read(new File("resources/images/Sprites/Ant/ranten60.png"));
            antImg120 = ImageIO.read(new File("resources/images/Sprites/Ant/ranten120.png"));
            antImg180 = ImageIO.read(new File("resources/images/Sprites/Ant/ranten180.png"));
            antImg240 = ImageIO.read(new File("resources/images/Sprites/Ant/ranten240.png"));
            antImg300 = ImageIO.read(new File("resources/images/Sprites/Ant/ranten300.png"));
                        
            
            bantImg = ImageIO.read(new File("resources/images/Sprites/Ant/banten.png"));
            bantImg60 = ImageIO.read(new File("resources/images/Sprites/Ant/banten60.png"));
            bantImg120 = ImageIO.read(new File("resources/images/Sprites/Ant/banten120.png"));
            bantImg180 = ImageIO.read(new File("resources/images/Sprites/Ant/banten180.png"));
            bantImg240 = ImageIO.read(new File("resources/images/Sprites/Ant/banten240.png"));
            bantImg300 = ImageIO.read(new File("resources/images/Sprites/Ant/banten300.png"));
            
            rfantImg = ImageIO.read(new File("resources/images/Sprites/Ant/rfangten.png"));
            rfantImg60 = ImageIO.read(new File("resources/images/Sprites/Ant/rfangten60.png"));
            rfantImg120 = ImageIO.read(new File("resources/images/Sprites/Ant/rfangten120.png"));
            rfantImg180 = ImageIO.read(new File("resources/images/Sprites/Ant/rfangten180.png"));
            rfantImg240 = ImageIO.read(new File("resources/images/Sprites/Ant/rfangten240.png"));
            rfantImg300 = ImageIO.read(new File("resources/images/Sprites/Ant/rfangten300.png"));
            
            
            bfantImg = ImageIO.read(new File("resources/images/Sprites/Ant/bfangten.png"));
            bfantImg60 = ImageIO.read(new File("resources/images/Sprites/Ant/bfangten60.png"));
            bfantImg120 = ImageIO.read(new File("resources/images/Sprites/Ant/bfangten120.png"));
            bfantImg180 = ImageIO.read(new File("resources/images/Sprites/Ant/bfangten180.png"));
            bfantImg240 = ImageIO.read(new File("resources/images/Sprites/Ant/bfangten240.png"));
            bfantImg300 = ImageIO.read(new File("resources/images/Sprites/Ant/bfangten300.png"));
            
            
            rockImg = ImageIO.read(new File("resources/images/Sprites/Rock/Rock_c.png"));
            foodImg = ImageIO.read(new File("resources/images/Sprites/Food/Food_f.png"));
        }
        catch (IOException e)
        {
            System.out.println("Image not found.");
        }
    }

    /**
     * Sets the size for all the hexagons to be drawn at. Called by the 
     * zooming functions
     * @param hexagonSize the width in pixels that all the hexagons should be 
     * set at
     */
    public void setHexagonSize(int hexagonSize)
    {
        this.hexagonSize = hexagonSize;
        singleSideSize = (float) (hexagonSize / 2 / Math.cos(Math.toRadians(30)));

        antScaled = Scalr.resize(antImg, Scalr.Method.SPEED, (int) (1 * hexagonSize));
        bantScaled = Scalr.resize(bantImg, Scalr.Method.SPEED, (int) (1 * hexagonSize));
        rfantScaled = Scalr.resize(rfantImg, Scalr.Method.SPEED, (int) (1 * hexagonSize));
        bfantScaled = Scalr.resize(bfantImg, Scalr.Method.SPEED, (int) (1 * hexagonSize));
        rockScaled = Scalr.resize(rockImg, Scalr.Method.SPEED, (int) (1. * hexagonSize));
        foodScaled = Scalr.resize(foodImg, Scalr.Method.SPEED, (int) (1. * hexagonSize));

        antScaledRotate60 = Scalr.resize(antImg60, Scalr.Method.SPEED, (int) (1* hexagonSize));
        antScaledRotate120 = Scalr.resize(antImg120, Scalr.Method.SPEED, (int) (1 * hexagonSize));
        antScaledRotate180 = Scalr.resize(antImg180, Scalr.Method.SPEED, (int) (1 * hexagonSize));
        antScaledRotate240 = Scalr.resize(antImg240, Scalr.Method.SPEED, (int) (1 * hexagonSize));
        antScaledRotate300 = Scalr.resize(antImg300, Scalr.Method.SPEED, (int) (1 * hexagonSize));
        bantScaledRotate60 = Scalr.resize(bantImg60, Scalr.Method.SPEED, (int) (1 * hexagonSize));
        bantScaledRotate120 = Scalr.resize(bantImg120, Scalr.Method.SPEED, (int) (1 * hexagonSize));;
        bantScaledRotate180 = Scalr.resize(bantImg180, Scalr.Method.SPEED, (int) (1 * hexagonSize));
        bantScaledRotate240 = Scalr.resize(bantImg240, Scalr.Method.SPEED, (int) (1 * hexagonSize));
        bantScaledRotate300 = Scalr.resize(bantImg300, Scalr.Method.SPEED, (int) (1 * hexagonSize));

        
        rfantScaledRotate60 = Scalr.resize(rfantImg60, Scalr.Method.SPEED, (int) (1 * hexagonSize));
        rfantScaledRotate120 = Scalr.resize(rfantImg120, Scalr.Method.SPEED, (int) (1 * hexagonSize));
        rfantScaledRotate180 = Scalr.resize(rfantImg180, Scalr.Method.SPEED, (int) (1 * hexagonSize));
        rfantScaledRotate240 = Scalr.resize(rfantImg240, Scalr.Method.SPEED, (int) (1 * hexagonSize));
        rfantScaledRotate300 = Scalr.resize(rfantImg300, Scalr.Method.SPEED, (int) (1 * hexagonSize));

        bfantScaledRotate60 = Scalr.resize(bfantImg60, Scalr.Method.SPEED, (int) (1 * hexagonSize));
        bfantScaledRotate120 = Scalr.resize(bfantImg120, Scalr.Method.SPEED, (int) (1 * hexagonSize));
        bfantScaledRotate180 = Scalr.resize(bfantImg180, Scalr.Method.SPEED, (int) (1 * hexagonSize));
        bfantScaledRotate240 = Scalr.resize(bfantImg240, Scalr.Method.SPEED, (int) (1 * hexagonSize));
        bfantScaledRotate300 = Scalr.resize(bfantImg300, Scalr.Method.SPEED, (int) (1 * hexagonSize));

        forceRedraw();
    }

    /**
     * Sets the rows and columns this WorldPanel is to represent
     * @param dimension The dimension contains the height and width to set the 
     * WorldPanel at
     */
    public void setRowsAndColumns(Dimension dimension)
    {
        this.rows = (int) dimension.getHeight();
        this.columns = (int) dimension.getWidth();

        forceRedraw();
    }

    /**
     * Force a redraw - used internally
     */
    private void forceRedraw()
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

        g2d.setColor(ColourScheme.plainCellColor);
        g2d.fill(hexagonShape);

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
