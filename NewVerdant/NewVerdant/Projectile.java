/**
 * Projectile
 *
 * @author Chris Angelo Isidro
 * @version 1.0 April 14, 2016
 * 
 */

public class Projectile extends Spawn{
	
	private String spriteHere;
	protected float velocity;
	
	public Projectile( float x, float y, float w, float h ){
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		setType( Spawn.IS_PROJECTILE );
		
		//collisionable = new 
		movable = new StandardMovable();
		fallable = new StandardFallable();
		flyable = new UnFlyable();
		jumpable = new UnJumpable();
		
		spriteHere = "Images\\Circle.jpg";
	}
	
	public Projectile( float x, float y, float w, float h, String sprite ){
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		setType( Spawn.IS_PROJECTILE );
		
		movable = new StandardMovable();
		fallable = new StandardFallable();
		flyable = new UnFlyable();
		jumpable = new UnJumpable();
		
		spriteHere = sprite;
	}
	
	public int setSpriteHook(){
		spriteName = spriteHere;
        return 0;
	}
	
}