import java.awt.*;

/*
 ** @author: Migs
 ** Date: April 21, 2016
 ** Version: 1.0
 **
 **
 ** 
 */ 
public class Hamburger extends Powerup
{
	int healAmt = 25;
	public Hamburger(String s, float x, float y, float w, float h)
	{
		super(s, x, y, w, h);
	}
	
	public Player upgradePlayer(Player player)
	{
		player.hp = player.hp + healAmt;
		return player;
	}
	
	public int draw(Graphics g)
	{
		return 0;
	}
	
}