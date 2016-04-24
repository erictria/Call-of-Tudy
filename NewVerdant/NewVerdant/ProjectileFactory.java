/**
* Projectile
*
* @author   Chris Angelo Isidro
* @version  1.1 April 21, 2016
*
* Changelog
* CAI v1.1  - Added currentMap
*           - set shoot to add the projectile into currentMap
*/

public abstract class ProjectileFactory{

    public float projectileVel;
    public long fireRate;
    public long timeElapsed;

    protected Map currentMap;

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
    * @param degrees - degrees of fire.
    *
    * @return int - This returns 0 if successfully fired, -1 if not
    */
    protected int shoot( float x, float y, float degrees ){
        if( System.nanoTime() - timeElapsed >= fireRate*1000000 ){
            timeElapsed = System.nanoTime();
            Projectile bulletFired = createProjectile( x, y );
            double radians = Math.toRadians(degrees);
            bulletFired.setYSpeed(-(float)(Math.sin(radians)*projectileVel));
            bulletFired.setXSpeed((float)(Math.cos(radians)*projectileVel));
            currentMap.addSpawn( bulletFired );
            //System.out.println( "bang!" );
            return 0;
        }
        else{
            return -1;
        }
    }
    
    /**
    * method for shooting
    *
    * @param x - current x position
    * @param y - current y position
    *
    * @return int - This returns 0 if successfully fired, -1 if not
    */
    protected int shoot( float x, float y ){
        if( System.nanoTime() - timeElapsed >= fireRate*1000000 ){
            timeElapsed = System.nanoTime();
            Projectile bulletFired = createProjectile( x, y );
            bulletFired.setVelocity( projectileVel );
            currentMap.addSpawn( bulletFired );
            //System.out.println( "bang!" );
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

    /**
    * method for setting the map where the bullets would be fired
    *
    * @param newMap - new Map to be assigned
    *
    * @return int   - 0 is successful
    */
    public int setMap( Map newMap ){
        currentMap = newMap;
        return 0;
    }
}
