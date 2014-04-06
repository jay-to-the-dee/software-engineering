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
public class FoeMarkerCondition  implements Condition{

    //TODO may need to change this according to the spec
    @Override
    public boolean checkCondition(TerrainToken token, Color color, Marker m) {
        //may need refactoring
        boolean foemarker = false;
        if (color instanceof ColorRed){
            for(int i =0; i < token.getMarkers().getBlackAntsmarker().getMarkers().length;i++){
                if(token.getMarkers().getBlackAntsmarker().getMarkers()[i]==true){
                    foemarker = true;
                }
            }
        }
        else if (color instanceof ColorBlack){
            for(int i =0; i < token.getMarkers().getRedAntsmarker().getMarkers().length;i++){
                if(token.getMarkers().getRedAntsmarker().getMarkers()[i]==true){
                    foemarker = true;
                }
            }
        }
        return foemarker;
    }
}
