
//unimportant. Just an example.
public class TESTSpawnVHCMExample4 extends Spawn
{
    public TESTSpawnVHCMExample4(float x, float y, float w, float h, Spawn s, boolean r){
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        movable = new ShadowMovable(x,y,s,r);
        fallable = new UnFallable();
        flyable = new UnFlyable();
        jumpable = new UnJumpable();
    }
    public int setSpriteHook(){
        spriteName = "Images\\TestPinkishBox.jpg";
        return 0;
    }
}