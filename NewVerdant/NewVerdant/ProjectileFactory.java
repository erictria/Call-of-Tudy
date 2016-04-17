/**
* Projectile
*
* @author   Chris Angelo Isidro
* @version  1.0 April 16, 2016
*/

public abstract class ProjectileFactory{

    public float projectileVel;
    public long fireRate;
    public long timeElapsed;

    /**
    * constructor for ProjectileFactory
    */
    public ProjectileFactory( ){
        timeElapsed = 0;
    }

    /**
    * abstract method for creating Projectiles
    *
    * @param x - x Position
    * @param y - y Position
    *
    */
    protected abstract Projectile createProjectile( float x, float y );

    /**
    * method for shooting
    *
    * @param x - current x position
    * @param y - current y position
    *
    * @return int - This returns 0 if successfully fired, -1 if not
    */
    protected int shoot( float x, float y ){
        if( System.nanoTime() - timeElapsed >= fireRate ){
            timeElapsed = System.nanoTime();
            Projectile bulletFired = createProjectile( x, y );
            bulletFired.setVelocity( projectileVel );
            return 0;
        }
        else{
            return -1;
        }
    }

    /**
    * method for setting new fire rate
    *
    * @param newFR - new fire rate
    *
    * @return int - 0 if successful
    */
    public int setFireRate( long newFR ){
        fireRate = newFR;
        return 0;
    }

    /**
    * method for setting new projectile velocity
    *
    * @para newPV - new projectile velocity
    *
    * @return int - 0 if successful
    */
    public int setProjVel( float newPV ){
        projectileVel = newPV;
        return 0;
    }
}
