/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.parsers.worldparser;

import java.util.List;

/**
 *
 * @author Main User
 */
public class RequirementDimension implements CheckRequirement{
    private int xsize;
    private int ysize;
    public RequirementDimension(int xsize,int ysize){
        this.xsize=xsize;
        this.ysize=ysize;
    }

    /**
     *
     * @param xsize
     * @param ysize
     * @param tokens
     * @return
     */
    @Override
    public boolean checkRequirements(int xsize,int ysize,List<WorldToken> tokens) throws SomeException{
        if (this.xsize!=xsize ||this.ysize!=ysize){
            System.out.println("validation error");
            return false;
        }
        return true;
        
    }
}