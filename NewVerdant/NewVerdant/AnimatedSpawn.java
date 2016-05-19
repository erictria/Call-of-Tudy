/**
*   Animated spawn attribute to be implemented
*
*   @author     Chris Angelo Isidro
*   @version    1.0 May 16, 2016
*/
public abstract class AnimatedSpawn implements Animated{

    String[][] spriteSetLeft;
    String[][] spriteSetRight;

    long delay;
    long startTime;

    int currentFrame;

    boolean playedOnce;

    /**
    *   Constructor for animated projectile
    */
    public AnimatedSpawn( ){
        startTime = System.nanoTime();
        currentFrame = 0;
        playedOnce = false;
    }

    /**
    *   @return     playedOnce
    */
    public boolean played(){
        return playedOnce;
    }

    /**
    *   Sets playedOnce to false again
    *
    *   @return     0 if successful
    */
    public int resetPlay(){
        playedOnce = false;
        return 0;
    }

    public abstract String animate();
}
