
import antgame.model.Ant;
import antgame.instructions.InstructionSet;
import antgame.model.Position;
import antgame.model.World;
import antgame.model.world.Color;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Main User
 */
public class AntFactory {
    private ArrayList<Ant> ants;
    public AntFactory(){
    }

    public List<Ant> generateAnts(int numberOfAntsPerTeam,int numberOfColors, InstructionSet[] brain,Position position,World world){
        int antID=0;
        List<Ant> list = new ArrayList<Ant>();
        for(int i=0;i<numberOfAntsPerTeam;i++){
            for (int j=0;j<numberOfColors;j++){
                Color currColor = new Color();
                //to do
                
                
            list.add(generateAnt(currColor, brain,position,world));
            
            
            
            }
        }return list;
    }
    public Ant generateAnt(Color color, InstructionSet[] antBrain,Position position,World world){
        return new Ant(color,antBrain,position,world);    //Instruction [] brain,int position,World world
        //return null;
    }
   

    public ArrayList<Ant> getAnts() {
        return ants;
    }

    public void addBlackAnts(Ant ant) {
        this.ants.add(ant);
    }
    
    
}
