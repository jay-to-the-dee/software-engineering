package antgame.model;

/**
 *
 * @author ItsTheRai
 */
public class Food {
    public Food(){
        
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Food){
            Food f = (Food)obj;
            
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        int hashCode = 84295;
        return hashCode;
    }
    
    
}
