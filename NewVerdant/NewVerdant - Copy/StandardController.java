/**
 * Should be applicable for most.
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version April 17, 2016
 */
public class StandardController extends SpawnController
{
    public StandardController(Spawn e){
        super(e);
    }
    public void listenHook(){
        if(up){
            mySpawn.jump(1);
        }
        if(left){
            mySpawn.move(-1);
        }
        if(right){
            mySpawn.move(1);
        }
    }
}
