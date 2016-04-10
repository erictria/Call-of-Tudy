
/**
 * Platform
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.0 April 10, 2016
 * Changelog
 */
public class DefaultPlatform extends Spawn
{
    private String spriteHere;
    public DefaultPlatform(float x, float y, float w, float h){
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        setType(Spawn.IS_PLATFORM);
        movable = new Immovable();
        fallable = new UnFallable();
        flyable = new UnFlyable();
        jumpable = new UnJumpable();
        spriteHere = "Images\\Box.jpg";
    }
    
    public DefaultPlatform(float x, float y, float w, float h, String sh){
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        setType(Spawn.IS_PLATFORM);
        movable = new Immovable();
        fallable = new UnFallable();
        flyable = new UnFlyable();
        jumpable = new UnJumpable();
        spriteHere = sh;
    }
    
    public int setSpriteHook(){
        spriteName = spriteHere;
        return 0;
    }
}
