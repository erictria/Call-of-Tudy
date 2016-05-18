//Controler test for testingRotationFiring

public class TESTControllerVHCM1 extends SpawnController{

    ProjectileFactory pf;
    float currDegrees = 0;
    float currTime;

    public TESTControllerVHCM1( Spawn e, ProjectileFactory pf){
        super( e );
        this.pf = pf;
        currTime = System.nanoTime();
    }

    public void listenHook(){
        float temp = System.nanoTime() - currTime;
        currTime = System.nanoTime();
        currDegrees += temp/100000.0f;
        if( up ){
            mySpawn.jump( 1 );
        }
        if( left ){
            mySpawn.move( -1 );
        }
        if( right ){
            mySpawn.move( 1 );
        }
        if( action4 ){
            pf.shoot( mySpawn.getLocation()[0]+mySpawn.getLocation()[2], mySpawn.getLocation()[1] 
            , currDegrees);
        }
    }
}
