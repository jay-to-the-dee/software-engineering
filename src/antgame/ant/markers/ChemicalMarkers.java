/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.ant.markers;

import antgame.model.world.Color;
import antgame.model.Position;

/**
 *
 * @author Main User
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