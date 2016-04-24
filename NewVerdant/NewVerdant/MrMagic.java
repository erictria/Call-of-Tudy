import java.awt.*;
public class MrMagic extends Player
{
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
        moveSpeed[0] = 2.5f; jumpSpeed[1] = 25;
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
        moveSpeed[0] = 2.5f; jumpSpeed[1] = 15;
        spriteName = "Images\\MrMagic.png";
    }
    
    @Override
    public int fire(double angle)
    {
        if(hp <= (ogHp/2))
        {
            pro.projectileVel *= 2;
            pro.fireRate /= 2;
        }
        
        pro.createProjectile(xPos, yPos);
        pro.shoot(xPos+60, yPos);
        return 0;
    }
    
    public int draw(Graphics g)
    {
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
        setFall(new StandardFallable());
        setCollision(new UltimateSharkCollisionable(this));
        spriteName = "Images\\MrShark.png";
        jumpSpeed[1] = 9;
        moveSpeed[0] = 4.25f;
        return 0;
    }

}