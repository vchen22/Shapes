/**
 * Author: Vicki Chen
 * CSE8B Login: cs8wamh
 * Date: 2/26/19
 * File: Circle8B.java
 * Source of Help: PA5 write up
 * 
 * This file contains the subclass Circle8B.
 * It can create Circle8b objects and draw it out
 * */

import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import java.util.*;

/**
 * This class contains methods that can access and manipulate the circle8b 
 * objects' center point and radius, and use those features to digitally
 * draw out the circles.
 * */
public class Circle8B extends Shape
{
    private Point center;
    private int radius;
    private static final int RADIUS_DECREASE = 10;
    private static final String DEFAULT_NAME = "NoName";

    /**
     * Intializes a Circle8B object given the center and radius with
     * deep-copying
     * @param center Center point
     * @param radius Radius of circle
     * @return       Circle8B object created
     * */
    public Circle8B(Point center, int radius)
    {
        super(DEFAULT_NAME);
        this.setCenter(new Point(center));
        this.setRadius(radius);
    }

    /**
     * Intializes a Circle8B object given the center, radius, and name with
     * deep-copying
     * @param center Center point
     * @param radius Radius of circle
     * @param name Name of circle
     * @return     Circle8B object created
     * */
    public Circle8B(Point center, int radius, String name)
    {
        super(name);
        this.setCenter(new Point(center));
        this.setRadius(radius);
    }

    /**
     * Intializes a Circle8B object given by another Circle8B object and
     * extracting the data (copy constructor) with deep-copying
     * @param c Other Circle8B object
     * @return  Circle8B object created
     * */
    public Circle8B(Circle8B c)
    {
        super(DEFAULT_NAME);
        this.setCenter(new Point(c.getCenter()));
        this.setRadius(c.getRadius());
    }

    /**
     * Intializes a Circle8B object given by another Circle8B object and
     * extracting its data, and a name with deep-copying
     * @param c Other Circle8B object
     * @param name Name of Circle
     * @return     Circle8B object created
     * */
    public Circle8B(Circle8B c, String name)
    {
        super(name);
        this.setCenter(new Point(c.getCenter()));
        this.setRadius(c.getRadius());
    }

    /**
     * Intializes a default Circle8B object when given no data
     * @param none
     * @return     Circle8B object created
     **/
    public Circle8B()
    {
        super(DEFAULT_NAME);
        this.setCenter(new Point(0,0));
        this.setRadius(0);
    }

    /**
     * Get the center point
     * @param none
     * @return center point of circle
     * */
    public Point getCenter()
    {
        return this.center;
    }

    /**
     * Get the radius of circle
     * @param none
     * @return radius of circle
     * */
    public int getRadius()
    {
        return this.radius;
    }

    /**
     * Set center point to a new point
     * @param center New center point
     * @return void
     * */
    private void setCenter(Point center)
    {
        this.center = center;
    }

    /**
     * Set radius to new radius
     * @param radius New radius
     * @return void
     * */
    private void setRadius(int radius)
    {
        this.radius = radius;
    }

    /**
     * Format Circle8B object's features
     * @param none
     * @return string representation of circle
     * */
    @Override
    public String toString()
    {
        return String.format("Circle: %s; Center: %s; Radius: %s",
            getShapeName(), center.toString(), radius);
        
    }

    /**
     * Draw out the circle into a group
     * @param group Group circle is in
     * @param c Color of circle/stroke
     * @param fill To fill in circle or not
     * @return void
     * */
    @Override
    public void draw(Group group, Color c, boolean fill)
    {
        if (fill == true)
        {
            //create circle object from Circle class constructor with color
            Circle circle = new Circle(center.getX(), center.getY(), 
                    getRadius(), c);
            group.getChildren().add(circle);
            
        }
        else
        {
            //create circle object from Circle class constructor with no color
            Circle circle = new Circle(center.getX(), center.getY(), 
                    getRadius(), null);  
            //circle not filled so set stroke as given color
            circle.setStroke(c);
            group.getChildren().add(circle);
            
        }
    }

    /**
     * Create a bullseye image
     * @param group Group the circles are in
     * @param fill To fill in the circle or not
     * @param n Number of circles
     * @return void
     * */
    public void drawBullsEye(Group group, boolean fill, int n)
    {
        //generate random color from helper method of shape class
        Color randColor = getRandomColor();

        //base case
        if (n == 0)
        {
            return;
        }
        else
        {
            //draw circle
            draw(group, randColor, fill);
            //decrement radius by 10
            Circle8B inCir = new Circle8B(center, getRadius()-RADIUS_DECREASE);
            //recurse to draw the next smaller circle
            inCir.drawBullsEye(group, fill, n-1);
        }
    }

}
