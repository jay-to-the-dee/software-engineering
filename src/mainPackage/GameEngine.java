package mainPackage;

import antgame.world.worldTokens.TerrainToken;
import antgame.world.worldTokens.World;
/**
 *
 * @author ItsTheRai
 */
public class GameEngine {
    //holds the current world being used by all
    private static World currentWorld;
    //load stuff from GUI into here
    private GameFile gameFile;
    /////using these:
    private final WorldFactory worldFactory;
    private final AntBrainFactory brainFactory;
    //used to populate world with ants
    private final AntFactory antFactory;
    private int numberOfRounds;
    /**
     *
     */
    public GameEngine(){
        antFactory = new AntFactory();
        worldFactory = new WorldFactory();
        brainFactory = new AntBrainFactory();
    }
    
    public void run() throws Exception{
        //set world in cache as current world
        currentWorld = gameFile.getWorld();
        //populate world with ants
        putAnts();
        //run the simulator on currentWorld
        //TODO update GUI or whatever
        runSimulator(numberOfRounds);
    }
    
    private void putAnts() throws Exception {
        for(int i = 0;i < currentWorld.getWorldTokens().size();i++){
            TerrainToken t = ((TerrainToken)currentWorld.getWorldTokens().get(i));
            if(t.isAnthill()){
                t.putAnt(antFactory.generateAnt(t.getAnthillColor(), t.getAnthillColor().getBrain(gameFile),t.getPosition(), currentWorld));
            }
        }
    }
    
    private void runSimulator(int numberOfRounds){
            for (int i = 0 ; i < numberOfRounds ; i++){
                currentWorld.executeOneRound();
            }
    }

    public static World getCurrentWorld() {
        return currentWorld;
    }
}