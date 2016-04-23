import java.awt.*;
/**
 * Player
 *
 * Uses the move, jump, fly, fall, collision from Spawn.
 * Has methods to set the Movable, Flyable, etc objects.
 * Those objects must be set in the constructors of the concrete players that will extend this class.
 * The projectile will also be set in the constructors of the concrete players.
 * In the constructors, speed should be set to 0.
 * Checks hp
 * 
 * @author Eric Tria
 * @version 1.3 April 20, 2016
 * VHCM 1.3 Added action1 - 4 dir
 */
public abstract class Player extends Spawn
{
    protected int hp;
    //protected boolean isAlive; //If this variable already exists in the Spawn, just remove.
    protected ProjectileFactory pro; //The Projectile will be set in the constructor of the concrete players.
    protected String bottomSprite, topSprite;
    protected float topHalf;
   	
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
    * When a Projectile collides with a Player, this method is called.
    *
    */
    public int damage(int x)
    {
    	hp -= x;
    	if(hp <= 0) isAlive = true;
    	return 0;
    }
    
    /*
    * Possible to use this when a Player picks up a Powerup.
    *
    */
    public int heal(int x)
    {
    	hp += x;
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
    	return isAlive;
    }
    
    public int fire(double angle)
    {
    	//pro.shoot(xPos, yPos, angle); // Assuming that there is a Projectile.shoot() function.
    								// Will replace with the actual method of Projectile once the Projectile code is posted.
    	return 0;
    }
    
    /*@Override
    
    * When a Player collides with an Obstacle, Wall, or fellow Player it stops momentarily. Move factor is 0. 
    *
    *
    public float collision(Spawn other, float[] location)
    {
    	if (other instanceof Powerup)
    	{
    		//other.upgrade(this); //The Powerup does the upgrade on the Player.
    	}
    	else if (other instanceof Projectile)
    	{
    		//damage(other.damage()); //Calls the Player's damage() method and uses the Projectile's damage as the parameter.
    								//Assumes that the Projectile has this getter function. Will update to the actual function when Projectile code is posted.
    	}
    	else if (other instanceof Obstacle)
    	{
    		move(0); 
    	}
    	else if (other instanceof Player)
    	{
    		move(0);
    	}
    	else if (other instanceof Platform)
    	{
    	}
    	else if (other instanceof Wall)
    	{
    		move(0);
    	}
    }*/
    
    /*
    * Should be implemented by the concrete players.
    * Different for every player.
    *
    */
    public abstract int ultimate();
    
    public int setProjectileFactory(ProjectileFactory p){
        pro = p;
        return 0;
    }
    
    public int action1(){
        return 0;
    }
    public int action2(){
        return 0;
    }
    public int action3(){
        return 0;
    }
    public int action4(){
        return 0;
    }
    public int dirFir(int directionFactor){
        return 0;
    }
}