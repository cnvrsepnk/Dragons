import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
* View that displays the number of iterations the Heighway Dragon is currently at.
* @author Vanessa Gill
* @version October 2012
*/
public class DragonDisplay extends JPanel implements DragonViewer {
     
     //instance variables
     private DragonModel dm;
     public JSlider slider;
     private JLabel it_num;
     
     /**
     * Constructor for DragonDisplay. IS-A JPanel.
     * @param DragonModel dm The dragonmodel that this viewer is assigned to.
     */
     public DragonDisplay(DragonModel dm) {
          super();
          this.setPreferredSize(new Dimension(500, 40));
          slider = new JSlider(0, 16, 0); //set upper limit to 16 instead of 20 because my computer is OLD and it was crashing at 18.
          this.add(slider);
          it_num = new JLabel();
          this.add(it_num);
          this.dm = dm;
          dm.signUpViewer(this); 
          setBackground(Color.LIGHT_GRAY);
     }

     /**
     * Method implemented from DragonViewer interface. Tells view what to do when model notifies it of a change.
     */
     public void drawingChanged() { 
          it_num.setText("" + slider.getValue());
     }
     
     
}
