package antgame.ant.markers;
import antgame.world.worldTokens.TerrainToken;
import antgame.ant.color.Color;

/**
 *
 * @author ItsTheRai
 */
public interface Marker {
    public void mark(TerrainToken t,Color c);
    public void unmark(TerrainToken t,Color c);
    public int getMarkerIndex();
}