/**
 * For objects that are able to jump.
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version Version 1.0 February 5, 2016
 * Most should use this
 */
public class StandardKillable implements Killable
{
    public float kill(float killFactor, float currHP){
        if(killFactor < 0)
            return killFactor;
        return (float)(currHP - killFactor);
    }
}
