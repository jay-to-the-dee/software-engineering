/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.ant.markers;

import antgame.model.Position;
import antgame.model.TerrainToken;
import antgame.model.World;
import antgame.model.world.Color;

/**
 *
 * @author Main User
 */
public class Marker1 implements Marker{

    @Override
    public void mark(World w,Position p,Color c) {
        ((TerrainToken)w.getTokenAt(p.getXlocation(), p.getYlocation())).setMarkerAt(c,1);
    }

    @Override
    public int getMarker() {
return 1;
    }
    @Override
    public void unmark(World w, Position p, Color c) {
        ((TerrainToken)w.getTokenAt(p.getXlocation(), p.getYlocation())).removeMarkerAt(c, 1);
    }
    
}
