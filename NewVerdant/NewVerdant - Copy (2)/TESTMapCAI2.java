//Testing projectile factory and firing

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class TESTMapCAI2 extends Map{

    static Map map;
    public static void main( String args[] ){
        JFrame x = new JFrame();
        x.setSize(1050,720);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setVisible(true);
        map = new TESTMapCAI2();
        x.add(map);
        x.addComponentListener(new Resizer(map));

        map.setCage();
        map.addSpawn(new DefaultPlatform(0,650,1000,50));
        map.addSpawn(new DefaultPlatform(0,350,200,25));
        map.addSpawn(new DefaultPlatform(800,350,200,25));
        map.addSpawn(new DefaultPlatform(350,100,300,25));
        map.addSpawn(new DefaultPlatform(350,500,300,25));
        map.addSpawn(new DefaultWall(480,125,40,375));

        Player cai = new TESTPlayerCAI1("Images\\Box.jpg",10,10,40,40);
        Obstacle cc = new Cube("Images\\companion.png", 100, 600, 50, 50);

        map.addSpawn( cai );
        map.addSpawn( cc );

        SpawnController sc = new TESTControllerCAI1( cai, new TESTProjectileFactoryCAI1( map ) );
        map.addKeyListener( sc );
        map.addSpawnController( sc );

        map.setGravity(0.05f);
        map.setTerVel(10);
        map.gameLoop();
        //map.gameLoop();
    }
}
