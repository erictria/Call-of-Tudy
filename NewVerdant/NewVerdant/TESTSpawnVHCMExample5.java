//unimportant. Just an example.
public class TESTSpawnVHCMExample5 extends Spawn
{
    public TESTSpawnVHCMExample5(float x, float y, float w, float h){
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        movable = new StandardMovable();
        fallable = new UnFallable();
        flyable = new UnFlyable();
        jumpable = new UnJumpable();
    }
    public int setSpriteHook(){
        spriteName = "Images\\Box.jpg";
        return 0;
    }
}