/**
 * For objects that are unaffected by gravity
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version Version 1.0 February 5, 2016
 */
public class StandardFallable implements Fallable
{
    public float[] fall(float[] speed, int onGround, float gravity, float terminalVelocity){
        if(speed[1]<terminalVelocity){
            speed[1] += gravity;
            if(speed[1]>terminalVelocity)
                speed[1] = terminalVelocity;
        }
        return speed;
    }
}