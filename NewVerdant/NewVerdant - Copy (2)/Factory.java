
/**
 * Factory, for those who like industrialization
 * 
 * @author Vincent Haron C. Mamutuk
 * @version 1.0 May 18, 2016
 */
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
public class Factory extends BattleGameFactory
{
    private int counter = 0;
    private int innerCounter = 0;
    public static void main(String args[]){
        JFrame x = new JFrame();
        x.setSize(1050,720);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setVisible(true);
        BattleGameFactory map = new Factory();
        x.add(map);
        map.createMap(3,new boolean[]{true,false,false,false},
            new String[]{"ReD","Mr Magic","Mr Butch","Chase"}, true);
        //x.add(map);
        x.addComponentListener(new Resizer(map));
        Rectangle newSize = x.getBounds();
        map.setSize(newSize.width,newSize.height);
        map.setSizeRatio(newSize.width,newSize.height);
        map.gameLoop();
    }
    public Factory(){
        super(20,100,950,100,270,20,700,20);
    }
    public void setup(){
        //taken from http://opengameart.org/content/fossil-cave
        addSpawn(new BackGround("Images//fossil_cave.jpg"));
        DefaultPlatform x = new DefaultPlatform(350,200,125,10);
        x.setXSpeed(-1.5f);
        addSpawn(x);
        x = new DefaultPlatform(525,200,125,10);
        x.setXSpeed(1.5f);
        addSpawn(x);
        x = new DefaultPlatform(0,350,250,10);
        x.setXSpeed(1.5f);
        addSpawn(x);
        x = new DefaultPlatform(750,350,250,10);
        x.setXSpeed(-1.5f);
        addSpawn(x);
        x = new DefaultPlatform(100,120,165,10);
        x.setXSpeed(-1.5f);
        addSpawn(x);
        x = new DefaultPlatform(735,120,165,10);
        x.setXSpeed(1.5f);
        addSpawn(x);
        x = new DefaultPlatform(250,500,150,10);
        x.setXSpeed(3f);
        addSpawn(x);
        addSpawn(new DefaultWall(250,510,9,175));
        x = new DefaultPlatform(600,500,150,10);
        x.setXSpeed(-3f);
        addSpawn(x);
        addSpawn(new DefaultWall(741,510,9,175));
        //addSpawn(new DefaultPlatform(350,500,300,10));
        MovingPlatform g = new MovingPlatform(50,650,150,10);
        addSpawn(g);
        g.setXSpeed2(3.25f);
        g.setMax(210);
        setGravity(.25f);
        setTerVel(10);
    }
    public void gameHook(){
        counter++;
        innerCounter++;
        if(counter==(int)(117*1)){
            counter = 0;
            addSpawn(new Cube("Images\\companion.png", 200, 0, 50, 50));
            addSpawn(new Cube("Images\\companion.png", 750, 0, 50, 50));
        }
        if(innerCounter==(int)(117*1)){
            innerCounter = 0;
            addSpawn(new Cube("Images\\companion.png", 450, 0, 50, 50));
            addSpawn(new Cube("Images\\companion.png", 500, 0, 50, 50));
        }
    }
}