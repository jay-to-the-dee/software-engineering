/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainPackage;

import antgame.ant.instructions.InstructionSet;
import antgame.model.World;

/**
 *
 * @author ItsTheRai
 */
public class GameFile {
    private InstructionSet[] redBrain;
    private InstructionSet[] blackBrain;
    private World emptyWorld;
    private static final int NUMBER_OF_STEPS = 300000;

    /**
     *
     * @param redBrain InstructionSet[] representing the red ant brain
     * @param blackBrain InstructionSet[] representing the black ant brain
     * @param world World object
     */
    public GameFile(InstructionSet[] redBrain, InstructionSet[] blackBrain, World world) {
        this.redBrain = redBrain;
        this.blackBrain = blackBrain;
        this.emptyWorld = world;
    }

    public GameFile()
    {
    }

    /**
     *
     * @return red ant brain
     */
    public InstructionSet[] getRedBrain() {
        return redBrain;
    }

    /**
     *
     * @param redBrain InstructionSet[] representing the red ant brain
     */
    public void setRedBrain(InstructionSet[] redBrain) {
        this.redBrain = redBrain;
    }

    /**
     *
     * @return black ant brain
     */
    public InstructionSet[] getBlackBrain() {
        return blackBrain;
    }

    /**
     *
     * @param blackBrain InstructionSet[] representing the black ant brain
     */
    public void setBlackBrain(InstructionSet[] blackBrain) {
        this.blackBrain = blackBrain;
    }

    /**
     *
     * @return returns the current World object
     */
    public World getWorld() {
        return emptyWorld;
    }

    /**
     *set the current world to world
     * @param world World object
     */
    public void setWorld(World world) {
        this.emptyWorld = world;
    }
    
    
}
