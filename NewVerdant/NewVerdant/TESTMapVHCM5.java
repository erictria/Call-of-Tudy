//JUST A TEST. Expected output is a bunch of rotating boxes next to each other in unison, as if just one long box
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
public class TESTMapVHCM5 extends Map
{
    static Map map;
    static Map mapper;
    static Spawn te;
    public static void main(String args[]){
        class Listener implements KeyListener{
            public void keyReleased(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_W){
                    te.setYSpeed(0);
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    te.setYSpeed(0);
                }
                if(e.getKeyCode()==KeyEvent.VK_A){
                    te.setXSpeed(0);
                }
                if(e.getKeyCode()==KeyEvent.VK_D){
                    te.setXSpeed(0);
                }
            }

            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_W){
                    te.setYSpeed(-2);
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    te.setYSpeed(2);
                }
                if(e.getKeyCode()==KeyEvent.VK_A){
                    te.setXSpeed(-2);
                }
                if(e.getKeyCode()==KeyEvent.VK_D){
                    te.setXSpeed(2);
                }
            }
            //public void keyClicked(KeyEvent e);
            public void keyTyped(KeyEvent e){
            }
        }
        JFrame x = new JFrame();
        x.setSize(1050,720);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setVisible(true);
        map = new TESTMapVHCM4();
        map.addKeyListener(new Listener());

        x.add(map);
        te = new TESTSpawnVHCMExample(500,350,50,50);
        map.addSpawn(te);
        map.addSpawn(new TESTSpawnVHCMExample4(30,0,50,50,te,false));
        map.addSpawn(new TESTSpawnVHCMExample4(60,0,50,50,te,false));
        map.addSpawn(new TESTSpawnVHCMExample4(-30,0,50,50,te,false));
        map.addSpawn(new TESTSpawnVHCMExample4(-60,0,50,50,te,false));
        /*for(int i =0;i!=20;i++){
            map.addSpawn(new TESTSpawnVHCMExample3((int)(Math.random()*500+250),(int)(
                        Math.random()*500+100),(int)(Math.random()*50+25),(int)(Math.random()*50+25),te));
        }
        /*map.addSpawn(new SpawnExample(0,0,20,20));
        map.addSpawn(new SpawnExample(450,350,70,100));
         */
        //addSpawnRandTestFunc(20);
        map.setGravity(0.05f);
        map.setTerVel(10);
        map.gameLoop();
        //x.add();
    }
}