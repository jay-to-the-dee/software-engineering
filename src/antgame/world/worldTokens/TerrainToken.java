package antgame.world.worldTokens;

import antgame.ant.color.Color;
import antgame.ant.color.ColorBlack;
import antgame.ant.color.ColorRed;
import antgame.ant.markers.ChemicalMarkers;
import antgame.ant.markers.Marker;
import antgame.model.Ant;
import antgame.model.Food;
import antgame.model.FoodStack;
import antgame.model.Position;
import antgame.model.World;
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
    private final ChemicalMarkers markers;
    private boolean hasAnt;
    
    public TerrainToken (boolean predicate, Position p,FoodStack food, boolean anthill,Color anthillColor){
        rocky=predicate;
        position = p;
        this.food = food;
        this.anthill = anthill;
        this.anthillColor=anthillColor;
        markers = new ChemicalMarkers();
        hasAnt=false;
    }
    
    
    public ChemicalMarkers getMarkers() {
        return markers;
    }

    public void mark(Color c,Marker m){
        m.mark(this, c);
    }
        
    public void setMarkerAt(Color c,int m){
        //TODO a bit messy, could do better but works fine for the current impl
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
        if (getClass() != obj.getClass()) {
            return false;
        }
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
    
    public boolean isAnthill() {
        return anthill;
    }

    public boolean isRocky() {
        return rocky;
    }

    public boolean hasAnt(){
        return hasAnt;
    }
    public Ant getAnt(){
            return ant;
    }

    public void putAnt(Ant ant) throws Exception {
        if(!this.hasAnt){
        this.ant = ant;
        this.hasAnt = true;
        }
    }
    public void removeAnt(){
        this.ant = null;
        this.hasAnt = false;
        
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

    public void fetchFood(Color colour) {
            if(colour instanceof ColorRed){
                World.increaseRedScore();
            }
            else if(colour instanceof ColorBlack){
                World.increaseBlackScore();
        }
    }

    public int getBlackScore() {
        return World.getBlackScore();
    }

    public int getRedScore() {
        return World.getRedScore();
    }
}