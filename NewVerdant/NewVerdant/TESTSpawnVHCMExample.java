//unimportant. Just an example.
public class TESTSpawnVHCMExample extends Spawn
{
    public TESTSpawnVHCMExample(int x, int y, int w, int h){
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        movable = new Immovable();
        fallable = new UnFallable();
    }
}
