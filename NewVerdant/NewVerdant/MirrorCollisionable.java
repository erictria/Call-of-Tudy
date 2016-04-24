/**
 * For mirrors
 * 
 * @author Vincent Haron C. Mamutuk
 * @version Version 1.0 April 24, 2016
 */
public class MirrorCollisionable implements Collisionable
{
    public float[] collision(Spawn x, float[] location){
        if(x.getType() == Spawn.IS_PROJECTILE)
        {
            float[] speed = x.getSpeed();
            float xVal = speed[0];
            float yVal = speed[1];
            double radius = Math.sqrt(xVal*xVal+yVal*yVal);
            double radians = Math.asin(yVal/radius);
            if(xVal<0){
                radians=Math.toRadians(180)-radians;
            }
            double degrees = Math.toDegrees(radians);
            float rotationDegrees = location[5];
            degrees%=360;
            rotationDegrees%=360;
            if(Math.abs(degrees-rotationDegrees)<90){
                rotationDegrees+=180;
            }
            double newDegrees = degrees+180;
            newDegrees-=2*(degrees-rotationDegrees);
            speed[4] = (float)newDegrees;
            speed[0] = (float)(radius*Math.cos(Math.toRadians(newDegrees)));
            speed[1] = (float)(radius*Math.sin(Math.toRadians(newDegrees)));
            return speed;
        }
        return null;
    }
}
