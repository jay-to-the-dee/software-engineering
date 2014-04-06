package antgame.ant.markers;

import java.util.Arrays;

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Arrays.hashCode(this.markers);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SingleAntColorMarkers other = (SingleAntColorMarkers) obj;
        if (!Arrays.equals(this.markers, other.markers)) {
            return false;
        }
        return true;
    }
        
        
    }