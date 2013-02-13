/**
 * Listener interface for DragonModel.
 * 
 * @author Vanessa Gill
 * @version October 2012
 */
public interface DragonViewer {
     
     /**
     * All viewers must run this method to update their view when a change has been made to the model.
     */
     public void drawingChanged();
  
}
