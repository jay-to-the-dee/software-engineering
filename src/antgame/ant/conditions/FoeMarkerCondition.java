package antgame.ant.conditions;

import antgame.ant.markers.Marker;
import antgame.model.TerrainToken;
import antgame.model.world.Color;
import antgame.model.world.ColorBlack;
import antgame.model.world.ColorRed;

/**
 *
 * @author ItsTheRai
 */
public class FoeMarkerCondition  implements Condition{

    //TODO may need to change this according to the spec
    @Override
    public boolean checkCondition(TerrainToken token, Color color, Marker m) {
        //may need refactoring
        if (color instanceof ColorRed){
                return token.getMarkers().getBlackAntsmarker().getMarkers()[m.getMarkerIndex()];
        }
        else if (color instanceof ColorBlack){
                return token.getMarkers().getRedAntsmarker().getMarkers()[m.getMarkerIndex()];
        }
        else return false;
    }
}
