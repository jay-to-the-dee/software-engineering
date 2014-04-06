/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.parsers.worldparser.testClasses;

import antgame.model.Food;
import antgame.model.FoodStack;
import antgame.model.Position;
import antgame.model.World;
import antgame.world.worldTokens.MapSizeToken;
import antgame.world.worldTokens.PlainToken;
import antgame.world.worldTokens.RockToken;
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
    @Override
    public World getWorld(){
        
        List<TerrainToken> expResult= new LinkedList();
        FoodStack s = new FoodStack();
        for (int i = 0; i < 5; i++){
            s.push(new Food());
        }
        expResult.add(new RockToken(new Position(0,0)));
        expResult.add(new RockToken(new Position(1,0)));
        expResult.add(new RockToken(new Position(2,0)));
        expResult.add(new RockToken(new Position(3,0)));
        expResult.add(new RockToken(new Position(4,0)));
        expResult.add(new RockToken(new Position(5,0)));
        expResult.add(new RockToken(new Position(6,0)));
        expResult.add(new RockToken(new Position(7,0)));
        expResult.add(new RockToken(new Position(8,0)));
        expResult.add(new RockToken(new Position(9,0)));
        
        expResult.add(new RockToken(new Position(0,1)));
        expResult.add(new PlainToken(new Position(1,1),new FoodStack()));
        expResult.add(new PlainToken(new Position(2,1),new FoodStack()));
        expResult.add(new PlainToken(new Position(3,1),new FoodStack()));
        expResult.add(new PlainToken(new Position(4,1),new FoodStack()));
        expResult.add(new PlainToken(new Position(5,1),new FoodStack()));
        expResult.add(new PlainToken(new Position(6,1),new FoodStack()));
        expResult.add(new PlainToken(new Position(7,1),new FoodStack()));
        expResult.add(new PlainToken(new Position(8,1),new FoodStack()));
        expResult.add(new RockToken(new Position(9,1)));
        
        expResult.add(new RockToken(new Position(0,2)));
        expResult.add(new PlainToken(new Position(1,2),new FoodStack()));
        expResult.add(new PlainToken(new Position(2,2),new FoodStack()));
        expResult.add(new PlainToken(new Position(3,2),new FoodStack()));
        expResult.add(new PlainToken(new Position(4,2),new FoodStack()));
        expResult.add(new PlainToken(new Position(5,2),new FoodStack()));
        expResult.add(new PlainToken(new Position(6,2),new FoodStack()));
        expResult.add(new PlainToken(new Position(7,2),new FoodStack()));
        expResult.add(new PlainToken(new Position(8,2),new FoodStack()));
        expResult.add(new RockToken(new Position(9,2)));
        
        expResult.add(new RockToken(new Position(0,3)));
        expResult.add(new PlainToken(new Position(1,3),new FoodStack()));
        expResult.add(new PlainToken(new Position(2,3),new FoodStack()));
        expResult.add(new PlainToken(new Position(3,3),new FoodStack()));
        expResult.add(new PlainToken(new Position(4,3),new FoodStack()));
        expResult.add(new PlainToken(new Position(5,3),new FoodStack()));
        expResult.add(new PlainToken(new Position(6,3),new FoodStack()));
        expResult.add(new PlainToken(new Position(7,3),new FoodStack()));
        expResult.add(new PlainToken(new Position(8,3),new FoodStack()));
        expResult.add(new RockToken(new Position(9,3)));
        
        expResult.add(new RockToken(new Position(0,4)));
        expResult.add(new PlainToken(new Position(1,4),new FoodStack()));
        expResult.add(new PlainToken(new Position(2,4),new FoodStack()));
        expResult.add(new PlainToken(new Position(3,4),new FoodStack()));
        expResult.add(new PlainToken(new Position(4,4),new FoodStack()));
        expResult.add(new PlainToken(new Position(5,4),new FoodStack()));
        expResult.add(new PlainToken(new Position(6,4),new FoodStack()));
        expResult.add(new PlainToken(new Position(7,4),new FoodStack()));
        expResult.add(new PlainToken(new Position(8,4),new FoodStack()));
        expResult.add(new RockToken(new Position(9,4)));
        
        expResult.add(new RockToken(new Position(0,5)));
        expResult.add(new PlainToken(new Position(1,5),new FoodStack()));
        expResult.add(new PlainToken(new Position(2,5),new FoodStack()));
        expResult.add(new PlainToken(new Position(3,5),new FoodStack()));
        expResult.add(new PlainToken(new Position(4,5),new FoodStack()));
        expResult.add(new PlainToken(new Position(5,5),new FoodStack()));
        expResult.add(new PlainToken(new Position(6,5),new FoodStack()));
        expResult.add(new PlainToken(new Position(7,5),new FoodStack()));
        expResult.add(new PlainToken(new Position(8,5),new FoodStack()));
        expResult.add(new RockToken(new Position(9,5)));
        
        expResult.add(new RockToken(new Position(0,6)));
        expResult.add(new PlainToken(new Position(1,6),new FoodStack()));
        expResult.add(new PlainToken(new Position(2,6),new FoodStack()));
        expResult.add(new PlainToken(new Position(3,6),new FoodStack()));
        expResult.add(new PlainToken(new Position(4,6),new FoodStack()));
        expResult.add(new PlainToken(new Position(5,6),new FoodStack()));
        expResult.add(new PlainToken(new Position(6,6),new FoodStack()));
        expResult.add(new PlainToken(new Position(7,6),new FoodStack()));
        expResult.add(new PlainToken(new Position(8,6),new FoodStack()));
        expResult.add(new RockToken(new Position(9,6)));
        
        expResult.add(new RockToken(new Position(0,7)));
        expResult.add(new PlainToken(new Position(1,7),new FoodStack()));
        expResult.add(new PlainToken(new Position(2,7),new FoodStack()));
        expResult.add(new PlainToken(new Position(3,7),new FoodStack()));
        expResult.add(new PlainToken(new Position(4,7),new FoodStack()));
        expResult.add(new PlainToken(new Position(5,7),new FoodStack()));
        expResult.add(new PlainToken(new Position(6,7),new FoodStack()));
        expResult.add(new PlainToken(new Position(7,7),new FoodStack()));
        expResult.add(new PlainToken(new Position(8,7),new FoodStack()));
        expResult.add(new RockToken(new Position(9,7)));
        
        expResult.add(new RockToken(new Position(0,8)));
        expResult.add(new PlainToken(new Position(1,8),new FoodStack()));
        expResult.add(new PlainToken(new Position(2,8),new FoodStack()));
        expResult.add(new PlainToken(new Position(3,8),new FoodStack()));
        expResult.add(new PlainToken(new Position(4,8),new FoodStack()));
        expResult.add(new PlainToken(new Position(5,8),new FoodStack()));
        expResult.add(new PlainToken(new Position(6,8),new FoodStack()));
        expResult.add(new PlainToken(new Position(7,8),new FoodStack()));
        expResult.add(new PlainToken(new Position(8,8),new FoodStack()));
        expResult.add(new RockToken(new Position(9,8)));
        
        expResult.add(new RockToken(new Position(0,9)));
        expResult.add(new RockToken(new Position(1,9)));
        expResult.add(new RockToken(new Position(2,9)));
        expResult.add(new RockToken(new Position(3,9)));
        expResult.add(new RockToken(new Position(4,9)));
        expResult.add(new RockToken(new Position(5,9)));
        expResult.add(new RockToken(new Position(6,9)));
        expResult.add(new RockToken(new Position(7,9)));
        expResult.add(new RockToken(new Position(8,9)));
        expResult.add(new RockToken(new Position(9,9)));
        World Result = new World(10,10, expResult);
        return Result;
    }
}