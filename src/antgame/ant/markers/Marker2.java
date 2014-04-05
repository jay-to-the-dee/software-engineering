package antgame.ant.markers;

import antgame.world.worldTokens.TerrainToken;
import antgame.ant.color.Color;

/**
 *
 * @author ItsTheRai
 */
public class Marker2 implements Marker{

    @Override
    public void mark(TerrainToken t,Color c) {
        t.setMarkerAt(c,2);
    }

    @Override
    public void unmark(TerrainToken t, Color c) {
        t.removeMarkerAt(c, 2);
    }
    
    @Override
    public int getMarkerIndex() {
        return 2;
    }
}
