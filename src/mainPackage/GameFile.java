/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainPackage;

import antgame.ant.instructions.Instruction;
import antgame.ant.instructions.InstructionSet;
import antgame.model.World;

/**
 *
 * @author Main User
 */
public class GameFile {
    private InstructionSet[] redBrain;
    private InstructionSet[] blackBrain;
    private World emptyWorld;
    private static final int NUMBER_OF_STEPS = 300000;

    public GameFile(InstructionSet[] redBrain, InstructionSet[] blackBrain, World world) {
        this.redBrain = redBrain;
        this.blackBrain = blackBrain;
        this.emptyWorld = world;
    }

    public GameFile()
    {
    }

    public InstructionSet[] getRedBrain() {
        return redBrain;
    }

    public void setRedBrain(InstructionSet[] redBrain) {
        this.redBrain = redBrain;
    }

    public InstructionSet[] getBlackBrain() {
        return blackBrain;
    }

    public void setBlackBrain(InstructionSet[] blackBrain) {
        this.blackBrain = blackBrain;
    }

    public World getWorld() {
        return emptyWorld;
    }

    public void setWorld(World world) {
        this.emptyWorld = world;
    }
    
    
}
