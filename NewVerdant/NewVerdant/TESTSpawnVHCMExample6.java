//unimportant. Just an example.
public class TESTSpawnVHCMExample6 extends Spawn
{
    public TESTSpawnVHCMExample6(float x, float y, float w, float h, Spawn s){
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        rotationSpeed = 1;
        movable = new OrbitingMovable2(x,y,1,s);
        fallable = new UnFallable();
        flyable = new UnFlyable();
        jumpable = new UnJumpable();
        setXSpeed(1);
        setYSpeed(1);
        collisionable = new UnCollisionable();
    }
    public int setSpriteHook(){
        spriteName = "Images\\TestPinkishBox.jpg";
        //System.out.println(spriteName);
        return 0;
    }
}