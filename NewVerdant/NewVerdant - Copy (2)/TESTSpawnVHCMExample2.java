//unimportant. Just an example.
public class TESTSpawnVHCMExample2 extends Spawn
{
    public TESTSpawnVHCMExample2(float x, float y, float w, float h){
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        rotationSpeed = 1;
        movable = new RotatingMovable();
        fallable = new StandardFallable();
        flyable = new UnFlyable();
        jumpable = new UnJumpable();
        collisionable = new UnCollisionable();
    }
}