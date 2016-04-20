/**
 * For ReD
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version Version 1.0 April 20, 2016
 */
public class GravBootsJumpable implements Jumpable
{
    public float[] jump(float[] speed, int jumpFactor, int onGround, float[] jumpSpeed){
        if(jumpFactor==0){
            return speed;
        }
        if(jumpFactor<0){
            if(speed[1] <jumpSpeed[1]/2)
                speed[1] = jumpSpeed[1]/2;
            return speed;
        }
        if(onGround!=1){
            return speed;
        }
        //System.out.println("Hi");
        speed[1] -= jumpSpeed[1];
        return speed;
    }
}