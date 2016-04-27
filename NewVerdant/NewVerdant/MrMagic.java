import java.awt.*;
public class MrMagic extends Player
{
    private boolean firePlus = true;
    private boolean transFormed = false;
    private boolean forward = true;
    private boolean fire = false;
    public MrMagic(String s, float x, float y, float w, float h)
    {
        //pro = new Projectile(0, 0, 0, 0, "");
        setMove(new StandardMovable());
        setFly(new UnFlyable());
        setJump(new StandardJumpable());
        setFall(new SlowFallable());
        setCollision(new PlayerCollisionable(this));
        setType(Spawn.IS_PLAYER);
        //setKill(new StandardKillable());
        xVel = 0;
        yVel = 0;
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        moveSpeed[0] = 1.5f; jumpSpeed[1] = 20;
        spriteName = s;
    }

    public MrMagic(float x, float y)
    {
        pro = new MagicFactory(null);
        setMove(new StandardMovable());
        setFly(new UnFlyable());
        setJump(new StandardJumpable());
        setFall(new SlowFallable());
        setCollision(new PlayerCollisionable(this));
        setType(Spawn.IS_PLAYER);
        //setKill(new StandardKillable());
        xVel = 0;
        yVel = 0;
        xPos = x;
        yPos = y;
        width = 30;
        height = 60;
        moveSpeed[0] = 1.85f; jumpSpeed[1] = 7;
        spriteName = "Images\\MrMagic.png";
    }

    @Override
    public int fire(double angle)
    {
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
    
    public int fireHook(){
        if(fire)
            fire(0);
        fire = false;
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
        if(hP <= (100/2)&&firePlus&&!transFormed)
        {
            firePlus=false;
            pro.projectileVel *= 1.5;
            pro.fireRate /= 1.5;
            moveSpeed[0] = 3f; jumpSpeed[1] = 5f;
        }
        if(hP<21){
            ultimate();
        }
        return 0;
    }

    public int ultimate()
    {
        setFall(new StandardFallable());
        setCollision(new UltimateSharkCollisionable(this));
        spriteName = "Images\\MrShark.png";
        jumpSpeed[1] = 9;
        moveSpeed[0] = 4.25f;
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