/**
 * Flyable attribute to be implemented
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.1 March 18
 * Changelog
 * 1.1 properly implemented fly function. Probably gonna change implementation in the future.
 */
public interface Flyable
{
    /*
     * flyFactor is an input that changes how fly behaves
     * onGround checks whether or not object is currently on the ground. 
     * Usually only works if notOnGround.
     * 
     * output is an array of integers. Expected output is
     * Index    Corresponds to
     *   0         yVel
     *  1&2        xVel modifier
     */
    public float[] fly(int flyFactor, int onGround);
}
