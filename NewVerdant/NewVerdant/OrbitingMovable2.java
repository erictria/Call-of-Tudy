
/**
 * For objects that rotate at a given speed and revolve around a certain point at a certain speed
 * Refactored version of OrbitingMovable but this time stuck in orbit
 * 
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version Version 1.0 April 9, 2016
 */
public class OrbitingMovable2 implements Movable
{
    //float rotatingFactor = 1;
    float orbitingFactor = 1;
    double radius, radians;
    float width, height;
    Spawn node;
    //float prevX, prevY; 
    public OrbitingMovable2(float x, float y, float w, float h, float r, Spawn node){
        //rotatingFactor = z;
        orbitingFactor = r;
        float[] center = node.getLocation();
        width = w/2; height = h/2;
        double xVal = x+w/2-center[0]-center[2]/2;
        //System.out.println(center[0]+center[2]/2);
        //System.out.println(xVal);
        double yVal = y+h/2-center[1]-center[3]/2;
        //System.out.println(center[1]+center[3]/2);
        //System.out.println(yVal);
        //System.out.println(xVal+" "+yVal);
        radius = Math.sqrt(Math.abs(xVal*xVal)+Math.abs(yVal*yVal));
        this.node = node;
        radians = Math.asin(yVal/radius);
        if(xVal<0){
            radians=Math.toRadians(180)-radians;
        }
        //node.setXSpeed(1);
        //node.setYSpeed(1);
        //prevX = center[2];
        //prevY = center[3];
    }
    //xVel and yVel take different meanings, they are now the radius scaling factors.
    public float[] move(int moveFactor, float[] speed, float[] moveSpeed){
        float[] center = node.getLocation();
        
        /*double xVal = speed[2] + speed[6]/2 - center[0]-center[2]/2;
        double yVal = speed[3] + speed[7]/2 - center[1]-center[3]/2;*/
        //System.out.println(Math.abs(xVal*xVal));
        //System.out.println(Math.abs(yVal*yVal));
        //double radius = Math.sqrt(Math.abs(xVal*xVal)+Math.abs(yVal*yVal));
        /*if(Double.isNaN(xVal)){
            System.out.println(xVal);
        }
        //System.out.println(radius);
        /*double radians = Math.asin(yVal/radius);
        if(xVal<0){
            radians=Math.toRadians(180)-radians;
        }*/
        radians += Math.toRadians(speed[5]);
        float xValue = center[0]+center[2]/2+(float)((float)radius*speed[0]*(float)Math.cos(radians))-width;
        float yValue = center[1]+center[3]/2+(float)((float)radius*speed[1]*(float)Math.sin(radians))-height;
        speed[2] = xValue;
        speed[3] = yValue;
        speed[4] += speed[5];
        /*prevX = center[2];
        prevY = center[3];*/
        return speed;
    }
}
