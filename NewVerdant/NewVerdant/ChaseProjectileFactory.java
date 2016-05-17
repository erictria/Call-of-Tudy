/**
*   ChaseProjectileFactory
*
*   @author Chris Angelo Isidro
*   @version April 26, 2016
*/
public class ChaseProjectileFactory extends ProjectileFactory{

    public ChaseProjectileFactory( Map m ){
        super();
        projectileVel = 10;
        fireRate = 600;
        currentMap = m;
    }

    protected Projectile createProjectile( float x, float y ){
        Projectile card = new ChaseProjectile( x, y );
        return card;
    }
}
