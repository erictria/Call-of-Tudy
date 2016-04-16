
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
    Spawn node;
    //float prevX, prevY; 
    public OrbitingMovable2(float x, float y, float w, Spawn node){
        //rotatingFactor = z;
        orbitingFactor = w;
        float[] center = node.getSpeed();
        double xVal = x-center[2];
        double yVal = y-center[3];
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
    public float[] move(int moveFactor, float[] speed){
        float[] center = node.getSpeed();
        
        double xVal = speed[2] - center[2];
        double yVal = speed[3] - center[3];
        //System.out.println(Math.abs(xVal*xVal));
        //System.out.println(Math.abs(yVal*yVal));
        //double radius = Math.sqrt(Math.abs(xVal*xVal)+Math.abs(yVal*yVal));
        if(Double.isNaN(xVal)){
            System.out.println(xVal);
        }
        //System.out.println(radius);
        /*double radians = Math.asin(yVal/radius);
        if(xVal<0){
            radians=Math.toRadians(180)-radians;
        }*/
        radians += Math.toRadians(orbitingFactor);
        float xValue = center[2]+(float)((float)radius*speed[0]*(float)Math.cos(radians));
        float yValue = center[3]+(float)((float)radius*speed[1]*(float)Math.sin(radians));
        speed[2] = xValue;
        speed[3] = yValue;
        speed[4] += speed[5];
        /*prevX = center[2];
        prevY = center[3];*/
        return speed;
    }
}
