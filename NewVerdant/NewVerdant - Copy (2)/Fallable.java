
/**
 * Fallable attribute to be implemented
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.2 April 5, 2016
 * Changelog
 * VHCM 1.2 Added gravity to fall function parameters
 * VHCM 1.1 properly implemented fall function
 */
public interface Fallable
{
    /*
     * speed comes from Spawns getSpeed method
     * onGround checks whether or not object is currently on the ground.
     * gravity allows map to dictate the gravity in the world
     * Usually only works if onGround.
     * 
     * output right now is just one and that's the new yVel.
     */
    public float[] fall(float[] speed, int onGround, float gravity, float terminalVelocity);
}