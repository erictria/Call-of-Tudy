
/**
 * HPBar
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.0 May 16, 2016
 */
public class HPBar extends Spawn
{
    //protected float xPos, yPos, width, height;
    protected int playerNumber;
    protected boolean isOuter;
    public HPBar(float x, float y, float w, float h, int pN, boolean isO){
        xPos = x;
        yPos = y;
        height = h;
        width = w;
        playerNumber = pN;
        isOuter = isO;
        String temp = "Images\\HPBar" + (playerNumber+1);
        if(!isOuter){
            temp+="Inner";
        }
        temp+=".jpg";
        spriteName = temp;
    }
    
    public int setSpriteHook(){
        String temp = "Images\\HPBar" + playerNumber;
        if(!isOuter){
            temp+="Inner";
        }
        temp+=".jpg";
        spriteName = temp;
        return 0;
    }
}
