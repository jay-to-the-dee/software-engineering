package antgame.ant.conditions;

import antgame.ant.markers.Marker;
import antgame.world.worldTokens.TerrainToken;
import antgame.ant.color.Color;

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