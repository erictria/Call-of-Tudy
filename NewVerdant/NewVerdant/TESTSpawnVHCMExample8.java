//unimportant. Just an example.
public class TESTSpawnVHCMExample8 extends Spawn
{
    private int killMeIn = 299;
    public TESTSpawnVHCMExample8(float x, float y, float w, float h){
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        killMeIn+=Math.random()*500;
        setType(Spawn.IS_PLATFORM);
        movable = new Immovable();
        fallable = new UnFallable();
        flyable = new UnFlyable();
        jumpable = new UnJumpable();
        //spriteHere = "Images\\Box.jpg";
        collisionable = new UnCollisionable();
    }
    public int setSpriteHook(){
        spriteName = "Images\\TestPinkishBox.jpg";
        killMeIn--;
        if(killMeIn<0){
            setDead();
        }
        //System.out.println(spriteName);
        return 0;
    }
}