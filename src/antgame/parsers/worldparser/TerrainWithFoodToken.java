package antgame.parsers.worldparser;

/**
 *
 * @author Main User
 */
public class TerrainWithFoodToken extends TerrainToken implements GetType{

    private int numberOfFood;
    
    public TerrainWithFoodToken(int numberOfFood){
        this.numberOfFood = numberOfFood;
    }
    @Override
    public void getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getNumberOfFood() {
        return numberOfFood;
    }
    public void decrementNumberOfFood(){
        if(numberOfFood<=0){
            
        }else numberOfFood--;
    }
    
}
