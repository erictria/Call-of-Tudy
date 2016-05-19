
/**
 * Game Factory mapMaking made easy
 * 
 * @author Vincent Haron C. Mamutuk
 * @version 1.0 May 18, 2016
 */
import java.io.*;
import java.util.*;
public abstract class BattleGameFactory extends BattleMap
{
    protected float[] spawnX = new float[4], spawnY = new float[4];
    protected int[][] receiver = new int[3][9];
    protected boolean immaNetwork[] = new boolean[3];
    protected boolean here = false;
    protected int numPlays = 2;
    public BattleGameFactory(float a, float b, float c, float d, float e, float f, float g, float h){
        spawnX[0] = a;
        spawnX[1] = c;
        spawnX[2] = e;
        spawnX[3] = g;
        spawnY[0] = b;
        spawnY[1] = d;
        spawnY[2] = f;
        spawnY[3] = h;
        addControls(0,new int[]{0,0,0,0,0,0,0,0,1});
        addControls(1,new int[]{0,0,0,0,0,0,0,0,1});
        addControls(2,new int[]{0,0,0,0,0,0,0,0,1});
    }

    public void addControls(int i, int[] x){
        receiver[i] = x;
    }

    public abstract void setup();

    public void createMap(int numLives, boolean[] isPlayer, String[] playerNames, boolean isLocal){
        setCage();
        setup();
        here = isLocal;
        numPlays = playerNames.length;
        for(int i =0; i!=playerNames.length; i++){
            PlayerFactory pf = null;
            SpawnController sp = new AIController(null);
            if(isPlayer[i]){
                sp = new StandardPlayerController(null);
                String controlName = "Controller " + (i+1);
                int[] buttonKeys = new int[12];
                try{
                    FileReader fr = new FileReader(controlName);
                    Scanner sc = new Scanner(fr);
                    String namer = sc.nextLine();
                    String[] split = namer.split("\\s");
                    //System.out.println(split.length);
                    for(String x:split)
                    //System.out.println(x);
                        for(int iv = 0; iv!=buttonKeys.length; iv++)
                            buttonKeys[iv] = Integer.parseInt(split[iv]);
                    sp.changeKeys(buttonKeys);
                }catch(IOException ioe){}
                if(isLocal||i==0)
                    addKeyListener(sp);
                else{
                    immaNetwork[i-1] = true;
                }
            }
            if(playerNames[i].equals("ReD")){
                pf = new ReDPlayerFactory(spawnX[i],spawnY[i],numLives,i+1,this,sp);
                addPlayerHUD(new PlayerHUD(numLives,i+1,100,"Images\\Red.png"));
            }else if(playerNames[i].equals("Mr Magic")){
                pf = new MrMagicPlayerFactory(spawnX[i],spawnY[i],numLives,i+1,this,sp);
                addPlayerHUD(new PlayerHUD(numLives,i+1,100,"Images\\Mr Magic.png"));
            }else if(playerNames[i].equals("Mr Butch")){
                pf = new MrButchPlayerFactory(spawnX[i],spawnY[i],numLives,i+1,this,sp);
                addPlayerHUD(new PlayerHUD(numLives,i+1,100,"Images\\Mr Butch.png"));
            }else if(playerNames[i].equals("Chase")){
                pf = new ChasePlayerFactory(spawnX[i],spawnY[i],numLives,i+1,this,sp);
                addPlayerHUD(new PlayerHUD(numLives,i+1,100,"Images\\Chase.png"));
            }else{
                pf = new ReDPlayerFactory(spawnX[i],spawnY[i],numLives,i+1,this,sp);
                addPlayerHUD(new PlayerHUD(numLives,i+1,100,"Images\\TestRed.png"));
            }
            addPlayer(pf.playerSpawn());
            addPlayerFactory(pf);
            addSpawnController(sp);
        }
    }

    public void gameHook(){
        for(int i = 0; i!=numPlays-1; i++){
            if(immaNetwork[i]){
                receiveControls(i+1,receiver[i]);
            }
        }
        if(!here) OnlineGameSetup.xevere = giveMap();
    }
}
