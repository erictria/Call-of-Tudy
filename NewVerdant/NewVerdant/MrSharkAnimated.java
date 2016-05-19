/**
*   Implementation of Mr. Shark animations
*
*   @author     Chris Angelo Isidro
*   @version    1.0 May 19, 2016
*/
public class MrSharkAnimated extends AnimatedPlayer{

    public MrSharkAnimated( Player p ){
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
        spriteSetRight[0] = new String[]{ "Images\\MrShark\\Player\\Right\\MrSharkBase.png" };
        spriteSetRight[1] = new String[]{ "Images\\MrShark\\Player\\Right\\MrSharkJumping-1.png" };
        spriteSetRight[2] = new String[]{ "Images\\MrShark\\Player\\Right\\MrSharkWalking-1.png",
                                          "Images\\MrShark\\Player\\Right\\MrSharkWalking-2.png"};
        spriteSetRight[3] = new String[]{ "Images\\MrShark\\Player\\Right\\MrSharkWalking-1.png",
                                          "Images\\MrShark\\Player\\Right\\MrSharkWalking-2.png"};


        spriteSetLeft = new String[5][3];
        spriteSetLeft[0] = new String[]{ "Images\\MrShark\\Player\\Left\\MrSharkBase.png" };
        spriteSetLeft[1] = new String[]{ "Images\\MrShark\\Player\\Left\\MrSharkJumping-1.png" };
        spriteSetLeft[2] = new String[]{ "Images\\MrShark\\Player\\Left\\MrSharkWalking-1.png",
                                         "Images\\MrShark\\Player\\Left\\MrSharkWalking-2.png"};
        spriteSetLeft[2] = new String[]{ "Images\\MrShark\\Player\\Left\\MrSharkWalking-1.png",
                                         "Images\\MrShark\\Player\\Left\\MrSharkWalking-2.png"};


        delay = 70;
    }

}
