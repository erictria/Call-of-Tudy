import java.awt.*;
/**
 * Obstacle
 * @author Migi Ramos
 * @version 1.2 April 16
 */
public abstract class Obstacle extends Spawn
{
    protected int hp;
    protected boolean isDead; //If this variable already exists in the Spawn, just remove.
   	
    
    public int setKill(Killable j)
    {
    	killable = j;
    	return 0;
    }
    
    /*
    * When a Projectile collides with a Obstacle, this method is called.
    *
    */
    public int damage(int x)
    {
    	hp -= x;
    	if(hp <= 0) isDead = true;
    	return 0;
    }
    
    public int getHP()
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
    
    //@Override
    /*
    * When a Player collides with an Obstacle, Wall, or fellow Player it stops momentarily. Move factor is 0. 
    *
    */
    /*public float collision(Spawn other, float[] location)
    {
    	if (other instanceof Powerup)
    	{
    		
    	}
    	else if (other instanceof Projectile)
    	{
    		damage(other.damage()); //Calls the Obstacle's damage() method and uses the Projectile's damage as the parameter.
    								//Assumes that the Projectile has this getter function. Will update to the actual function when Projectile code is posted.
			//some method to make the projectile disappear goes here I guess? Or not?
    	}
    	else if (other instanceof Obstacle)
    	{
    		 
    	}
    	else if (other instanceof Player)
    	{
    		
    	}
    	else if (other instanceof Platform)
    	{
    	}
    	else if (other instanceof Wall)
    	{
    		
    	}
    }*/
    
    /*
    * Should be implemented by the concrete players.
    * 
    */
    public abstract int draw(Graphics g);
    
    
    
}