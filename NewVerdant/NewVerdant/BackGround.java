
/**
 * Just for BGs
 */
public class BackGround extends Spawn
{
    private String myName;
    public BackGround(String myName){
        xPos = 0;
        yPos = 0;
        width = 1005;
        height = 720;
        setType(-1);
        movable = new Immovable();
        fallable = new UnFallable();
        flyable = new UnFlyable();
        jumpable = new UnJumpable();
        collisionable = new UnCollisionable();
        this.myName = myName;
        //super(0,0,1005,720);
    }
    public int setSpriteHook(){
        spriteName = myName;
        return 0;
    }
}
