
/**
 * MrMagicPlayerFactory
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version April 24, 2016
 */
public class MrMagicPlayerFactory extends PlayerFactory
{
    public MrMagicPlayerFactory(float x, float y, Map m, SpawnController sp){
        super(x,y,m,sp);
    }
    public Player addPlayer(){
        float x = xPos, y = yPos;
        MrMagic te = new MrMagic(x,y);
        te.setProjectileFactory(new MagicFactory(map));
        /*Mirror[] mirrors = new Mirror[4];
        mirrors[0] = new Mirror(x+55,y+20,15,15,0,te,map);
        mirrors[0].setNumber(0);
        mirrors[1] = new Mirror(x-45,y+20,15,15,180,te,map);
        mirrors[1].setNumber(1);
        mirrors[2] = new Mirror(x+5,y+70,15,15,270,te,map);
        mirrors[2].setNumber(2);
        mirrors[3] = new Mirror(x+5,y-30,15,15,90,te,map);
        mirrors[3].setNumber(3);
        te.setMirrors(mirrors);*/
        map.addSpawn(te);
        sp.setSpawn(te);
        //SpawnController spC = new StandardPlayerController(te);
        return te;
    }
}
