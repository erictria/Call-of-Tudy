
/**
 * I'm the Map. I hold Everything. Extend me to create specific maps.
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.5 April 19, 2016
 * Changelog
 * VHCM 1.5 - Added Spawn Controllers
 * VHCM 1.4 - Added Collision and Kill
 * VHCM 1.3 - Added Resize Capabilities
 * VHCM 1.2 - Added player ArrayList.
 *          - Added giveMap function.
 *          - Added rotateSize Capabilities.
 * VHCM 1.1 - Added iterative move function of all spawns;
 *          - Added iterative fall function of all spawns;
 *          - Added terminalVelocity and Gravity variables as well as setter methods;
 *          - Added gameLoop function;
 *          - Moved Test code to seperate class
 */
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.geom.*;
public class Map extends Canvas
{
    protected ArrayList<Spawn> spawns = new ArrayList<Spawn>();
    protected ArrayList<Player> players = new ArrayList<Player>();
    protected ArrayList<SpawnController> spawnControllers = new ArrayList<SpawnController>();
    ArrayList<PlayerFactory> playerFactories = new ArrayList<PlayerFactory>();
    protected ArrayList<PlayerHUD> playerHUDs = new ArrayList<PlayerHUD>();
    //will be used later Ask Me if curious. -Haron
    protected float widthFactor = 1, heightFactor = 1;
    protected float terminalVelocity = 0, gravity = 0;
    protected int slowDownTime = 1;
    public float flyFactor = 0,jumpFactor = 0;
    protected ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
    protected ArrayList<String> imageNames = new ArrayList<String>();
    private static Map map;

    protected int moveSpawns(){
        for(int i = 0; i!=spawns.size(); i++){
            spawns.get(i).move(0);
        }
        return 0;
    }

    protected int fallSpawns(){
        for(Spawn e: spawns){
            e.fall(gravity,terminalVelocity);
        }
        return 0;
    }

    protected int jumpSpawns(){
        for(Spawn e: spawns){
            e.jump(0);
        }
        return 0;
    }

    protected int flySpawns(){
        for(int i = 0; i!=spawns.size(); i++){
            spawns.get(i).fly(0);
        }
        return 0;
    }

    protected int iterateSpawnControllers(){
        for(SpawnController e: spawnControllers){
            e.listenHook();
        }
        return 0;
    }

    protected int fireSpawns(){
        for(int i = 0; i!=spawns.size(); i++){
            spawns.get(i).fireHook();
        }
        return 0;
    }

    protected int collideSpawns(){
        for(int i = spawns.size()-1; i!=-1;i--){
            Spawn a = spawns.get(i);
            for(int j = i-1; j!=-1; j--){
                Spawn b = spawns.get(j);
                if(Spawn.checkCollisionWithSpawn(a.getLocation(),b.getLocation())==1){
                    b.collisionPassive(a.collisionActive(b));
                    a.collisionPassive(b.collisionActive(a));
                }
            }
        }
        return 0;
    }

    protected int removeSpawns(){
        for(int i = 0; i<players.size();i++){
            Player a = players.get(i);
            if(a.isDead()){
                int temp = -1;
                for(int iv = 0; iv!= playerFactories.size(); iv++){
                    if(playerFactories.get(iv).getNumber()==a.getNumber()){
                        temp = iv;
                        break;
                    }
                }
                if(playerFactories.get(temp).getLives()>=0){
                    players.set(i,spawn(temp));
                    //System.out.println(players.size());
                }else{
                    //players.set(i,spawn(i));
                    players.remove(i);
                    //System.out.println("hi");
                    if(players.size()<2){
                        finish();
                    }
                }
            }
        }
        for(int i = 0; i!=spawns.size();i++){
            Spawn a = spawns.get(i);
            if(a.isDead()){
                spawns.remove(i);
                i--;
            }
        }
        return 0;
    }

    private int finish(){
        slowDownTime = 3;
        //drawText(10);
        return 0;
    }

    protected int iterateSpawns(){
        fallSpawns();
        jumpSpawns();
        flySpawns();
        moveSpawns();
        fireSpawns();
        collideSpawns();
        removeSpawns();
        return 0;
    }

    protected Player spawn(int i){
        return playerFactories.get(i).playerSpawn();
    }

