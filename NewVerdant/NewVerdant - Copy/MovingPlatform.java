
/**
 * Moving Platform
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.0 April 20, 2016
 * Changelog
 */
public class MovingPlatform extends Spawn
{
    private String spriteHere;
    protected float xSpeed = 2.5f, ySpeed = 0;
    protected int MAX = 180, counter = 0;
    public MovingPlatform(float x, float y, float w, float h){
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        setType(Spawn.IS_PLATFORM);
        movable = new StandardMovable();
        fallable = new UnFallable();
        flyable = new UnFlyable();
        jumpable = new UnJumpable();
        collisionable = new PlatformCollisionable();
        spriteHere = "Images\\Box.jpg";
    }
    
    public MovingPlatform(float x, float y, float w, float h, String sh){
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        setType(Spawn.IS_PLATFORM);
        movable = new StandardMovable();
        fallable = new UnFallable();
        flyable = new UnFlyable();
        jumpable = new UnJumpable();
        collisionable = new PlatformCollisionable();
        spriteHere = "Images\\Box.jpg";
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
        setXSpeed(xSpeed);
        setYSpeed(ySpeed);
        counter++;
        if(counter>MAX){
            counter = 0;
            xSpeed*=-1;
            ySpeed*=-1;
            //System.out.println(xSpeed);
        }
        spriteName = spriteHere;
        return 0;
    }
}
