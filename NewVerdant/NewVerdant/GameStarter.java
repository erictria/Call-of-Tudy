import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GameStarter extends JFrame
{
    public BattleGameFactory map;
    static ThreadGroup hello = new ThreadGroup("Hello");
    static boolean runMe = true;
    public static void main(String[] args){
        GameStarter a = new GameStarter("Factory",3,new boolean[]{true,false,false,false},
                new String[]{"ReD","Chase","Mr Butch","Mr Magic"}, true);
        //a.loop();
    }

    public GameStarter(String mapName, int a, boolean[] b, String[] c, boolean d){
        setSize(1050,720);
        //addKeyListener(new OpenMain());
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new OpenMain(this));
        setVisible(true);
        map = null;
        if(mapName.equals("Classic"))
            map = new Classic();
        if(mapName.equals("Spicy"))
            map = new Classic();
        if(mapName.equals("Sky Dive"))
            map = new SkyDive();
        if(mapName.equals("Factory"))
            map = new Factory();
        map.createMap(a,b,c,d);
        add(map);
        addComponentListener(new Resizer(map));
        Rectangle newSize = getBounds();
        map.setSize(newSize.width,newSize.height);
        map.setSizeRatio(newSize.width,newSize.height);
        new Thread( hello,new Runnable(){
                public void run(){
                    loop();
                }
            }
        ).start();
    }

    public void loop(){
        long timeElapsed = System.nanoTime();
        //System.out.println(timeElapsed);
        setBackground(Color.MAGENTA);
        while(runMe){
            /*if(Thread.currentThread().interrupted()){
                break;
            }*/
            timeElapsed = System.nanoTime();
            map.gameHook();
            map.iterateSpawnControllers();
            map.iterateSpawns();
            map.repaint();
            long timer = System.nanoTime() - timeElapsed;
            //System.out.println(timer);
            try{
                long x = (17*map.slowDownTime*1000000-timer)/1000000;
                if(x>0)
                    Thread.sleep(x);
                //System.out.println((17*1000000-timer)/1000000);
            }catch(InterruptedException e){
            }
        }
        runMe = true;
    }
}
