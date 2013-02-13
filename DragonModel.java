import java.awt.*;
import java.util.*;

/**
* Class DragonModel - a class that keeps track of my Dragon objects and notifies views of changes.
* 
* @author Vanessa Gill
* @version October 2012
*/
public class DragonModel {

     //instance variables
     //list of shapes in DragonModel
     public ArrayList<Dragon> myList;
     //list of views for DragonModel
     private ArrayList<DragonViewer> viewerList;
     
     /**
     * Constructor for DragonModel - constructs a new DragonModel object.
     */
     public DragonModel() {
          myList = new ArrayList<Dragon>();
          viewerList = new ArrayList<DragonViewer>();           
     }
     
     /**
     * Adds a Dragon to DragonModel.
     * @param Dragon d the dragon to add to the DragonModel
     */
     public void addDragon(Dragon d) {
          myList.add(d);
          notifyAllViewers();
     }
     
     /**
     * Removes all dragons from DragonModel
     */
     public void emptyList() {
          myList.clear();
          notifyAllViewers();        
     }
     
     
     /**
     * For each dragon in the DragonModel, calls setDragons(iteration).
     * Uses that value to set its iteration and if iteration > 0, spawn new dragons.
     * Notifies viewers to update/redraw themselves.
     * @param int iteration the specified iteration
     */
     public void setIteration(int iteration) {
          for(int i = 0; i < myList.size(); i ++) {
               //grab dragon from list
               Dragon d = myList.get(i);
               //change iteration
               d.setDragons(iteration);
          }
          notifyAllViewers();         
     }
     
     /**
     * Register the given view with this DragonModel
     * @param dv the interested Viewer
     * @throws NullPointerException if dv == null
     */
     public void signUpViewer(DragonViewer dv) {
          if (dv == null){
               throw new NullPointerException();
          }
          viewerList.add(dv);
          dv.drawingChanged(); 
     }
     
     //notify viewers of change in DragonModel
     private void notifyAllViewers() {
          Iterator<DragonViewer> it = viewerList.iterator();
          while (it.hasNext()) {
               DragonViewer dv = it.next();
               dv.drawingChanged();
          }
     }

}  
     
