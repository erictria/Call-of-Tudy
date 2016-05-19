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
    private ProjectileFactory projFacts[];
    private float degrees = 0;
    private boolean fire = false;
   
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
        projFacts = new ProjectileFactory[2];
    }
    
    private void shoot(){
        float xCenter = xPos+width/2;
        float yCenter = yPos+height/2;
        //System.out.println(xCenter);
        xCenter+=Spawn.clamp(width/2+25 + xVel,-width/2-30-xVel,(float)(Math.cos(Math.toRadians(degrees))*(100)));
        //System.out.println(xCenter);
        yCenter-=Spawn.clamp(height/2+25 + 5,-height/2-25 - 5,(float)(Math.sin(Math.toRadians(degrees))*(100)));
        //System.out.println(xCenter);
        //System.out.println(yCenter);
        pro.shoot(xCenter-10,yCenter-10,degrees);
    }

    @Override
    public int fire(double angle)
    {
        if(transFormed){
            degrees-=14;
            degrees%=360;
            shoot();
        }
        else if(forward)
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
            fire = true;
        return 0;
    }

    public int moveHook(){
        if(hP<21){
            ultimate();
        }
        return 0;
    }
    
    public void setProjFacts(ProjectileFactory[] pj){
        projFacts[0] = pj[0];
        projFacts[1] = pj[1];
        //System.out.println("Got You!!!");
    }

    public int ultimate()
    {      
        spriteName = "Images\\ramsay.jpg";
        
        //Map m = pro.getMap();
        //m.iterateSpawns();
        //pro = new SuperMeatballFactory(m);
        pro = projFacts[1];
        transFormed = true;
        return 0;
    }
    
    public int fireHook(){
        if(transFormed)
            fire = true;
        if(fire)
            fire(0);
        fire = false;
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