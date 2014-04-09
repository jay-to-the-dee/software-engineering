package antgame.ant.instructions;

import antgame.model.Ant;
import java.util.Random;

/**
 *
 * @author ItsTheRai
 */
public class InstructionFlip extends InstructionSet implements Instruction{
    private final int state1;
    private final int state2;
    private int n;

    /**
     *
     * @param n an nonnegative integer
     * @param state1 the state used if condition holds
     * @param state2 the state used if condition does not hold
     */
    public InstructionFlip(int n, int state1, int state2) {
        this.state1 = state1;
        this.state2 = state2;
        this.n = n;
    }

    @Override
    public void executeInstruction(Ant ant) {
        //BigInteger used for testing, too slow to be used in the game
        //BigInteger random =RandomIntGenerator.getRandomInt(new BigInteger(Integer.toString(n)));
        Random r = new Random();
        if(r.nextInt(n)==0){//.intValue()==0){
            ant.setState(state1);
        }
        else ant.setState(state2);
    }
}