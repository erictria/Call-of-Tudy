/**
*   Implementation of Chase animated projectile
*
*   @author     Chris Angelo Isidro
*   @version    1.1 May 18, 2016
*   Changelog
*   CAI 1.1     - Moved animate() function to AnimatedProjectile instead
*/
public class ChaseAnimatedProjectile extends AnimatedProjectile{

    public ChaseAnimatedProjectile( Projectile p ){
        super( p );
        
        spriteSetRight = new String[1][4];
        spriteSetRight[0] = new String[]{ "Images\\Chase\\Projectile\\Right\\ChaseProjectile-1.png",
                                          "Images\\Chase\\Projectile\\Right\\ChaseProjectile-2.png",
                                          "Images\\Chase\\Projectile\\Right\\ChaseProjectile-3.png",
                                          "Images\\Chase\\Projectile\\Right\\ChaseProjectile-4.png"};

        spriteSetLeft = new String[1][4];
        spriteSetLeft[0] = new String[]{ "Images\\Chase\\Projectile\\Left\\ChaseProjectile-1.png",
                                         "Images\\Chase\\Projectile\\Left\\ChaseProjectile-2.png",
                                         "Images\\Chase\\Projectile\\Left\\ChaseProjectile-3.png",
                                         "Images\\Chase\\Projectile\\Left\\ChaseProjectile-4.png"};
        delay = 50;
    }

}
