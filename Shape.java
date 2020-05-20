/**
 * Author: Vicki Chen
 * CSE8B Login: cs8wamh
 * Date: 2/26/19
 * File: Shape.java
 * Source of Help: PA5 write up
 * 
 * This file contains the abstract class Shape.
 * Provides a simple blueprint of the properties of a general shape
 * */

import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import java.util.*;

/**
 * This class contains abstact methods on how to manipulate a shapes' name,
 * draw out shapes, format a string representation of a shape, and generate
 * a random color
 * */
public abstract class Shape
{
    private String shapeName;
    private static final String DEFAULT_NAME = "NoName";

    /**
     * Intializes a Shape object when given a name
     * @param shapeName name of Shape
     * @return          Shape object created
     * */
    public Shape(String shapeName)
    {
        this.shapeName = shapeName;
    }

    /**
     * Initializes a default Shape object
     * @param none
     * @return Shape object created
     * */
    public Shape()
    {
        this.shapeName = DEFAULT_NAME;
    }

    /**
     * Get shape object's name
     * @param none
     * @return name of the shape
     * */
    public String getShapeName()
    {
        return this.shapeName;
    }

    /**
     * set shapeName to new name
     * @param newName new name given
     * @return void
     * */
    public void setShapeName(String newName)
    {
        this.shapeName = newName;
    }

    /**
     * Draw out shape
     * @param group Group shape is in
     * @param c Color of shape
     * @param fill To fill in shape or not
     * @return void
     * */
    public abstract void draw(Group group, Color c, boolean fill);

    /**
     * Format shape objects' features (name)
     * @param none
     * @return shape's name
     * */
    public String toString()
    {
        return getShapeName();
    }

    /**
     * Generate random color
     * @param none
     * @return randomized color
     * */
    public static Color getRandomColor()
    {
        Random random = new Random();
        //set randomzied num to a Color object
        double r = random.nextDouble(),
               g = random.nextDouble(),
               b = random.nextDouble();
        return new Color(r, g, b, 1); //Color constructor
    }


}
