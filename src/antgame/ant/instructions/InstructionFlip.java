package antgame.ant.instructions;

import antgame.model.Ant;
import java.math.BigInteger;
import java.util.Random;
import mainPackage.RandomIntGenerator;

/**
 *
 * @author ItsTheRai
 */
public class InstructionFlip extends InstructionSet implements Instruction{
    private int state1;
    private int state2;
    private int n;

    public InstructionFlip(int n,int state1, int state2) {
        this.state1 = state1;
        this.state2 = state2;
        this.n = n;
    }

    @Override
    public void executeInstruction(Ant ant) {
        //BigInteger random =RandomIntGenerator.getRandomInt(new BigInteger(Integer.toString(n)));
        Random r = new Random();
        if(r.nextInt(n)==0){//.intValue()==0){
            ant.setState(state1);
        }
        else ant.setState(state2);
    }
}