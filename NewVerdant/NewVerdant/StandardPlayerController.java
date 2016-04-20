/**
 * Should be applicable for most players.
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version April 20, 2016
 */
public class StandardPlayerController extends SpawnController
{
    Player mySpawnE = (Player) mySpawn;
    public StandardPlayerController(Player e){
        super(e);
    }
    public void listenHook(){
        if(up){
            mySpawnE.jump(1);
        }
        if(left){
            mySpawnE.move(-1);
        }
        if(right){
            mySpawnE.move(1);
        }
        if(down){
            mySpawnE.jump(-1);
        }
        if(action1){
            mySpawnE.action1();
        }
        if(action2){
            mySpawnE.action2();
        }
        if(action3){
            mySpawnE.action3();
        }
        if(action4){
            mySpawnE.action4();
        }
    }
}