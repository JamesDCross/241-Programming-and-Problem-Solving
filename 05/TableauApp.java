package week05;

import java.util.ArrayList;
import java.util.*;

/**
 * Skeleton code for an array based implementation of Young's tableau.
 *
 * @author Iain Hewson
 */

public class TableauApp {

    /**
     * The main method is just used for testing.
     *
     * @param args  command line arguments are not used.
     *           
     */
    public static void main(String[] args) {
      

    }

    /**
     * Determines whether the array passed to it is a valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *           
     *
     * @return true if the parameter is a valid tableau, otherwise false
a     */

    public static boolean isTableau(int[][] t) {
        return rowLengthsDecrease(t) && rowValuesIncrease(t)
            && columnValuesIncrease(t) && isSetOf1toN(t);

    }
    
    /**
     * Checks that no row is longer than the preceding row.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *           
     *
     * @return false if row length is less than the next row length
     *  otherwise false.
     *
     */

    

    public static boolean rowLengthsDecrease(int[][] t) {
        for(int i = 0; i < t.length-1; i ++){
            if(t[i].length < t[i +1].length){
                return false;
            }

        }
        return true;   
    }

    /**
     * Determines whether the array passed to it is a valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *           
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean rowValuesIncrease(int[][] t) {
        for(int i = 0; i < t.length-1; i++){
            for(int j = 0; j < t[j].length-1; j++){
                if(t[i][j] >t[i][j+1]){
                    return false;
                }
            }

        }
        return true;
      
    }

    /**
     * Using a decremental for loop to define row numbers means we do not 
     * go out of bounds. Then we check the "columns" in pairs of 2 e.g.
     * 3,0 against 2,0, 3,1 against 2,1. So the "column" values are checked 
     * to be incremental.
     * 
     * @param t a two-dimensional array which represents a tableau.
     * 
     * @return false if the value in the corresponding row index is greater
     * than the first row index, return true if the value in the corresponding
     * row index is less than the first row index. 
     * 
     * 
     */

               
    public static boolean columnValuesIncrease(int[][] t) {
        for(int i = t.length-1; i >=1; i--){
            for(int j = 0; j < t[i].length; j++){
                if(t[i][j] < t[i-1][j]){
                    return false;
                }

            }

        }
        return true;
    }
    
    /**
     * 
     * Takes the values from 2d array t and puts them into an ArrayList.
     * Then the ArrayList is sorted and the checks that define "1 to N"
     * are performed using for loops.
     * 
     * @param t   a two-dimensional array which represents a tableau.
     * 
     * @return false if value is less than 1 or greater then ArrayList size
     * and if any repeated numbers are found, otherwise return true.
     *           
     * 
     */

    public static boolean isSetOf1toN(int[][] t) {
        ArrayList<Integer> list = new  ArrayList<Integer>();

        for(int i = t.length-1; i >=0; i--){
            for(int j = 0; j <= t[i].length-1; j++){
                list.add(t[i][j]);
            }

        }

        Collections.sort(list);

        for(int i = 0; i < list.size(); i ++){
            if(list.get(i) < 1 || list.get(i) > list.size()){
                return false;

            }

        }

        for(int i = 0; i < list.size()-1; i ++){
            if(list.get(i)==list.get(i + 1)){
                return false;

            }

        }
        return true;
    }

    /**
     * Returns a string representation of an array based tableau.
     * 
     * @param t   a two-dimensional array which represents a tableau.
     *          
     * @return a string representation of an array based tableau.
     */
    public static String toString(int[][] t) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                result.append(String.format("%-4s", t[i][j]));
            }
            if (i < t.length - 1) {
                result.append("\n");
            }

        }
        return result.toString();
    }

}
