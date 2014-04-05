package mainPackage;


import antgame.ant.instructions.Instruction;
import antgame.model.Ant;
import antgame.world.worldTokens.TerrainToken;
import antgame.world.worldTokens.World;
import antgame.world.requirements.CheckRequirement;
import antgame.parsers.worldparser.ParseAndValidate;
import antgame.parsers.worldparser.ReadFile;
import antgame.world.requirements.RequirementBorder;
import antgame.parsers.exceptions.SomeException;
import antgame.parsers.exceptions.SymbolNotFoundException;
import antgame.parsers.exceptions.TokenSizeMismatchException;
import antgame.world.textworldgenerator.GenRandomMap;
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
        currentBrains = new ArrayList<>();
    }
    
    public void run() throws IOException, Exception{
        List<CheckRequirement> list = new ArrayList<>();
        list.add(new RequirementBorder(1));
        Instruction[] redBrain = brainFactory.generataAntBrainFromString(ReadFile.readFile("./data/brains/uni-examples/sampleant.brain",Charset.defaultCharset()));
        currentGameWorlds.add(worldFactory.loadWorld(new ParseAndValidate(),
                ReadFile.readFile("./data/worlds/uni-examples/a.world",Charset.defaultCharset()),
                list));
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
        //run the simulation
        for (int j=0;j<1000;j++){
            w.executeOneRound();
        }
    }
}