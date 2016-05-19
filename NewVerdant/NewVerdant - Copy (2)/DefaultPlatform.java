
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
        //xVel = 1;
        setType(Spawn.IS_PLATFORM);
        movable = new Immovable();
        fallable = new UnFallable();
        flyable = new UnFlyable();
        jumpable = new UnJumpable();
        collisionable = new PlatformCollisionable();
        spriteHere = "Images\\Platform.png";
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
        collisionable = new PlatformCollisionable();
        spriteHere = sh;
    }
    
    //ForTestingPurposesOnly
    /*public DefaultPlatform(float x, float y, float w, float h, boolean wh){
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        setType(Spawn.IS_PLATFORM);
        yVel = -4;
        movable = new StandardMovable();
        fallable = new UnFallable();
        flyable = new UnFlyable();
        jumpable = new UnJumpable();
        collisionable = new PlatformCollisionable();
        spriteHere = "Images\\Box.jpg";
    }*/
    
    public int setSpriteHook(){
        spriteName = spriteHere;
        return 0;
    }
}
