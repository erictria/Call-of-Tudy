
/**
 * Write a description of class Mirror here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mirror extends Spawn
{
    private boolean daddyMirror = false;
    public static final float MIRROR_SPEED = 1.25f;
    public static final int ACTIVATE_LENGTH_FRAMES = 420;
    public static final int ACTIVATE_COOLDOWN = 840;
    public static final float MAX_RAD = 3.5f;
    private static Collisionable[] stack = new Collisionable[2];
    private String state = "", number = "";
    //private int cd = ACTIVATE_COOLDOWN;
    private int active = ACTIVATE_COOLDOWN;
    private Mirror[] mirrorPieces = new Mirror[4]; 
    public Mirror(float x, float y, float w, float h, float r, ReD s, Map m){
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        rotationDegrees = r;
        rotationSpeed = MIRROR_SPEED;
        setType(Spawn.IS_MIRROR);
        movable = new OrbitingMovable2(x,y,w,h,MIRROR_SPEED,s);
        fallable = new UnFallable();
        flyable = new UnFlyable();
        jumpable = new UnJumpable();
        jumpable = new UnJumpable();
        setXSpeed(MIRROR_SPEED);
        setYSpeed(MIRROR_SPEED);
        //System.out.println(r);
        double radians = Math.toRadians(r);
        //System.out.println((Math.cos(radians)*w*0.6)+" "+(Math.sin(radians)*w*0.6));
        /*mirrorPieces[0] = new Mirror((float)(Math.cos(radians)*w*0.6),
        (float)(Math.sin(radians)*w*0.6),w,h,r,this);
        mirrorPieces[1] = new Mirror((float)(Math.cos(radians)*w*1.2),
        (float)(Math.sin(radians)*w*1.2),w,h,r,this);
        radians = Math.toRadians(r+180);
        System.out.println((Math.cos(radians)*w*0.6)+" "+(Math.sin(radians)*w*0.6));
        mirrorPieces[2] = new Mirror((float)(Math.cos(radians)*w*0.6),
        (float)(Math.sin(radians)*w*0.6),w,h,r+180,this);
        mirrorPieces[3] = new Mirror(w*1.2,
        (float)(Math.sin(radians)*w*1.2),w,h,r,this);*/
        //System.out.println(r);
        mirrorPieces[0] = new Mirror(w*0.6f,0,w,h,90,this);
        mirrorPieces[1] = new Mirror(w*1.2f,0,w,h,90,this);
        mirrorPieces[2] = new Mirror(w*0.6f,0,w,h,270,this);
        mirrorPieces[3] = new Mirror(w*1.2f,0,w,h,270,this);
        m.addSpawn(this);
        m.addSpawn(mirrorPieces[1]);
        m.addSpawn(mirrorPieces[0]);
        m.addSpawn(mirrorPieces[2]);
        m.addSpawn(mirrorPieces[3]);
        //m.addSpawn(this);
        daddyMirror = true;
        collisionable = new UnCollisionable();
        stack[0] = new UnCollisionable();
        stack[1] = new MirrorCollisionable();
    }

    public Mirror(float x, float y, float w, float h, float r, Spawn s){
        setType(Spawn.IS_MIRROR);
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        movable = new ShadowMovable(x,y,r,s);
        fallable = new UnFallable();
        flyable = new UnFlyable();
        jumpable = new UnJumpable();
        collisionable = new UnCollisionable();
    }

    public int activate(){
        if(active==ACTIVATE_COOLDOWN){
            if(daddyMirror){
                for(Mirror e: mirrorPieces){
                    e.activate();
                }
            }
            collisionable = stack[1];
            active = 0;
        }
        return 0;
    }

    public int activated(){
        return 0;
    }

    public int setSpriteHook(){
        if(active<ACTIVATE_LENGTH_FRAMES){
            state = "";
            if(xVel<MAX_RAD){
                addXSpeed(0.05f);
                addYSpeed(0.05f);
            }
        }
        else{
            if(active==ACTIVATE_COOLDOWN){
                state = "_Ready";
            }
            else{
                state = "_Inactive";
            }
            collisionable = stack[0];
            if(xVel>1){
                addXSpeed(-0.05f);
                addYSpeed(-0.05f);
            }
        }
        if(active<ACTIVATE_COOLDOWN){
            active++;
        }
        spriteName = "Images\\MirrorSample" + state + number + ".png";
        //spriteName = "Images\\TestPinkishBox.jpg";
        return 0;
    }

    public int setNumber(int number){
        if(daddyMirror){
            for(Mirror e: mirrorPieces){
                e.setNumber(number);
            }
        }
        if(number==0){
            this.number = "";
            return 0;
        }
        this.number = number+"";
        return 0;
    }

    public int deathHook(){
        for(Mirror e: mirrorPieces)
            e.setDead();
        return 0;
    }
}
