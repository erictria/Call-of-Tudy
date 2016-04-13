//unimportant. Just an example.
public class TESTSpawnVHCMExample9 extends Spawn
{
    public TESTSpawnVHCMExample9(float x, float y, float w, float h){
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        rotationSpeed = 0;
        setType(Spawn.IS_PLAYER);
        movable = new RotatingMovable();
        fallable = new StandardFallable();
        flyable = new UnFlyable();
        jumpable = new UnJumpable();
        collisionable = new UnCollisionable();
    }
    public int setSpriteHook(){
        spriteName = "Images\\TestRedBox.png";
        //System.out.println(spriteName);
        return 0;
    }
}