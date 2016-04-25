import java.awt.*;
public class Hemlock extends Powerup
{
	int damgAmt = 100;
	public Hemlock(String s, float x, float y, float w, float h)
	{
		super(s, x, y, w, h);
	}
	
	public Player upgradePlayer(Player player)
	{
		player.hp = player.hp - damgAmt;
		player.kill(100);
		return player;
	}
	
	public int draw(Graphics g)
	{
		return 0;
	}
	
}