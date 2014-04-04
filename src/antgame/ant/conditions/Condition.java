package antgame.ant.conditions;

import antgame.ant.markers.Marker;
import antgame.model.TerrainToken;
import antgame.model.world.Color;

/**
 *
 * @author ItsTheRai
 */
public interface Condition {

    /**
     *
     * @param token
     * @param color
     * @return
     */
    public boolean checkCondition(TerrainToken token,Color color,Marker m);
}