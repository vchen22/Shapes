/**
 * Author: Vicki Chen
 * CSE8B Login: cs8wamh
 * Date: 2/26/19
 * File: README.md
 * Source of Help: PA5 write up, week 6 and week 7 lecture slides
 * 
 * This file contains the answers to PA5 write up's README question
 * */

Program Description
The Shape class is a general blueprint of what properties a general shape
should have. All classes under the Shape class also takes in the properties
Shape has but will also have its own specific properties that differentiate
itself from others and from Shape. Line8B has more specific 
properties such as having two points that will connect to draw a line.
Circle8B has a center point where it will draw a circle from it with a given
radius. Square takes in a set of coordinates that would be the upperLeft
corner of the square and draw out the rest of the square using the given side
length. Triangle takes in three points and connect the three points.

Short Response
1. Recursion is way to solve a problem by breaking down a problem into smaller
problems. This can be achieved by making a function call on itself 
with a smaller set of inputs until it hits a base case. A base case is a 
scenario that allows recursive function to know when to stop calling itself.

2. Recursion calls on the function itself, so it is defined by itself. While
iteration executes a statement repeatedly until a condition is met using loops.
Recursion uses more memory compared to iteration. And recursion makes code
much shorter than iteration.

3. Following the write up's instruction, I made sure all the constructors
correlate to the different given datas like if it was not given a name, I 
I would make sure to pass in NoName. Then for the specific instance variables,
I made methods in order to access it and to change it. Next, I created each
classes own specific toString method because it has different properties and
points. To draw each shape, I looked for the correlating constructors in the
java documentation that will take in the information each class has. Next,
for the recursion calls, I made sure to do the calculations for next set of
parameters that will make the function smaller. For example, I will make sure
to decrement the radius in Circle8B to draw the inner circles.

4. There were many different constructors, so I would often get compile errors
because my data types didn't match. The most difficult was calculating the
next set of parameter inputs for the next recursive call. For example, for
Triangle, I forgot to store the points before finding the midpoint, so I was
trying to calculate the new midpoints with the new points not the old points.
I solved these problems by drawing out the shapes the outputs of each
recursive call and looking for the patterns. In fibonacci, I noticed that 
in each angle the center points moves in certain manner, so by looking
at a visualization, I was able to create a formula.

