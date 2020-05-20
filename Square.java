/**
 * Author: Vicki Chen
 * CSE8B Login: cs8wamh
 * Date: 2/26/19
 * File: Square.java
 * Source of Help: PA5 write up, CSE8B tutors
 * 
 * This file contains the subclass Square.
 * It can create Square objects and draw it out
 * */

import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import java.util.*;

/**
 * This class contains methods that can access and manipulate the Triangle 
 * objects' upperLeft point and side length, and use those features to 
 * digitally draw out the triangles
 * */
public class Square extends Shape
{
    private int side;
    private Point upperLeft;
    private static final String DEFAULT_NAME = "NoName";

    /**
     * Intializes a Square object when given a upperLeft point and side length
     * by deep-copying
     * @param upperLeft Upperleft point of square
     * @param side Side length
     * @return     Square object created
     * */
    public Square(Point upperLeft, int side)
    {
        super(DEFAULT_NAME);
        this.setUpperLeft(new Point(upperLeft));
        this.setSide(side);
    }

    /**
     * Initializes a Square object when given a upperLeft point, side length,
     * and a name by deep-copying
     * @param upperLeft upperLeft point
     * @param side Side Length
     * @param name Name of square
     * @return     Square object created
     * */
    public Square(Point upperLeft, int side, String name)
    {
        super(name);
        this.setUpperLeft(new Point(upperLeft));
        this.setSide(side);
    }

    /**
     * Initializes a Square object when given another Square object by
     * extracting its data and deep-copying
     * @param square Other Square object
     * @return       Square object created
     * */
    public Square(Square square)
    {
        super(DEFAULT_NAME);
        this.setUpperLeft(new Point(square.getUpperLeft()));
        this.setSide(square.getSide());       
    }

    /**
     * Intializes a default Square object
     * @param none
     * @return Square object created
     * */
    public Square()
    {
        super(DEFAULT_NAME);
        this.setUpperLeft(new Point(0,0));
        this.setSide(0);
        
    }

    /**
     * Get side length
     * @param none
     * @return side length of square
     * */
    public int getSide()
    {
        return this.side;
    }

    /**
     * get upperLeft point
     * @param none
     * @return upperLeft point of square
     * */
    public Point getUpperLeft()
    {
        return this.upperLeft;
    }

    /**
     * set upperLeft to a new point
     * @param upperLeft upperLeft point
     * @return void
     * */
    private void setUpperLeft(Point upperLeft)
    {
        this.upperLeft = upperLeft;
    }

    /**
     * set side to new side length
     * @param side Side length
     * @return void
     * */
    private void setSide(int side)
    {
        this.side = side;
    }

     /**
     * Format Square object's features
     * @param none
     * @return string representation of square
     * */     
    @Override
    public String toString()
    {
        return String.format("Square: %s; upperLeft: %s; side: %s",
            getShapeName(), upperLeft.toString(), side);
        
    }

    /**
     * Draw out the circle into a group
     * @param group Group square is in
     * @param c Color of square/stroke
     * @param fill To fill in square or not
     * @return void
     * */    
    @Override
    public void draw(Group group, Color c, boolean fill)
    {
        if (fill == true)
        {
            //rectangle constructor
            Rectangle square = new Rectangle(upperLeft.getX(), 
                    upperLeft.getY(), side, side);
            //fill with given color
            square.setFill(c);
            group.getChildren().add(square);            
        }
        else
        {
            //rectangle constructor
            Rectangle square = new Rectangle(upperLeft.getX(), 
                    upperLeft.getY(), side, side); 
            //no fill so set stroke with color
            square.setStroke(c);
            //no fill so set as null
            square.setFill(null);
            group.getChildren().add(square);            
        }
    }

    /**
     * Create a checkboard grid image
     * @param group Group the squares are in
     * @param fill To fill in the square or not
     * @param n Number of squares
     * @return void
     * */
    public void drawGrid(Group group, boolean fill, int n)
    {
        if (n == 0)
        {
            return;
        }
        else
        {
            Color randColor = getRandomColor();
            draw(group, randColor, fill);

            int tempX = getUpperLeft().getX();
            int tempY = getUpperLeft().getY();

            //draw top left corner squares
            Square topLeft = new Square(new Point(tempX-getSide(), 
                        tempY-getSide()), getSide());
            topLeft.drawGrid(group, fill, n-1);

            //draw top right corner sqaures
            Square topRight = new Square(new Point(tempX+getSide(), 
                        tempY-getSide()), getSide());
            topRight.drawGrid(group, fill, n-1);
            
            //draw bottom left corner squares
            Square botLeft = new Square(new Point(tempX-getSide(), 
                        tempY+getSide()), getSide());
            botLeft.drawGrid(group, fill, n-1);

            //draw bottom right corner squares
            Square botRight = new Square(new Point(tempX+getSide(), 
                        tempY+getSide()), getSide());
            botRight.drawGrid(group, fill, n-1);

        }
    }
}
