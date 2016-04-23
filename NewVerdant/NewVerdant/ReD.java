
/**
 * ReD!!! Starting right now.
 * 
 * @author Vincent Haron C. Mamutuk
 * @version 1.0 April 20, 2016
 */
import java.awt.*;
public class ReD extends Player
{
    private Mirror[] mirrors = new Mirror[4];
    public ReD(float x, float y){
        xPos = x;
        yPos = y;
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
    
    public int action1(){
        mirrors[0].activate();
        return 0;
    }
    public int action2(){
        mirrors[1].activate();
        return 0;
    }
    public int action3(){
        mirrors[2].activate();
        return 0;
    }
    public int action4(){
        mirrors[3].activate();
        return 0;
    }
    
    public int setMirrors(Mirror[] mirrors){
        this.mirrors = mirrors;
        return 0;
    }
    
    public int setSpriteHook(){
        //pro.shoot(xPos+width, yPos);
        return 0;
    }
    
    public int moveHook(){
        pro.shoot(xPos+width, yPos);
        return 0;
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
