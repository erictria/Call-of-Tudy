/**
 * For objects that are unable to fly.
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version Version 1.0 February 5, 2016
 */
public class UnFlyable implements Flyable
{
    public float[] fly(float[] speed, int flyFactor, int onGround, float[] flySpeed){
        if(flyFactor==0){
            return speed;
        }
        if(onGround==1)
            return speed;
        return speed;
    }
}