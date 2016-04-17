
/**
 * Objects that simply shadow other objects/are extensions of other objects.
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.0 April 9, 2016
 */
public class ShadowMovable implements Movable
{
    float xPos, yPos;
    double startingDegrees, radius;
    boolean rotate;
    Spawn z;
    public ShadowMovable(float x, float y, Spawn z){
        this.z = z;
        xPos = x;
        yPos = y;
        radius = Math.sqrt(Math.abs(x*x)+Math.abs(y*y));
        double radians = Math.asin(y/radius);
        if(x<0){
            radians=Math.toRadians(180)-radians;
        }
        startingDegrees = radians;
    }
    
    public ShadowMovable(float x, float y, Spawn z, boolean rotate){
        this.z = z;
        xPos = x;
        yPos = y;
        radius = Math.sqrt(Math.abs(x*x)+Math.abs(y*y));
        double radians = Math.asin(y/radius);
        if(x<0){
            radians=Math.toRadians(180)-radians;
        }
        /*if(rotate180){
            radians-=Math.toRadians(180);
            System.out.println(radians);
        }*/
        this.rotate = rotate;
        startingDegrees = radians;
    }
    
    public float[] move(int moveFactor, float[] speed, float[] moveSpeed){
        float center[] = z.getSpeed();
        //center[4];
        double xVal = xPos;
        //System.out.println(xVal);
        double yVal = yPos;
        //double radius = Math.sqrt(Math.abs(xVal*xVal)+Math.abs(yVal*yVal));
        /*System.out.println(radius);
        double radians = Math.asin(yVal/radius);
        if(xVal<0){
            radians=Math.toRadians(180)-radians;
        }
        radians += Math.toRadians(center[4]);*/
        if(rotate)
            speed[4] = (float)Math.toDegrees(startingDegrees)+center[4];
        else
            speed[4] = center[4];
        float xValue = center[2]+(float)((float)radius*(float)Math.cos(startingDegrees+Math.toRadians(center[4])));
        float yValue = center[3]+(float)((float)radius*(float)Math.sin(startingDegrees+Math.toRadians(center[4])));
        speed[2] = xValue;
        speed[3] = yValue;
        return speed;
    }
}
