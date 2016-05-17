/**
*   ChaseProjectile
*
*   @author Chris Angelo Isidro
*   @version 1.0 April 26, 2016
*/
public class ChaseProjectile extends Projectile{

    ChaseAnimatedProjectile cap;

    public ChaseProjectile( float x, float y ){
        super( x, y, 15, 15, "Images\\Circle.png" );
        ProjectileCollisionable pj = new ProjectileCollisionable();
        pj.setDamage( 7 );
        collisionable = pj;
        cap = new ChaseAnimatedProjectile(  );
    }

    @Override
    public int setSpriteHook(){
        spriteName = cap.animate();
        return 0;
    }

}
