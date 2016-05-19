/**
*   ChaseProjectile
*
*   @author     Chris Angelo Isidro
*   @version    1.2 May 18, 2016
*   Changelog
*   CAI 1.2 - Transfered overriding to projectile instead
*   CAI 1.1 - Added animations by overriding setSpriteHook()
*/
public class ChaseProjectile extends Projectile{

    public ChaseProjectile( float x, float y ){
        super( x, y, 15, 15, "Images\\Circle.png" );
        ProjectileCollisionable pj = new ProjectileCollisionable();
        pj.setDamage( 7 );
        collisionable = pj;
        ap = new ChaseAnimatedProjectile( this );
    }

}
