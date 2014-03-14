/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classification;

/**
 *
 * @author Main User
 */
public class Logarithm
{
public static double logb( double a, double b )
{
return Math.log(a) / Math.log(b);
}

public static double log2( double a )
{
return logb(a,2);
}}

