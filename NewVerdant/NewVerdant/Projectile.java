/**
 * Projectile
 *
 * @author Chris Angelo Isidro
 * @version 1.1 April 14, 2016
 *
 * Changelog
 * CAI v1.1	- Added setVelocity
 *			-
 */

public class Projectile extends Spawn{

	private String spriteHere;

	/**
	* constructor for Projectile
	*
	* @param x - x position
	* @param y - y position
	* @param w - projectile width
	* @param h - projectile height
	*/
	public Projectile( float x, float y, float w, float h ){
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		setType( Spawn.IS_PROJECTILE );

		collisionable = new ProjectileCollisionable();
		movable = new StandardMovable();
		fallable = new StandardFallable();
		flyable = new UnFlyable();
		jumpable = new UnJumpable();

		spriteHere = "Images/Circle.jpg";
	}

	/**
	* constructor for Projectile
	*
	* @param x 		- x position
	* @param y 		- y position
	* @param w 		- projectile width
	* @param h 		- projectile height
	* @param sprite - sprite name
	*/
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

	/**
	* method for setting new velocity
	*
	* @param newFR - new fire rate
	*
	* @return int - 0 if successful
	*/
	public int setVelocity( float vel ){
		xVel = vel;
		yVel = vel;
		return 0;
	}

	/**
	* method for setting sprites (I think)
	*
	* @return int - 0 if successful
	*/
	public int setSpriteHook(){
		spriteName = spriteHere;
        return 0;
	}

}
