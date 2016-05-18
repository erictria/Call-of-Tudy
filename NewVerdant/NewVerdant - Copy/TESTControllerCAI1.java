//Controler test for CAI and shooting projectiles

public class TESTControllerCAI1 extends SpawnController{

    ProjectileFactory pf;

    public TESTControllerCAI1( Spawn e, ProjectileFactory pf){
        super( e );
        this.pf = pf;
    }

    public void listenHook(){
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
            pf.shoot( mySpawn.getLocation()[0]+mySpawn.getLocation()[2], mySpawn.getLocation()[1] );
        }
    }
}
