/**
 * For objects that are unable to jump.
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version Version 1.0 February 5, 2016
 */
public class UnJumpable implements Jumpable
{
    public float[] jump(float[] speed, int jumpFactor, int onGround, float[] jumpSpeed){
        if(jumpFactor==0){
            return speed;
        }
        if(onGround!=1)
            return speed;
        return speed;
    }
}