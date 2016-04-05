
/**
 * Fallable attribute to be implemented
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.1 March 16
 * Changelog
 * VHCM 1.1 properly implemented fall function
 */
public interface Fallable
{
    /*
     * speed comes from Spawns getSpeed method
     * onGround checks whether or not object is currently on the ground. 
     * Usually only works if onGround.
     * 
     * output right now is just one and that's the new yVel.
     */
    public float[] fall(float[] speed, int onGround);
}