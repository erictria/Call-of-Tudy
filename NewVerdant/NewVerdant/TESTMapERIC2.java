//JUST A TEST. Expected output is a player and an obstacle.
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
/**
 * Write a description of class TESTMapERIC2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TESTMapERIC2 extends Map
{
    static Map map;
    public static void main(String args[]){
        JFrame x = new JFrame();
        x.setSize(1050,720);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setVisible(true);
        map = new TESTMapERIC2();
        x.add(map);
        x.addComponentListener(new Resizer(map));
        /*map.addSpawn(new SpawnExample(0,0,20,20));
        map.addSpawn(new SpawnExample(450,350,70,100));
         */
        //addSpawnRandTestFunc(20);
        map.setCage();
        map.addSpawn(new DefaultPlatform(0,650,1000,50));
        map.addSpawn(new DefaultPlatform(0,350,200,25));
        map.addSpawn(new DefaultPlatform(800,350,200,25));
        map.addSpawn(new DefaultPlatform(350,100,300,25));
        map.addSpawn(new DefaultPlatform(350,500,300,25));
        map.addSpawn(new DefaultWall(480,125,40,375));
        map.setGravity(0.05f);
        map.setTerVel(10);
        Player xx = new MrMagic(10, 10);
        Player xy = new ReD(200, 100);
        xx.ultimate();
        Obstacle cc = new Cube("Images\\companion.png", 100, 600, 50, 50);
        map.addSpawn(xx);
        map.addSpawn(xy);
        map.addSpawn(cc);
        ProjectileFactory pf = new MagicFactory(map);
        SpawnController sp = new PlayerController(xx, pf);
        map.addKeyListener(sp);
        map.addSpawnController(sp);
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
