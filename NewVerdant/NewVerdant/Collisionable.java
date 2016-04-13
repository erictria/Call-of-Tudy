
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
    /*
     * output is an array of integers. Expected output is
     * Index    Corresponds to
     *   0         xPos
     *   1         yPos
     */
    public float[] collision(Spawn collidedWith);
}
