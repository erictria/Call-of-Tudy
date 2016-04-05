
/**
 * Jumpable attribute to be implemented
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.0 March 16
 */
public interface Jumpable
{
    /*
     * jumpFactor is an input that changes how jump behaves
     * onGround checks whether or not object is currently on the ground
     * 
     * output is an array of integers. Expected output is
     * Index    Corresponds to
     *   0         yVel
     *  1&2        change in xVel, index 1 is 1 if change in xVel(which is index 2) takes effect. 
     *             0 if not.
     */
    public float[] jump(int jumpFactor, int onGround);
}