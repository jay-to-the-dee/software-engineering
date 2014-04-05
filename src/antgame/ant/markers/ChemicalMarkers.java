package antgame.ant.markers;

import antgame.ant.color.Color;
import antgame.model.Position;

/**
 *
 * @author ItsTheRai
 */
public class ChemicalMarkers
{
    SingleAntColorMarkers blackAntsmarker;
    SingleAntColorMarkers redAntsmarker;
    public ChemicalMarkers(){
        blackAntsmarker = new SingleAntColorMarkers();
        redAntsmarker = new SingleAntColorMarkers();
    }
    public void setMarkersAt(Position p,Color c){
        
    }

    public SingleAntColorMarkers getBlackAntsmarker() {
        return blackAntsmarker;
    }

    public SingleAntColorMarkers getRedAntsmarker() {
        return redAntsmarker;
    }
    
}