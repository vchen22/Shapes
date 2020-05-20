/**
 * Author: Vicki Chen
 * CSE8B Login: cs8wamh
 * Date: 2/26/19
 * File: Triangle.java
 * Source of Help: PA5 write up, Piazza, CSE8B tutors
 * 
 * This file contains the subclass Triangle.
 * It can create Triangle objects and draw it out
 * */

import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import java.util.*;

/**
 * This class contains methods that can access and manipulate the Triangle 
 * objects' p1, p2, p3, and use those point to digitally
 * draw out the triangles
 * */
public class Triangle extends Shape
{
    private Point p1;
    private Point p2;
    private Point p3;
    private static final String DEFAULT_NAME = "NoName";
    private static final int DIVIDE_TWO = 2;

    /**
     * Intializes a Triangle object when given 3 points by deep-copying
     * @param p1 Point one
     * @param p2 Point two
     * @param p3 Point three
     * @return   Triangle object created
     * */
    public Triangle(Point p1, Point p2, Point p3)
    {
        super(DEFAULT_NAME);
        this.setP1(new Point(p1));
        this.setP2(new Point(p2));
        this.setP3(new Point(p3));
    }

    /**
     * Intializes a Triangle object when given 3 points and a name by
     * deep-copying
     * @param p1 Point one
     * @param p2 Point two
     * @param p3 Point three
     * @param name Name of Triangle
     * @return     Triangle object created
     * */
    public Triangle(Point p1, Point p2, Point p3, String name)
    {
        super(name);
        this.setP1(new Point(p1));
        this.setP2(new Point(p2));
        this.setP3(new Point(p3));
    }

    /**
     * Intializes a Triangle object when given another Triangle object and
     * extracting its data by deep-copying
     * @param tri Other Triangle object
     * @return    Triangle object created
     * */
    public Triangle(Triangle tri)
    {
        super(DEFAULT_NAME);
        this.setP1(new Point(tri.getP1()));
        this.setP2(new Point(tri.getP2()));
        this.setP3(new Point(tri.getP3()));          
    }

    /**
     * Intializes a default Triangle object
     * @param none
     * @return     Triangle object created
     * */
    public Triangle()
    {
        super(DEFAULT_NAME);
        this.setP1(new Point(0, 0));
        this.setP2(new Point(0, 0));
        this.setP3(new Point(0, 0));                
    }

    /**
     * Get coordinate of point one
     * @param none
     * @return coordinate of point one
     * */
    public Point getP1()
    {
        return this.p1;
    }

    /**
     * Get coordinate of point two
     * @param none
     * @return coordinate of point two
     * */
    public Point getP2()
    {
        return this.p2;
    }

    /**
     * Get coordinate of point three
     * @param none
     * @return coordinate of point three
     * */
    public Point getP3()
    {
        return this.p3;
    }

    /**
     * Set p1 to new point
     * @param p1 point one
     * @return void
     * */
    private void setP1(Point p1)
    {
        this.p1 = p1;
    }

    /**
     * set p2 to new point
     * @param p2 point two
     * @return void
     * */
    private void setP2(Point p2)
    {
        this.p2 = p2;
    }

    /**
     * set p3 to new point
     * @param p3 point three
     * @return void
     * */
    private void setP3(Point p3)
    {
        this.p3 = p3;
    }

    /**
     * Format Triangle object's features
     * @param none
     * @return string representation of triangle
     * */  
    @Override
    public String toString()
    {
         return String.format("Triangle: %s; p1: %s; p2: %s; p3: %s",
            getShapeName(), p1.toString(), p2.toString(), p3.toString());  
    }

    /**
     * Draw out triangles into a group
     * @param group Group triangles are in
     * @param c Color of Triangle
     * @param fill To fill in the triangle or not
     * @return void
     * */
    @Override
    public void draw(Group group, Color c, boolean fill)
    {
        //put points into an array because polygon constructor takes
        //in an array
        double[] pointList = {p1.getX(), p1.getY(), p2.getX(), p2.getY(),
            p3.getX(), p3.getY()};

        if (fill == true)
        {
            //polygon constructor
            Polygon triangle = new Polygon(pointList);
            //fill with given color
            triangle.setFill(c);
            group.getChildren().add(triangle);
            
        }
        else
        {
            //polygon constructor
            Polygon triangle = new Polygon(pointList); 
            //set stroke because no fill
            triangle.setStroke(c);
            //need to make no fill so make it null
            triangle.setFill(null);
            group.getChildren().add(triangle);
            
        }
    }

    /**
     * Create a Triforce image
     * @param group Group the triangles are in
     * @param fill To fill in the triangles or not
     * @param n Number of triangles
     * @return void
     * */
    public void drawTriforce(Group group, boolean fill, int n)
    {
        Color randColor = getRandomColor();

        //base case
        if (n == 0)
        {
            return;
        }
        else
        {
            draw(group, randColor, fill);

            //store current coordinate points
            int tempP1x = p1.getX();
            int tempP1y = p1.getY();
            int tempP2x = p2.getX();
            int tempP2y = p2.getY();
            int tempP3x = p3.getX();
            int tempP3y = p3.getY();
                 
            //use midpoint formula and temp vars to find 3 new points
            Point mid1 = new Point((tempP1x+tempP2x)/DIVIDE_TWO, 
                        (tempP1y+tempP2y)/DIVIDE_TWO);
            Point mid2 = new Point((tempP2x+tempP3x)/DIVIDE_TWO, 
                        (tempP2y+tempP3y)/DIVIDE_TWO); 
            Point mid3 = new Point((tempP1x+tempP3x)/DIVIDE_TWO, 
                        (tempP1y+tempP3y)/DIVIDE_TWO); 
            Triangle innerTri = new Triangle(mid1, mid2, mid3);
            innerTri.drawTriforce(group, fill, n-1);
        }
    }
}

    

