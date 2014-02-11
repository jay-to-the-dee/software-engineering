/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package worldparser;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Main User
 */
public class World {
    private int width;
    private int height;
    private List<Token> worldTokens = new ArrayList<>();
    
    
    public World(int size, List<Token> world){
        width = Integer.parseInt(String.valueOf(size).substring(0,  String.valueOf(size).length()/2-1));
        height = Integer.parseInt(String.valueOf(size).substring(String.valueOf(size).length()/2,String.valueOf(size).length()));
        worldTokens=world;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Token> getWorldTokens() {
        return worldTokens;
    }
    
}
