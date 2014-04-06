package mainPackage;


import antgame.ant.instructions.Instruction;
import antgame.model.Ant;
import antgame.model.Position;
import antgame.model.World;
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

    public Ant generateAnt(Color color, Instruction[] antBrain,Position position,World world){
        return new Ant(color,antBrain,position,world);    //Instruction [] brain,int position,World world
        //return null;
    }    
}
