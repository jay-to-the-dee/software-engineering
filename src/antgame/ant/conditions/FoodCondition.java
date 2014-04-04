package antgame.ant.conditions;

import antgame.ant.markers.Marker;
import antgame.model.TerrainToken;
import antgame.model.world.Color;

/**
 *
 * @author ItsTheRai
 */
public class FoodCondition implements Condition{

    @Override
    public boolean checkCondition(TerrainToken token, Color color, Marker m) {
        return token.hasFood();
    }
}
