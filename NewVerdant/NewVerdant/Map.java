
/**
 * I'm the Map. I hold Everything. Extend me to create specific maps.
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.1 February 5, 2016
 * Changelog
 * VHCM 1.1 - Added iterative move function of all spawns;
 *          - Added iterative fall function of all spawns;
 *          - Added terminalVelocity and Gravity variables as well as setter methods;
 *          - Added gameLoop function;
 *          - Moved Test code to seperate class
 */
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
public class Map extends Canvas
{
    protected ArrayList<Spawn> spawns = new ArrayList<Spawn>();
    //will be used later Ask Me if curious. -Haron
    protected float widthFactor = 1, heightFactor = 1;
    protected float terminalVelocity = 0, gravity = 0;
    public float flyFactor = 0,jumpFactor = 0;
    private static Map map;

    public static void main(String args[]){
    }

    protected int moveSpawns(){
        for(Spawn e: spawns){
            e.move(0);
        }
        return 0;
    }

    protected int fallSpawns(){
        for(Spawn e: spawns){
            e.fall(gravity,terminalVelocity);
        }
        return 0;
    }

    protected int jumpSpawns(){
        for(Spawn e: spawns){
            e.jump(0);
        }
        return 0;
    }

    protected int flySpawns(){
        for(Spawn e: spawns){
            e.fly(0);
        }
        return 0;
    }

    protected int iterateSpawns(){
        fallSpawns();
        jumpSpawns();
        flySpawns();
        moveSpawns();
        return 0;
    }

    public int gameLoop(){
        setBackground(Color.BLACK);
        while(true){
            iterateSpawns();
            gameHook();
            repaint();
            try{
                Thread.sleep(16);
            }catch(InterruptedException e){
            }
            if(false)
                return 0;
        }
        //return 0;
    }

    public void gameHook(){
        
    }

    public int addSpawn(Spawn spawn){
        spawns.add(spawn);
        return 0;
    }

    public void paint(Graphics g)
    {
        Image buffer = createImage((int)(1000*widthFactor),(int)(700*heightFactor));
        Graphics gg = buffer.getGraphics();
        prePaint(gg);
        g.drawImage(buffer, 0 , 0, this);
    }

    public void update(Graphics g){
        paint(g);
    }

    public int setGravity(float grav){
        gravity = grav;
        return 0;
    }

    public int setTerVel(float tv){
        terminalVelocity = tv;
        return 0;
    }

    public float getTerVel(){
        return terminalVelocity;
    }

    public float getGravity(){
        return gravity;
    }

    public int prePaint(Graphics g)
    {
        //setBackground(Color.BLACK);
        BufferedImage i = null;
        for(Spawn a: spawns){
            try{
                i = ImageIO.read(new File(a.getSprite()));
            }catch(IOException e){
                System.out.println("Failed to find " + a.getSprite()+".");
            }
            float[] temp = a.getLocation();
            g.drawImage(i,(int)(temp[0]*widthFactor),(int)(temp[1]*heightFactor),(int)(
                    temp[2]*widthFactor),(int)(temp[3]*heightFactor),null);
        }
        return 0;
    }
}
