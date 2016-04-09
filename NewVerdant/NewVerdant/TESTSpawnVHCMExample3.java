//unimportant. Just an example.
public class TESTSpawnVHCMExample3 extends Spawn
{
    public TESTSpawnVHCMExample3(float x, float y, float w, float h){
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        movable = new OrbitingMovable(1.0f,1,500,350);
        fallable = new UnFallable();
        flyable = new UnFlyable();
        jumpable = new UnJumpable();
    }
}