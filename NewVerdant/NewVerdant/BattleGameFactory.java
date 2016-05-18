
/**
 * Game Factory mapMaking made easy
 * 
 * @author Vincent Haron C. Mamutuk
 * @version 1.0 May 18, 2016
 */
public abstract class BattleGameFactory extends BattleMap
{
    protected float[] spawnX = new float[4], spawnY = new float[4];
    public BattleGameFactory(float a, float b, float c, float d, float e, float f, float g, float h){
        spawnX[0] = a;
        spawnX[1] = c;
        spawnX[2] = e;
        spawnX[3] = g;
        spawnY[0] = b;
        spawnY[1] = d;
        spawnY[2] = f;
        spawnY[3] = h;
    }
    public abstract void setup();
    public void createMap(int numLives, boolean[] isPlayer, String[] playerNames, boolean isLocal){
        setCage();
        setup();
        for(int i =0; i!=playerNames.length; i++){
            PlayerFactory pf = null;
            SpawnController sp = new AIController(null);
            if(isPlayer[i]){
                sp = new StandardPlayerController(null);
                addKeyListener(sp);
            }
            if(playerNames[i].equals("ReD")){
                pf = new ReDPlayerFactory(spawnX[i],spawnY[i],numLives,i+1,this,sp);
                addPlayerHUD(new PlayerHUD(numLives,i+1,100,"Images\\TestRed.png"));
            }else if(playerNames[i].equals("Mr Magic")){
                pf = new MrMagicPlayerFactory(spawnX[i],spawnY[i],numLives,i+1,this,sp);
                addPlayerHUD(new PlayerHUD(numLives,i+1,100,"Images\\MrMagic.png"));
            }else if(playerNames[i].equals("Mr Butch")){
                pf = new MrButchPlayerFactory(spawnX[i],spawnY[i],numLives,i+1,this,sp);
                addPlayerHUD(new PlayerHUD(numLives,i+1,100,"Images\\MrButch.png"));
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
}
