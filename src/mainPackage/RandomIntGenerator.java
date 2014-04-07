package mainPackage;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author ItsTheRai
 */
public class RandomIntGenerator {
    private int initialSeed=12345;
    private static BigInteger currentSeed;
    
    public RandomIntGenerator(BigInteger initialSeed){
        currentSeed = initialSeed;
    }
    //input: a nonnegative int
    
    public static BigInteger getNextSeed(BigInteger x){
        BigInteger a = new BigInteger("22695477");
        BigInteger multiply = x.multiply(a);
        BigInteger b = new BigInteger("1");
        BigInteger result = multiply.add(b);
        return result;
    }
    
    public static BigInteger getRandomInt(BigInteger n){
        BigInteger a = getX();
         BigInteger returnint = a.mod(n);
         currentSeed = getNextSeed(currentSeed);
        return returnint;
    }
    
    public static BigInteger  getX(){
        BigInteger a = getNextSeed(currentSeed);
        BigInteger b = getNextSeed(a);
        BigInteger c = getNextSeed(b);
        BigInteger d = getNextSeed(c);
        BigInteger e = d.divide(new BigInteger("65536"));
        BigInteger f = e.mod(new BigInteger("16384"));
        return f;
    }
}