/**
*   Implementation of ReD animations
*
*   @author     Chris Angelo Isidro
*   @version    1.0 May 19, 2016
*/
public class RedAnimated extends AnimatedPlayer{

    public RedAnimated( Player p ){
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
        spriteSetRight[0] = new String[]{ "Images\\ReD\\Player\\Right\\ReDBase.png" };
        spriteSetRight[1] = new String[]{ "Images\\ReD\\Player\\Right\\ReDJumping-1.png" };
        spriteSetRight[2] = new String[]{ "Images\\ReD\\Player\\Right\\ReDWalking-1.png",
                                          "Images\\ReD\\Player\\Right\\ReDWalking-2.png",
                                          "Images\\ReD\\Player\\Right\\ReDWalking-3.png"};



        spriteSetLeft = new String[5][3];
        spriteSetLeft[0] = new String[]{ "Images\\ReD\\Player\\Left\\ReDBase.png" };
        spriteSetLeft[1] = new String[]{ "Images\\ReD\\Player\\Left\\ReDJumping-1.png" };
        spriteSetLeft[2] = new String[]{ "Images\\ReD\\Player\\Left\\ReDWalking-1.png",
                                         "Images\\ReD\\Player\\Left\\ReDWalking-2.png",
                                         "Images\\ReD\\Player\\Left\\ReDWalking-3.png"};


        delay = 50;
    }

    @Override
    public String animate(){

        if( p.getDir() == Player.RIGHT ){
            currentSet = spriteSetRight;
        }
        else if( p.getDir() == Player.LEFT  ){
            currentSet = spriteSetLeft;
        }

        String[] currentFrameSet;

        if( p.isOnGround() != Spawn.IS_ON_GROUND ){
            //System.out.println( "Jumping/Falling" );
            currentFrameSet = currentSet[1];
        }
        else if( p.getWalking() ){
            //System.out.println( "Walking" );
            currentFrameSet = currentSet[2];
        }
        else{
            //System.out.println( "Idle" );
            currentFrameSet = currentSet[0];
        }

        long elapsed = (System.nanoTime()-startTime)/1000000;

        if(elapsed > delay){
            currentFrame++;
            startTime = System.nanoTime();
        }

        if(currentFrame >= currentFrameSet.length){
            currentFrame = 0;
            playedOnce = true;
        }

        try{
            return currentFrameSet[currentFrame];
        }catch( ArrayIndexOutOfBoundsException aioobe ){
            currentFrame = 0;
            return currentFrameSet[0];
        }
    }

}
