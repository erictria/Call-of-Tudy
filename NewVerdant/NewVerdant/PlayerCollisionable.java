/**
 * For players;
 * 
 * @author Eric Tria
 * @version Version 1.1 April 19, 2016
 * VHCM 1.1 Changed to destroy projectiles and Powerups
 */
public class PlayerCollisionable implements Collisionable
{
	protected Player pl;
	
    public PlayerCollisionable(Player p)
    {
    	pl = p;
    }
    
    public float[] collision(Spawn x, float[] location){
        if(x.getType()==Spawn.IS_PLAYER||x.getType()==Spawn.IS_OBSTACLE){
            pl.setXSpeed(0);
            pl.setYSpeed(0);
            x.setXSpeed(0);
            x.setYSpeed(0);
        }
        else if(x.getType() == Spawn.IS_PROJECTILE||x.getType()==Spawn.IS_POWERUP)
        {
            x.kill(-1);
        	/*pl.setXSpeed(0);
            pl.setYSpeed(0);
            x.setXSpeed(0);
            x.setYSpeed(0);*/
        	//pl.damage(x.getDamage()); // waiting for the actual getter method of the projectile.
        }
        /*else if(x.getType() == Spawn.IS_POWERUP)
        {
        	pl.move(0);
        	x.upgrade(pl); 
        }*/
        return null;
    }
}