/**
 * Should be applicable for most players.
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version April 20, 2016
 */
public class StandardPlayerController extends SpawnController
{
    public StandardPlayerController(Player e){
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
        if(down){
            mySpawn.jump(-1);
        }
    }
}