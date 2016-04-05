
/**
 * Collisionable attribute to be implemented
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.0 March 16
 */
public interface Collisionable
{
    //collisionables comes from Spawn's getLocation Method of all objects in the class.
    /*
     * output is an array of integers. Expected output is
     * Index    Corresponds to
     *   0         xPos
     *   1         yPos
     */
    public float[] collision(float[][] collisionables);
}
