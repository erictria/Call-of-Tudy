//JUST A TEST. Expected output is a bunch of red boxes not moving. These are platforms.
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
public class TESTMapVHCM13 extends Map
{
    static Map map;
    static ReD te;
    public static void main(String args[]){
        JFrame x = new JFrame();
        x.setSize(1050,720);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setVisible(true);
        map = new TESTMapVHCM13();
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
        SpawnController spC = new StandardPlayerController(te);
        int[] bk = spC.getKeys();
        bk[0] = KeyEvent.VK_U;
        bk[1] = KeyEvent.VK_J;
        bk[2] = KeyEvent.VK_H;
        bk[3] = KeyEvent.VK_K;
        spC.changeKeys(bk);
        PlayerFactory redPF = new ReDPlayerFactory(20,20,map,spC);
        map.addPlayer(redPF.playerSpawn());
        map.addPlayerFactory(redPF);
        map.addKeyListener(spC);
        map.addSpawnController(spC);
        Obstacle cc = new Cube("Images\\companion.png", 100, 600, 50, 50);
        map.addSpawn(cc);
        SpawnController sp = new StandardPlayerController(null);
        bk = sp.getKeys();
        bk[7] = KeyEvent.VK_NUMPAD7;
        bk[6] = KeyEvent.VK_NUMPAD9;
        bk[5] = KeyEvent.VK_NUMPAD3;
        bk[4] = KeyEvent.VK_NUMPAD1;
        bk[8] = KeyEvent.VK_NUMPAD8;
        bk[9] = KeyEvent.VK_NUMPAD4;
        bk[10] = KeyEvent.VK_NUMPAD6;
        bk[11] = KeyEvent.VK_NUMPAD5;
        sp.changeKeys(bk);
        PlayerFactory mrMagicPF = new ReDPlayerFactory(800,20,map,sp);
        map.addPlayer(mrMagicPF.playerSpawn());
        map.addPlayerFactory(mrMagicPF);
        map.addKeyListener(sp);
        map.addSpawnController(sp);
        //Player xx = new MrMagic(900, 10);
        //Spawn xy = new TESTSpawnVHCMExample9(200, 100, 30, 60);
        //xx.ultimate();
        //Obstacle cc = new Cube("Images\\companion.png", 100, 600, 50, 50);
        //map.addSpawn(xx);
        //map.addSpawn(xy);
        // map.addSpawn(cc);
        //ProjectileFactory pf = new MagicFactory(map);
        //SpawnController sp = new PlayerController(xx, pf);
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