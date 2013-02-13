import java.awt.*;
import java.util. *;

/**
* Dragon Class - a class that creates one dragon object.
* One Dragon is defined as a straight line.
* Each dragon object spawns two new dragons as the iteration increases if the iteration is greater than zero.
* @author Vanessa Gill
* @version October 2012
*/
public class Dragon {

     //instance variables
     private Point tail;
     private Point head;
     private int iteration;
     private boolean isRight;
     private Color color;    
     private Dragon first;
     private Dragon second;
     
     /**
     * Constructor for Dragon. Instantiates a Dragon object.
     * @param tail coordinates for tail of dragon
     * @param head coordinates for head of dragon
     * @param iteration the iteration of the dragon
     * @param isRight boolean value to determine which direction the two new dragons will be spawned in
     * @param color the color of each dragon
     */
     public Dragon(Point tail, Point head, int iteration, boolean isRight, Color color) {
          if (iteration < 0) {
               throw new IllegalArgumentException("Cannot have an iteration below zero.");
          }
          this.tail = tail;
          this.head = head;
          this.isRight = isRight;
          this.color = color;
          //if iteration is greater than zero, initialize two new Dragons for this dragon.
          this.setDragons(iteration);
     }
     
     /**
     * Gets location of the tail point.
     * return Point the coordinates of the tail
     */
     public Point getTail() {
          return tail;
     }
     
     /**
     * Gets location of the head point.
     * return Point the coordinates of the head
     */
     public Point getHead() {
          return head;
     }
     
     /**
     * Gets color of dragon.
     * return Color the color of the dragon
     */
     public Color getColor() {
          return color;
     }
     
     /**
     * Gets current iteration of the dragon.
     * return int the current iteration of the dragon.
     */
     public int getIteration() {
          return iteration;
     }
     
     /**
     * Gets the first initialized new dragon.
     * return Dragon the first new dragon
     */
     public Dragon getFirstDragon() {
          return first;
     }
     
     /**
     * Gets the second initialized new dragon.
     * return Dragon the second new dragon
     */
     public Dragon getSecondDragon() {
          return second;
     }
     
     //find new head point
     private Point newHead(boolean isRight) {
          //midpoint of line
          double midX = (getHead().getX()+getTail().getX())/2;
          double midY = (getHead().getY()+getTail().getY())/2;
          //initialize new x and y coordinates
          double peakX; 
          double peakY;
          //initialize new point
          Point peak;
          //calculate new head point based if the new dragons are spawning to the left or right
          if ((isRight)){
               peakX = midX + (getTail().getY()-getHead().getY())/2;
               peakY = midY + (getHead().getX()-getTail().getX())/2;
          } else {
               peakX = midX - (getTail().getY()-getHead().getY())/2;
               peakY = midY - (getHead().getX()-getTail().getX())/2;
          }
          //set coordinates for new head point
          peak = new Point();
          peak.setLocation(peakX, peakY);
          return peak;
     }
     
     /**
     * Method that "spawns" two new dragons for THIS dragon.
     * @param iterate the number of iterations
     */
     public void setDragons(int iterate) {
          //assign iterate to class variable for use in the constructor
          iteration = iterate;
          //base case
          if (iterate == 0) {
               first = null;
               second = null;
          } else {
               //find coordinates of new head/tail point for the two new dragons
               Point newPeak = newHead(isRight);
               //recursion: each new dragon calls setDragons(iteration-1) in it's constructor. trickles down until hits base case.
               first = new Dragon(tail, newPeak, iteration-1, false, color);
               second = new Dragon(newPeak, head, iteration-1, true, color);
          }
     }
     
     /**
     * Method that draws a dragon.
     * @param Graphics g the graphics object that does the drawing
     */
     public void drawDragon(Graphics g) {
          if (iteration == 0) {
               g.setColor(getColor());
               g.drawLine((int)getTail().getX(), (int)getTail().getY(), (int)getHead().getX(), (int)getHead().getY());
          } else {
               //recursion: checks all "spawns" to see if they're at the base case - a dragon only draws itself when it's at iteration 0.
               getFirstDragon().drawDragon(g);
               getSecondDragon().drawDragon(g);
          }
     }

}
