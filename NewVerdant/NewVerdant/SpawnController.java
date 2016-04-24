
/**
 * SpawnController, to make using easier.
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version April 17, 2016
 */
import java.awt.event.*;
public abstract class SpawnController implements KeyListener
{
    //Override to make it actually do something.
    public abstract void listenHook();
    
    protected Spawn mySpawn;
    protected boolean up = false, down = false, left = false, right = false, action1 = false, 
        action2 = false, action3 = false, action4 = false, dirUp = false, dirLeft = false, 
        dirRight = false, dirDown = false, dirUpLeft = false, dirUpRight = false, 
        dirDownRight = false, dirDownLeft = false;
    protected int[] buttonKeys;
    public SpawnController(Spawn e){
        mySpawn = e;
        int i = 0;
        buttonKeys = new int[20];
        buttonKeys[i++] = KeyEvent.VK_UP;
        buttonKeys[i++] = KeyEvent.VK_DOWN;
        buttonKeys[i++] = KeyEvent.VK_LEFT;
        buttonKeys[i++] = KeyEvent.VK_RIGHT;
        buttonKeys[i++] = KeyEvent.VK_Q;
        buttonKeys[i++] = KeyEvent.VK_E;
        buttonKeys[i++] = KeyEvent.VK_R;
        buttonKeys[i++] = KeyEvent.VK_F;
        buttonKeys[i++] = KeyEvent.VK_W;
        buttonKeys[i++] = KeyEvent.VK_A;
        buttonKeys[i++] = KeyEvent.VK_D;
        buttonKeys[i++] = KeyEvent.VK_S;
    }
    
    public void keyReleased(KeyEvent e){
        int i = 0;
        if(e.getKeyCode() == buttonKeys[i++])
            up = false;
        else if(e.getKeyCode() == buttonKeys[i++])
            down = false;
        else if(e.getKeyCode() == buttonKeys[i++])
            left = false;
        else if(e.getKeyCode() == buttonKeys[i++])
            right = false;
        else if(e.getKeyCode() == buttonKeys[i++])
            action1 = false;
        else if(e.getKeyCode() == buttonKeys[i++])
            action2 = false;
        else if(e.getKeyCode() == buttonKeys[i++])
            action3 = false;
        else if(e.getKeyCode() == buttonKeys[i++])
            action4 = false;
        else if(e.getKeyCode() == buttonKeys[i++])
            dirUp = false;
        else if(e.getKeyCode() == buttonKeys[i++])
            dirLeft = false;
        else if(e.getKeyCode() == buttonKeys[i++])
            dirRight = false;
        else if(e.getKeyCode() == buttonKeys[i++])
            dirDown = false;
        //System.out.println(e.getKeyCode());
    }
    
    public void keyPressed(KeyEvent e){
        int i = 0;
        if(e.getKeyCode() == buttonKeys[i++])
            up = true;
        else if(e.getKeyCode() == buttonKeys[i++])
            down = true;
        else if(e.getKeyCode() == buttonKeys[i++])
            left = true;
        else if(e.getKeyCode() == buttonKeys[i++])
            right = true;
        else if(e.getKeyCode() == buttonKeys[i++])
            action1 = true;
        else if(e.getKeyCode() == buttonKeys[i++])
            action2 = true;
        else if(e.getKeyCode() == buttonKeys[i++])
            action3 = true;
        else if(e.getKeyCode() == buttonKeys[i++])
            action4 = true;
        else if(e.getKeyCode() == buttonKeys[i++])
            dirUp = true;
        else if(e.getKeyCode() == buttonKeys[i++])
            dirLeft = true;
        else if(e.getKeyCode() == buttonKeys[i++])
            dirRight = true;
        else if(e.getKeyCode() == buttonKeys[i++])
            dirDown = true;
    }
    
    public void keyTyped(KeyEvent e){
    }
}
