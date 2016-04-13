//JUST A TEST. Expected output is a bunch of pinkRed boxes that are platforms that disappear after a while
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
public class TESTMapVHCM8 extends Map
{
    static Map map;
    public static void main(String args[]){
        JFrame x = new JFrame();
        x.setSize(1050,720);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setVisible(true);
        map = new TESTMapVHCM8();
        x.add(map);
        x.addComponentListener(new Resizer(map));
        /*map.addSpawn(new SpawnExample(0,0,20,20));
        map.addSpawn(new SpawnExample(450,350,70,100));
         */
        //addSpawnRandTestFunc(20);
        map.setCage();
        map.setGravity(0.05f);
        map.setTerVel(10);
        map.addSpawn(new TESTSpawnVHCMExample8(0,650,1000,50));
        map.addSpawn(new TESTSpawnVHCMExample8(0,350,200,25));
        map.addSpawn(new TESTSpawnVHCMExample8(800,350,200,25));
        map.addSpawn(new TESTSpawnVHCMExample8(350,100,300,25));
        map.addSpawn(new TESTSpawnVHCMExample8(350,500,300,25));
        map.addSpawn(new TESTSpawnVHCMExample8(480,125,40,375));
        map.gameLoop();
        //x.add();
    }

    private static void addSpawnRandTestFunc(int x){
        for(int i =0;i!=x;i++){
            map.addSpawn(new TESTSpawnVHCMExample((int)(Math.random()*500+250),(int)(
                        Math.random()*500+100),(int)(Math.random()*50+25),(int)(Math.random()*50+25)));
        }
    }
}