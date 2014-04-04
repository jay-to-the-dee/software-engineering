package antgame.ant.conditions;

import antgame.ant.markers.Marker;
import antgame.model.TerrainToken;
import antgame.model.world.Color;

/**
 *
 * @author ItsTheRai
 */
public class FriendWithFoodCondition  implements Condition{

    @Override
    public boolean checkCondition(TerrainToken token, Color color, Marker m) {
        if(token.hasAnt()&&token.getAnt().getColour()==color &&token.getAnt().isHasFood()){
            return true;
        }
        else return false;
    }
}
