package antgame.model;

import antgame.ant.instructions.Instruction;
import antgame.world.worldTokens.TerrainToken;
import antgame.world.worldTokens.WorldToken;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ItsTheRai
 */
public class World {
    private int width;
    private int height;
    private TerrainToken[] worldTokens;
    int count = 0;
    
    
    public World(int xsize,int ysize, TerrainToken[] world){
        //needs refactoring
        width = xsize;
        height = ysize;
        worldTokens = new TerrainToken[world.length];
        worldTokens = world;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public TerrainToken[] getWorldTokens() {
        return worldTokens;
    }
    
    public void executeOneRound(){
        System.out.println(count++);
        //goes through the whole terrain to check if an ant is present, update if need to improve performance
        for(int i = 0; i < this.worldTokens.length;i++){
            //this takes too long
            
            //TODO fix this
            if((worldTokens[i]).hasAnt()){
          //      Ant ant = ((TerrainToken)worldTokens.get(i)).getAnt();
                //System.out.println("ant "+ant.getID()+" at row "+ant.getAntLocation().getPosition().getYlocation()+
                //        " column "+
                //ant.getAntLocation().getPosition().getXlocation()+
                //        " state :"+ant.getState()+" facing difection "+ant.getDirection());
                //if (ant.isHasFood()){
                    //System.out.println();
                    //System.out.println("Ant found food!");
                    //System.out.println();
                //}
                //step(((TerrainToken)worldTokens.get(i)).getAnt());
            }
        }
    }
    
    public void step(Ant ant){
        if(ant.isAlive()){
            if(ant.isResting()){
                ant.rest();
            }
            else ant.getCurrentInstruction().executeInstruction(ant);
        }
    }
    
    
    //xposition - index starting from 0 to width -1
    //yposition - index starting from 0 to heigth -1
    public TerrainToken getTokenAt(int xposition, int yposition){
        return getWorldTokens()[(yposition*getWidth()+xposition)];
    }
    public TerrainToken getCell(Position p){
        return (TerrainToken)this.getTokenAt(p.getXlocation(), p.getYlocation());
    }
    public TerrainToken getAdjacentCell(int direction,Position position){
        TerrainToken t =new TerrainToken(false,position,null,false,null);
        switch(direction){
            case 0:t= (TerrainToken)getTokenAt(position.getXlocation()+1, position.getYlocation());
                break;
            case 1:
                if (position.getYlocation()%2==0){
                t=(TerrainToken)getTokenAt(position.getXlocation(), position.getYlocation()+1);
                
                }
                else t= (TerrainToken)getTokenAt(position.getXlocation()+1, position.getYlocation()+1);
                break;
            case 2:
                if (position.getYlocation()%2==0){
                    t=(TerrainToken)getTokenAt(position.getXlocation()-1, position.getYlocation()+1);
                    }
                else t= (TerrainToken)getTokenAt(position.getXlocation(), position.getYlocation()+1);
                break;
            case 3:
                t= (TerrainToken)getTokenAt(position.getXlocation()-1, position.getYlocation());
                break;
            case 4:
                if (position.getYlocation()%2==0){
                    t=(TerrainToken)getTokenAt(position.getXlocation()-1, position.getYlocation()-1);
                    }
                else t= (TerrainToken)getTokenAt(position.getXlocation(), position.getYlocation()-1);
                break;
            case 5:
                if (position.getYlocation()%2==0){
                    t=(TerrainToken)getTokenAt(position.getXlocation(), position.getYlocation()-1);
                    }
                else t= (TerrainToken)getTokenAt(position.getXlocation()+1, position.getYlocation()-1);
                break;
        }
        return t;
    }
}