
/**
 * PlayerHUDs
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.0 May 16, 2016
 */
import java.awt.*;
public class PlayerHUD
{
    protected float xPos, yPos, maxHP;
    protected int currentLives, startingLives, playerNumber;
    protected HPBar hpOuter;
    protected HPBar hpInner;
    private final float width = 150;
    protected PlayerLives[] playerLife;
    public PlayerHUD(int startingLives, int playerNumber, float maxHP, String characterSprite){
        yPos = 5;
        xPos = 5 + (playerNumber-1)*250;
        hpOuter = new HPBar(xPos, yPos, width - 1, 19, playerNumber, true);
        hpInner = new HPBar(xPos+3, yPos+3, width - 7, 14, playerNumber, false);
        playerLife = new PlayerLives[startingLives];
        currentLives = this.startingLives = startingLives;
        this.maxHP = maxHP;
        this.playerNumber = playerNumber;
        for(int i = 0; i!=startingLives; i++){
            playerLife[i] = new PlayerLives(xPos+i*25, yPos+25, characterSprite);
        }
    }
    
    public Spawn[] myNodes(){
        int j = currentLives;
        if(j>=6){
            j = 6;
        }
        if(j<=0){
            j = 0;
        }
        Spawn[] temp = new Spawn[2+j];
        temp[0] = hpOuter;
        temp[1] = hpInner;
        for(int i = 0; i<j; i++){
            temp[i+2] = playerLife[i];
        }
        return temp;
    }
    
    public int getNumber(){
        return playerNumber;
    }
    
    public void setLives(int currentLives){
        this.currentLives = currentLives+1;
    }
    
    public void setHP(float x){
        double temp = x/maxHP;
        if(temp>1)
            temp = 1;
        if(temp<0)
            temp = 0;
        hpInner.setWidth((float)((width-7)*temp));
        //System.out.println((float)((width-7)*temp));
    }
}
