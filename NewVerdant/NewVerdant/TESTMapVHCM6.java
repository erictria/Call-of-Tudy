//JUST A TEST. Expected output is 4 mirrors rotating around a box
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
public class TESTMapVHCM6 extends Map
{
    static Map map;
    static Map mapper;
    static Spawn te, re, pe ,fe, ReD;
    static int m1, m2, m3, m4;
    static float xRad1 = 0, xRad2 = 0, xRad3 = 0, xRad4 = 0;
    public static void main(String args[]){
        class Listener implements KeyListener{
            public void keyReleased(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_W){
                    ReD.setYSpeed(0);
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    ReD.setYSpeed(0);
                }
                if(e.getKeyCode()==KeyEvent.VK_A){
                    ReD.setXSpeed(0);
                }
                if(e.getKeyCode()==KeyEvent.VK_D){
                    ReD.setXSpeed(0);
                }
                if(e.getKeyCode()==KeyEvent.VK_Q){
                    //m1 = 0;
                }
                if(e.getKeyCode()==KeyEvent.VK_E){
                    //m2 = 0;
                }
                if(e.getKeyCode()==KeyEvent.VK_1){
                    //m3 = 0;
                }
                if(e.getKeyCode()==KeyEvent.VK_3){
                    //m4 = 0;
                }
            }

            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_W){
                    ReD.setYSpeed(-2);
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    ReD.setYSpeed(2);
                }
                if(e.getKeyCode()==KeyEvent.VK_A){
                    ReD.setXSpeed(-2);
                }
                if(e.getKeyCode()==KeyEvent.VK_D){
                    ReD.setXSpeed(2);
                }
                if(e.getKeyCode()==KeyEvent.VK_Q){
                    if(m1!=1)
                        m1 = 1;
                    else m1 = 0;
                }
                if(e.getKeyCode()==KeyEvent.VK_E){
                    if(m2!=1)
                        m2 = 1;
                    else m2 = 0;
                }
                if(e.getKeyCode()==KeyEvent.VK_1){
                    if(m3!=1)
                        m3 = 1;
                    else m3 = 0;
                }
                if(e.getKeyCode()==KeyEvent.VK_3){
                    if(m4!=1)
                        m4 = 1;
                    else m4 = 0;
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
        map = new TESTMapVHCM6();
        map.addKeyListener(new Listener());

        x.add(map);
        x.addComponentListener(new Resizer(map));
        ReD = new TESTSpawnVHCMExample5(500,350,50,50);
        map.addSpawn(ReD);
        te = new TESTSpawnVHCMExample6(550,350,50,50,ReD);
        map.addSpawn(te);
        //te.setXSpeed(4); te.setYSpeed(4);
        map.addSpawn(new TESTSpawnVHCMExample4(0,30,50,50,te,false));
        map.addSpawn(new TESTSpawnVHCMExample4(0,60,50,50,te,false));
        map.addSpawn(new TESTSpawnVHCMExample4(0,-30,50,50,te,false));
        map.addSpawn(new TESTSpawnVHCMExample4(0,-60,50,50,te,false));
        re = new TESTSpawnVHCMExample6(450,350,50,50,ReD);
        map.addSpawn(re);
        map.addSpawn(new TESTSpawnVHCMExample4(0,30,50,50,re,false));
        map.addSpawn(new TESTSpawnVHCMExample4(0,60,50,50,re,false));
        map.addSpawn(new TESTSpawnVHCMExample4(0,-30,50,50,re,false));
        map.addSpawn(new TESTSpawnVHCMExample4(0,-60,50,50,re,false));
        pe = new TESTSpawnVHCMExample6(500,400,50,50,ReD);
        map.addSpawn(pe);
        map.addSpawn(new TESTSpawnVHCMExample4(30,0,50,50,pe,false));
        map.addSpawn(new TESTSpawnVHCMExample4(60,0,50,50,pe,false));
        map.addSpawn(new TESTSpawnVHCMExample4(-30,0,50,50,pe,false));
        map.addSpawn(new TESTSpawnVHCMExample4(-60,0,50,50,pe,false));
        fe = new TESTSpawnVHCMExample6(500,300,50,50,ReD);
        map.addSpawn(fe);
        map.addSpawn(new TESTSpawnVHCMExample4(30,0,50,50,fe,false));
        map.addSpawn(new TESTSpawnVHCMExample4(60,0,50,50,fe,false));
        map.addSpawn(new TESTSpawnVHCMExample4(-30,0,50,50,fe,false));
        map.addSpawn(new TESTSpawnVHCMExample4(-60,0,50,50,fe,false));
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
    
    public void gameHook(){
        if(m1==1){
            xRad1+=.05;
        }else
            xRad1-=.05;
        if(m2==1)
            xRad2+=.05;
        else
            xRad2-=.05;
        if(m3==1)
            xRad3+=.05;
        else
            xRad3-=.05;
        if(m4==1)
            xRad4+=.05;
        else
            xRad4-=.05;
        if(xRad1>5)
            xRad1=5;
        if(xRad1<1)
            xRad1=1;
        if(xRad2>5)
            xRad2=5;
        if(xRad2<1)
            xRad2=1;
        if(xRad3>5)
            xRad3=5;
        if(xRad3<1)
            xRad3=1;
        if(xRad4>5)
            xRad4=5;
        if(xRad4<1)
            xRad4=1;
        //System.out.println(xRad1);
        fe.setXSpeed(xRad1); fe.setYSpeed(xRad1);
        re.setXSpeed(xRad2); re.setYSpeed(xRad2);
        te.setXSpeed(xRad3); te.setYSpeed(xRad3);
        pe.setXSpeed(xRad4); pe.setYSpeed(xRad4);
    }
}