package antgame.ant.conditions;

import antgame.ant.markers.Marker;
import antgame.world.worldTokens.TerrainToken;
import antgame.ant.color.Color;
import antgame.ant.color.ColorBlack;
import antgame.ant.color.ColorRed;

/**
 *
 * @author ItsTheRai
 */
public class MarkerCondition  implements Condition{

    @Override
    public boolean checkCondition(TerrainToken token, Color color, Marker m) {
        if (color instanceof ColorRed){
                return token.getMarkers().getRedAntsmarker().getMarkers()[m.getMarkerIndex()];
        }
        else if (color instanceof ColorBlack){
                return token.getMarkers().getBlackAntsmarker().getMarkers()[m.getMarkerIndex()];
        }
        else return false;
    }
}