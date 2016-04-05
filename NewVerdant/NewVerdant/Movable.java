
/**
 * Movable attribute to be implemented
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.0 March 16
 */
public interface Movable
{
    /*
     * moveFactor is an input that changes how move behaves
     * speed takes the speed of an object in the given standard
     * 
     * Index    Corresponds to
     *   0         xVel
     *   1         yVel
     *   2         xPos
     *   3         yPos
     *   
     * output is an array of integers. Expected output is
     * Index    Corresponds to
     *   0         xVel
     *   1         yVel
     *   2         xPos
     *   3         yPos
     */
    public float[] move(int moveFactor, float[] speed);
}
