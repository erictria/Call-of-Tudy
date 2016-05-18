
/**
 * Added to JFrames to resize the map there.
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.0 April 10, 2016
 */
import java.awt.event.*;
import java.awt.*;
public class Resizer implements ComponentListener {
    Map map;
    public Resizer(Map map){
        this.map = map;
    }
    
    public void componentHidden(ComponentEvent e) {}

    public void componentMoved(ComponentEvent e) {}

    public void componentShown(ComponentEvent e) {}

    public void componentResized(ComponentEvent e) {
        Rectangle newSize = e.getComponent().getBounds();
        map.setSize(newSize.width,newSize.height);
        map.setSizeRatio(newSize.width,newSize.height);
    }   
}