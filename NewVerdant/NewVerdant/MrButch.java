/**
 * Write a description of class MrButchPlayerFactory here.
 * 
 * @author Migs
 * @version April 25, 2016
 */
import java.awt.*;
public class MrButch extends Player
{
    private boolean firePlus = true;
    private boolean transFormed = false;
    private boolean forward = true;
   
    public MrButch(float x, float y)
    {
        pro = new MagicFactory(null);
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
        width = 75;
        height = 85;
        moveSpeed[0] = 1.85f; jumpSpeed[1] = 11;
        spriteName = "Images\\pudge.png";
    }

    @Override
    public int fire(double angle)
    {
        if(hP <= (100/2)&&firePlus&&!transFormed)
        {
            firePlus=false;
            pro.projectileVel *= 1.5;
            pro.fireRate /= 1.5;
            moveSpeed[0] = 3f; jumpSpeed[1] = 5f;
        }

        //pro.createProjectile(xPos, yPos);
        //if(prevXPos<=xPos)
        if(forward)
        {
            pro.shoot(xPos+35, yPos, forward);
        }
        else 
        {
            pro.shoot(xPos-45, yPos, forward);
        }
        //else
            //pro.shoot(xPos-20, yPos, 0);
        return 0;
    }

    public int draw(Graphics g)
    {
        return 0;
    }

    public int action4(){
        if(!transFormed)
            fire(0);
        return 0;
    }

    public int moveHook(){
        if(hP<21){
            ultimate();
        }
        return 0;
    }

    public int ultimate()
    {      
        spriteName = "Images\\ramsay.jpg";
        transFormed = true;
        return 0;
    }
    
    public int dirFir (int something)
    {
        if(something%5 == 0) 
        {
            forward = false;
        }
        if(something%3 == 0) forward = true;
        return 0;
    }

}