
/**
 * Boundary
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.0 April 10, 2016
 * Changelog
 */
public class Boundary extends Spawn
{
    public Boundary(float x, float y, float w, float h){
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        setType(0);
        movable = new Immovable();
        fallable = new UnFallable();
        flyable = new UnFlyable();
        jumpable = new UnJumpable();
        collisionable = new HardCollisionable();
    }
}