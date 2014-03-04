/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package antgame.parsers.worldparser;

import java.util.List;

/**
 *
 * @author Main User
 */
public interface CheckRequirement {
    
    public abstract boolean checkRequirements(int xsize,int ysize,List<WorldToken> tokens) throws SomeException;
}
