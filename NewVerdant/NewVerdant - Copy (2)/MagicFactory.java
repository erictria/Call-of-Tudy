
/**
 * Write a description of class MagicFactory here.
 * 
 * @author Eric Tria 
 * @version 1.0 Apr 22, 2016
 */
public class MagicFactory extends ProjectileFactory
{
    // instance variables - replace the example below with your own
    private int x;
    private float lastX = 0, lastY = 0;
    public MagicFactory(Map m){
        super();
        projectileVel = 10;
        fireRate = 700;
        currentMap = m;
    }

    protected Projectile createProjectile( float x, float y ){
        Projectile sample = new Magic( x, y, 40, 40 );
        return sample;
    }

    public int setMap(Map m)
    {
        currentMap = m;
        return 0;
    }
}