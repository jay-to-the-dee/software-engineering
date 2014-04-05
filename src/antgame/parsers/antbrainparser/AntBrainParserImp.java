package antgame.parsers.antbrainparser;

import antgame.ant.conditions.Condition;
import antgame.ant.conditions.FoeCondition;
import antgame.ant.conditions.FoeHomeCondition;
import antgame.ant.conditions.FoeMarkerCondition;
import antgame.ant.conditions.FoeWithFoodCondition;
import antgame.ant.conditions.FoodCondition;
import antgame.ant.conditions.FriendCondition;
import antgame.ant.conditions.FriendWithFoodCondition;
import antgame.ant.conditions.HomeCondition;
import antgame.ant.conditions.MarkerCondition;
import antgame.ant.conditions.RockCondition;
import antgame.ant.direction.Ahead;
import antgame.ant.direction.Direction;
import antgame.ant.direction.Here;
import antgame.ant.direction.LeftAhead;
import antgame.ant.direction.RightAhead;
import antgame.ant.direction.turndirection.Left;
import antgame.ant.direction.turndirection.LeftOrRight;
import antgame.ant.direction.turndirection.Right;
import antgame.ant.markers.Marker;
import antgame.ant.markers.Marker0;
import antgame.ant.markers.Marker1;
import antgame.ant.markers.Marker2;
import antgame.ant.markers.Marker3;
import antgame.ant.markers.Marker4;
import antgame.ant.markers.Marker5;
import antgame.instructions.Instruction;
import antgame.instructions.InstructionDrop;
import antgame.instructions.InstructionMark;
import antgame.instructions.InstructionMove;
import antgame.instructions.InstructionPickUp;
import antgame.instructions.InstructionSense;
import antgame.instructions.InstructionTurn;
import antgame.instructions.InstructionUnmark;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author ItsTheRai
 */
public class AntBrainParserImp implements AntBrainParser{
    private static final String senseInstruction = "Sense";
    private static final String markInstruction = "Mark";
    private static final String unmarkInstruction = "Unmark";
    private static final String pickUpInstruction = "PickUp";
    private static final String dropInstruction = "Drop";
    private static final String turnInstruction = "Turn";
    private static final String moveInstruction = "Move";
    private static final String flipInstruction = "Flip";
    Queue rowQueue = new LinkedList();

    @Override
    public Instruction[] parseAntBrain(String input) {
        int state = 0;
        
        rowQueue.addAll(Arrays.asList(input.split("\\r?\\n|\\r")));
        
        Instruction[] brain= new Instruction[rowQueue.size()];
        while(!rowQueue.isEmpty()){
            try {
                System.out.println("see whole row: "+ rowQueue.peek());
                brain[state++]=parseLine((String)rowQueue.remove());
            } catch (Exception ex) {
                System.out.println("line error");
                //TODO make some exception
            }
        }
        //not sure if need to clear array
        return brain;
    }
    
    private Instruction parseLine(String row) throws Exception{
            Queue columnQueue = new LinkedList();
        //rowString contains all row objects
            columnQueue.addAll(Arrays.asList(row.split("\\s+")));
           return getInstruction(columnQueue);
    }
    
