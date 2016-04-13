/**
 * For platforms;
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version Version 1.0 April 13, 2016
 */
public class PlatformCollisionable implements Collisionable
{
    public float[] collision(Spawn x, float[] location){
        if(x.getType()==Spawn.IS_PLAYER||x.getType()==Spawn.IS_OBSTACLE){
            float[] prev = x.getPrevCor();
            float[] speed = x.getSpeed();
            float[] loc = x.getLocation();
        }
        return null;
    }
}