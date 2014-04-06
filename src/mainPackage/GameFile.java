/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainPackage;

import antgame.ant.instructions.Instruction;
import antgame.model.World;

/**
 *
 * @author Main User
 */
public class GameFile {
    private Instruction[] redBrain;
    private Instruction[] blackBrain;
    private World emptyWorld;
    private static final int NUMBER_OF_STEPS = 300000;

    public GameFile(Instruction[] redBrain, Instruction[] blackBrain, World world) {
        this.redBrain = redBrain;
        this.blackBrain = blackBrain;
        this.emptyWorld = world;
    }

    public GameFile()
    {
    }

    public Instruction[] getRedBrain() {
        return redBrain;
    }

    public void setRedBrain(Instruction[] redBrain) {
        this.redBrain = redBrain;
    }

    public Instruction[] getBlackBrain() {
        return blackBrain;
    }

    public void setBlackBrain(Instruction[] blackBrain) {
        this.blackBrain = blackBrain;
    }

    public World getWorld() {
        return emptyWorld;
    }

    public void setWorld(World world) {
        this.emptyWorld = world;
    }
    
    
}
