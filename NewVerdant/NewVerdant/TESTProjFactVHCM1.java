// Projectile Factory test for rotating
public class TESTProjFactVHCM1 extends ProjectileFactory{

    public TESTProjFactVHCM1( Map m ){
        super();
        projectileVel = 10;
        fireRate = 100;
        currentMap = m;
    }

    protected Projectile createProjectile( float x, float y){
        Projectile sample = new TESTProjectileCAI1( x, y, 0, 0 );
        return sample;
    }
}