import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GameStarter extends JFrame
{
    private BattleGameFactory map;
    static ThreadGroup hello = new ThreadGroup("Hello");
    public static void main(String[] args){
        GameStarter a = new GameStarter("Factory",3,new boolean[]{true,false,false,false},
                new String[]{"ReD","Chase","Mr Butch","Mr Magic"}, true);
        //a.loop();
    }

    public GameStarter(String mapName, int a, boolean[] b, String[] c, boolean d){
        setSize(1050,720);
        //addKeyListener(new OpenMain());
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new OpenMain());
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
        map.gameLoop();
    }
}
