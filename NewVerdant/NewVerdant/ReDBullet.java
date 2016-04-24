
/**
 * ReDBullet
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.0 April 24, 2016
 */
public class ReDBullet extends Projectile
{
    public ReDBullet( float x, float y){
        super( x, y, 20, 20, "Images\\Circle.png" );
        /*collisionable = new UnCollisionable();
        setType(Spawn.IS_PLATFORM);*/
    }
}
