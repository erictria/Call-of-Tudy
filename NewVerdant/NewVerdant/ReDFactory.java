
/**
 * ReDBullet Factory
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.0 April 24, 2016
 */
public class ReDFactory extends ProjectileFactory
{
    public ReDFactory(Map m){
        super();
        projectileVel = 8;
        fireRate = 600;
        currentMap = m;
    }
    
    protected Projectile createProjectile( float x, float y){
        Projectile sample = new ReDBullet( x, y);
        return sample;
    }
}
