
/**
 * For objects that cannot under any circumstances move.
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version Version 1.0 February 5, 2016
 */
public class Immovable implements Movable
{
    public float[] move(int moveFactor, float[] speed, float moveSpeed[]){
        //speed[0] = 0;
        //speed[1] = 0;
        /*speed[0] = 1;
        speed[1] = 1;
        speed[2] += speed[0];
        speed[3] += speed[1];
        System.out.println(speed[2]+" "+speed[3]);
        */
        return speed;
    }
}
