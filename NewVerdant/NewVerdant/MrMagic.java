import java.awt.*;
public class MrMagic extends Player
{
	public MrMagic(String s, float x, float y, float w, float h)
	{
		pro = new Projectile(0, 0, 0, 0, "");
		setMove(new StandardMovable());
		setFly(new UnFlyable());
		setJump(new StandardJumpable());
		setFall(new StandardFallable());
		setCollision(new PlayerCollisionable(this));
		setType(Spawn.IS_PLAYER);
		//setKill(new StandardKillable());
		xVel = 0;
		yVel = 0;
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		moveSpeed[0] = 2.5f; jumpSpeed[1] = 25;
		spriteName = s;
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