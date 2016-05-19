/**
*   Animated projectile attribute to be implemented
*
*   @author     Chris Angelo Isidro
*   @version    1.0 May 13, 2016
*/
public abstract class AnimatedProjectile implements Animated{

    String[][] spriteSet;

    /**
    *   Constructor for animated projectile
    */
    public AnimatedProjectile( ){
        ;
    }

    public abstract String animate();
}
