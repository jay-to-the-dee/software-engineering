/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.model;

/**
 *
 * @author Main User
 */
public class SingleAntColorMarkers
    {
        private final boolean[] markers;
        private static final int numberOfMarkers = 6;

        public SingleAntColorMarkers()
        {
            markers = new boolean[numberOfMarkers];
        }

        public boolean[] getMarkers()
        {
            return markers;
        }

        public void setMarker(int index, boolean value)
        {
            markers[index] = value;
        }
        
    }