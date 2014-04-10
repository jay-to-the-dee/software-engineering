package antgame.model;

import antgame.world.worldTokens.TerrainToken;
import java.awt.Dimension;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author ItsTheRai
 */
public class World
{
    private final int width;
    private final int height;
    private TerrainToken[] worldTokens;
    int count = 0;
    private static int blackScore;
    private static int redScore;
    private final List<Ant> ants;

    /**
     * create a new World object with width xsize and height ysize containing
     * the TerrainToken array world
     *
     * @param xsize integer - number of tokens per row
     * @param ysize integer - number of tokens per column
     * @param world TerrainToken[] - all the tokens the world contains
     */
    public World(int xsize, int ysize, TerrainToken[] world)
    {
        width = xsize;
        height = ysize;
        worldTokens = new TerrainToken[world.length];
        worldTokens = world;
        blackScore = 0;
        redScore = 0;
        ants = new LinkedList<>();
    }

    /**
     * add an ant to this location
     *
     * @param ant An Ant object
     */
    public void addAnt(Ant ant)
    {
        this.ants.add(ant);
    }

    /**
     *
     * @return number of TerrainTokens horizontally
     */
    public int getWidth()
    {
        return width;
    }

    /**
     *
     * @return number of TerrainTokens vertically
     */
    public int getHeight()
    {
        return height;
    }

    /**
     *
     * @return return all TerrainTokens
     */
    public TerrainToken[] getWorldTokens()
    {
        return worldTokens;
    }

    /**
     * Executes one instruction for each ant in the world starting with ant with
     * ID 0, then ID1 etc untill all ants
     * hae executed one instruction
     * for this every ants step instruction is called
     */
    public void executeOneRound()
    {
        for (int i = 0; i < this.ants.size(); i++)
        {
            step(this.ants.get(i));
        }
    }

    /**
     * executes the current instruction of the ant according to its state if ant
     * is alive and not resting
     * if ant is resting but alive, decrements the resting field of the ant
     *
     * @param ant Ant object
     */
    public void step(Ant ant)
    {
        if (ant.isAlive())
        {
            if (ant.isResting())
            {
                ant.rest();
            }

            else
            //retrieve the ants current instruction by instruction index using state, and execute that instrucction
            {
                ant.getCurrentInstruction().executeInstruction(ant);
            }
        }
    }

    /**
     *
     * @param xposition index starting from 0 to width -1
     * @param yposition index starting from 0 to height -1
     * @return return the TerrainToken with coordinates x,y
     */
    public TerrainToken getTokenAt(int xposition, int yposition)
    {
        return getWorldTokens()[(yposition * getWidth() + xposition)];
    }

    /**
     *
     * @param p Postion object
     * @return the TerrainToken at Position p
     */
    public TerrainToken getCell(Position p)
    {
        return (TerrainToken) this.getTokenAt(p.getXlocation(), p.getYlocation());
    }

    /**
     * returns cell in direction direction of cell in position position
     *
     * @param direction integer - ants facing direction
     * @param position Position - ants position in the world
     * @return TerrainToken in the specified direction
     */
    public TerrainToken getAdjacentCell(int direction, Position position)
    {
        TerrainToken t = new TerrainToken(false, position, null, false, null);
        switch (direction)
        {
            case 0:
                t = (TerrainToken) getTokenAt(position.getXlocation() + 1, position.getYlocation());
                break;
            case 1:
                if (position.getYlocation() % 2 == 0)
                {
                    t = (TerrainToken) getTokenAt(position.getXlocation(), position.getYlocation() + 1);

                }
                else
                {
                    t = (TerrainToken) getTokenAt(position.getXlocation() + 1, position.getYlocation() + 1);
                }
                break;
            case 2:
                if (position.getYlocation() % 2 == 0)
                {
                    t = (TerrainToken) getTokenAt(position.getXlocation() - 1, position.getYlocation() + 1);
                }
                else
                {
                    t = (TerrainToken) getTokenAt(position.getXlocation(), position.getYlocation() + 1);
                }
                break;
            case 3:
                t = (TerrainToken) getTokenAt(position.getXlocation() - 1, position.getYlocation());
                break;
            case 4:
                if (position.getYlocation() % 2 == 0)
                {
                    t = (TerrainToken) getTokenAt(position.getXlocation() - 1, position.getYlocation() - 1);
                }
                else
                {
                    t = (TerrainToken) getTokenAt(position.getXlocation(), position.getYlocation() - 1);
                }
                break;
            case 5:
                if (position.getYlocation() % 2 == 0)
                {
                    t = (TerrainToken) getTokenAt(position.getXlocation(), position.getYlocation() - 1);
                }
                else
                {
                    t = (TerrainToken) getTokenAt(position.getXlocation() + 1, position.getYlocation() - 1);
                }
                break;
        }
        return t;
    }

    /**
     *
     * @return the dimension of the world
     */
    public Dimension getWorldSize()
    {
        return new Dimension(getWidth(), getHeight());
    }

    /**
     * increase the score for black ants by one
     */
    public static void increaseBlackScore()
    {
        blackScore++;
    }

    /**
     * increase the score for red ants by one
     */

    public static void increseRedScore()
    {
        redScore++;
    }

    /**
     *
     * @return the current score for the black ants
     */
    public static int getBlackScore()
    {
        return blackScore;
    }

    /**
     *
     * @return the current score for the red ants
     */
    public static int getRedScore()
    {
        return redScore;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.width;
        hash = 71 * hash + this.height;
        hash = 71 * hash + Arrays.deepHashCode(this.worldTokens);
        hash = 71 * hash + this.count;
        hash = 71 * hash + Objects.hashCode(this.ants);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final World other = (World) obj;
        if (this.width != other.width) {
            return false;
        }
        if (this.height != other.height) {
            return false;
        }
        if (!Arrays.deepEquals(this.worldTokens, other.worldTokens)) {
            return false;
        }
        if (this.count != other.count) {
            return false;
        }
        if (!Objects.equals(this.ants, other.ants)) {
            return false;
        }
        return true;
    }
    public static void resetScores()
    {
        blackScore = 0;
        redScore = 0;
    }
}
