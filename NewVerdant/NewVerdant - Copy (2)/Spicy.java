
/**
 * Classic Map with a little bit of spice
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
public class Spicy extends BattleGameFactory
{
    public static void main(String args[]){
        JFrame x = new JFrame();
        x.setSize(1050,720);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setVisible(true);
        BattleGameFactory map = new Spicy();
        x.add(map);
        map.createMap(3,new boolean[]{true,false,false,false},
            new String[]{"ReD","Chase","Mr Butch","Mr Magic"}, true);
        //x.add(map);
        x.addComponentListener(new Resizer(map));
        Rectangle newSize = x.getBounds();
        map.setSize(newSize.width,newSize.height);
        map.setSizeRatio(newSize.width,newSize.height);
        map.gameLoop();
    }
    public Spicy(){
        super(20,20,800,20,100,400,950,400);
    }
    public void setup(){
        //taken from http://opengameart.org/content/space-backgrounds-3
        addSpawn(new BackGround("Images//Background-4.png"));
        addSpawn(new DefaultPlatform(0,650,350,50));
        addSpawn(new DefaultPlatform(650,650,350,50));
        addSpawn(new DefaultPlatform(0,350,200,10));
        addSpawn(new DefaultPlatform(800,350,200,10));
        addSpawn(new DefaultPlatform(350,100,300,10));
        addSpawn(new DefaultPlatform(350,500,300,10));
        addSpawn(new MovingPlatform(200,200,150,10));
        addSpawn(new DefaultWall(495,69,10,140));
        addSpawn(new DefaultWall(495,300,10,100));
        Obstacle cc = new Cube("Images\\companion.png", 475, 450, 50, 50);
        addSpawn(cc);
        Obstacle cD = new Cube("Images\\companion.png", 475, 400, 50, 50);
        addSpawn(cD);
        setGravity(.25f);
        setTerVel(10);
    }
}
