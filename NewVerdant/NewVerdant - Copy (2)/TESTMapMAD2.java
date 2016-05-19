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
 * @author Migs
 * @version April 25, 2016
 */
public class TESTMapMAD2 extends Map
{
    static Map map;
    public static void main(String args[]){
        JFrame x = new JFrame();
        x.setSize(1050,720);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setVisible(true);
        map = new TESTMapMAD2();
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
        map.setGravity(0.25f);
        map.setTerVel(10);
        MrButch xx = new MrButch(100, 100);
        //xx.setProjFacts();
        Obstacle cc = new Cube("Images\\companion.png", 100, 600, 50, 50);
        PowerupFactory upFactory = new PowerupFactory();
        Powerup testPowerup1 = upFactory.createPowerup("Hamburger", 450, 0, 100, 100);
        //Powerup testPowerup2 = upFactory.createPowerup("Hemlock", 350, 400, 100, 100);
        Powerup testPowerup3 = upFactory.createPowerup("Ultimate", 600, 550, 100, 100); 
        
        map.addSpawn(testPowerup1);
        //map.addSpawn(testPowerup2);
        map.addSpawn(testPowerup3);
        map.addSpawn(xx);
        map.addSpawn(cc);
        ProjectileFactory pf = new MeatballFactory(map);
        ProjectileFactory[] pj = new ProjectileFactory[2];
        pj[0] = new MeatballFactory(map);
        pj[1] = new SuperMeatballFactory(map);
        xx.setProjectileFactory(pj[0]);
        //te.setProjectileFactory(new MeatballFactory(map));
        xx.setProjFacts(pj);
        SpawnController sp = new StandardPlayerController(xx);
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
