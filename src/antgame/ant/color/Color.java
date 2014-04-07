/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.ant.color;

import antgame.ant.instructions.Instruction;
import antgame.ant.instructions.InstructionSet;
import mainPackage.GameFile;

/**
 *
 * @author ItsTheRai
 */
public interface Color {
    public Color otherColor();
    public InstructionSet[] getBrain(GameFile f);

    @Override
    public boolean equals(Object obj);

    @Override
    public int hashCode();
    
}
