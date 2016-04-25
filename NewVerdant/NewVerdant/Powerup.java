/*
 ** @author: Migs
 ** Date: April 21, 2016
 ** Version: 1.1
 ** Update 1.1: Updated collisionActiveHook to make sure object collided with is a player
 **
 ** Concrete Powerups need to implement these methods:
 ** - upgrade(Player) : place specific behavior here; should return 0.
 */ 
public abstract class Powerup extends Spawn 
{
    Player player;
    
    //constructor
    public Powerup(String s, float x, float y, float w, float h)
    {
        spriteName = s;
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        setType(Spawn.IS_POWERUP);
        
        setMove(new Immovable());
        setFly(new UnFlyable());
        setJump(new UnJumpable());
        setFall(new UnFallable());
        setKill(new StandardKillable());
        setCollision(new UnCollisionable());

    }
    public int setMove(Movable m)
    {
        movable = m;
        return 0;
    }
    public int setJump(Jumpable j)
    {
        jumpable = j;
        return 0;
    }
    public int setFly(Flyable f)
    {
        flyable = f;
        return 0;
    }
    public int setFall(Fallable f)
    {
        fallable = f;
        
        return 0;
    }
    public int setKill(Killable k)
    {
        killable = k;
        return 0;
    }
    public int setCollision(Collisionable c)
    {
        collisionable = c;
        return 0;
    }
    //Behavior: 


    
    // Hook/Decorator
    @Override
    public int collisionActiveHook(Spawn spawn){

       if (spawn instanceof Player)
       { 
           player = (Player) spawn;
           upgradePlayer(player); 
       }
        return 0;
    }
    
    public abstract Player upgradePlayer(Player player);
    
    
}