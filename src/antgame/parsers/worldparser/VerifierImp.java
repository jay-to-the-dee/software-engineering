/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package antgame.parsers.worldparser;

import antgame.model.World;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rg293
 */
public class VerifierImp implements Verifier{

    @Override
    public World verify(int xsize,int ysize,List<WorldToken> world,List<CheckRequirement> requirements) {
        
        //if success 
        //make sure this always works
        //int xsize = ((MapSizeToken)world.get(0)).getSize();
        //int ysize = ((MapSizeToken)world.get(1)).getSize();
        //////////////////////////////
        for(CheckRequirement req:requirements){
            try {
                req.checkRequirements(xsize,ysize,world);
            } catch (SomeException ex) {
                System.out.println("verifier error");
            }
        }
        return null;//new World();//xsize,ysize,l);
        //else trow exception
    }
}
