package mainPackage;

import antgame.model.World;
import antgame.parsers.exceptions.ColumnNumberException;
import antgame.parsers.exceptions.RowDoesntStartWithWhitespaceException;
import antgame.parsers.exceptions.RowNumberException;
import antgame.parsers.worldparser.ParseAndValidate;
import antgame.parsers.worldparser.ReadFile;
import antgame.world.requirements.*;
import antgame.world.worldTokens.*;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ItsTheRai
 */
public class GameEngine
{
    //holds the current world being used by all
    private static World currentWorld;
    //load stuff from GUI into here
    private GameFile gameFile;
    private int executedRounds;

    /**
     *
     */
    public GameEngine()
    {
        RandomIntGenerator f = new RandomIntGenerator(new BigInteger("12345"));
        executedRounds = 0;
        gameFile = new GameFile();
    }

    /**
     *
     * @param blackBrainFile InstructionSet[] containing a parsed ant brain
     * @param redBrainFile InstructionSetp[] containing a parsed ant brain
     * @throws Exception exception thrown if world cant be populated with ants
     */
    public void initEngine(File blackBrainFile, File redBrainFile) throws Exception
    {
        gameFile.setBlackBrain(AntBrainFactory.generateAntBrainFromString(ReadFile.readFile(blackBrainFile.getPath(), Charset.defaultCharset())));
        gameFile.setRedBrain(AntBrainFactory.generateAntBrainFromString(ReadFile.readFile(redBrainFile.getPath(), Charset.defaultCharset())));
        //populate world with ants
        putAnts();

    }

    /**
     *parses the world file into a World object and puts it into the gameFile if successful
     * @param worldFile a text file
     * @throws IOException Can't read file
     * @throws RowNumberException formal and actual number of rows differ
     * @throws RowDoesntStartWithWhitespaceException Odd row doesn't start with a whitespace
     * @throws ColumnNumberException formal and actual number of column differ
     * @throws Exception General exception
     */
    public void loadWorld(File worldFile) throws IOException, RowNumberException, RowDoesntStartWithWhitespaceException, ColumnNumberException, Exception
    {
        ParseAndValidate pav = new ParseAndValidate();
        List<CheckRequirement> ls = new LinkedList();
        //ls.add(new RequirementDimension(100, 100));
        ls.add(new RequirementBorder(1));

        String input = ReadFile.readFile(worldFile.getPath(), Charset.defaultCharset());

        gameFile.setWorld(WorldFactory.loadWorld(pav, input, ls));

        //set world in cache as current world
        currentWorld = gameFile.getWorld();
    }

    /**
     *uses the WorldFactory to generate a random world according to tournament requirements
     * and updates the gameFile field by putting this world as the current world
     */
    public void loadRandomWorld()
    {
        List<CheckRequirement> ls = new LinkedList();
        //ls.add(new RequirementDimension(100, 100));
        ls.add(new RequirementBorder(1));

        gameFile.setWorld(WorldFactory.generateRandomWorld(ls));
    }

    //Populates the world with ants
    //iterates through the whole world and when an anthill is found, an ant is placed in that location of 
    //its respective color
    //copies all created ants into the currenWorld.ants field ir rising order of antID
    private void putAnts() throws Exception
    {
        for (int i = 0; i < currentWorld.getWorldTokens().length; i++)
        {
            TerrainToken t = (currentWorld.getWorldTokens()[i]);
            if (t.isAnthill())
            {
                t.putAnt(AntFactory.generateAnt(t.getAnthillColor(), t.getAnthillColor().getBrain(gameFile), t.getPosition(), currentWorld));
                currentWorld.addAnt(t.getAnt());
            }
        }
    }

    /**
     * the fields currentWorld executeOneROund() instruction is executed as many times as the parameter suggests
     * the counter executed Rounds is incremented
     * @param getToThisManyCompletedRuns number of round to be executed
     */
    public void runSimulator(int getToThisManyCompletedRuns)
    {
        if (currentWorld == null)
        {
        }
        else
        {
            for (int i = executedRounds; i < getToThisManyCompletedRuns; i++)
            {
                currentWorld.executeOneRound();
                executedRounds++;
            }
        }
    }

    /**
     *
     * @return returns the currently loaded world
     */
    public static World getCurrentWorld()
    {
        return currentWorld;
    }
   
    public int getRedScore()
    {
        return currentWorld.getRedScore();
    }

    public int getBlackScore()
    {
        return currentWorld.getBlackScore();
    }

    /**
     *resets the currentWorld to null
     */
    public static void resetCurrentWorld()
    {
        GameEngine.currentWorld = null;
    }
}
