package antgame.ant.conditions;

import antgame.ant.markers.Marker;
import antgame.world.worldTokens.TerrainToken;
import antgame.ant.color.Color;

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