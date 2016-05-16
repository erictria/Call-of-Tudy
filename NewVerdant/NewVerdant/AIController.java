
/**
 * Controller for AIs, can be improved
 * 
 * @author Vincent Haron C. Mamutuk 
 * @version 1.0 May 16, 2016
 */
public class AIController extends SpawnController
{
    Player mySpawnE = (Player) mySpawn;
    int movementCounter = 1;
    int aimCounter = 1;
    public AIController(Spawn e){
        super(e);
    }
    public void setSpawn(Spawn e){
        mySpawnE = (Player) e;
    }

    public void listenHook(){
        movementCounter--;
        if(movementCounter<=0){
            movementCounter=175;
            int x = (int)(Math.random()*9);
            if(x%3==0){
                movementCounter/=Math.random()*2+1;
            }
            if(x==0){
                right = false;
                left = false;
            }
            else if(x%2==1){
                right = true;
                left = false;
            }
            else if(x%2==0){
                right = false;
                left = true;
            }
        }
        action4 = true;
        action1 = (int)(Math.random()*20)==19;
        action2 = (int)(Math.random()*20)==19;
        action3 = (int)(Math.random()*20)==19;
        aimCounter--;
        if(aimCounter<=0){
            aimCounter = 76;
            int temp = (int)(Math.random()*8);
            if(temp==0){
                dirUp=true;dirDown=false;dirLeft=false;dirRight=false;
            }else if(temp==1){
                dirUp=false;dirDown=true;dirLeft=false;dirRight=false;
            }else if(temp==2){
                dirUp=false;dirDown=false;dirLeft=true;dirRight=false;
            }else if(temp==3){
                dirUp=false;dirDown=false;dirLeft=false;dirRight=true;
            }else if(temp==4){
                dirUp=true;dirDown=false;dirLeft=true;dirRight=false;
            }else if(temp==5){
                dirUp=true;dirDown=false;dirLeft=false;dirRight=true;
            }else if(temp==6){
                dirUp=false;dirDown=true;dirLeft=false;dirRight=true;
            }else if(temp==7){
                dirUp=true;dirDown=true;dirLeft=true;dirRight=false;
            }
        }
        down = (int)(Math.random()*100)==99;
        up = (int)(Math.random()*25)==24;
        if(up){
            mySpawnE.jump(1);
        }
        if(left){
            mySpawnE.move(-1);
        }
        if(right){
            mySpawnE.move(1);
        }
        if(down){
            mySpawnE.jump(-1);
        }
        if(action1){
            mySpawnE.action1();
        }
        if(action2){
            mySpawnE.action2();
        }
        if(action3){
            mySpawnE.action3();
        }
        if(action4){
            mySpawnE.action4();
        }
        int dirFir = 1;
        if(dirUp){
            dirFir*=2;
        }
        if(dirRight){
            dirFir*=3;
        }
        if(dirLeft){
            dirFir*=5;
        }
        if(dirDown){
            dirFir*=7;
        }
        mySpawnE.dirFir(dirFir);
    }
}
