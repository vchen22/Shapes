/**
 * Author: Vicki Chen
 * CSE8B Login: cs8wamh
 * Date: 2/26/19
 * File: Exercise.java
 * Source of Help: PA5 write up, Piazza
 * 
 * This file contains the class Exercise
 * This file contains methods from PA5's exercises
 * */

import java.util.*;

/**
 * This class contains methods that add up all integers in an arraylist,
 * find the average of numbers in an arraylist, and seperate all 
 * characters in a word into an array
 **/
public class Exercise{
    /**
     * Add up all elements in arraylist
     * @param list List of Integers
     * @return sum Sum of all Integers
     * */
	public static Integer sumList(ArrayList<Integer> list){
		//TODO

        if (list == null || list.size() == 0)
        {
            return null;
        }
        //base case
        else if (list.size() == 1)
        {
            return list.get(0);
        }
        else
        {
            //once added first element, cut list to remaining nums
            int addSum = list.get(0) + sumList(new ArrayList<Integer>
                    (list.subList(1, list.size())));
            //convert int to Integer
            Integer sum = new Integer(addSum);
            return sum;
            
        }
	}

    /**
     * Find the average of a list of Integers
     * @param list List of Integer
     * @return avg Average of the Integers of the list
     * */
	public static Double findAverage(ArrayList<Integer> list){
		//TODO
         
        int denominator = list.size();
        if (list == null || list.size() == 0)
        {
            return null;
        }
        //base case
        else if (list.size() == 1)
        {
            return (double) list.get(0);
            
        }
        else
        {
            //equation: (n*m+x)/(n+1) -> changed a bit because index start at 0
            //adding all elements
            double sum = (list.size()-1)*findAverage(new ArrayList<Integer>
                    (list.subList(1, list.size()))) + list.get(0);
            //divide
            double initAvg = sum/denominator;
            //convert double to Double
            Double avg = new Double(initAvg);
            return avg;
        }
            
                
	}
    
    /**
     * Put each character of a word into an array
     * @param word Given word
     * @return charList List of characters of the word
     * */
	public static ArrayList<Character> strToList(String word){
		//TODO
        ArrayList<Character> charList = new ArrayList<Character>();
        if (word == null || word.length() == 0)
        {
            return null;
        }
        //base case
        else if (word.length() == 1)
        {
            charList.add(word.charAt(0));
            return charList;
        }
        else
        {
            //cut list from start to second to last element to recuse to 
            //add the first element
            charList = strToList(word.substring(0, word.length()-1));
            //add last element of cut list
            charList.add(word.charAt(word.length()-1));
            return charList;
        }
	}

    /**
     * Tester for methods sumList, findAverage, strToList
     * @param args Arguments from the command line being passed in
     * @return void
     * */
	public static void main(String[] args){
		//TODO

       //sumList
       ArrayList<Integer> sum1 = new ArrayList<Integer>();
       sum1.add(2);
       sum1.add(3);
       sum1.add(5);
       sum1.add(7);
       System.out.println(sumList(sum1));
       System.out.println("exp: " + 17);

       ArrayList<Integer> sum2 = new ArrayList<Integer>();
       sum2.add(4);
       sum2.add(6);
       sum2.add(10);
       System.out.println(sumList(sum2));
       System.out.println("exp: " + 20);

       //strToList
       System.out.println(strToList("hello"));
       System.out.println("exp : [h, e, l, l, o]");

       System.out.println(strToList("vicki"));
       System.out.println("exp : [v, i, c, k, i]");

       System.out.println(strToList("v"));
       System.out.println("exp : [v]");

       //findAverage
       System.out.println(findAverage(sum1));
       System.out.println("exp: " + 4.25);

       ArrayList<Integer> oneNum = new ArrayList<Integer>();
       oneNum.add(5);
       System.out.println(findAverage(oneNum));
       System.out.println("exp: 5.0");

       //sumList - one element
       System.out.println(sumList(oneNum));
       System.out.println(5);
        

	}
}
