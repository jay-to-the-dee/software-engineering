/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.ant.color;

import antgame.ant.instructions.Instruction;
import mainPackage.GameFile;

/**
 *
 * @author ItsTheRai
 */
public interface Color {
    public Color otherColor(Color c);
    public Instruction[] getBrain(GameFile f);
    
}