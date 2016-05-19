/**
 * Projectile
 *
 * @author Chris Angelo Isidro
 * @version 1.3 May 19, 2016
 *
 * Changelog
 * CAI v1.3 - Added AnimatedProjectile attribute
 * CAI v1.2 - changed StandardFallable to UnFallable
 * CAI v1.1	- Added setVelocity
 *
 */

public class Projectile extends Spawn{

	private String spriteHere;
	protected AnimatedProjectile ap;

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
		fallable = new UnFallable();
		flyable = new UnFlyable();
		jumpable = new UnJumpable();

		spriteHere = "Images/Circle.png";
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

		collisionable = new ProjectileCollisionable();
		movable = new StandardMovable();
		fallable = new UnFallable();
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
		return 0;
	}

	/**
	* method for setting sprites (I think)
	*
	* @return int - 0 if successful
	*/
	@Override
    public int setSpriteHook(){
        spriteName = ap.animate();
        return 0;
    }

}
