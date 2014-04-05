package antgame.ant.markers;

/**
 *
 * @author Jonathan Dilks
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