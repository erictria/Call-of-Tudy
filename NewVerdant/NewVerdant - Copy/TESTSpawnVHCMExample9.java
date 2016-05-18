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
        movable = new StandardMovable();
        fallable = new StandardFallable();
        flyable = new UnFlyable();
        jumpable = new StandardJumpable();
        collisionable = new UnCollisionable();
        moveSpeed[0] = 2.5f;
        jumpSpeed[1] = 12;
    }
    public int setSpriteHook(){
        spriteName = "Images\\TestRedBox.png";
        //System.out.println(spriteName);
        return 0;
    }
}