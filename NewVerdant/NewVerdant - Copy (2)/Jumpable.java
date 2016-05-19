
/**
 * Jumpable attribute to be implemented
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.0 April 5, 2016
 */
public interface Jumpable
{
    /*
     * jumpFactor is an input that changes how jump behaves
     * onGround checks whether or not object is currently on the ground
     * 
     * output is an array of floats. Expected output is
     * Index    Corresponds to
     *   0         xVel
     *   1         yVel
     *   2         xPos
     *   3         yPos
     */
    public float[] jump(float[] speed, int jumpFactor, int onGround, float[] jumpSpeed);
}