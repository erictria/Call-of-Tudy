/**
*   ChaseProjectileFactory
*
*   @author     Chris Angelo Isidro
*   @version    1.1 May 16, 2016
*   Changelog
*   CAI 1.1     - Changed projectileVel to 10 from 15
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
