import java.awt.*;
/**
 * Obstacle
 *
 * Uses the collision from Spawn.
 * Structured similarly to the Player class.
 * In the constructors, speed should be set to 0.
 * Checks hp
 * 
 * Regarding the collision, the only objects that affect the Obstacle would be, and vice versa, would be Player and Projectile.
 * This is assuming that Obstacles can't be pushed by either Player or Projectiles.
 * If Obstacles can be pushed then we would have to add collision with other Obstacles.
 * 
 * @author Migi Ramos
 * @version 1.3 April 19
 */
public abstract class Obstacle extends Spawn
{
    protected int hp;
    protected boolean isDead; //If this variable already exists in the Spawn, just remove.
   	
    
    public int setMove(Movable m)
    {
    	movable = m;
    	return 0;
    }
    
    public int setFly(Flyable f)
    {
    	flyable = f;
    	return 0;
    }
    
    public int setJump(Jumpable j)
    {
    	jumpable = j;
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
    
    /*
    * When a Projectile collides with an Obstacle, this method is called.
    *
    */
    public int damage(int x)
    {
    	hp -= x;
    	if(hp <= 0) isDead = true;
    	return 0;
    }
    
    public float getHP()
    {
    	return hp;
    }
    
    /*
    * If this already exists in the Spawn just remove.
    *
    */
    public boolean deathCheck()
    {
    	return isDead;
    }

    /*
    * Should be implemented by the concrete players.
    * 
    */
    public abstract int draw(Graphics g);
    
}