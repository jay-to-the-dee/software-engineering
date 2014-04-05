package antgame.model;

import antgame.ant.direction.Direction;
import antgame.instructions.Instruction;
import antgame.model.world.Color;

/**
 *
 * @author ItsTheRai
 */
public class Ant {
    private int ID;
    private Position position;
    private final Color color;
    private int resting;
    private int facingDirection;
    private boolean hasFood;
    private Instruction[] brain;
    private int state;
    private boolean isAlive;
    private final World world;
    
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
    
    public TerrainToken senseTile(Direction sensedir){
        return sensedir.getTileInDirection(world,position,facingDirection);        
    }
    
    public void setPosition(int x,int y){
        position.setXlocation(x);
        position.setYlocation(y);
    }
    
    public Instruction getCurrentInstruction(){
        return getInstruction(state);
    }
    
    public Instruction getInstruction(int s){
        return brain[s];
    }
    
    public boolean isAlive(){
        return this.isAlive;
    }
    
    public TerrainToken getAntLocation(){
        return (TerrainToken)world.getTokenAt(position.getXlocation(), position.getYlocation());
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

    public void rest(){
        if(resting>0){
            resting--;
        }
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
    
    public boolean isResting(){
        return resting>0;
    }

    public void setResting(int RESTING) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
