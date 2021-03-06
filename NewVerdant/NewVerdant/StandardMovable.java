
/**
 * For objects that move normally
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version Version 1.0 February 5, 2016
 */
public class StandardMovable implements Movable
{
    public float[] move(int moveFactor, float[] speed, float[] moveSpeed){
        //speed[0] = 1;
        //speed[1] = 1;
        if(moveFactor!=0){
            speed[2] += moveSpeed[0]*moveFactor;
        }
        else{
            speed[2] += speed[0];
            speed[3] += speed[1];
            speed[4] += speed[5];
        }
        return speed;
    }
}