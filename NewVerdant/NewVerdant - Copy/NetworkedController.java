
/**
 * Should be applicable for networking use
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.0 May 13, 2016
 */
public class NetworkedController extends SpawnController
{
    MapReader mr;
    public NetworkedController(MapReader m){
        super(null);
        mr=m;
    }
    public void listenHook(){
        //System.out.println("WE ARE HERE!!!");
        mr.setUp(up);
        mr.setDown(down);
        mr.setRight(right);
        mr.setLeft(left);
        mr.setAction1(action1);
        mr.setAction2(action2);
        mr.setAction3(action3);
        mr.setAction4(action4);
        int dirFir = 1;
        if(dirUp){
            dirFir*=2;
        }
        if(dirRight){
            dirFir*=3;
        }
        if(dirLeft){
            dirFir*=5;
        }
        if(dirDown){
            dirFir*=7;
        }
        mr.setDirFir(dirFir);
    }
}
