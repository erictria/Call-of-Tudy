/**
*   ChasePlayerFactory
*
*   @author Chris Angelo Isidro
*   @version April 26, 2016
*/
public class ChasePlayerFactory extends PlayerFactory{

    public ChasePlayerFactory( float x, float y, Map m, SpawnController sp ){
        super( x, y, m, sp );
    }
    public ChasePlayerFactory(float x, float y, int l, int t, Map m, SpawnController sp){
        super(x,y,l,t,m,sp);
    }
    public Player addPlayer(){
        float x = xPos, y = yPos;
        Chase chase = new Chase( x, y );
        chase.setProjectileFactory( new ChaseProjectileFactory( map ) );
        chase.setNumber(playerNumber);
        map.addSpawn( chase );
        sp.setSpawn( chase );
        return chase;
    }
}
