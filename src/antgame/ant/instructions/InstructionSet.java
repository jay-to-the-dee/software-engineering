/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.ant.instructions;

import antgame.model.Ant;

/**
 *
 * @author ItsTheRai
 */
public abstract class InstructionSet {

    /**
     * A superclass of all instructions
     */
    public InstructionSet() {
    }
    public abstract void executeInstruction(Ant ant);
}
