
/**
 * Added to JFrames to resize the map there.
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.0 April 10, 2016
 */
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class OpenMain extends WindowAdapter implements KeyListener {
    public void windowClosing(WindowEvent e){
        Thread array[] = new Thread[5];
        GameStarter.hello.enumerate(array);
        for(int i = 0; i!=5; i++){
            if(array[i]!=null){
                array[i].interrupt();
            }
        }
        //System.out.println();
        //System.out.println("Hello");
        JFrame f = new LaunchGame();
    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
            //dispose();
            JFrame f = new LaunchGame();
        }
    }

    public void keyReleased(KeyEvent e){
    }

    public void keyTyped(KeyEvent e){
    }
}