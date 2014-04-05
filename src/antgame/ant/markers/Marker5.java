package antgame.ant.markers;

import antgame.world.worldTokens.TerrainToken;
import antgame.ant.color.Color;

/**
 *
 * @author ItsTheRai
 */
public class Marker5 implements Marker{

    @Override
    public void mark(TerrainToken t,Color c) {
        t.setMarkerAt(c,5);
    }

    @Override
    public void unmark(TerrainToken t, Color c) {
        t.removeMarkerAt(c, 5);
    }
    
    @Override
    public int getMarkerIndex() {
        return 5;
    }
}
