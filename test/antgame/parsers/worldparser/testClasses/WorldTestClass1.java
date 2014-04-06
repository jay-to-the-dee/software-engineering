/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.parsers.worldparser.testClasses;

import antgame.model.Food;
import antgame.model.FoodStack;
import antgame.model.Position;
import antgame.world.worldTokens.MapSizeToken;
import antgame.world.worldTokens.PlainToken;
import antgame.world.worldTokens.TerrainToken;
import antgame.world.worldTokens.WorldToken;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Main User
 */
public class WorldTestClass1 implements WorldTestClass{
    public WorldTestClass1(){
        
}
    public List<WorldToken> getWorld(){
        List<WorldToken> expResult = new LinkedList<>();
        expResult.add(new MapSizeToken(2));
        expResult.add(new MapSizeToken(2));
        FoodStack s = new FoodStack();
        for (int i = 0; i < 5; i++){
            s.push(new Food());
        }
        expResult.add(new PlainToken(new Position(0,0),s));
        expResult.add(new PlainToken(new Position(1,0),s));
        expResult.add(new PlainToken(new Position(0,1),s));
        expResult.add(new PlainToken(new Position(1,1),s));
        return expResult;
    }
}