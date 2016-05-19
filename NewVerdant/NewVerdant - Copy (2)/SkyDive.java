
/**
 * For people who like to sky dive
 */
import javax.swing.*;
import java.awt.*;
public class SkyDive extends BattleGameFactory
{
    public static void main(String args[]){
        JFrame x = new JFrame();
        x.setSize(1050,720);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setVisible(true);
        BattleGameFactory map = new SkyDive();
        x.add(map);
        map.createMap(3,new boolean[]{true,false,false,false},
            new String[]{"ReD","Chase","Mr Butch","Mr Magic"}, true);
        //x.add(map);
        x.addComponentListener(new Resizer(map));
        Rectangle newSize = x.getBounds();
        map.setSize(newSize.width,newSize.height);
        map.setSizeRatio(newSize.width,newSize.height);
        map.gameLoop();
    }
    public SkyDive(){
        super(20,20,270,20,520,20,770,20);
    }
    public void setup(){
        //taken from http://opengameart.org/content/sky-backdrop
        addSpawn(new BackGround("Images//sky1.png"));
        addSpawn(new DefaultPlatform(475,650,49,50));
        addSpawn(new DefaultPlatform(0,125,90,10));
        addSpawn(new DefaultWall(0,0,20,125));
        addSpawn(new DefaultPlatform(250,125,90,10));
        addSpawn(new DefaultWall(250,0,20,125));
        addSpawn(new DefaultPlatform(500,125,90,10));
        addSpawn(new DefaultWall(500,0,20,125));
        addSpawn(new DefaultPlatform(750,125,90,10));
        addSpawn(new DefaultWall(750,0,20,125));
        MovingPlatform x = new MovingPlatform(50,250,150,10);
        x.setXSpeed2(3f);
        x.setMax(250);
        addSpawn(x);
        x = new MovingPlatform(800,400,150,10);
        x.setXSpeed2(-3f);
        x.setMax(250);
        addSpawn(x);
        x = new MovingPlatform(-100,500,50,10);
        x.setXSpeed2(1f);
        x.setMax(250);
        addSpawn(x);
        x = new MovingPlatform(1050,500,50,10);
        x.setXSpeed2(-1f);
        x.setMax(250);
        addSpawn(x);
        x = new MovingPlatform(450,800,100,10);
        x.setXSpeed2(0f);
        x.setYSpeed2(-2f);
        x.setMax(129);
        addSpawn(x);
        x = new MovingPlatform(0,400,20,10);
        x.setXSpeed2(0f);
        x.setYSpeed2(-0.5f);
        x.setMax(100);
        addSpawn(x);
        x = new MovingPlatform(970,350,30,10);
        x.setXSpeed2(0f);
        x.setYSpeed2(0.5f);
        x.setMax(100);
        addSpawn(x);
        setGravity(.25f);
        setTerVel(10);
    }
}
