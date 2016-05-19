/**
*   Implementation of Mr. Magic animations
*
*   @author     Chris Angelo Isidro
*   @version    1.0 May 19, 2016
*/
public class MrMagicAnimated extends AnimatedPlayer{

    public MrMagicAnimated( Player p ){
        super( p );

        /**
        *   Sprite set array assignment:
        *       0   -   Base/Standing
        *       1   -   Jumping
        *       2   -   Walking
        *       3   -   Firing
        *       4+  -   Special/Character Specific
        */

        spriteSetRight = new String[5][3];
        spriteSetRight[0] = new String[]{ "Images\\MrMagic\\Player\\Right\\MrMagicBase.png" };
        spriteSetRight[1] = new String[]{ "Images\\MrMagic\\Player\\Right\\MrMagicJumping-1.png" };
        spriteSetRight[2] = new String[]{ "Images\\MrMagic\\Player\\Right\\MrMagicWalking-1.png",
                                          "Images\\MrMagic\\Player\\Right\\MrMagicWalking-2.png",
                                          "Images\\MrMagic\\Player\\Right\\MrMagicWalking-3.png"};
        spriteSetRight[3] = new String[]{ "Images\\MrMagic\\Player\\Right\\MrMagicFiring-1.png",
                                          "Images\\MrMagic\\Player\\Right\\MrMagicFiring-2.png",
                                          "Images\\MrMagic\\Player\\Right\\MrMagicFiring-3.png"};


        spriteSetLeft = new String[5][3];
        spriteSetLeft[0] = new String[]{ "Images\\MrMagic\\Player\\Left\\MrMagicBase.png" };
        spriteSetLeft[1] = new String[]{ "Images\\MrMagic\\Player\\Left\\MrMagicJumping-1.png" };
        spriteSetLeft[2] = new String[]{ "Images\\MrMagic\\Player\\Left\\MrMagicWalking-1.png",
                                         "Images\\MrMagic\\Player\\Left\\MrMagicWalking-2.png",
                                         "Images\\MrMagic\\Player\\Left\\MrMagicWalking-3.png"};
        spriteSetLeft[3] = new String[]{ "Images\\MrMagic\\Player\\Left\\MrMagicFiring-1.png",
                                         "Images\\MrMagic\\Player\\Left\\MrMagicFiring-2.png",
                                         "Images\\MrMagic\\Player\\Left\\MrMagicFiring-3.png"};

        delay = 70;
    }

}