    private Instruction getInstruction(Queue q) throws Exception{
        //get instruction
        System.out.println("show instruction: "+q.peek());
        
        if(q.peek().toString().equalsIgnoreCase(senseInstruction)){
            q.remove();
            //TODO collect tokens for case sense
            Direction sensedirection =getSenseDirection(q.remove().toString());
            //TODO add exceptions
            int state1 = getState(q.remove().toString());
            int state2 = getState(q.remove().toString());
            Condition c = getCondition(q.remove().toString());
            int marker = -1;
            Marker m = null;
            if (c instanceof MarkerCondition){
                marker = getMarker(q.remove().toString());
                if(marker==0){
                    m= new Marker0();
                }
                else if(marker==1){
                    m= new Marker1();
                }
                else if(marker==2){
                    m= new Marker2();
                }
                else if(marker==3){
                    m= new Marker3();
                }
                else if(marker==4){
                    m= new Marker4();
                }
                else if(marker==5){
                    m= new Marker5();
                }
                else throw new Exception("marker not recognised");
                return new InstructionSense(state1,state2,sensedirection,c,m);
            }
            else return new InstructionSense(state1,state2,sensedirection,c,null);
        }
        else if (q.peek().toString().equalsIgnoreCase(markInstruction)){
            q.remove();
            //TODO collect tokens for case mark
            int marker = getMarker(q.remove().toString());
            int state = getState(q.remove().toString());
            Marker m = null;
            //TODO check for comments and stuff
            if(marker==0){
                    m= new Marker0();
                }
                else if(marker==1){
                    m= new Marker1();
                }
                else if(marker==2){
                    m= new Marker2();
                }
                else if(marker==3){
                    m= new Marker3();
                }
                else if(marker==4){
                    m= new Marker4();
                }
                else if(marker==5){
                    m= new Marker5();
                }
            return new InstructionMark(m,state);
        }
        else if (q.peek().toString().equalsIgnoreCase(unmarkInstruction)){
            q.remove();
            //TODO collect tokens for case unmark
            int marker = getMarker(q.remove().toString());
            int state = getState(q.remove().toString());
            Marker m = null;
            //TODO check for comments and stuff
            if(marker==0){
                    m= new Marker0();
                }
                else if(marker==1){
                    m= new Marker1();
                }
                else if(marker==2){
                    m= new Marker2();
                }
                else if(marker==3){
                    m= new Marker3();
                }
                else if(marker==4){
                    m= new Marker4();
                }
                else if(marker==5){
                    m= new Marker5();
                }
            return new InstructionUnmark(m,state);
        }
        else if (q.peek().toString().equalsIgnoreCase(pickUpInstruction)){
            //TODO collect tokens for case pickup
            q.remove();
            int state1 = getState(q.remove().toString());
            int state2 = getState(q.remove().toString());
            return new InstructionPickUp(state1,state2);
        }
        else if (q.peek().toString().equalsIgnoreCase(dropInstruction)){
            q.remove();
            //TODO collect tokens for case drop
            int state = getState(q.remove().toString());
            return new InstructionDrop(state);
        }
        else if (q.peek().toString().equalsIgnoreCase(turnInstruction)){
            q.remove();
            //TODO collect tokens for case turn
            LeftOrRight lor = getTurnDirection(q.remove().toString());
            int state = getState(q.remove().toString());
            return new InstructionTurn(lor, state);
            
            
        }
        else if (q.peek().toString().equalsIgnoreCase(moveInstruction)){
            q.remove();
            //TODO collect tokens for case move
            int state1 = getState(q.remove().toString());
            int state2 = getState(q.remove().toString());
            return new InstructionMove(state1,state2);
        }
        else if (q.peek().toString().equalsIgnoreCase(flipInstruction)){
            q.remove();
            //TODO collect tokens for case flip
            // not implemented yet
            
        }
        else throw new Exception();
        return null;
    }
    
    private Direction getSenseDirection(String s) throws Exception{
            if(s.equalsIgnoreCase("LeftAhead")){
                return new LeftAhead();
            }
            else if (s.equalsIgnoreCase("RightAhead")){
                return new RightAhead();
            }
            else if (s.equalsIgnoreCase("Ahead")){
                return new Ahead();
            }
            else if (s.equalsIgnoreCase("Here")){
                return new Here();
            }
            else throw new Exception("no direciton data given");
    }
    
    private int getState(String s){
        int i = -1;
        try  
        {  
           i=Integer.parseInt(s);
           return i;
           // do something when integer values comes 
        }  
        catch(NumberFormatException nfe)  
        {  
                 // do something when string values comes 
        }
        return i;
    }
    
    private Condition getCondition(String s) throws Exception{
        if(s.equalsIgnoreCase("Friend")){
            return new FriendCondition();
        }
        else if (s.equalsIgnoreCase("Foe")){
            return new FoeCondition();
        }
        else if (s.equalsIgnoreCase("FriendWithFood")){
            return new FriendWithFoodCondition();
        }
        else if (s.equalsIgnoreCase("FoeWithFood")){
            return new FoeWithFoodCondition();
        }
        else if (s.equalsIgnoreCase("Food")){
            return new FoodCondition();
        }
        else if (s.equalsIgnoreCase("Rock")){
            return new RockCondition();
        }
        else if (s.equalsIgnoreCase("Home")){
            return new HomeCondition();
        }
        else if (s.equalsIgnoreCase("FoeHome")){
            return new FoeHomeCondition();
        }
        else if (s.equalsIgnoreCase("FoeMarker")){
            return new FoeMarkerCondition();
        }
        else if (s.equalsIgnoreCase("Marker")){
            return new MarkerCondition();
        }
        else throw new Exception("no condition found");

    }
    
    private int getMarker(String s) throws Exception{
        int i = -1;
        try  
        {  
           i=Integer.parseInt(s);
           if(i==0){
               return 0;
           }
           else if (i==1){
               return 1;
           }
           else if (i==2){
               return 2;
           }
           else if (i==3){
               return 3;
           }
           else if (i==4){
               return 4;
           }
           else if (i==5){
               return 5;
           }
           else throw new Exception("marker not recognised");
           // do something when integer values comes 
        }  
        catch(NumberFormatException nfe)  
        {  
            throw new Exception("not a number");
                 // do something when string values comes 
        }
    }

    private LeftOrRight getTurnDirection(String s) throws Exception {
        if (s.equalsIgnoreCase("Left")){
            return new Left();
        }
        else if(s.equalsIgnoreCase("Right")){
            return new Right();
        }
        else throw new Exception("no such direction");
    }
}