//JUST A TEST. Expected output is a bunch of red boxes orbiting around the Center
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
public class TESTMapVHCM4 extends Map
{
    static Map map;
    static Map mapper;
    public static void main(String args[]){
        JFrame x = new JFrame();
        x.setSize(1050,720);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setVisible(true);
        map = new TESTMapVHCM2();
        
        x.add(map);
        /*map.addSpawn(new SpawnExample(0,0,20,20));
        map.addSpawn(new SpawnExample(450,350,70,100));
         */
        addSpawnRandTestFunc(20);
        map.setGravity(0.05f);
        map.setTerVel(0);
        map.gameLoop();
        //x.add();
    }

    private static void addSpawnRandTestFunc(int x){
        for(int i =0;i!=x;i++){
            map.addSpawn(new TESTSpawnVHCMExample3((int)(Math.random()*500+250),(int)(
                        Math.random()*500+100),(int)(Math.random()*50+25),(int)(Math.random()*50+25)));
        }
    }
    
    public void gameHook(){
        for(Spawn e: spawns){
            float[] x = e.getSpeed();
            if(x[3]>800){
                e.setLocation((float)(Math.random()*500+250),(float)(
                        Math.random()*500+100),(float)(Math.random()*50+25),(float)(Math.random()*50+25));
            }
        }
    }
}