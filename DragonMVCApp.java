import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
* Sets up and controls the Dragon Application.
* Populates JFrame with Views and registers controller behavior to them, which then uses information from the Model.
* @author Vanessa Gill
* @version October 2012
*/
public class DragonMVCApp implements ChangeListener {
     
     //instance variables
     private DragonModel dm;
     private DragonGraphicDisplay disp;
     private DragonDisplay disp2;
     private final Point TAIL_CONST = new Point (250, 250);

     /**
     * Constructor for DrawingBoard Application
     */ 
     public DragonMVCApp () {
          //create dragonmodel
          dm = new DragonModel();
          //initial values of head location for each dragon
          Point headnorth = new Point (250, 50);
          Point headsouth = new Point (250, 450);
          Point headeast = new Point (450, 250);
          Point headwest = new Point (50, 250);
          //instantiate 4 initial Dragons
          Dragon north = new Dragon(TAIL_CONST, headnorth, 0, false, Color.RED); 
          Dragon south = new Dragon(TAIL_CONST, headsouth, 0, false, Color.BLUE);
          Dragon east = new Dragon(TAIL_CONST, headeast, 0,  false, Color.GREEN);
          Dragon west = new Dragon(TAIL_CONST, headwest, 0, false, Color.BLACK);
          //add dragons to dragonmodel
          dm.addDragon(north);
          dm.addDragon(south);
          dm.addDragon(east);
          dm.addDragon(west); 
          // create & show GUI
          JFrame win = new JFrame("There be Dragons!!!");
          win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
          //IS-A JPanel
          disp = new DragonGraphicDisplay(dm);
          win.getContentPane().add(disp);
          //IS-A JPanel
          disp2 = new DragonDisplay(dm);
          //register slider as listener
          disp2.slider.addChangeListener(this);
          //add to JFrame
          win.getContentPane().add(disp2, BorderLayout.PAGE_END);
          win.pack();
          win.setVisible(true); 
     }
     
     /**
     * Reacts to JSlider movement.
     * Use current value of slider for iteration value.
     * @param ChangeEvent e the ChangeEvent object
     */
     public void stateChanged(ChangeEvent e) {
          disp2.slider = (JSlider)e.getSource();
          int val = (int)disp2.slider.getValue();
          dm.setIteration(val);
     }
    
     /**
     * Run the program
     * @param String[] args Command line arguments.
     */
     public static void main(String[] args) {
          //Schedule a job for the event-dispatching thread:
          //creating and showing this application's GUI.
          javax.swing.SwingUtilities.invokeLater(new Runnable() {
               public void run() {
                    DragonMVCApp myapp = new DragonMVCApp();
               }
          });
     }
}
