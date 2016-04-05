
/**
 * I'm the Map. I hold Everything. Extend me to create specific maps.
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.0 March 28
 * Changelog
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
    private static Map map;

    public static void main(String args[]){
        JFrame x = new JFrame();
        x.setSize(1050,720);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setVisible(true);
        map = new Map();
        x.add(map);
        /*map.addSpawn(new SpawnExample(0,0,20,20));
        map.addSpawn(new SpawnExample(450,350,70,100));
        */
        addSpawnRandTestFunc(20);
        //x.add();
    }
    
    //Test Function, not useful
    private static void addSpawnRandTestFunc(int x){
        for(int i =0;i!=x;i++){
            map.addSpawn(new TESTSpawnExample((int)(Math.random()*500+250),(int)(
            Math.random()*500+100),(int)(Math.random()*50+25),(int)(Math.random()*50+25)));
        }
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

    public int prePaint(Graphics g)
    {
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
