/**
* Collisionable attribute designed for projectiles
*
* @author   Chris Angelo Isidro
* @version  1.0 April 16, 2016
*/

public class ProjectileCollisionable implements Collisionable{
    public float[] collision(Spawn collidedWith, float[] location){
        collidedWith.setDead();
        return location;
    }
}
