
/**
 * PlayerHUDs
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.0 May 16, 2016
 */
public class PlayerHUD
{
    protected int xPos, yPos;
    protected int maxHP, currentLives, startingLives;
    protected HPBar hpOuter;
    protected HPBar hpInner;
    //protected PlayerLife[] playerLife;
    public PlayerHUD(int startingLives, int playerNumber, float maxHP, String characterSprite){
        yPos = 5;
        xPos = 5 + (playerNumber-1)*250;
        //hpOuter = new HPBar(xPos, yPos, 200, 20, playerNumber, true);
        //hpInner = new HPBar(xPos+2.5, yPos+2.5, 195, 15, playerNumber, false);
        //playerLife = new PlayerLife[startingLives];
        currentLives = this.startingLives = startingLives;
        for(int i = 0; i!=startingLives; i++){
            //playerLife[i] = new PlayerLife(xPos+i*40, yPos+25);
        }
    }
}
