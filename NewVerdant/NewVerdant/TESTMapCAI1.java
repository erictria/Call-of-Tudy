//Testing projectiles

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class TESTMapCAI1 extends Map{

    static Map map;
    public static void main( String args[] ){
        JFrame x = new JFrame();
        x.setSize(1050,720);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setVisible(true);
        map = new TESTMapCAI1();
        x.add(map);
        x.addComponentListener(new Resizer(map));

        Projectile test = new TESTProjectileCAI1( 50, 50, 50, 50 );
        test.setVelocity( 10 );
        map.addSpawn( test );

        map.setCage();
        map.setGravity(0.05f);
        map.setTerVel(10);
        map.gameLoop();
        //map.gameLoop();
    }
}
