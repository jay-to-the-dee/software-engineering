package antgame.ant.markers;

import antgame.world.worldTokens.TerrainToken;
import antgame.ant.color.Color;

/**
 *
 * @author ItsTheRai
 */
public class Marker3 implements Marker{

    @Override
    public void mark(TerrainToken t,Color c) {
        t.setMarkerAt(c,3);
    }

    @Override
    public void unmark(TerrainToken t, Color c) {
        t.removeMarkerAt(c, 3);
    }
    
    @Override
    public int getMarkerIndex() {
        return 3;
    }
}
