package antgame.model;

import antgame.ant.color.Color;
import antgame.ant.direction.sensedireciton.Direction;
import antgame.ant.instructions.Instruction;
import antgame.ant.instructions.InstructionSet;
import antgame.world.worldTokens.TerrainToken;

/**
 *
 * @author ItsTheRai
 */
public class Ant {
    private int ID=0;
    private static int antid = 0;
    private Position position;
    private final Color color;
    private int resting;
    private int facingDirection;
    private boolean hasFood;
    private InstructionSet[] brain;
    private int state;
    private boolean isAlive;
    private final World world;
    
    public Ant(Color color,InstructionSet [] brain,Position position,World world){
        this.brain = new InstructionSet[brain.length];
        this.brain = brain;
        this.color = color;
        hasFood = false;
        facingDirection = 0;
        state = 0;
        isAlive = true;
        this.position = position;
        this.world = world;
        this.resting=0;
        this.ID=antid++;
    }
    
    public TerrainToken senseTile(Direction sensedir){
        return sensedir.getTileInDirection(world,position,facingDirection);
    }
    
    public void setPosition(int x,int y){
        position.setXlocation(x);
        position.setYlocation(y);
    }
    
    public InstructionSet getCurrentInstruction(){
        return getInstruction(state);
    }
    
    public InstructionSet getInstruction(int s){
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
            
            if(world.getCell(p).getAnt().adjacent_ants(this.position, this.getColour().otherColor())>=5){
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
        this.getAntLocation().removeAnt();
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

    public InstructionSet[] getBrain() {
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
        resting = RESTING;
    }
}
