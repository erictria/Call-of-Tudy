/**
 * For objects that are unaffected by gravity
 * 
 * @author Eric Tria 
 * @version Version 1.0 April 21, 2016
 */
public class SlowFallable implements Fallable
{
    public float[] fall(float[] speed, int onGround, float gravity, float terminalVelocity){
        if(onGround==Spawn.IS_ON_GROUND){
            if(speed[1]>0){
                speed[1] = 0;
            }
            return speed;
        }
        if(speed[1]<terminalVelocity){
            speed[1] += gravity/5;
            if(speed[1]>terminalVelocity)
                speed[1] = terminalVelocity/5;
        }
        return speed;
    }
}
