/**
 * Author: Vicki Chen
 * CSE8B Login: cs8wamh
 * Date: 2/26/19
 * File: Fibonacci.java
 * Source of Help: PA5 write up, CS8B tutors
 * 
 * This file contains the class Fibonacci.
 * Using the fibonacci sequence, it draws out snail shape like image
 * */

import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

/**
 * This class contains a method that draws out a sprial shape using the
 * fibonacci sequence influencing the radius length, angle and center
 * coordinates
 * */
public class Fibonacci {

    // every arc is a quarter circle
    static final int arcLength = 90;
    private static final int FULL_CIRCLE = 360;
    private static final int PI2_DEGREE = 90;
    private static final int PI_DEGREE = 180;

    /**
     * Draws out the fibonacci sequence spiral shell based on what angle
     * and radius from the fibonacci sequence, and changing center point
     * @param group Group the fibonacci spiral shell is in
     * @param centerX x-coordinate of center point
     * @param centerY y-coordinate of center point
     * @param prevRadius previous radius
     * @param currRadius current radius
     * @param startAngle starting angle
     * @param n number of arcs
     * @return void
     **/
    public static void draw(Group group, 
                            int centerX, int centerY,
                            int prevRadius, int currRadius,
                            int startAngle,
                            int n) {
        if (n == 0) return;

        Arc a = new Arc(centerX, centerY, currRadius, currRadius, 
                        startAngle, arcLength);
        a.setType(ArcType.ROUND);
        a.setFill(null);
        a.setStroke(Color.BLACK);
        group.getChildren().add(a);

        // TODO 
        // calculate any new values needed, then make a recursive call
        
        if (n == 0)
        {
            return;
        }
        else
        {
           if (startAngle == 0)
           {
               //centerX stays the same, move centerY down
               centerY = centerY + prevRadius;
               
               //save currRadius and then calculate new currRadius
               int temp = currRadius;
               currRadius = prevRadius + currRadius;
               prevRadius = temp;

               //calculate new angle
               startAngle = (startAngle + arcLength)%FULL_CIRCLE;
               draw(group, centerX, centerY, prevRadius, currRadius, 
                       startAngle, n-1);
           }
           else if (startAngle == PI2_DEGREE)
           {
               //centerY stays the same, move centerX to the right
               centerX = centerX + prevRadius;

               //save currRadius and then calculate new currRadius
               int temp = currRadius;
               currRadius = prevRadius + currRadius;
               prevRadius = temp;
                
               //calculate new angle
               startAngle = (startAngle + arcLength)%FULL_CIRCLE;
               draw(group, centerX, centerY, prevRadius, currRadius, 
                       startAngle, n-1);
                
           }
           else if (startAngle == PI_DEGREE)
           {
               //centerX stays the same, move centerY up
               centerY = centerY - prevRadius;

               //save currRadius and then calculate new currRadius
               int temp = currRadius;
               currRadius = prevRadius + currRadius;
               prevRadius = temp;
                
               //calculate new angle
               startAngle = (startAngle + arcLength)%FULL_CIRCLE;
               draw(group, centerX, centerY, prevRadius, currRadius, 
                       startAngle, n-1);
           }
           else
           {
               //centerY stays the same, centerX move to the left
               centerX = centerX - prevRadius;

               //save currRadius and then calculate new currRadius
               int temp = currRadius;
               currRadius = prevRadius + currRadius;
               prevRadius = temp;
                
               //calculate new angle
               startAngle = (startAngle+ arcLength)%FULL_CIRCLE;
               draw(group, centerX, centerY, prevRadius, currRadius, 
                       startAngle, n-1);
           }

        }

    }

}
