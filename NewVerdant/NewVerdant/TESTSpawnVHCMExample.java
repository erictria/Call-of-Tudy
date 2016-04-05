//unimportant. Just an example.
public class TESTSpawnVHCMExample extends Spawn
{
    public TESTSpawnVHCMExample(float x, float y, float w, float h){
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        movable = new Immovable();
        fallable = new UnFallable();
        flyable = new UnFlyable();
        jumpable = new UnJumpable();
    }
}
