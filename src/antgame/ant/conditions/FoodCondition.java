/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.ant.conditions;

import antgame.ant.conditions.checkCondition;
import antgame.model.TerrainToken;

/**
 *
 * @author Main User
 */
public class FoodCondition implements checkCondition{
    
    @Override
    public boolean checkCondition(TerrainToken token,Color color) {
        return token.hasFood();
        
    }
}