
/**
 * I'm the Map. I hold Everything. Extend me to create specific maps.
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.2 April 9, 2016
 * Changelog
 * VHCM 1.2 - Added player ArrayList.
 *          - Added giveMap function.
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
import java.awt.geom.*;
public class Map extends Canvas
{
    protected ArrayList<Spawn> spawns = new ArrayList<Spawn>();
    protected ArrayList<Spawn> players = new ArrayList<Spawn>();
    //will be used later Ask Me if curious. -Haron
    protected float widthFactor = 1, heightFactor = 1;
    protected float terminalVelocity = 0, gravity = 0;
    public float flyFactor = 0,jumpFactor = 0;
    private static Map map;

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
        long timeElapsed = System.nanoTime();
        //System.out.println(timeElapsed);
        setBackground(Color.BLACK);
        while(true){
            //System.out.println(System.nanoTime()-timeElapsed);
            timeElapsed = System.nanoTime();
            //System.out.println(timeElapsed);
            iterateSpawns();
            gameHook();
            repaint();
            long timer = System.nanoTime() - timeElapsed;
            //System.out.println(timer);
            try{
                Thread.sleep((17*1000000-timer)/1000000);
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
            double rotationRequired = Math.toRadians(temp[5]);
            double locationX = i.getWidth() / 2;
            double locationY = i.getHeight() / 2;
            AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            float widther = temp[2]*widthFactor;
            float heighter = (temp[3]*heightFactor);
            g.drawImage(op.filter(i,null),(int)(temp[0]*widthFactor),(int)(temp[1]*heightFactor),(int) 
                    normalize(widther,heighter,rotationRequired,true),(int)normalize(widther,heighter,rotationRequired,false),null);
            /*g.drawImage(i,(int)(temp[0]*widthFactor),(int)(temp[1]*heightFactor),(int)(
            temp[2]*widthFactor),(int)(temp[3]*heightFactor),null);*/             
        }
        return 0;
    }

    public String[][] giveMap(){
        String[][] returnValue = new String[spawns.size()+players.size()][6];
        for(int i = 0; i!=spawns.size(); i++){
            returnValue[i] = spawns.get(i).getLocationPlusSprite();
        }
        for(int i = 0; i!=players.size(); i++){
            returnValue[i+spawns.size()] = players.get(i).getLocationPlusSprite();
        }
        return returnValue;
    }
    
    public static double normalize(float x, float y, double radians, boolean isX){
        if(!isX){
            radians-=Math.toRadians(90);
        }
        return Math.sqrt(Math.abs(x*x*Math.cos(radians))+Math.abs(y*y*Math.sin(radians)));
    }
}
