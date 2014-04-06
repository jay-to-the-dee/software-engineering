package antgame.world.worldTokens;

import antgame.ant.markers.ChemicalMarkers;
import antgame.ant.markers.Marker;
import antgame.model.Ant;
import antgame.model.Position;
import antgame.ant.color.Color;
import antgame.ant.color.ColorBlack;
import antgame.ant.color.ColorRed;
import antgame.model.Food;
import java.util.Objects;
import java.util.Stack;

/**
 *
 * @author ItsTheRai
 */
public class TerrainToken extends WorldToken{
    public Position position;
    private Ant ant;
    private final boolean rocky;
    private final Stack food;
    private final boolean anthill;
    private final Color anthillColor;
    private ChemicalMarkers markers;
    public TerrainToken (boolean predicate, Position p,Stack food, boolean anthill,Color anthillColor){
        rocky=predicate;
        position = p;
        this.food = food;
        this.anthill = anthill;
        this.anthillColor=anthillColor;
        markers = new ChemicalMarkers();
    }
    
    
    public ChemicalMarkers getMarkers() {
        return markers;
    }

    public void setMarkers(ChemicalMarkers markers) {
        this.markers = markers;
    }
    public void mark(Color c,Marker m){
        m.mark(this, c);
    }
        
    public void setMarkerAt(Color c,int m){
        //find a better way of doing this
        //todo
       if(c instanceof ColorRed){
           this.getMarkers().getRedAntsmarker().setMarker(m, true);
       }
       else if(c instanceof ColorBlack){
           this.getMarkers().getBlackAntsmarker().setMarker(m, true);
       }
    }
    public void removeMarkerAt(Color c,int m){
        if(c instanceof ColorRed){
           this.getMarkers().getRedAntsmarker().setMarker(m, false);
       }
       else if(c instanceof ColorBlack){
           this.getMarkers().getBlackAntsmarker().setMarker(m, false);
       }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.position);
        hash = 67 * hash + Objects.hashCode(this.ant);
        hash = 67 * hash + (this.rocky ? 1 : 0);
        hash = 67 * hash + Objects.hashCode(this.food);
        hash = 67 * hash + (this.anthill ? 1 : 0);
        hash = 67 * hash + Objects.hashCode(this.anthillColor);
        hash = 67 * hash + Objects.hashCode(this.markers);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        //if (getClass() != obj.getClass()) {
        //    return false;
        //}
        final TerrainToken other = (TerrainToken) obj;
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }
        if (!Objects.equals(this.ant, other.ant)) {
            return false;
        }
        if (this.rocky != other.rocky) {
            return false;
        }
        if (!Objects.equals(this.food, other.food)) {
            return false;
        }
        if (this.anthill != other.anthill) {
            return false;
        }
        if (!Objects.equals(this.anthillColor, other.anthillColor)) {
            return false;
        }
        if (!Objects.equals(this.markers, other.markers)) {
            return false;
        }
        return true;
    }

    
   
    
 
    
    //////////////////////
    ///////////////////
    
    public boolean isAnthill() {
        return anthill;
    }

    public boolean isRocky() {
        return rocky;
    }

    public boolean hasAnt(){
        return ant!=null;
    }
    public Ant getAnt(){
            return ant;
    }

    public void putAnt(Ant ant) throws Exception {
        if(ant==null){
        this.ant = ant;
        }//else throw new Exception("ant already there");
    }
    public void removeAnt(){
        this.ant = null;
    }

    public boolean hasFood() {
        return !food.empty();
    }
    
    public int getFoodSize(){
        return food.size();
    }

    public Position getPosition() {
        return position;
    }
    public void remove1food(){
        if(hasFood()){
            food.pop();
        }
    }

    public void drop1food() {
        food.push(new Food());
    }

    public Color getAnthillColor() {
        return anthillColor;
    }
    
    
}
