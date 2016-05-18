/*
 ** @author: Migs
 ** Date: April 21, 2016
 ** Version: 1.0
 **
 **
 ** 
 */ 
public class PowerupFactory
{
	private static final String HAMBURGER_IMG = "Images\\burger.png";
	private static final String ULTIMATE_IMG = "Images\\star.png";
	private static final String HEMLOCK_IMG = "Images\\hemlock.png";
	//constructor
	public PowerupFactory()
	{
		
	}
	
	//factory method
	public Powerup createPowerup( String powerupType, float x, float y, float w, float h )
	{
		if ( powerupType.equals("Hamburger") )
		{
			Powerup hamburger = new Hamburger(HAMBURGER_IMG, x, y, w, h);
			return hamburger;
		}
		else if (powerupType.equals("Ultimate"))
		{
			Powerup ultimatePowerup = new UltimatePowerup(ULTIMATE_IMG, x, y, w, h);	
			return ultimatePowerup;
		}
		else if (powerupType.equals("Hemlock"))
		{
			Powerup hemlock = new Hemlock(HEMLOCK_IMG, x, y, w, h);
			return hemlock;
		}
		return null;
	}
	
	
	
}