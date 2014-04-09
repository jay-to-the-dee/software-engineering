package antgame.model;

import antgame.ant.instructions.Instruction;
import antgame.world.worldTokens.TerrainToken;
import antgame.world.worldTokens.WorldToken;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ItsTheRai
 */
public class World
{
    private int width;
    private int height;
    private TerrainToken[] worldTokens;
    int count = 0;
    private static int blackScore;
    private static int redScore;
    private List<Ant> ants;
    

    public World(int xsize, int ysize, TerrainToken[] world)
    {
        width = xsize;
        height = ysize;
        worldTokens = new TerrainToken[world.length];
        worldTokens = world;
        blackScore=0;
        redScore=0;
        ants = new LinkedList<>();
    }
    
    public void addAnt(Ant ant){
        this.ants.add(ant);
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public TerrainToken[] getWorldTokens()
    {
        return worldTokens;
    }

    public void executeOneRound()
    {
        for (int i = 0; i < this.ants.size(); i++)
        {
            step(this.ants.get(i));
        }
    }

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

    //xposition - index starting from 0 to width -1
    //yposition - index starting from 0 to heigth -1
    public TerrainToken getTokenAt(int xposition, int yposition)
    {
        return getWorldTokens()[(yposition * getWidth() + xposition)];
    }

    public TerrainToken getCell(Position p)
    {
        return (TerrainToken) this.getTokenAt(p.getXlocation(), p.getYlocation());
    }

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

    public Dimension getWorldSize()
    {
        return new Dimension(getWidth(), getHeight());
    }
    
    public static void increaseBlackScore(){
        blackScore++;
    }
    
    public static void increseRedScore(){
        redScore++;
    }

    public static int getBlackScore() {
        return blackScore;
    }

    public static int getRedScore() {
        return redScore;
    }
    
    
}
