package antgame.model;

/**
 *
 * @author ItsTheRai
 */
public class Position {
    private int xlocation;
    private int ylocation;
    public Position(int x, int y){
        xlocation = x;
        ylocation = y;
    }

    public int getXlocation() {
        return xlocation;
    }

    public int getYlocation() {
        return ylocation;
    }
    public void setXlocation(int x){
        xlocation = x;
    }
    
    public void setYlocation(int y){
        ylocation = y;
    }
    
}
