/**
* Collisionable attribute designed for projectiles
*
* @author   Chris Angelo Isidro
* @version  1.1 April 21, 2016
*
* Changelog
* CAI v1.1  - Changed collision so that only players get instakilled
*           - Added if statement to separate collision with players and obstacles
*/

public class ProjectileCollisionable implements Collisionable{

    protected float damage;

    public float[] collision(Spawn collidedWith, float[] location){
        if( collidedWith.getType() == Spawn.IS_PLAYER ){
            collidedWith.kill( -1 );
        }
        else if( collidedWith.getType() == Spawn.IS_OBSTACLE){
            collidedWith.kill( -1 );
        }
        return collidedWith.getSpeed();
    }

    public int setDamage( float newD ){
        damage = newD;
        return 0;
    }
}
