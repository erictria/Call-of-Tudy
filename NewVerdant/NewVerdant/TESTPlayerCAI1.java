//Player test for CAI

import java.awt.*;
public class TESTPlayerCAI1 extends Player
{

	protected ProjectileFactory testFact;

	public TESTPlayerCAI1(String s, float x, float y, float w, float h)
	{
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
