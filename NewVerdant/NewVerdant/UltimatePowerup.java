import java.awt.*;


/*
 ** @author: Migs
 ** Date: April 21, 2016
 ** Version: 1.0
 **
 **
 ** 
 */ 
public class UltimatePowerup extends Powerup
{
	
	public UltimatePowerup(String s, float x, float y, float w, float h)
	{
		super(s, x, y, w, h);
	}
	
	public Player upgradePlayer(Player player)
	{
		player.hp = player.hp + 15;
		player.ultimate();
		return player;

	}
	
	public int draw(Graphics g)
	{
		return 0;
	}
	

}