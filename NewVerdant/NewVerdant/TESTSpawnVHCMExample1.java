//unimportant. Just an example.
public class TESTSpawnVHCMExample1 extends Spawn
{
    public TESTSpawnVHCMExample1(int x, int y, int w, int h){
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        movable = new StandardMovable();
        fallable = new StandardFallable();
        flyable = new UnFlyable();
        jumpable = new UnJumpable();
    }
}
