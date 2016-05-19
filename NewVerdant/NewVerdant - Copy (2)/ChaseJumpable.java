/**
 * For Chase.
 *
 * @author Vincent Haron C. Mamutuk
 * @version Version 1.0 February 5, 2016
 */
public class ChaseJumpable implements Jumpable{

    float blinkDistance, cooldown, timeElapsed;

    public ChaseJumpable( float bd, float cd ){
        blinkDistance = bd;
        cooldown = cd;
    }

    public float[] jump(float[] speed, int jumpFactor, int onGround, float[] jumpSpeed){
        if( jumpFactor <= 0 ){
            return speed;
        }
        if(System.nanoTime() - timeElapsed >= cooldown*1000000000 ){
            timeElapsed = System.nanoTime();
            float newY = Math.max( speed[3] - blinkDistance, 0 );
            speed[3] = newY;
            return speed;
        }
        return speed;
    }

    public int setCooldown( float cd ){
        cooldown = cd;
        return 0;
    }
}
