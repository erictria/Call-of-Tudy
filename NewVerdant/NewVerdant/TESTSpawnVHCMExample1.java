//unimportant. Just an example.
public class TESTSpawnVHCMExample1 extends Spawn
{
    public TESTSpawnVHCMExample1(float x, float y, float w, float h){
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        setType(Spawn.IS_PLAYER);
        movable = new StandardMovable();
        fallable = new StandardFallable();
        flyable = new UnFlyable();
        jumpable = new UnJumpable();
        collisionable = new UnCollisionable();
    }
}
