//JUST A TEST. Expected output is a bunch of red boxes not moving but rotating
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
public class SetPlayerControls
{
    static Map map;
    public static void main(String args[]){
        class KeyRecorder implements KeyListener{
            public void keyPressed(KeyEvent e){
            }

            public void keyReleased(KeyEvent e){
                System.out.println(e.getKeyCode());
            }

            public void keyTyped(KeyEvent e){
            }
        }
        JFrame x = new JFrame();
        x.setSize(1050,720);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setVisible(true);
        x.addKeyListener(new KeyRecorder());
        //map = new Map();
        //x.add(map);
        //x.addComponentListener(new Resizer(map));
        /*map.addSpawn(new SpawnExample(0,0,20,20));
        map.addSpawn(new SpawnExample(450,350,70,100));
         */
        //addSpawnRandTestFunc(20);
        //map.gameLoop();
        //x.add();
    }
}
