package antgame.ant.markers;

import java.util.Objects;

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

    public SingleAntColorMarkers getBlackAntsmarker() {
        return blackAntsmarker;
    }

    public SingleAntColorMarkers getRedAntsmarker() {
        return redAntsmarker;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.blackAntsmarker);
        hash = 53 * hash + Objects.hashCode(this.redAntsmarker);
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
        final ChemicalMarkers other = (ChemicalMarkers) obj;
        if (!Objects.equals(this.blackAntsmarker, other.blackAntsmarker)) {
            return false;
        }
        if (!Objects.equals(this.redAntsmarker, other.redAntsmarker)) {
            return false;
        }
        return true;
    }
    
}