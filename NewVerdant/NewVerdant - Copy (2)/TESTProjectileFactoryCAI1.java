// Projectile Factory test
public class TESTProjectileFactoryCAI1 extends ProjectileFactory{

    public TESTProjectileFactoryCAI1( Map m ){
        super();
        projectileVel = 10;
        fireRate = 700;
        currentMap = m;
    }

    protected Projectile createProjectile( float x, float y){
        Projectile sample = new TESTProjectileCAI1( x, y, 0, 0 );
        return sample;
    }
}
