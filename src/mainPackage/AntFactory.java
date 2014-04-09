package mainPackage;


import antgame.ant.color.Color;
import antgame.ant.instructions.Instruction;
import antgame.ant.instructions.InstructionSet;
import antgame.model.Ant;
import antgame.model.Position;
import antgame.model.World;
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

    /**
     *
     * @param color Color of the ant to be generated
     * @param antBrain InstructionSet[] representing the brain of the ant
     * @param position Location of the ant in the world
     * @param world The world the ant belongs to
     * @return An Ant object with the required parameters
     */
    public static Ant generateAnt(Color color, InstructionSet[] antBrain,Position position,World world){
        return new Ant(color,antBrain,position,world);    //Instruction [] brain,int position,World world
        //return null;
    }    
}
