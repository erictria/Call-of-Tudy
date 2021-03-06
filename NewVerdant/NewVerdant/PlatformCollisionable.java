/**
 * For platforms;
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version Version 1.1 April 13, 2016
 * VHCM 1.1 - Added dropping of speed when colliding with platform from underneath.
 */
public class PlatformCollisionable implements Collisionable
{
    public float[] collision(Spawn x, float[] location){
        if(x.getType()==Spawn.IS_PLAYER||x.getType()==Spawn.IS_OBSTACLE){
            float[] prev = x.getPrevCor();
            float[] speed = x.getSpeed();
            float[] loc = x.getLocation();
            //System.out.println(speed[0]+" "+speed[1]+" "+speed[2]+" "+speed[3]
                //+" "+speed[4]+" "+speed[5]);
            if(loc[0]+loc[2]<location[0]+4.5f){
                speed[2] = location[0]-loc[2];
            }
            else if(loc[0]>location[0]+location[2]-4.5f){
                speed[2] = location[0]+location[2];
            }
            else if(prev[1]<location[1]){
                speed[3] = Spawn.clampZero(1000,location[1] - loc[3]);
                speed[1] = 0;
                x.ground();
            }
            else{
                if(speed[1]<0)
                    speed[1] = speed[1] / -4;
                System.out.println(speed[1]);
                speed[3] = Spawn.clampZero(1000,location[1] + location[3]);
            }
            float[] strike = {speed[0],speed[1],speed[2],speed[3],speed[4],speed[5],0};
            return strike;
        }
        return null;
    }
}