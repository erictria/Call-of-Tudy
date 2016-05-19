
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
    JFrame x;
    public OpenMain(JFrame x){
        this.x = x;
    }

    public void windowClosing(WindowEvent e){
        //Thread array[] = new Thread[5];
        //GameStarter.hello.interrupt();
        /*GameStarter.hello.enumerate(array);
        for(int i = 0; i!=5; i++){
        if(array[i]!=null){
        System.out.println("Hey");
        array[i].interrupt();
        }
        }*/
        //GameStarter.hello.destroy();
        //System.out.println();
        //System.out.println("Hello");
        x.dispose();
        GameStarter.runMe = false;
        JFrame f = new LaunchGame();
        try{
            Thread.sleep(120);
        }catch(Exception a){}
        GameStarter.runMe = true;
    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
            x.dispose();
            JFrame f = new LaunchGame();
        }
    }

    public void keyReleased(KeyEvent e){
    }

    public void keyTyped(KeyEvent e){
    }
}