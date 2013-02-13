import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

/**
* View that displays custom drawing shapes on the DragonModel.
* 
* @author Vanessa Gill
* @version October 2012
*/
public class DragonGraphicDisplay extends JPanel implements DragonViewer {

     //instance variable 
     private DragonModel dm;

     /**
     * Constructor for DragonGraphicDisplay. IS-A JPanel.
     * @param DragonModel dm The dragonmodel that this viewer is assigned to.
     */
     public DragonGraphicDisplay(DragonModel dm) {
          super();
          this.setPreferredSize(new Dimension(500, 500));
          this.dm = dm;
          dm.signUpViewer(this);
          setBackground(Color.WHITE);
     }
     
     /**
     * Method implemented from DragonViewer interface. Tells view what to do when model notifies it of a change.
     */
     public void drawingChanged() {
          //dragon model has changed - update display
          //call repaint since custom drawing. repaint calls paintComponent().
          this.repaint();
     }

     /**
     * Override method inherited from JPanel to draw graphics.
     * @param Graphics g The Graphics object that does the drawing.
     */
     public void paintComponent(Graphics g) {
          super.paintComponent(g);
          Iterator<Dragon> it = dm.myList.iterator();
          while (it.hasNext()){
               Dragon d = it.next();
               d.drawDragon(g);
          }   
     }
     
}
