//unimportant. Just an example.
public class TESTSpawnVHCMExample extends Spawn
{
    public TESTSpawnVHCMExample(float x, float y, float w, float h){
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        rotationSpeed=1;
        movable = new RotatingMovable();
        fallable = new UnFallable();
        flyable = new UnFlyable();
        jumpable = new UnJumpable();
        collisionable = new UnCollisionable(); 
    }
    public int setSpriteHook(){
        spriteName = "Images\\Box.jpg";
        return 0;
    }
}
