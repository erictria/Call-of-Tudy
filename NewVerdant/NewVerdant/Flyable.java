/**
 * Flyable attribute to be implemented
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.2 April 5, 2016
 * Changelog
 * VHCM 1.2 Changed to input and output speed
 * VHCM 1.1 properly implemented fly function. Probably gonna change implementation in the future.
 */
public interface Flyable
{
    /*
     * flyFactor is an input that changes how fly behaves
     * onGround checks whether or not object is currently on the ground. 
     * Usually only works if notOnGround.
     * 
     * output is an array of floats. Expected output is
     * Index    Corresponds to
     *   0         xVel
     *   1         yVel
     *   2         xPos
     *   3         yPos
     */
    public float[] fly(float[] speed, int flyFactor, int onGround, float[] flySpeed);
}
