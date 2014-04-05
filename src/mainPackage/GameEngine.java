package mainPackage;


import antgame.instructions.Instruction;
import antgame.model.Ant;
import antgame.model.TerrainToken;
import antgame.model.World;
import antgame.parsers.worldparser.ReadFile;
import antgame.parsers.worldparser.SomeException;
import antgame.parsers.worldparser.SymbolNotFoundException;
import antgame.parsers.worldparser.TokenSizeMismatchException;
import antgame.textworldgenerator.GenRandomMap;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ItsTheRai
 */
public class GameEngine {
    private AntFactory antFactory;
    private WorldFactory worldFactory;
    private List<World> currentGameWorlds;
    private AntBrainFactory brainFactory;
    private List<Instruction[]> currentBrains;
    private int worldSize = 150;
    /**
     *
     */
    public GameEngine(){
        antFactory = new AntFactory();
        worldFactory = new WorldFactory();
        brainFactory = new AntBrainFactory();
        currentGameWorlds = new ArrayList<>();
        currentBrains = new ArrayList<Instruction[]>();
    }
    
    public void run() throws IOException, Exception{
        Instruction[] redBrain = brainFactory.generataAntBrainFromString(ReadFile.readFile("./data/brains/uni-examples/sampleant.brain",Charset.defaultCharset()));
        currentGameWorlds.add(worldFactory.generateRandomWorld(null, new GenRandomMap(worldSize)));
        for (int i=0;i<currentGameWorlds.get(0).getWorldTokens().size();i++){
            TerrainToken t = ((TerrainToken)currentGameWorlds.get(0).getWorldTokens().get(i));
            if(t.isAnthill()){
                t.putAnt(new Ant(t.getAnthillColor()
                                ,redBrain
                                ,t.getPosition()
                                ,((World)currentGameWorlds.get(0)))
                    );
            }
        }
        World w = (World)currentGameWorlds.get(0);
        for (int j=0;j<300000;j++){
            w.executeOneRound();
        }
    }
}