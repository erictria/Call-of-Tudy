//JUST A TEST. Testing MapReader
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
public class TESTMapVHCM15 extends BattleMap
{
    static Map map;
    static ReD te;
    static MapReader mapper;
    public static void main(String args[]){
        JFrame x = new JFrame();
        x.setSize(1050,720);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setVisible(true);
        map = new TESTMapVHCM15();
        mapper = new MapReader();
        x.add(mapper);
        //x.add(map);
        x.addComponentListener(new Resizer(mapper));
        //Thread runner = new Thread(new MapReaderThread(map,mapper));
        /*map.addSpawn(new SpawnExample(0,0,20,20));
        map.addSpawn(new SpawnExample(450,350,70,100));
         */
        //addSpawnRandTestFunc(20);
        map.setCage();
        map.addSpawn(new DefaultPlatform(0,650,350,50));
        map.addSpawn(new DefaultPlatform(650,650,350,50));
        map.addSpawn(new DefaultPlatform(0,350,200,10));
        map.addSpawn(new DefaultPlatform(800,350,200,10));
        map.addSpawn(new DefaultPlatform(350,100,300,10));
        map.addSpawn(new DefaultPlatform(350,500,300,10));
        map.addSpawn(new MovingPlatform(200,200,150,10));
        map.addSpawn(new DefaultWall(495,69,10,140));
        map.addSpawn(new DefaultWall(495,300,10,100));
        PlayerFactory redPF = new ReDPlayerFactory(20,20,map,null);
        map.addPlayer(redPF.playerSpawn());
        map.addPlayerFactory(redPF);
        Obstacle cc = new Cube("Images\\companion.png", 475, 450, 50, 50);
        map.addSpawn(cc);
        Obstacle cD = new Cube("Images\\companion.png", 475, 400, 50, 50);
        map.addSpawn(cD);
        //SpawnController sp = new StandardPlayerController(null);
        PlayerFactory mrMagicPF = new MrMagicPlayerFactory(800,20,map,null);
        map.addPlayer(mrMagicPF.playerSpawn());
        map.addPlayerFactory(mrMagicPF);
        SpawnController networked = new NetworkedController(mapper);
        mapper.addKeyListener(networked);
        mapper.addSpawnController(networked);
        map.setGravity(.25f);
        map.setTerVel(10);
        //runner.start();
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
        mapper.getMap(map.giveMap());
        map.receiveControls(0,mapper.sendInput());
        mapper.repaint();
    }
}