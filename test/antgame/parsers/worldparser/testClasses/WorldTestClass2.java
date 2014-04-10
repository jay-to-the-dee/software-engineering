package antgame.parsers.worldparser.testClasses;

import antgame.model.Food;
import antgame.model.FoodStack;
import antgame.model.Position;
import antgame.model.World;
import antgame.world.worldTokens.BlackAnthillToken;
import antgame.world.worldTokens.PlainToken;
import antgame.world.worldTokens.RedAnthillToken;
import antgame.world.worldTokens.RockToken;
import antgame.world.worldTokens.TerrainToken;

/**
 *
 * @author ItsTheRai
 */
public class WorldTestClass2 implements WorldTestClass{
    public WorldTestClass2(){
        
}
    @Override
    public World getWorld(){
        
        TerrainToken[] expResult = new TerrainToken[100];
        FoodStack s = new FoodStack();
        FoodStack a = new FoodStack();
        FoodStack b = new FoodStack();
        FoodStack c = new FoodStack();
        FoodStack d = new FoodStack();
        for (int i = 0; i < 5; i++){
            a.push(new Food());
        }
        for (int i = 0; i < 1; i++){
            b.push(new Food());
        }
        for (int i = 0; i < 9; i++){
            c.push(new Food());
        }
        for (int i = 0; i < 4; i++){
            d.push(new Food());
        }
        
        for(int i=0;i<1;i++){
        expResult[i++] = new RockToken(new Position(0,0));
        expResult[i++] = new RockToken(new Position(1,0));
        expResult[i++] = new RockToken(new Position(2,0));
        expResult[i++] = new RockToken(new Position(3,0));
        expResult[i++] = new RockToken(new Position(4,0));
        expResult[i++] = new RockToken(new Position(5,0));
        expResult[i++] = new RockToken(new Position(6,0));
        expResult[i++] = new RockToken(new Position(7,0));
        expResult[i++] = new RockToken(new Position(8,0));
        expResult[i++] = new RockToken(new Position(9,0));
      
        expResult[i++] = new RockToken(new Position(0,1));
        expResult[i++] = new BlackAnthillToken(new Position(1,1));
        expResult[i++] = new BlackAnthillToken(new Position(2,1));
        expResult[i++] = new BlackAnthillToken(new Position(3,1));
        expResult[i++] = new BlackAnthillToken(new Position(4,1));
        expResult[i++] = new BlackAnthillToken(new Position(5,1));
        expResult[i++] = new BlackAnthillToken(new Position(6,1));
        expResult[i++] = new BlackAnthillToken(new Position(7,1));
        expResult[i++] = new BlackAnthillToken(new Position(8,1));
        expResult[i++] = new RockToken(new Position(9,1));
        
        expResult[i++] = new RockToken(new Position(0,2));
        expResult[i++] = new PlainToken(new Position(1,2),a);
        expResult[i++] = new PlainToken(new Position(2,2),new FoodStack());
        expResult[i++] = new PlainToken(new Position(3,2),b);
        expResult[i++] = new PlainToken(new Position(4,2),new FoodStack());
        expResult[i++] = new PlainToken(new Position(5,2),c);
        expResult[i++] = new PlainToken(new Position(6,2),new FoodStack());
        expResult[i++] = new PlainToken(new Position(7,2),d);
        expResult[i++] = new PlainToken(new Position(8,2),new FoodStack());
        expResult[i++] = new RockToken(new Position(9,2));
        
        expResult[i++] = new RockToken(new Position(0,3));
        expResult[i++] = new PlainToken(new Position(1,3),new FoodStack());
        expResult[i++] = new PlainToken(new Position(2,3),new FoodStack());
        expResult[i++] = new PlainToken(new Position(3,3),new FoodStack());
        expResult[i++] = new PlainToken(new Position(4,3),new FoodStack());
        expResult[i++] = new PlainToken(new Position(5,3),new FoodStack());
        expResult[i++] = new PlainToken(new Position(6,3),new FoodStack());
        expResult[i++] = new PlainToken(new Position(7,3),new FoodStack());
        expResult[i++] = new PlainToken(new Position(8,3),new FoodStack());
        expResult[i++] = new RockToken(new Position(9,3));
        
        expResult[i++] = new RockToken(new Position(0,4));
        expResult[i++] = new PlainToken(new Position(1,4),new FoodStack());
        expResult[i++] = new PlainToken(new Position(2,4),new FoodStack());
        expResult[i++] = new PlainToken(new Position(3,4),new FoodStack());
        expResult[i++] = new PlainToken(new Position(4,4),new FoodStack());
        expResult[i++] = new PlainToken(new Position(5,4),new FoodStack());
        expResult[i++] = new PlainToken(new Position(6,4),new FoodStack());
        expResult[i++] = new PlainToken(new Position(7,4),new FoodStack());
        expResult[i++] = new PlainToken(new Position(8,4),new FoodStack());
        expResult[i++] = new RockToken(new Position(9,4));
        
        expResult[i++] = new RockToken(new Position(0,5));
        expResult[i++] = new PlainToken(new Position(1,5),new FoodStack());
        expResult[i++] = new PlainToken(new Position(2,5),new FoodStack());
        expResult[i++] = new PlainToken(new Position(3,5),new FoodStack());
        expResult[i++] = new PlainToken(new Position(4,5),new FoodStack());
        expResult[i++] = new PlainToken(new Position(5,5),new FoodStack());
        expResult[i++] = new PlainToken(new Position(6,5),new FoodStack());
        expResult[i++] = new PlainToken(new Position(7,5),new FoodStack());
        expResult[i++] = new PlainToken(new Position(8,5),new FoodStack());
        expResult[i++] = new RockToken(new Position(9,5));
        
        expResult[i++] = new RockToken(new Position(0,6));
        expResult[i++] = new PlainToken(new Position(1,6),new FoodStack());
        expResult[i++] = new PlainToken(new Position(2,6),new FoodStack());
        expResult[i++] = new PlainToken(new Position(3,6),new FoodStack());
        expResult[i++] = new PlainToken(new Position(4,6),new FoodStack());
        expResult[i++] = new PlainToken(new Position(5,6),new FoodStack());
        expResult[i++] = new PlainToken(new Position(6,6),new FoodStack());
        expResult[i++] = new PlainToken(new Position(7,6),new FoodStack());
        expResult[i++] = new PlainToken(new Position(8,6),new FoodStack());
        expResult[i++] = new RockToken(new Position(9,6));
        
        expResult[i++] = new RockToken(new Position(0,7));
        expResult[i++] = new PlainToken(new Position(1,7),new FoodStack());
        expResult[i++] = new PlainToken(new Position(2,7),new FoodStack());
        expResult[i++] = new PlainToken(new Position(3,7),new FoodStack());
        expResult[i++] = new PlainToken(new Position(4,7),new FoodStack());
        expResult[i++] = new PlainToken(new Position(5,7),new FoodStack());
        expResult[i++] = new PlainToken(new Position(6,7),new FoodStack());
        expResult[i++] = new PlainToken(new Position(7,7),new FoodStack());
        expResult[i++] = new PlainToken(new Position(8,7),new FoodStack());
        expResult[i++] = new RockToken(new Position(9,7));
        
        expResult[i++] = new RockToken(new Position(0,8));
        expResult[i++] = new RedAnthillToken(new Position(1,8));
        expResult[i++] = new RedAnthillToken(new Position(2,8));
        expResult[i++] = new RedAnthillToken(new Position(3,8));
        expResult[i++] = new RedAnthillToken(new Position(4,8));
        expResult[i++] = new RedAnthillToken(new Position(5,8));
        expResult[i++] = new RedAnthillToken(new Position(6,8));
        expResult[i++] = new RedAnthillToken(new Position(7,8));
        expResult[i++] = new RedAnthillToken(new Position(8,8));
        expResult[i++] = new RockToken(new Position(9,8));
        
        expResult[i++] = new RockToken(new Position(0,9));
        expResult[i++] = new RockToken(new Position(1,9));
        expResult[i++] = new RockToken(new Position(2,9));
        expResult[i++] = new RockToken(new Position(3,9));
        expResult[i++] = new RockToken(new Position(4,9));
        expResult[i++] = new RockToken(new Position(5,9));
        expResult[i++] = new RockToken(new Position(6,9));
        expResult[i++] = new RockToken(new Position(7,9));
        expResult[i++] = new RockToken(new Position(8,9));
        expResult[i++] = new RockToken(new Position(9,9));
        }
        World Result = new World(10,10, expResult);
        
        return Result;
    }
}