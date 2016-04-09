
/**
 * For objects that rotate at a given speed
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version Version 1.0 April 9, 2016
 */
public class RotatingMovable implements Movable
{
    float rotatingFactor = 1;
    public RotatingMovable(float x){
        rotatingFactor = x;
    }
    public float[] move(int moveFactor, float[] speed){
        //speed[0] = 1;
        //speed[1] = 1;
        speed[2] += speed[0];
        speed[3] += speed[1];
        speed[4] += rotatingFactor;
        return speed;
    }
}