    public int gameLoop(){
        long timeElapsed = System.nanoTime();
        //System.out.println(timeElapsed);
        setBackground(Color.MAGENTA);
        while(true){
            timeElapsed = System.nanoTime();
            gameHook();
            iterateSpawnControllers();
            iterateSpawns();
            repaint();
            long timer = System.nanoTime() - timeElapsed;
            //System.out.println(timer);
            try{
                long x = (17*slowDownTime*1000000-timer)/1000000;
                if(x>0)
                    Thread.sleep(x);
                //System.out.println((17*1000000-timer)/1000000);
            }catch(InterruptedException e){
            }
            if(false)
                return 0;
        }
        //return 0;
    }

    public void gameHook(){

    }

    public int addSpawn(Spawn spawn){
        spawns.add(spawn);
        return 0;
    }

    public int addPlayer(Player spawn){
        players.add(spawn);
        return 0;
    }

    public int addPlayerFactory(PlayerFactory pf){
        playerFactories.add(pf);
        return 0;
    }

    public int addPlayerHUD(PlayerHUD ph){
        playerHUDs.add(ph);
        return 0;
    }

    public int addSpawnController(SpawnController spawn){
        spawnControllers.add(spawn);
        return 0;
    }

    public void paint(Graphics g)
    {
        Image buffer = createImage((int)(1000*widthFactor),(int)(700*heightFactor));
        Graphics gg = buffer.getGraphics();
        //g.setFont(new Font("System",Font.BOLD,200));
        prePaint(gg);
        g.drawImage(buffer, 0 , 0, this);
    }

    public void update(Graphics g){
        paint(g);
    }

    public int setGravity(float grav){
        gravity = grav;
        return 0;
    }

    public int setTerVel(float tv){
        terminalVelocity = tv;
        return 0;
    }

    public float getTerVel(){
        return terminalVelocity;
    }

    public float getGravity(){
        return gravity;
    }

    public int setCage(){
        addSpawn(new DefaultPlatform(0,-50,1000,50));
        addSpawn(new Boundary(-1000,-150,2050,50));
        addSpawn(new Boundary(-2000,950,4050,4000));
        addSpawn(new Boundary(-500,-100,100,1000));
        addSpawn(new Boundary(1500,-100,100,1000));
        addSpawn(new DefaultWall(-50,0,50,700));
        addSpawn(new DefaultWall(1000,0,50,700));
        return 0;
    }

    public int prePaint(Graphics g)
    {
        //setBackground(Color.BLACK);
        try{
            for(int it = 0; it<spawns.size(); it++){
                Spawn a = spawns.get(it);
                drawSpawn(a,g);
                /*String sprite = a.getSprite();
                BufferedImage i = null;
                //System.out.println(sprite);
                for(int counter = 0; counter!=imageNames.size(); counter++){
                if(imageNames.get(counter).equals(sprite)){
                //System.out.println(imageNames.get(counter));
                i = images.get(counter);
                }
                }
                if(i==null){
                //System.out.println(sprite);
                try{
                i = ImageIO.read(new File(sprite));
                //System.out.println(sprite);
                images.add(i);
                imageNames.add(sprite);
                }catch(IOException e){
                try{
                String replaced = sprite.replaceAll( "\\\\","/" );
                i = ImageIO.read(new File(replaced));
                //System.out.println(replaced);
                images.add(i);
                imageNames.add(sprite);
                }catch(IOException e2){
                System.out.println("Failed to find " + sprite+".");
                }
                }
                }

                float[] temp = a.getLocation();
                float widther = temp[2]*widthFactor/i.getWidth();
                float heighter = (temp[3]*heightFactor)/i.getHeight();
                AffineTransform matrix = AffineTransform.getTranslateInstance((int)(temp[0]*widthFactor),
                (int)(temp[1]*heightFactor));
                matrix.scale(widther,heighter);
                matrix.rotate(Math.toRadians(temp[5]),i.getWidth()/2,i.getHeight()/2);

                Graphics2D gg = (Graphics2D) g;
                gg.drawImage(i,matrix,null);
                /*double rotationRequired = Math.toRadians(temp[5]);
                double locationX = i.getWidth() / 2;
                double locationY = i.getHeight() / 2;
                AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
                AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
                float widther = temp[2]*widthFactor;
                float heighter = (temp[3]*heightFactor);
                //g.drawImage(i,tx,null);
                g.drawImage(op.filter(i,null),(int)(temp[0]*widthFactor),(int)(temp[1]*heightFactor),(int) 
                normalize(widther,heighter,rotationRequired,true),(int)normalize(widther,heighter,rotationRequired,false),null);
                /*g.drawImage(i,(int)(temp[0]*widthFactor),(int)(temp[1]*heightFactor),(int)(
                temp[2]*widthFactor),(int)(temp[3]*heightFactor),null);*/          
            }
            drawHUDs(g);
            if(slowDownTime>2.5){
                g.setColor(Color.WHITE);
                g.setFont(new Font("System",Font.BOLD,200));
                g.drawString("GAME",200,200);
                g.drawString("OVER",200,400);
            }
        }catch(ConcurrentModificationException e){System.out.println("concurrentModification");}
        return 0;
    }

