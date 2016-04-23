//JUST A TEST. Expected output is a bunch of red boxes not moving. These are platforms.
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
public class TESTMapVHCM9 extends Map
{
    static Map map;
    static ReD te;
    public static void main(String args[]){
        JFrame x = new JFrame();
        x.setSize(1050,720);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setVisible(true);
        map = new TESTMapVHCM9();
        x.add(map);
        x.addComponentListener(new Resizer(map));
        /*map.addSpawn(new SpawnExample(0,0,20,20));
        map.addSpawn(new SpawnExample(450,350,70,100));
         */
        //addSpawnRandTestFunc(20);
        map.setCage();
        map.addSpawn(new DefaultPlatform(0,650,1000,50));
        map.addSpawn(new DefaultPlatform(0,350,200,10));
        map.addSpawn(new DefaultPlatform(800,350,200,10));
        map.addSpawn(new DefaultPlatform(350,100,300,10));
        map.addSpawn(new DefaultPlatform(350,500,300,10));
        map.addSpawn(new MovingPlatform(200,200,150,10));
        map.addSpawn(new DefaultWall(487,109,26,391));
        te = new ReD(20,20);
        te.setProjectileFactory(new TESTProjectileFactoryCAI1(map));
        Mirror[] mirrors = new Mirror[4];
        mirrors[0] = new Mirror(75,40,20,20,0,te,map);
        mirrors[1] = new Mirror(-25,40,20,20,180,te,map);
        mirrors[2] = new Mirror(25,90,20,20,270,te,map);
        mirrors[3] = new Mirror(25,-10,20,20,90,te,map);
        te.setMirrors(mirrors);
        map.addSpawn(te);
        SpawnController spC = new StandardPlayerController(te);
        map.addKeyListener(spC);
        map.addSpawnController(spC);
        //addSpawnRandTestFunc(1);
        map.setGravity(.25f);
        map.setTerVel(10);
        map.gameLoop();
        //x.add();
    }

    private static void addSpawnRandTestFunc(int x){
        for(int i =0;i!=x;i++){
            map.addSpawn(new TESTSpawnVHCMExample9((int)(Math.random()*500+250),(int)(
                        Math.random()*500+100),(int)(Math.random()*50+25),(int)(Math.random()*50+25)));
        }
    }
    
    public void gameHook(){
    }
}