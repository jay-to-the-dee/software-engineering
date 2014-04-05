package antgame.world.worldTokens;

import antgame.model.Position;
import antgame.ant.color.ColorBlack;

/**
 *
 * @author ItsTheRai
 */
public class BlackAnthillToken extends AnthillToken{

    public BlackAnthillToken(Position p) {
        //Color c= new ColorBlack();
        //ColorBlack c = new Color();
        super(p, new ColorBlack());
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof BlackAnthillToken){
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
        }
        else return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }
    
    

    
}
