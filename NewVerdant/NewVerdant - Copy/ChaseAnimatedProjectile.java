/**
*   Implementation of Chase animated projectile
*
*   @author     Chris Angelo Isidro
*   @version    1.0 May 13, 2016
*/
public class ChaseAnimatedProjectile extends AnimatedProjectile{

    long delay;
    long startTime;

    int currentFrame;

    boolean playedOnce;

    public ChaseAnimatedProjectile( ){
        spriteSet = new String[1][4];
        spriteSet[0] = new String[]{ "Images\\ChaseProjectile-1.png",
                                     "Images\\ChaseProjectile-2.png",
                                     "Images\\ChaseProjectile-3.png",
                                     "Images\\ChaseProjectile-4.png"};
        delay = 50;
        startTime = System.nanoTime();
        currentFrame = 0;
        playedOnce = false;
    }
    public String animate(){
        long elapsed = (System.nanoTime()-startTime)/1000000;

        if(elapsed > delay){
            currentFrame++;
            startTime = System.nanoTime();
        }
        if(currentFrame == spriteSet[0].length){
            currentFrame = 0;
            playedOnce = true;
        }

        return spriteSet[0][currentFrame];
    }
}
