package antgame.model;

import antgame.parsers.worldparser.WorldToken;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Main User
 */
public class World {
    private int width;
    private int height;
    private List<WorldToken> worldTokens = new ArrayList<>();
    
    
    public World(int xsize,int ysize, List<WorldToken> world){
        //needs refactoring
        width = xsize;
        height = ysize;
        worldTokens=world;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<WorldToken> getWorldTokens() {
        return worldTokens;
    }
}
