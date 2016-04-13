
/**
 * I'm the Map. I hold Everything. Extend me to create specific maps.
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.4 April 13, 2016
 * Changelog
 * VHCM 1.4 - Added Collision and Kill
 * VHCM 1.3 - Added Resize Capabilities
 * VHCM 1.2 - Added player ArrayList.
 *          - Added giveMap function.
 *          - Added rotateSize Capabilities.
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
    private ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
    private ArrayList<String> imageNames = new ArrayList<String>();
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
    
    protected int collideSpawns(){
        for(int i = 0; i!=spawns.size();i++){
            Spawn a = spawns.get(i);
            for(int j = i+1; j!=spawns.size(); j++){
                Spawn b = spawns.get(j);
                if(Spawn.checkCollisionWithSpawn(a.getLocation(),b.getLocation())==1){
                    b.collisionPassive(a.collisionActive(b));
                    a.collisionPassive(b.collisionActive(a));
                }
            }
        }
        return 0;
    }
    
    protected int removeSpawns(){
        for(int i = 0; i!=spawns.size();i++){
            Spawn a = spawns.get(i);
            if(a.isDead()){
                spawns.remove(i);
                i--;
            }
        }
        return 0;
    }

    protected int iterateSpawns(){
        fallSpawns();
        jumpSpawns();
        flySpawns();
        moveSpawns();
        collideSpawns();
        removeSpawns();
        return 0;
    }

    public int gameLoop(){
        long timeElapsed = System.nanoTime();
        //System.out.println(timeElapsed);
        setBackground(Color.BLUE);
        while(true){
            //System.out.println(System.nanoTime()-timeElapsed);
            timeElapsed = System.nanoTime();
            //System.out.println(timeElapsed);
            gameHook();
            iterateSpawns();
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
    
    public int setCage(){
        addSpawn(new DefaultPlatform(0,-50,1000,50));
        addSpawn(new DefaultWall(-50,0,50,700));
        addSpawn(new DefaultWall(1000,0,50,700));
        return 0;
    }

    public int prePaint(Graphics g)
    {
        //setBackground(Color.BLACK);
        for(Spawn a: spawns){
            String sprite = a.getSprite();
            BufferedImage i = null;
            //System.out.println(sprite);
            for(int counter = 0; counter!=imageNames.size(); counter++){
                if(imageNames.get(counter).equals(sprite)){
                    //System.out.println(imageNames.get(counter));
                    i = images.get(counter);
                }
            }
            if(i==null){
                //System.out.println(sprite);
                try{
                    i = ImageIO.read(new File(sprite));
                    //System.out.println(sprite);
                    images.add(i);
                    imageNames.add(sprite);
                }catch(IOException e){
                    System.out.println("Failed to find " + sprite+".");
                }
            }

            float[] temp = a.getLocation();
            float widther = temp[2]*widthFactor/i.getWidth();
            float heighter = (temp[3]*heightFactor)/i.getHeight();
            AffineTransform matrix = AffineTransform.getTranslateInstance((int)(temp[0]*widthFactor),
                        (int)(temp[1]*heightFactor));
            matrix.scale(widther,heighter);
            matrix.rotate(Math.toRadians(temp[5]),i.getWidth()/2,i.getHeight()/2);
            
            Graphics2D gg = (Graphics2D) g;
            gg.drawImage(i,matrix,null);
            /*double rotationRequired = Math.toRadians(temp[5]);
            double locationX = i.getWidth() / 2;
            double locationY = i.getHeight() / 2;
            AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            float widther = temp[2]*widthFactor;
            float heighter = (temp[3]*heightFactor);
            //g.drawImage(i,tx,null);
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
    
    public void setSizeRatio(float x, float y){
        widthFactor = x/1000;
        heightFactor = y/700;
    }
}