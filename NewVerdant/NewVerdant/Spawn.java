
/**
 * Everything that appears on screen is a spawn.
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.6 April 13, 2016
 * Changelog
 * VHCM 1.6 - Changed Collision to an actual implementation. Ask me how it works.
 *          - Added rotationSpeed
 * VHCM 1.5 - Added prevXPos and prevYPos.
 *          - Added getLocationPlusSprite.
 *          - Added rotationDegrees
 *          - Added setXandYSpeed methods
 * VHCM 1.4 - Added Gravity and TerminalVelocity to fall method
 *          - Changed everything to work with and output speed.
 *          - Changed jump to decrement onGround if jumped.
 * VHCM 1.3 - Changed xPos to yVel to floats
 *          - Added setDead and isDead methods
 * VHCM 1.2 - Added kill and sprite methods along with hooks for them. 
 *          - Added static Method for checking Collision.
 * VHCM 1.1 - Added collision, fly and fall methods. 
 *          - Still need to figure out how to implement kill.
 */
public abstract class Spawn
{
    // xPos = X-Coordinate. yPos = Y-Coordinate 
    protected float xPos, yPos, width, height, prevXPos, prevYPos;
    // xVel = X Velocity. yVel = yVelocity
    protected float xVel, yVel, rotationDegrees, rotationSpeed;
    //dictates how an object collides with another
    protected Collisionable collisionable;
    //dictates how an object jumps
    protected Jumpable jumpable;
    //dictates how and in what directions an object can moves
    protected Movable movable;
    //dictates how an object can maybe fly. Default can't
    protected Flyable flyable;
    //dictates how an object is affected by gravity.
    protected Fallable fallable;
    //dictates how an object reacts to death
    protected Killable killable;
    //boolean variables
    protected boolean hasSpawned, isAlive = true;
    //
    protected String spriteName = "Box.jpg";
    
    public float flySpeed[], jumpSpeed[];
    //shows the type. Will be explored more in the future.
    protected int type, onGround = 0;
    public final static int IS_ON_GROUND = 1;
    public final static int IS_PLATFORM = 1;
    public final static int IS_WALL = 2;
    public final static int IS_OBSTACLE = 3;
    public final static int IS_PLAYER = 4;
    public final static int IS_PROJECTILE = 5;
    public final static int IS_POWERUP = 6;

    public int jump(int jumpFactor){
        float[] x = jumpable.jump(getSpeed(),jumpFactor,onGround,jumpSpeed);
        if(Math.abs(yPos-x[3])<0.00001||Math.abs(yVel-x[1])<0.00001){
            onGround--;
        }
        xVel = x[0];
        yVel = x[1];
        xPos = x[2];
        yPos = x[3];
        rotationDegrees = x[4];
        rotationSpeed = x[5];
        rotationDegrees %= 360;
        return 0;
    }
    
    /*
     * return Values
     * 0 No Collision
     * -1 Object is the same
     * 1 Collision is true
     * Haven't tested yet. Please Test.
     */ 
    public static int checkCollisionWithSpawn(float[] cor,float[] res){
        if(res[0]==cor[0]&&res[1]==cor[1]&&res[2]==cor[2]&&cor[3]==res[3]&&cor[4]==res[4])
            return -1;
        if(res[0]+res[2]>cor[0]&&res[0]<cor[0]+cor[2]&&res[1]+res[3]>cor[1]&&res[1]<cor[1]+cor[3])
            return 1;
        return 0;
    }

    public int move(int moveFactor){
        float[] x = movable.move(moveFactor,getSpeed());
        prevXPos = xPos; prevYPos = yPos;
        xVel = x[0];
        yVel = x[1];
        xPos = x[2];
        yPos = x[3];
        rotationDegrees = x[4];
        rotationSpeed = x[5];
        if(onGround==IS_ON_GROUND)
            onGround=IS_ON_GROUND-1;
        return 0;
    }

    public int fly(int flyFactor){
        float[] x = flyable.fly(getSpeed(),flyFactor,onGround,flySpeed);
        xVel = x[0];
        yVel = x[1];
        xPos = x[2];
        yPos = x[3];
        rotationDegrees = x[4];
        rotationSpeed = x[5];
        return 0;
    }

