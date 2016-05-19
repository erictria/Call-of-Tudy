
/**
 * For objects that rotate at a given speed
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version Version 1.0 April 9, 2016
 */
//DEPRECATED DO NOT USE
//STANDARDMOVAVLE HAS BEEN UPDATED TO INCLUDE THE FUNCTIONALITY HERE
public class RotatingMovable implements Movable
{
    //float rotatingFactor = 1;
    public RotatingMovable(){
        //rotatingFactor = x;
    }
    public float[] move(int moveFactor, float[] speed, float moveSpeed[]){
        //speed[0] = 1;
        //speed[1] = 1;
        speed[2] += speed[0];
        speed[3] += speed[1];
        speed[4] += speed[5];
        return speed;
    }
}
