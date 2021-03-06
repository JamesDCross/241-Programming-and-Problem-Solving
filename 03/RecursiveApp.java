package week03;
/**
 * A class containing 2 methods to count the number of digits in an
 * argument and calculate the sum of an argument recursively.
 *
 * @author James Cross 1350026
 */
public class RecursiveApp {
    
    /**
     * Using integer divison, moves through the decimal places returning 1
     * each time therefore counting the decimal places in the number
     * recursively.
     *
     * @param x the long we are calculating the number of digits from.
     * @return x divided by 10 to "move" decimal place, and 1 to count.
     */
  
    public static long digits (long x){
        if(x < 10){
            
            return 1;
        }
        return digits (x/10) +1;

    }

    /**
     * Recursively adds the remainder of the given long divided by 10 
     * with n/10 as the base case.
     * 
     *
     * @param n the long we are calculating the sum of digits from.
     * @return ((n%10)+ sumOfDigits(n/10)) returns the remainder of the long
     *  divided by 10.
     */

    public static long sumOfDigits(long n){ 
        if((n/10)== 0){
            return n;
        
        } else {
            return ((n%10)+ sumOfDigits(n/10));
        }
         
    }

}
