/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.model;

import antgame.model.Instruction;
import antgame.model.TerrainToken;
import antgame.ant.conditions.checkCondition;
import antgame.ant.conditions.Color;
import antgame.ant.direction.Direction; 

/**
 *
 * @author Main User
 */
public class Ant {
    private int ID;
    private int position;
    private Color color;
    private int resting;
    private int direction;
    private boolean hasFood;
    private Instruction[] brain;
    private int state;
    private boolean isAlive;
    private static World world;
    
    public Ant(Color color,Instruction [] brain,int position,World world){
        this.brain = new Instruction[brain.length];
        this.brain = brain;
        this.color = color;
        hasFood = false;
        direction = 0;
        state = 0;
        isAlive = true;
        this.position = position;
        this.world = world;
    }
    
    public void sense(Direction sensedir, int st1, int st2, checkCondition condition) throws Exception{//Go to state st1 if cond holds in sensedir;
                      getDirection();                              //and to state st2 otherwise
        
        if (condition.checkCondition(senseTile(sensedir),this.color)){              
            state = st1;
        }else state = st2;
    }
    
    public void mark(){
        
    }
    
    public void unmark(){
        
    }
    
    public void pickUp(){
    }
    public void turn(){
        
    }
    public void move(){
        
    }
    public void flip(){
        
    }
    
    //not done yet
    public TerrainToken senseTile(Direction sensedir){
        sensedir.getTileInDirection(world,position);
        return null;
        
    }
    public void killAnt(){
        isAlive=false;
    }
    public int getID() {
        return ID;
    }

    public Color getColour() {
        return color;
    }

    public int getResting() {
        return resting;
    }

    public int getDirection() {
        return direction;
    }

    public boolean isHasFood() {
        return hasFood;
    }

    public Instruction[] getBrain() {
        return brain;
    }

    public int getState() {
        return state;
    }

    public void setResting(int resting) {
        this.resting = resting;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setHasFood(boolean hasFood) {
        this.hasFood = hasFood;
    }

    public void setState(int state) {
        this.state = state;
    }
    
    
}
