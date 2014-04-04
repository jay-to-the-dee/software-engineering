package antgame.model;

import antgame.ant.direction.Direction;
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
    
    //need to test functionality
    
    
    //xposition - index starting from 0 to width -1
    //yposition - index starting from 0 to heigth -1
    public WorldToken getTokenAt(int xposition, int yposition){
        return getWorldTokens().get(yposition*getWidth()+xposition);
    }
    public TerrainToken getCell(Position p){
        return (TerrainToken)this.getTokenAt(p.getXlocation(), p.getYlocation());
    }
    public TerrainToken getAdjacentCell(int direction,Position position){
        TerrainToken t =new TerrainToken(false,position,null,false,null);
        switch(direction){
            case 0:t= (TerrainToken)getTokenAt(position.getXlocation()+1, position.getYlocation());
            case 1:
                if (position.getYlocation()%2==0){
                t=(TerrainToken)getTokenAt(position.getXlocation(), position.getYlocation()+1);
                }
                else t= (TerrainToken)getTokenAt(position.getXlocation()+1, position.getYlocation()+1);
            case 2:
                if (position.getYlocation()%2==0){
                    t=(TerrainToken)getTokenAt(position.getXlocation()-1, position.getYlocation()+1);
                    }
                else t= (TerrainToken)getTokenAt(position.getXlocation(), position.getYlocation()+1);
            case 3:
                t= (TerrainToken)getTokenAt(position.getXlocation()-1, position.getYlocation());
            case 4:
                if (position.getYlocation()%2==0){
                    t=(TerrainToken)getTokenAt(position.getXlocation()-1, position.getYlocation()-1);
                    }
                else t= (TerrainToken)getTokenAt(position.getXlocation(), position.getYlocation()-1);
            case 5:
                if (position.getYlocation()%2==0){
                    t=(TerrainToken)getTokenAt(position.getXlocation(), position.getYlocation()-1);
                    }
                else t= (TerrainToken)getTokenAt(position.getXlocation()+1, position.getYlocation()-1);
        }
        return t;
    }
}