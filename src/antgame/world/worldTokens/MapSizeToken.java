package antgame.world.worldTokens;

import java.util.Objects;

/**
 *
 * @author ItsTheRai
 */
public class MapSizeToken extends WorldToken{
    private int size;
    
    public MapSizeToken(int size){
        this.size = size;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.size;
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
        final MapSizeToken other = (MapSizeToken) obj;
        if (this.size != other.size) {
            return false;
        }
        return true;
    }

    
    
    
    
    public int getSize(){
        return size;
    }
        //public int getSizeAsInt(){
        //    return Integer.parseInt(size);
        //}
}
