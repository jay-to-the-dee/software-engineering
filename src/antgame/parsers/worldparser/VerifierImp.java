/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package antgame.parsers.worldparser;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rg293
 */
public class VerifierImp implements Verifier{

    @Override
    public World verify(List<Token> world,WorldRequirements requirements) {
        
        //if success 
        //make sure this always works
        int xsize = ((MapSizeToken)world.get(0)).getSize();
        int ysize = ((MapSizeToken)world.get(1)).getSize();
        //////////////////////////////
        List l = new ArrayList<>();
        for (int i = 2; i<world.size();i++){
            l.add(world.get(i));
        }
        return new World(xsize,ysize,l);
        //else trow exception
        
    }
    
}
