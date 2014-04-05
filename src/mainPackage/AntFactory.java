package mainPackage;


import antgame.ant.instructions.Instruction;
import antgame.model.Ant;
import antgame.model.Position;
import antgame.world.worldTokens.World;
import antgame.ant.color.Color;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ItsTheRai
 */
public class AntFactory {
    public AntFactory(){
    }

    public List<Ant> generateAnts(int numberOfAntsPerTeam,int numberOfColors, Instruction[] brain,Position position,World world){
        int antID=0;
        List<Ant> list = new ArrayList<Ant>();
        for(int i=0;i<numberOfAntsPerTeam;i++){
            for (int j=0;j<numberOfColors;j++){
                Color currColor = new Color();
                //TODO
                
                
            list.add(generateAnt(currColor, brain,position,world));
            }
        }return list;
    }
    public Ant generateAnt(Color color, Instruction[] antBrain,Position position,World world){
        return new Ant(color,antBrain,position,world);    //Instruction [] brain,int position,World world
        //return null;
    }    
}
