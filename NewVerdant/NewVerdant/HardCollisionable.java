/**
 * For the boundaries
 * 
 * @author Vincent Haron C. Mamutuk
 * @version Version 1.0 April 21, 2016
 */
public class HardCollisionable implements Collisionable
{
    public float[] collision(Spawn x, float[] location){
        x.kill(-1);
        //System.out.println("Out of Bounds.");
        return null;
    }
}