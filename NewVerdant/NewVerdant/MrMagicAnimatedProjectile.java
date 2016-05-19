/**
*   Implementation of MrMagic animated projectile
*
*   @author     Chris Angelo Isidro
*   @version    1.0 May 19, 2016
*   Changelog
*/
public class MrMagicAnimatedProjectile extends AnimatedProjectile{

    public MrMagicAnimatedProjectile( Projectile p ){
        super( p );

        spriteSetRight = new String[1][2];
        spriteSetRight[0] = new String[]{ "Images\\MrMagic\\Projectile\\Right\\MrMagicProjectile-1.png",
                                          "Images\\MrMagic\\Projectile\\Right\\MrMagicProjectile-2.png"};

        spriteSetLeft = new String[1][4];
        spriteSetLeft[0] = new String[]{ "Images\\MrMagic\\Projectile\\Left\\MrMagicProjectile-1.png",
                                         "Images\\MrMagic\\Projectile\\Left\\MrMagicProjectile-2.png"};
        delay = 50;
    }

}
