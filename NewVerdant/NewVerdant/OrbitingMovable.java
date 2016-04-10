
/**
 * For objects that rotate at a given speed and revolve around a certain point at a certain speed
 * 
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version Version 1.0 April 9, 2016
 */
public class OrbitingMovable implements Movable
{
    float rotatingFactor = 1;
    float orbitingFactor = 1;
    Spawn x;
    float prevX, prevY; 
    public OrbitingMovable(float z, float w, Spawn x){
        rotatingFactor = z;
        orbitingFactor = w;
        this.x = x;
        float[] center = x.getSpeed();
        prevX = center[2];
        prevY = center[3];
    }
    public float[] move(int moveFactor, float[] speed){
        //speed[0] = 1;
        //speed[1] = 1;
        //xPos += speed[0];
        //yPos += speed[1];
        speed[2] += speed[0];
        speed[3] += speed[1];
        float[] center = x.getSpeed();
        
        if(prevX!= center[2]){
            //System.out.println(center[2]+" " + center[3]);
        }
        prevX -= center[2];
        prevY -= center[3];
        speed[2] -= prevX;
        speed[3] -= prevY;
        double xVal = speed[2] - center[2];
        double yVal = speed[3] - center[3];
        //System.out.println(Math.abs(xVal*xVal));
        //System.out.println(Math.abs(yVal*yVal));
        double radius = Math.sqrt(Math.abs(xVal*xVal)+Math.abs(yVal*yVal));
        if(Double.isNaN(xVal)){
            System.out.println(xVal);
        }
        //System.out.println(radius);
        double radians = Math.asin(yVal/radius);
        if(xVal<0){
            radians=Math.toRadians(180)-radians;
        }
        radians += Math.toRadians(orbitingFactor);
        float xValue = center[2]+(float)((float)radius*(float)Math.cos(radians));
        float yValue = center[3]+(float)((float)radius*(float)Math.sin(radians));
        speed[2] = xValue;
        speed[3] = yValue;
        speed[4] += rotatingFactor;
        prevX = center[2];
        prevY = center[3];
        return speed;
    }
}
