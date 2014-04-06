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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.xlocation;
        hash = 17 * hash + this.ylocation;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.xlocation != other.xlocation) {
            return false;
        }
        if (this.ylocation != other.ylocation) {
            return false;
        }
        return true;
    }
    
    
}
