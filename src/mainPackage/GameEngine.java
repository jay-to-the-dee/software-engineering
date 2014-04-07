package mainPackage;

import antgame.model.World;
 import antgame.parsers.exceptions.ColumnNumberException;
 import antgame.parsers.exceptions.RowDoesntStartWithWhitespaceException;
 import antgame.parsers.exceptions.RowNumberException;
 import antgame.parsers.worldparser.ParseAndValidate;
 import antgame.parsers.worldparser.ReadFile;
 import antgame.world.requirements.*;
 import antgame.world.worldTokens.*;
 import java.awt.Dimension;
 import java.io.File;
 import java.io.IOException;
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
 
     public GameEngine()
     {
         executedRounds = 0;
         gameFile = new GameFile();
     }
 
     public void initEngine(File blackBrainFile, File redBrainFile) throws Exception
     {
         //loadWorld(worldFile);
 
         gameFile.setBlackBrain(AntBrainFactory.generateAntBrainFromString(ReadFile.readFile(blackBrainFile.getPath(), Charset.defaultCharset())));
         gameFile.setRedBrain(AntBrainFactory.generateAntBrainFromString(ReadFile.readFile(redBrainFile.getPath(), Charset.defaultCharset())));
 
         //set world in cache as current world
         currentWorld = gameFile.getWorld();
         //populate world with ants
         putAnts();
 
     }
 
     public void loadWorld(File worldFile) throws IOException, RowNumberException, RowDoesntStartWithWhitespaceException, ColumnNumberException, Exception
     {
         ParseAndValidate pav = new ParseAndValidate();
         List<CheckRequirement> ls = new LinkedList();
         //ls.add(new RequirementDimension(100, 100));
         ls.add(new RequirementBorder(1));
 
         String input = ReadFile.readFile(worldFile.getPath(), Charset.defaultCharset());
 
         gameFile.setWorld(WorldFactory.loadWorld(pav, input, ls));
     }
 
     public void loadRandomWorld()
     {
         List<CheckRequirement> ls = new LinkedList();
         ls.add(new RequirementDimension(100, 100));
         ls.add(new RequirementBorder(1));
 
         gameFile.setWorld(WorldFactory.generateRandomWorld(ls));
     }
 
     private void putAnts() throws Exception
     {
         for (int i = 0; i < currentWorld.getWorldTokens().size(); i++)
         {
             TerrainToken t = ((TerrainToken) currentWorld.getWorldTokens().get(i));
             if (t.isAnthill())
             {
                 t.putAnt(AntFactory.generateAnt(t.getAnthillColor(), t.getAnthillColor().getBrain(gameFile), t.getPosition(), currentWorld));
                 //break is for testing remove for final version
                 break;
                 //TODO need to remove this
             }
         }
     }
 
     public void runSimulator(int getToThisManyCompletedRuns)
     {
         for (int i = executedRounds; i < getToThisManyCompletedRuns; i++)
         {
             currentWorld.executeOneRound();
             executedRounds++;
         }
     }
 
     public static World getCurrentWorld()
     {
         return currentWorld;
     }
     
     public Dimension getWorldSize()
     {
         return new Dimension(gameFile.getWorld().getWidth(), gameFile.getWorld().getHeight());
     }
 }