//unimportant. Just an example.
public class TESTSpawnVHCMExample3 extends Spawn
{
    public TESTSpawnVHCMExample3(float x, float y, float w, float h, Spawn s){
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        rotationSpeed = (float)Math.random()*2;
        movable = new OrbitingMovable((float)Math.random()*2,s);
        fallable = new UnFallable();
        flyable = new UnFlyable();
        jumpable = new UnJumpable();
        collisionable = new UnCollisionable();
    }
    public int setSpriteHook(){
        spriteName = "Images\\TestPinkishBox.jpg";
        //System.out.println(spriteName);
        return 0;
    }
}