
/**
 * ReD!!! Starting right now.
 * 
 * @author Vincent Haron C. Mamutuk
 * @version 1.0 April 20, 2016
 */
import java.awt.*;
public class ReD extends Player
{
    private Mirror[] mirrors = new Mirror[4];
    private float direction = 0;
    private float changeDir=45;
    public ReD(float x, float y){
        xPos = x;
        yPos = y;
        width = 30;
        height = 60;
        setMove(new StandardMovable());
        setJump(new GravBootsJumpable());
        setFall(new StandardFallable());
        setCollision(new PlayerCollisionable(this));
        setFly(new UnFlyable());
        setType(Spawn.IS_PLAYER);
        moveSpeed[0] = 2.00f;
        jumpSpeed[1] = 12;
        spriteName = "Images\\TestRed.png";
    }

    public int action1(){
        mirrors[0].activate();
        return 0;
    }

    public int action2(){
        mirrors[1].activate();
        return 0;
    }

    public int action3(){
        mirrors[2].activate();
        return 0;
    }

    public int action4(){
        mirrors[3].activate();
        return 0;
    }

    public int setMirrors(Mirror[] mirrors){
        this.mirrors = mirrors;
        return 0;
    }

    public int setSpriteHook(){
        //pro.shoot(xPos+width, yPos);
        return 0;
    }
    
    private void shoot(){
        float xCenter = xPos+width/2;
        float yCenter = yPos+height/2;
        xCenter+=(Math.cos(Math.toRadians(direction))*(width+10))-10;
        yCenter-=(Math.sin(Math.toRadians(direction))*(height+10))+10;
        pro.shoot(xCenter,yCenter,direction);
    }

    public int moveHook(){
        if(pro!=null)
            shoot();
        return 0;
    }

    public int draw(Graphics g)
    {
        return 0;
    }

    public int ultimate()
    {
        return 0;
    }

    public int dirFir(int directionFactor){
        if(directionFactor!=1){
            float directionTemp1;
            float directionTemp2;
            float idealDirection = 0;
            int divideBy = 0;
            if(directionFactor%2==0){
                idealDirection += 90;
                divideBy++;
            }
            if(directionFactor%3==0){
                idealDirection += 0;
                divideBy++;
            }
            if(directionFactor%5==0){
                idealDirection += 180;
                divideBy++;
            }
            if(directionFactor%7==0){
                idealDirection += 270;
                divideBy++;
            }
            idealDirection/=divideBy;
            directionTemp1 = direction+changeDir;
            directionTemp2 = direction-changeDir;
            directionTemp1%=360;
            directionTemp2%=360;
            direction%=360;
            if(Math.abs(direction-idealDirection)>Math.abs(directionTemp1-idealDirection)){
                direction = directionTemp1;
            }
            if(Math.abs(direction-idealDirection)>Math.abs(directionTemp2-idealDirection)){
                direction = directionTemp2;
            }
            System.out.println(direction);
            return 0;
        }
        return 0;
    }

    public int deathHook(){
        pro = null;
        for(Mirror e: mirrors)
            e.kill(-1);
        return 0;
    }
}
