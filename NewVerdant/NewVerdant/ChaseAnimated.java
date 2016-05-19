/**
*   Implementation of Chase animations
*
*   @author     Chris Angelo Isidro
*   @version    1.0 May 18, 2016
*/
public class ChaseAnimated extends AnimatedPlayer{

    public ChaseAnimated( Player p ){
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
        spriteSetRight[0] = new String[]{ "Images\\Chase\\Player\\Right\\ChaseBase.png" };
        spriteSetRight[1] = new String[]{ "Images\\Chase\\Player\\Right\\ChaseJumping-1.png" };
        spriteSetRight[2] = new String[]{ "Images\\Chase\\Player\\Right\\ChaseWalking-1.png",
                                          "Images\\Chase\\Player\\Right\\ChaseWalking-2.png",
                                          "Images\\Chase\\Player\\Right\\ChaseWalking-3.png"};
        spriteSetRight[3] = new String[]{ "Images\\Chase\\Player\\Right\\ChaseFiring-1.png",
                                          "Images\\Chase\\Player\\Right\\ChaseFiring-2.png",
                                          "Images\\Chase\\Player\\Right\\ChaseFiring-3.png"};


        spriteSetLeft = new String[5][3];
        spriteSetLeft[0] = new String[]{ "Images\\Chase\\Player\\Left\\ChaseBase.png" };
        spriteSetLeft[1] = new String[]{ "Images\\Chase\\Player\\Left\\ChaseJumping-1.png" };
        spriteSetLeft[2] = new String[]{ "Images\\Chase\\Player\\Left\\ChaseWalking-1.png",
                                         "Images\\Chase\\Player\\Left\\ChaseWalking-2.png",
                                         "Images\\Chase\\Player\\Left\\ChaseWalking-3.png"};
        spriteSetLeft[3] = new String[]{ "Images\\Chase\\Player\\Left\\ChaseFiring-1.png",
                                         "Images\\Chase\\Player\\Left\\ChaseFiring-2.png",
                                         "Images\\Chase\\Player\\Left\\ChaseFiring-3.png"};

        delay = 50;
    }

}
