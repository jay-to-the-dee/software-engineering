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
public class Food {
    public Food(){
        
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Food){
            Food f = (Food)obj;
            
        }
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hashCode = 84295;
        return hashCode; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
