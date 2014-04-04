/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.ant.markers;

import antgame.model.Position;
import antgame.model.World;
import antgame.model.world.Color;

/**
 *
 * @author Main User
 */
public interface Marker {
    public void mark(World w,Position p,Color c);
    public void unmark(World w,Position p,Color c);
    public int getMarker();
}