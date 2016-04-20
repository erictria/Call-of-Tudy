/**
 * For Walls;
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version Version 1.0 April 20, 2016
 */
public class WallCollisionable implements Collisionable
{
    public float[] collision(Spawn x, float[] location){
        if(x.getType()==Spawn.IS_PLAYER||x.getType()==Spawn.IS_OBSTACLE){
            float[] prev = x.getPrevCor();
            float[] speed = x.getSpeed();
            float[] loc = x.getLocation();
            //System.out.println(speed[0]+" "+speed[1]+" "+speed[2]+" "+speed[3]
                //+" "+speed[4]+" "+speed[5]);
            if(loc[0]+loc[2]<location[0]+10f){
                speed[2] = location[0]-loc[2] + location[7];
            }
            else if(loc[0]>location[0]+location[2]-10f){
                speed[2] = location[0]+location[2] + location[7];
            }
            else if(prev[1]<location[1]){
                speed[3] = Spawn.clampZero(1000,location[1] - loc[3]);
                speed[2] += location[6]*2;
                //System.out.println(speed[3]);
                speed[1] = 0;
                x.ground();
            }
            else{
                if(speed[1]<0)
                    speed[1] = speed[1] / -4;
                //System.out.println(speed[1]);
                speed[3] = Spawn.clampZero(1000,location[1] + location[3]);
                //System.out.println(speed[3]);
            }
            float[] strike = {speed[0],speed[1],speed[2],speed[3],speed[4],speed[5],0};
            return strike;
        }
        return null;
    }
}