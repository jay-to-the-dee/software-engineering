package antgame.ant.direction.turndirection;

/**
 *
 * @author Main User
 */
public class Right implements LeftOrRight{

    @Override
    public int turn(int dir) {
        return (dir+1)%6;
    }
    
}
