package mainPackage;

import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Main User
 */
public class Randomint {
    public Randomint(){
        
    }
    //input: a nonnegative int
    public int getRandomInt(int n){
        Random r = new Random();
        return r.nextInt(n);
    }
}