    public int fall(float gravity, float terminalVelocity){
        float[] x = fallable.fall(getSpeed(),onGround, gravity, terminalVelocity);
        xVel = x[0];
        yVel = x[1];
        xPos = x[2];
        yPos = x[3];
        rotationDegrees = x[4];
        rotationSpeed = x[5];
        return 0;
    }

    public float[] collisionActive(Spawn y){
        float[] x = collisionable.collision(y,getLocation());
        return x;
        /*xPos = x[0];
        yPos = x[1];
        killable.kill(x[2]);
        //isAlive = (int) x[2];
        return 0;*/
    }
    
    public int collisionPassive(float[] collisionResult){
        if(collisionResult==null)
            return 0;
        xVel = collisionResult[0];
        yVel = collisionResult[1];
        xPos = collisionResult[2];
        yPos = collisionResult[3];
        rotationDegrees = collisionResult[4];
        rotationSpeed = collisionResult[5];
        kill(collisionResult[6]);
        return 0;
    }

    public int kill(float killFactor){
        /*
         * Will uncomment when kill is fully implemented. Right now, can't be asked - VHCM
         */
        //float[] x = killable.kill(killFactor);
        killHook(killFactor);
        return 0;
    }

    //override to create specific kill behavior.
    public int killHook(float killFactor){
        //override
        return 0;
    }

    /*
     * gets the speed of the current object in an array of ints
     * Index    Corresponds to
     *   0         xVel
     *   1         yVel
     *   2         xPos
     *   3         yPos
     */
    public float[] getSpeed(){
        float[] x = new float[6];
        x[0] = xVel;
        x[1] = yVel;
        x[2] = xPos;
        x[3] = yPos;
        x[4] = rotationDegrees;
        x[5] = rotationSpeed;
        return x;
    }
    
    public int setLocation(float x, float y, float w, float h){
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        return 0;
    }

    /*
     * gets the location of the current object in an array of ints
     * Index    Corresponds to
     *   0         xPos
     *   1         yPos
     *   2         width
     *   3         height
     *   4         type
     */
    public float[] getLocation(){
        float[] x = new float[6];
        x[0] = xPos;
        x[1] = yPos;
        x[2] = width;
        x[3] = height;
        x[4] = type;
        x[5] = rotationDegrees;
        return x;
    }
    
    public int getType(){
        return type;
    }
    
    public int setSprite(){
        spriteName = "Images\\Box.jpg";
        setSpriteHook();
        return 0;
    }
    
    public String getSprite(){
        setSpriteHook();
        return spriteName;
    }
    
    //override to create specific sprite behavior.
    public int setSpriteHook(){
        //override
        return 0;
    }
    
    public void setXSpeed(float x){
        xVel=x;
    }
    
    public void setYSpeed(float x){
        yVel=x;
    }
    
    public void addXSpeed(float x){
        xVel+=x;
    }
    
    public void addYSpeed(float x){
        yVel+=x;
    }
    
    public void setRotSpeed(float x){
        rotationDegrees=x;
    }
    
    public void addRotSpeed(float x){
        rotationSpeed+=x;
    }
    
    public String[] getLocationPlusSprite(){
        String[] x = new String[6];
        x[0]=xPos+"";
        x[1]=yPos+"";
        x[2]=width+"";
        x[3]=height+"";
        x[4]=spriteName;
        x[5]=rotationDegrees+"";
        return x;
    }
    
    /*public float getXPos(){
        return xPos;
    }
    
    public float getYPos(){
        return yPos;
    }
    
    /*public float getX(){
        return xPos;
    }*/
    
    public int setDead(){
        isAlive = false;
        return 0;
    }
    
    public float[] getPrevCor(){
        float[] x = new float[2];
        x[0] = prevXPos;
        x[1] = prevYPos;
        return x;
    }
    
    protected int setType(int x){
        type = x;
        return 0;
    }
    
    public boolean isDead(){
        return !isAlive;
    }
    
    public int isOnGround(){
        return onGround;
    }
    
    public int ground(){
        onGround = IS_ON_GROUND;
        return 0;
    }
    
    public static float clampZero(float max, float clamped){
        if(clamped<0){
            return 0;
        }
        if(clamped>max){
            return max;
        }
        return clamped;
    }
}
