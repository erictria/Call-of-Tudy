/*
 ** @author: Migs
 ** Date: April 14, 2016
 ** Version: 0.1
 */
public class Powerup extends Spawn implements Killable, Collisionable
{
	//constructor
	public Powerup(float x, float y, float w, float h)
	{
		xPos = x;
        yPos = y;
        width = w;
        height = h;
		setType(Spawn.IS_POWERUP);
		
		//Powerup behaviors
        fallable = new UnFallable();
        flyable = new UnFlyable();
		movable = new Immovable();
        jumpable = new UnJumpable();
        spriteHere = sh;
	}
	
	//Collision: When Player collides with powerup
	@Override
	public float[] collision(Spawn collidedWith, float[] location)
	{
		//methods here
		kill();
	}
	
	//Kill: When powerup disappears from the screen
	@Override 
	public float[] kill(float killFactor)
	{
		
	}
	
	//Behavior: 
	public int upgrade()
	{
		return 0;
	}
	
	public int setSpriteHook(){
        spriteName = spriteHere;
        return 0;
    }
	
	
	
}