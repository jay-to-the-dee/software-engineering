package antgame.ant.markers;

import java.util.Arrays;

/**
 * This represents the chemical markers for a single ant team
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

    /**
     *
     * @param index the index of the marker to be set
     * @param value The boolean value the marker is to be set to
     */
    public void setMarker(int index, boolean value)
    {
        markers[index] = value;
    }

    public int getSetMarkersCount()
    {
        int count = 0;
        for (int i = 0; i < markers.length; i++)
        {
            if (markers[i] == true)
            {
                count++;
            }
        }
        return count;
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
