/**
*   Animated player attribute to be implemented
*
*   @author     Chris Angelo Isidro
*   @version    1.0 May 17, 2016
*/
public class AnimatedPlayer extends AnimatedSpawn{

    Player p;

    String[][] currentSet;

    public AnimatedPlayer( Player p ){
        super();
        this.p = p;

    }

    public String animate(){

        if( p.getDir() == Player.RIGHT ){
            currentSet = spriteSetRight;
        }
        else if( p.getDir() == Player.LEFT  ){
            currentSet = spriteSetLeft;
        }

        String[] currentFrameSet;

        if( p.getShooting() ){
            //System.out.println( "Shooting" );
            currentFrameSet = currentSet[3];
        }
        else if( p.isOnGround() != Spawn.IS_ON_GROUND ){
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

    public String animationHook(){
        return "";
    }

}
