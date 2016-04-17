/**
* Collisionable attribute designed for projectiles
*
* @author   Chris Angelo Isidro
* @version  1.0 April 16, 2016
*/

public class ProjectileCollisionable implements Collisionable{

    protected float damage;

    public float[] collision(Spawn collidedWith, float[] location){
        collidedWith.kill( damage );
        return location;
    }

    public int setDamage( float newD ){
        damage = newD;
        return 0;
    }
}
