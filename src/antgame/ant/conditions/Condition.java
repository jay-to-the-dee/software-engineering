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
     * @param token The WorldToken object whose condition is to be checked
     * @param color The color of the ant checking the condition
     * @param m A marker object that is to be sensed, null if not a sense operation
     * @return returns true if the condition is met, false otherwise
     */
    public boolean checkCondition(TerrainToken token,Color color,Marker m);
}