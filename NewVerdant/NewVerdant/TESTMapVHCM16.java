//JUST A TEST. Expected output is a bunch of red boxes not moving. These are platforms.
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
public class TESTMapVHCM16 extends BattleMap
{
    public static void main(String args[]){
        JFrame x = new JFrame();
        x.setSize(1050,720);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setVisible(true);
        Map map = new TESTMapVHCM16();
        x.add(map);
        x.addComponentListener(new Resizer(map));
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
        SpawnController spC = new StandardPlayerController(null);
        PlayerFactory redPF = new ChasePlayerFactory(20,20,3,1,map,spC);
        map.addPlayer(redPF.playerSpawn());
        map.addPlayerFactory(redPF);
        map.addKeyListener(spC);
        map.addSpawnController(spC);
        map.addPlayerHUD(new PlayerHUD(3,1,100,"Images\\Chase.png"));
        Obstacle cc = new Cube("Images\\companion.png", 475, 450, 50, 50);
        map.addSpawn(cc);
        Obstacle cD = new Cube("Images\\companion.png", 475, 400, 50, 50);
        map.addSpawn(cD);
        SpawnController sp = new AIController(null);
        PlayerFactory mrMagicPF = new ReDPlayerFactory(800,20,3,2,map,sp);
        Player first = mrMagicPF.playerSpawn();
        map.addPlayer(first);
        map.addPlayerFactory(mrMagicPF);
        map.addPlayerHUD(new PlayerHUD(3,2,100,"Images\\TestRed.png"));
        map.addSpawnController(sp);
        SpawnController sp1 = new AIController(null);
        PlayerFactory mrMagicPF1 = new ReDPlayerFactory(100,400,3,3,map,sp1);
        Player firstSpawn = mrMagicPF1.playerSpawn();
        map.addPlayer(firstSpawn);
        map.addPlayerFactory(mrMagicPF1);;
        map.addPlayerHUD(new PlayerHUD(3,3,100,"Images\\TestRed.png"));
        map.addSpawnController(sp1);
        SpawnController sp2 = new AIController(null);
        PlayerFactory mrMagicPF2 = new MrMagicPlayerFactory(950,400,3,4,map,sp2);
        map.addPlayer(mrMagicPF2.playerSpawn());
        map.addPlayerFactory(mrMagicPF2);
        map.addPlayerHUD(new PlayerHUD(3,4,100,"Images\\MrMagic.png"));
        map.addSpawnController(sp2);
        map.setGravity(.25f);
        map.setTerVel(10);
        map.gameLoop();
    }
}