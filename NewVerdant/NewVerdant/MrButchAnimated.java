/**
*   Implementation of Mr. Butch animations
*
*   @author     Chris Angelo Isidro
*   @version    1.0 May 19, 2016
*/
public class MrButchAnimated extends AnimatedPlayer{

    public MrButchAnimated( Player p ){
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
        spriteSetRight[0] = new String[]{ "Images\\MrButch\\Player\\Right\\MrButchBase.png" };
        spriteSetRight[1] = new String[]{ "Images\\MrButch\\Player\\Right\\MrButchJumping-1.png" };
        spriteSetRight[2] = new String[]{ "Images\\MrButch\\Player\\Right\\MrButchWalking-1.png",
                                          "Images\\MrButch\\Player\\Right\\MrButchWalking-2.png",
                                          "Images\\MrButch\\Player\\Right\\MrButchWalking-3.png",
                                          "Images\\MrButch\\Player\\Right\\MrButchWalking-4.png"};
        spriteSetRight[3] = new String[]{ "Images\\MrButch\\Player\\Right\\MrButchFiring-1.png",
                                          "Images\\MrButch\\Player\\Right\\MrButchFiring-2.png"};


        spriteSetLeft = new String[5][3];
        spriteSetLeft[0] = new String[]{ "Images\\MrButch\\Player\\Left\\MrButchBase.png" };
        spriteSetLeft[1] = new String[]{ "Images\\MrButch\\Player\\Left\\MrButchJumping-1.png" };
        spriteSetLeft[2] = new String[]{ "Images\\MrButch\\Player\\Left\\MrButchWalking-1.png",
                                         "Images\\MrButch\\Player\\Left\\MrButchWalking-2.png",
                                         "Images\\MrButch\\Player\\Left\\MrButchWalking-3.png",
                                         "Images\\MrButch\\Player\\Left\\MrButchWalking-4.png"};
        spriteSetLeft[3] = new String[]{ "Images\\MrButch\\Player\\Left\\MrButchFiring-1.png",
                                         "Images\\MrButch\\Player\\Left\\MrButchFiring-2.png"};

        delay = 50;
    }
}
