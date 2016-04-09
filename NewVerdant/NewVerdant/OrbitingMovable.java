
/**
 * For objects that rotate at a given speed and revolve around a certain point at a certain speed
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version Version 1.0 April 9, 2016
 */
public class OrbitingMovable implements Movable
{
    float rotatingFactor = 1;
    float orbitingFactor = 1;
    float xPos = 1;
    float yPos = 1;
    public OrbitingMovable(float z, float w, float x, float y){
        rotatingFactor = z;
        orbitingFactor = w;
        xPos = x;
        yPos = y;
    }
    public float[] move(int moveFactor, float[] speed){
        //speed[0] = 1;
        //speed[1] = 1;
        xPos += speed[0];
        yPos += speed[1];
        speed[2] += speed[0];
        speed[3] += speed[1];
        float xVal = speed[2] - xPos;
        float yVal = speed[3] - yPos;
        double radius = Math.sqrt(xVal*xVal+yVal*yVal);
        double radians = Math.asin(yVal/radius);
        if(xVal<0){
            radians=Math.toRadians(180)-radians;
        }
        radians += Math.toRadians(orbitingFactor);
        speed[2] = (float)(xPos+radius*Math.cos(radians));
        speed[3] = (float)(yPos+radius*Math.sin(radians));
        speed[4] += rotatingFactor;
        return speed;
    }
}
