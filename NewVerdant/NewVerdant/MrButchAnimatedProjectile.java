/**
*   Implementation of Mr. Butch animated Butch
*
*   @author     Chris Angelo Isidro
*   @version    1.1 May 18, 2016
*   Changelog
*   CAI 1.1     - Moved animate() function to AnimatedProjectile instead
*/
public class MrButchAnimatedProjectile extends AnimatedProjectile{

    public MrButchAnimatedProjectile( Projectile p ){
        super( p );

        spriteSetRight = new String[1][4];
        spriteSetRight[0] = new String[]{ "Images\\MrButch\\Projectile\\Right\\MrButchProjectile-1.png",
                                          "Images\\MrButch\\Projectile\\Right\\MrButchProjectile-2.png",
                                          "Images\\MrButch\\Projectile\\Right\\MrButchProjectile-3.png",
                                          "Images\\MrButch\\Projectile\\Right\\MrButchProjectile-4.png"};

        spriteSetLeft = new String[1][4];
        spriteSetLeft[0] = new String[]{ "Images\\MrButch\\Projectile\\Left\\MrButchProjectile-1.png",
                                         "Images\\MrButch\\Projectile\\Left\\MrButchProjectile-2.png",
                                         "Images\\MrButch\\Projectile\\Left\\MrButchProjectile-3.png",
                                         "Images\\MrButch\\Projectile\\Left\\MrButchProjectile-4.png"};
        delay = 50;
    }

}
