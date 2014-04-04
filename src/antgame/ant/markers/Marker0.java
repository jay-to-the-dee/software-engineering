package antgame.ant.markers;

import antgame.model.TerrainToken;
import antgame.model.world.Color;

/**
 *
 * @author ItsTheRai
 */
public class Marker0 implements Marker{

    @Override
    public void mark(TerrainToken t,Color c) {
        t.setMarkerAt(c,0);
    }

    @Override
    public void unmark(TerrainToken t, Color c) {
        t.removeMarkerAt(c, 0);
    }
}
