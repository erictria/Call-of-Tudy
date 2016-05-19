import java.awt.*;
public class Cube extends Obstacle
{
	public Cube(String s, float x, float y, float w, float h)
	{
	    setMove(new StandardMovable());
		setFly(new UnFlyable());
		setJump(new UnJumpable());
		setFall(new StandardFallable());
		setCollision(new ObstacleCollisionable(this));
		setType(Spawn.IS_OBSTACLE);
		//setKill(new StandardKillable());
		xVel = 0;
		yVel = 0;
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		spriteName = s;
	}
	
	public int draw(Graphics g)
	{
		return 0;
	}

}