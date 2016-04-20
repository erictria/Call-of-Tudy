/**
 * For obstacles;
 * 
 * @author Migi Ramos
 * @version Version 1.0 April 19, 2016
 */
public class ObstacleCollisionable implements Collisionable
{
    protected Obstacle ob;
    
    public ObstacleCollisionable(Obstacle o)
    {
        ob = o;
    }
    
    public float[] collision(Spawn x, float[] location){
        /*if(x.getType()==Spawn.IS_PLAYER){
            x.setXSpeed(0);
            x.setYSpeed(0);
        }
        else if(x.getType() == Spawn.IS_PROJECTILE)
        {
            x.setXSpeed(0);
            x.setYSpeed(0);
            //ob.damage(x.getDamage()); // waiting for the actual getter method of the projectile.
        }*/
        
        // copied from platform collisonable since obstacle collision with player is pretty much the same for platform
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
                //System.out.println(speed[1]);
                speed[3] = Spawn.clampZero(1000,location[1] + location[3]);
            }
            float[] strike = {speed[0],speed[1],speed[2],speed[3],speed[4],speed[5],0};
            return strike;
        }
        
        //Still To Do
        else if(x.getType() == Spawn.IS_PROJECTILE)
        {
            x.setXSpeed(0);
            x.setYSpeed(0);
            //ob.damage(x.getDamage()); // waiting for the actual getter method of the projectile.
        }
        return null;
    }
}