    public void drawSpawn(Spawn a, Graphics g){
        String sprite = a.getSprite();
        BufferedImage i = null;
        for(int counter = 0; counter!=imageNames.size(); counter++){
            if(imageNames.get(counter).equals(sprite)){
                i = images.get(counter);
            }
        }
        if(i==null){
            try{
                i = ImageIO.read(new File(sprite));
                images.add(i);
                imageNames.add(sprite);
            }catch(IOException|NullPointerException e){
                try{
                    String replaced = sprite.replaceAll( "\\\\","/" );
                    i = ImageIO.read(new File(replaced));
                    images.add(i);
                    imageNames.add(sprite);
                }catch(IOException|NullPointerException e2){
                    System.out.println("Failed to find " + sprite+".");
                }
            }
        }
        try{
            float[] temp = a.getLocation();
            float widther = temp[2]*widthFactor/i.getWidth();
            float heighter = (temp[3]*heightFactor)/i.getHeight();
            AffineTransform matrix = AffineTransform.getTranslateInstance((int)(temp[0]*widthFactor),
                    (int)(temp[1]*heightFactor));
            matrix.scale(widther,heighter);
            matrix.rotate(Math.toRadians(temp[5]),i.getWidth()/2,i.getHeight()/2);

            Graphics2D gg = (Graphics2D) g;
            gg.drawImage(i,matrix,null);
        }catch(NullPointerException e){
        }
    }

    public String[][] giveMap(){
        String[][] returnValue = new String[spawns.size()+players.size()][6];
        for(int i = 0; i<spawns.size(); i++){
            returnValue[i] = spawns.get(i).getLocationPlusSprite();
        }
        /*for(int i = 0; i!=players.size(); i++){
        returnValue[i+spawns.size()] = players.get(i).getLocationPlusSprite();
        }*/
        return returnValue;
    }

    public int receiveControls(int i, int[] controlsReceived){
        int j = 0;
        if(controlsReceived[j++]==1)
            players.get(i).jump(1);
        if(controlsReceived[j++]==1)
            players.get(i).jump(-1);
        if(controlsReceived[j++]==1)
            players.get(i).move(1);
        if(controlsReceived[j++]==1)
            players.get(i).move(-1);
        if(controlsReceived[j++]==1)
            players.get(i).action1();
        if(controlsReceived[j++]==1)
            players.get(i).action2();
        if(controlsReceived[j++]==1)
            players.get(i).action3();
        if(controlsReceived[j++]==1)
            players.get(i).action4();
        players.get(i).dirFir(controlsReceived[j]);
        return 0;
    }

    public static double normalize(float x, float y, double radians, boolean isX){
        if(!isX){
            radians-=Math.toRadians(90);
        }
        return Math.sqrt(Math.abs(x*x*Math.cos(radians))+Math.abs(y*y*Math.sin(radians)));
    }

    public void drawHUDs(Graphics g){
        //System.out.println("WE ARE HERE!!!");
        for(int i = 0; i!=playerHUDs.size(); i++){
            for(int iv = 0; iv!=players.size(); iv++){
                playerHUDs.get(i).setHP(0);
                if(playerHUDs.get(i).getNumber()==players.get(iv).getNumber()){
                    playerHUDs.get(i).setHP(players.get(iv).getHP());
                    break;
                }
            }
            for(int iv = 0; iv!=playerFactories.size(); iv++){
                if(playerHUDs.get(i).getNumber()==playerFactories.get(iv).getNumber()){
                    playerHUDs.get(i).setLives(playerFactories.get(iv).getLives());
                    break;
                }
            }
            Spawn[] temp = playerHUDs.get(i).myNodes();
            for(int j = 0; j!= temp.length; j++){
                float[] iv = temp[j].getLocation();
                //System.out.println(iv[0]+" "+iv[1]+" "+iv[2]+" "+iv[3]);
                drawSpawn(temp[j],g);
            }
        }
    }

    public void setSizeRatio(float x, float y){
        widthFactor = x/1000;
        heightFactor = y/700;
    }
}