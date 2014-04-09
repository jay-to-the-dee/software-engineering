package antgame.model;

import antgame.ant.color.Color;
import antgame.ant.direction.sensedireciton.Direction;
import antgame.ant.instructions.InstructionSet;
import antgame.world.worldTokens.TerrainToken;

/**
 *
 * @author ItsTheRai
 */
public class Ant {

    private final int ID;
    private static int antid = 0;
    private final Position position;
    private final Color color;
    private int resting;
    private int facingDirection;
    private boolean hasFood;
    private InstructionSet[] brain;
    private int state;
    private boolean isAlive;
    private final World world;

    /**
     *initialise an ant in the world with facing direction 0, no food, in state 0
     * @param color color of the ant
     * @param brain InstructionSet[] object representing the brain of the ant
     * @param position position of the ant in the world
     * @param world The World object the ant belongs to
     */
    public Ant(Color color, InstructionSet[] brain, Position position, World world) {
        this.brain = new InstructionSet[brain.length];
        this.brain = brain;
        this.color = color;
        hasFood = false;
        facingDirection = 0;
        state = 0;
        isAlive = true;
        this.position = position;
        this.world = world;
        this.resting = 0;
        this.ID = antid++;
    }

    /**
     *
     * @param sensedir Direciton object 
     * @return A TerrainToken object in the sensed direction of the ant
     */
    public TerrainToken senseTile(Direction sensedir) {
        return sensedir.getTileInDirection(world, position, facingDirection);
    }

    /**
     *change the position of the ant
     * @param x x coordinate
     * @param y y coordinate
     */
    public void setPosition(int x, int y) {
        position.setXlocation(x);
        position.setYlocation(y);
    }

    /**
     *
     * @return InstructionSet object to be executed next
     */
    public InstructionSet getCurrentInstruction() {
        return getInstruction(state);
    }

    /**
     *
     * @param s State of the ant brain
     * @return InstructionSet object for state s
     */
    public InstructionSet getInstruction(int s) {
        return brain[s];
    }

    /**
     *
     * @return True if ant is alive, false otherwise
     */
    public boolean isAlive() {
        return this.isAlive;
    }

    /**
     *
     * @return The ToerrainToken the ant is located on
     */
    public TerrainToken getAntLocation() {
        return world.getTokenAt(position.getXlocation(), position.getYlocation());
    }

    /**
     *
     * @param c Color object
     * @return An integer representing the number of ants of the opposite color surrounding the current ant
     */
    public int adjacent_ants(Color c) {
        int n = 0;
        for (int i = 0; i < 6; i++) {
            if (world.getAdjacentCell(i, this.position).hasAnt()) {
                if (world.getAdjacentCell(i, this.position).getAnt().color.equals(c)) {
                    n++;
                }
            }
        }
        return n;
    }

    /**
     *checks if the ant is surrounded by ants of the opposite color and hills off the ant if it is
     * also removes it from the TerrainToken object it was on 
     */
    public void checkForSurroundedAnts() {
        int foodParticles = 3;
        if (world.getCell(this.position).hasAnt()) {
            //a bit messy

            if (adjacent_ants(this.getColour().otherColor()) >= 2) {
                if (this.isHasFood()) {
                    foodParticles++;
                }
                for (int i = 0; i < foodParticles; i++) {
                    world.getCell(this.position).drop1food();
                }
                this.killAnt();
            }
        }
    }

    /**
     *
     /sets the ants isAlive field to false
     * removes the ant from its TerrainToken
     */
    public void killAnt() {
        this.getAntLocation().removeAnt();
        isAlive = false;
    }

    /**
     *
     * @return ant ID
     */
    public int getID() {
        return ID;
    }

    /**
     *
     * @return ant Color object
     */
    public Color getColour() {
        return color;
    }

    /**
     *
     * @return field resting 
     */
    public int getResting() {
        return resting;
    }

    /**
     *
     * @return field facingDirection
     */
    public int getDirection() {
        return facingDirection;
    }

    /**
     *
     * @return field hasFood
     */
    public boolean isHasFood() {
        return hasFood;
    }

    /**
     *
     * @return field brain
     */
    public InstructionSet[] getBrain() {
        return brain;
    }

    /**
     *
     * @return flied state
     */
    public int getState() {
        return state;
    }

    /**
     * decrements the resting field by one if it is higher than 0
     */
    public void rest() {
        if (resting > 0) {
            resting--;
        }
    }

    /**
     *change the ants facing direction to direction
     * @param direction integer representing the direction the ant is currently facing 
     */
    public void setDirection(int direction) {
        this.facingDirection = direction;
    }

    /**
     *change the hasFood predicate of the ant to hasFood
     * @param hasFood boolean 
     */
    public void setHasFood(boolean hasFood) {
        this.hasFood = hasFood;
    }

    /**
     *change the state of the ant
     * @param state new state
     */
    public void setState(int state) {
        this.state = state;
    }

    /**
     * check if the ant is still resting
     * @return true if resting is higher than 0, false otherwise
     */
    public boolean isResting() {
        return resting > 0;
    }

    /**
     * set field resting to RESTING
     * @param RESTING integer
     */
    public void setResting(int RESTING) {
        resting = RESTING;
    }
}
