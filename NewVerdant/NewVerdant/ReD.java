
/**
 * ReD!!! Starting right now.
 * 
 * @author Vincent Haron C. Mamutuk
 * @version 1.0 April 20, 2016
 */
import java.awt.*;
public class ReD extends Player
{
    public ReD(float x, float y){
        width = 30;
        height = 60;
        setMove(new StandardMovable());
        setJump(new GravBootsJumpable());
        setFall(new StandardFallable());
        setCollision(new PlayerCollisionable(this));
        setFly(new UnFlyable());
        setType(Spawn.IS_PLAYER);
        moveSpeed[0] = 2.00f;
        jumpSpeed[1] = 12;
        spriteName = "Images\\TestRed.png";
    }
    
    public int draw(Graphics g)
	{
		return 0;
	}
	
	public int ultimate()
	{
		return 0;
	}
}
