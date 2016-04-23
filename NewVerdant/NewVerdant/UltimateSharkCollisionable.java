/**
 * For Mr Magic's ultimate;
 * 
 * @author Eric Tria
 * @version Version 1.0 April 23, 2016
 */
public class UltimateSharkCollisionable implements Collisionable
{
	protected Player pl;
	
    public UltimateSharkCollisionable(Player p)
    {
    	pl = p;
    }
    
    public float[] collision(Spawn x, float[] location){
        if(x.getType()==Spawn.IS_PLAYER||x.getType()==Spawn.IS_OBSTACLE){
            pl.setXSpeed(0);
            pl.setYSpeed(0);
            x.setXSpeed(0);
            x.setYSpeed(0);
            x.kill(-1);
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