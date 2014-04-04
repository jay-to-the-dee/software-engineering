package antgame.ant.markers;
import antgame.model.TerrainToken;
import antgame.model.world.Color;

/**
 *
 * @author ItsTheRai
 */
public interface Marker {
    public void mark(TerrainToken t,Color c);
    public void unmark(TerrainToken t,Color c);
}