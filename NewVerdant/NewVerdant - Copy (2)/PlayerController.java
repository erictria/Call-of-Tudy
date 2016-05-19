
/**
 * Write a description of class PlayerController here.
 * 
 * @author Eric Tria
 * @version 1.0 Apr 22, 2016
 */
public class PlayerController extends SpawnController
{
    Player p;
    ProjectileFactory pf;
    public PlayerController(Player e, ProjectileFactory pf){
        super(e);
        this.pf = pf;
        //p = e;
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
        if( action4 ){
            pf.shoot( mySpawn.getLocation()[0]+mySpawn.getLocation()[2], mySpawn.getLocation()[1] );
        }
    }
}
