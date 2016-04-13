
/**
 * Collisionable attribute to be implemented
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.1 April 13, 2016
 * VHCM 1.1 - Changed to use float[] instead of float[][]
 */
public interface Collisionable
{
    //NOT VALID COMMENT collisionables comes from Spawn's getLocation Method of all objects in the class.
    //return null if 
    /*
     * output is an array of integers. Expected output is
     * Index    Corresponds to
     *   0         xVel
     *   1         yVel
     *   2         xPos
     *   3         yPos
     *   4         rotationDegrees
     *   5         rotationSpeed
     *   6         killFactor
     */
    public float[] collision(Spawn collidedWith, float[] location);
}
