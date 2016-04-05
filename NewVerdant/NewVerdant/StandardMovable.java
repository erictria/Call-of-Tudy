
/**
 * For objects that move normally
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version Version 1.0 February 5, 2016
 */
public class StandardMovable implements Movable
{
    public float[] move(int moveFactor, float[] speed){
        //speed[0] = 1;
        //speed[1] = 1;
        speed[2] += speed[0];
        speed[3] += speed[1];
        return speed;
    }
}