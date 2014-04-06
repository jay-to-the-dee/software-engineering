package mainPackage;

import antgame.parsers.worldparser.ParseAndValidate;
import antgame.parsers.worldparser.ReadFile;
import antgame.world.requirements.*;
import antgame.world.worldTokens.*;
import java.io.File;
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
    /////using these:
    private final WorldFactory worldFactory;
    private final AntBrainFactory brainFactory;
    //used to populate world with ants
    private final AntFactory antFactory;

    /**
     *
     */
    public GameEngine()
    {
        antFactory = new AntFactory();
        worldFactory = new WorldFactory();
        brainFactory = new AntBrainFactory();
    }

    public void initEngine(File worldFile, File blackBrainFile, File redBrainFile) throws Exception
    {
        ParseAndValidate pav = new ParseAndValidate();
        List<CheckRequirement> ls = new LinkedList();
        ls.add(new RequirementDimension(100, 100));
        ls.add(new RequirementBorder(1));

        String input = ReadFile.readFile(worldFile.getPath(), Charset.defaultCharset());
        
        gameFile.setWorld(WorldFactory.loadWorld(pav, input, ls));

        gameFile.setBlackBrain(AntBrainFactory.generateAntBrainFromString(ReadFile.readFile(blackBrainFile.getPath(), Charset.defaultCharset())));
        gameFile.setRedBrain(AntBrainFactory.generateAntBrainFromString(ReadFile.readFile(redBrainFile.getPath(), Charset.defaultCharset())));

        //set world in cache as current world
        currentWorld = gameFile.getWorld();
        //populate world with ants
        putAnts();

    }

    private void putAnts() throws Exception
    {
        for (int i = 0; i < currentWorld.getWorldTokens().size(); i++)
        {
            TerrainToken t = ((TerrainToken) currentWorld.getWorldTokens().get(i));
            if (t.isAnthill())
            {
                t.putAnt(antFactory.generateAnt(t.getAnthillColor(), t.getAnthillColor().getBrain(gameFile), t.getPosition(), currentWorld));
            }
        }
    }

    private void runSimulator(int numberOfRounds)
    {
        for (int i = 0; i < numberOfRounds; i++)
        {
            currentWorld.executeOneRound();
        }
    }

    public static World getCurrentWorld()
    {
        return currentWorld;
    }
}
