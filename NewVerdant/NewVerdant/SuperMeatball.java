
/**
 * Write a description of class Meatball here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SuperMeatball extends Projectile
{
    public SuperMeatball( float x, float y, float w, float h ){
        super( x, y, w, h, "Images\\meatball.png" );
        ProjectileCollisionable pj = new ProjectileCollisionable();
        pj.setDamage(2.75f);
        collisionable = pj;
        fallable = new UnFallable();
        ap = new MrButchAnimatedProjectile(this);
    }
}
