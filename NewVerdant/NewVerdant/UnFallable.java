/**
 * For objects that are unaffected by gravity
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version Version 1.0 February 5, 2016
 */
public class UnFallable implements Fallable
{
    public float[] fall(float[] speed, int onGround, float gravity, float terminalVelocity){
        return speed;
    }
}
