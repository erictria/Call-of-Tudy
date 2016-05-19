/**
*   Implementation of Red animated projectile
*
*   @author     Chris Angelo Isidro
*   @version    1.0 May 19, 2016
*/
public class RedAnimatedProjectile extends AnimatedProjectile{

    public RedAnimatedProjectile( Projectile p ){
        super( p );

        spriteSetRight = new String[1][4];
        spriteSetRight[0] = new String[]{ "Images\\ReD\\Projectile\\Right\\ReDProjectile-1.png",
                                          "Images\\ReD\\Projectile\\Right\\ReDProjectile-2.png"};

        spriteSetLeft = new String[1][4];
        spriteSetLeft[0] = new String[]{ "Images\\ReD\\Projectile\\Left\\ReDProjectile-1.png",
                                         "Images\\ReD\\Projectile\\Left\\ReDProjectile-2.png"};
        delay = 50;
    }

}
