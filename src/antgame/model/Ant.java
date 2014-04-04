/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.model;

import antgame.ant.conditions.Condition;
import antgame.ant.direction.Ahead;
import antgame.ant.direction.Direction;
import antgame.ant.direction.turndirection.LeftOrRight;
import antgame.ant.markers.Marker;
import antgame.model.Instruction;
import antgame.model.world.Color;

/**
 *
 * @author Main User
 */
public class Ant {
    private int ID;
    private Position position;
    private Color color;
    private int resting;
    private int facingDirection;
    private boolean hasFood;
    private Instruction[] brain;
    private int state;
    private boolean isAlive;
    private World world;
    
    public Ant(Color color,Instruction [] brain,Position position,World world){
        this.brain = new Instruction[brain.length];
        this.brain = brain;
        this.color = color;
        hasFood = false;
        facingDirection = 0;
        state = 0;
        isAlive = true;
        this.position = position;
        this.world = world;
        this.resting=0;
    }
    
    public void sense(Direction sensedir, int st1, int st2, Condition condition) throws Exception{//Go to state st1 if cond holds in sensedir;
                                                    //and to state st2 otherwise
        
        if (condition.checkCondition(senseTile(sensedir),this.color)){              
            state = st1;
        }else state = st2;
    }
    
    public TerrainToken senseTile(Direction sensedir){
        return sensedir.getTileInDirection(world,position,facingDirection);        
    }
    
    public void turn(int dir,LeftOrRight lor){
        this.facingDirection= lor.turn(dir);
    }
    
    public void mark(Marker marker, int state){
        marker.mark(world,this.position,this.color);
        this.state=state;
    }
    
    public void unmark(Marker marker,int state){
        marker.unmark(world,position,this.color);
        this.state = state;
    }
    
    public void pickUp(int state1,int state2){
        if (this.hasFood||!getAntLocation().hasFood()){
            this.state=state2;
        }
        else {
            getAntLocation().remove1food();
            hasFood=true;
            this.state=state1;
        }
    }
    
    public TerrainToken getAntLocation(){
        return (TerrainToken)world.getTokenAt(position.getXlocation(), position.getYlocation());
    }
    
    public void drop(int state){
        if(this.hasFood){
            getAntLocation().drop1food();
            hasFood=false;
        }
        this.state=state;
    }
    
    public void move(int state1,int state2) throws Exception{
        TerrainToken t = senseTile(new Ahead());
        if(t.isRocky()||t.getAnt()==null){
            this.state=state2;
        }
        else{
            t.putAnt(this);
            getAntLocation().removeAnt();
            this.position = new Position(this.senseTile(new Ahead()).getPosition().getXlocation(),this.senseTile(new Ahead()).getPosition().getYlocation());
            this.resting = 14;
            checkForSurroundedAnts(t.getPosition());
        }
    }
      public int adjacent_ants(Position p, Color c){
        int n=0;
        for (int i=0;i<6;i++){
            if(world.getAdjacentCell(i, position).hasAnt()){
                if(world.getAdjacentCell(i, position).getAnt().color ==c){
                    n++;
                }
            }
        }
        return n;
    }
    public void checkForSurroundedAnts(Position p){
        int foodParticles=3;
        if(world.getCell(p).hasAnt()){
            //a bit messy
            
            if(world.getCell(p).getAnt().adjacent_ants(this.position, this.getColour().otherColor(color))>=5){
                this.getAntLocation().removeAnt();
                if (this.isHasFood()){
                    foodParticles++;
                }
                for (int i =0;i<foodParticles;i++){
                    world.getCell(p).drop1food();
                }
                this.killAnt(); 
            }
        }
    }
    public void flip(int n, int state1, int state2){
        
    }
    
    //
    
    
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
        return facingDirection;
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
        this.facingDirection = direction;
    }

    public void setHasFood(boolean hasFood) {
        this.hasFood = hasFood;
    }

    public void setState(int state) {
        this.state = state;
    }
    
    
}
