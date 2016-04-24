
/**
 * PlayerFactory
 * 
 * @author Vincent Haron C. Mamutuk
 * @version 1.0 April 24, 2016
 */
public abstract class PlayerFactory
{
    private int numLives = 3;
    protected float xPos, yPos;
    protected Map map;
    protected SpawnController sp;
    public PlayerFactory(float x, float y, Map m, SpawnController sp){
        xPos = x;
        yPos = y;
        map = m;
        this.sp = sp;
    }
    public abstract Player addPlayer();
    public int getLives(){
        return numLives;
    }
    public Player playerSpawn(){
        numLives--;
        return addPlayer();
    }
}
