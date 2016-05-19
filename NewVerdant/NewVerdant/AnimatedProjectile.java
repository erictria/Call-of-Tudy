/**
*   Animated projectile attribute to be implemented
*
*   @author     Chris Angelo Isidro
*   @version    1.1 May 18, 2016
*   Changelog
*   CAI 1.1     - Extends AnimatedSpawn now instead of implementing Animated
*               - Added Projectile p as a local variable
*               - Added animate() function from ChaseAnimatedProjectile
*/
public class AnimatedProjectile extends AnimatedSpawn{

    Projectile p;

    public AnimatedProjectile( Projectile p ){
        super();
        this.p = p;
    }

    public String animate(){

        String[][] currentSet;

        if( p.getLocation()[6] > 0 ){
            currentSet = spriteSetRight;
        }
        else{
            currentSet = spriteSetLeft;
        }

        long elapsed = (System.nanoTime()-startTime)/1000000;

        if(elapsed > delay){
            currentFrame++;
            startTime = System.nanoTime();
        }
        if(currentFrame == currentSet[0].length){
            currentFrame = 0;
            playedOnce = true;
        }
        
        return currentSet[0][currentFrame];
    }
}
