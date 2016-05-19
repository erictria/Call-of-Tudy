
/**
 * Write a description of class MrButchPlayerFactory here.
 *
 * @author Migs
 * @version April 25, 2016
 */
public class MeatballFactory extends ProjectileFactory
{
    // instance variables - replace the example below with your own
    private int x;
    private float lastX = 0, lastY = 0;
    public MeatballFactory(Map m){
        super();
        projectileVel = 10;
        fireRate = 700;
        currentMap = m;
    }

    protected Projectile createProjectile( float x, float y ){
        Projectile sample = new Meatball( x, y, 40, 40 );
        return sample;
    }

    public int setMap(Map m)
    {
        currentMap = m;
        return 0;
    }
}
