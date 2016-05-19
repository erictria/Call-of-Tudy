
/**
 * Representation of PlayerLives
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.0 May 17, 2016
 */
public class PlayerLives extends Spawn
{
    String strName;
    public PlayerLives(float x, float y, String cha){
        strName = cha;
        xPos = x;
        yPos = y;
        width = 20;
        height = 20;
    }
    
    public int setSpriteHook(){
        spriteName = strName;
        return 0;
    }
}
