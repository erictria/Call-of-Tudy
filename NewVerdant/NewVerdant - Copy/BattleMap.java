
/**
 * Map for battles
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BattleMap extends Map
{
    public int finish(){
        if(players.size()<2)
            slowDownTime = 3;
        return 0;
    }
}
