/**
*   The Chase is on
*
*   @author     Chris Angelo Isidro
*   @version    1.1 April 29, 2016
*
*   Changelog
*   CAI 1.1 - Combined blink cooldown for left and right blink
*           - Changed blink cooldown from 2s to 2.5s
*           - Changed blink cooldown on ultimate from 0.5s to 0.75s
*/

import java.awt.*;
public class Chase extends Player{

    private float direction = 0;
    private float changeDr = 45;
    private float blinkDistance = 200;
    private float blinkTimer = 0;
    private float blinkCD = 2.5f; //seconds

    public Chase( float x, float y ){
        xPos = x;
        yPos = y;
        width = 30;
        height = 60;
        setMove( new StandardMovable() );
        setJump( new ChaseJumpable( blinkDistance, blinkCD ) );
        setFall( new StandardFallable() );
        setCollision( new PlayerCollisionable( this ) );
        setFly( new UnFlyable() );
        setType( Spawn.IS_PLAYER );
        moveSpeed[0] = 4.0f;
        jumpSpeed[1] = 0;
        spriteName = "Images\\Chase.png";

    }

    public int setSpriteHook(){
        return 0;
    }

    public int dirFir( int directionFactor ){
        if( directionFactor!=1 ){
            if( directionFactor%6==0 ){
                direction = 45;
            }else if( directionFactor%10==0 ){
                direction = 135;
            }else if( directionFactor%35==0 ){
                direction = 225;
            }else if( directionFactor%21==0 ){
                direction = 315;
            }else if( directionFactor%2==0 ){
                direction = 90;
            }else if( directionFactor%3==0 ){
                direction = 0;
            }else if( directionFactor%5==0 ){
                direction = 180;
            }else if( directionFactor%7==0 ){
                direction = 270;
            }
        }
        return 0;
    }

    private void shoot(){
        float xCenter = xPos+width/2;
        float yCenter = yPos+height/2;
        xCenter+=(Math.cos(Math.toRadians(direction))*(width+10))-10;
        yCenter-=(Math.sin(Math.toRadians(direction))*(height+10))+10;
        pro.shoot(xCenter,yCenter,direction);
    }

    public int action1(){
        if(System.nanoTime() - blinkTimer >= blinkCD*1000000000 ){
            blinkTimer = System.nanoTime();
            float[] currentLocation = this.getLocation();
            float newX = Math.max( currentLocation[0]-blinkDistance, 0 );
            this.setLocation( newX, currentLocation[1], currentLocation[2], currentLocation[3] );
            return 0;
        }
        return -1;
    }

    public int action2(){
        if(System.nanoTime() - blinkTimer >= blinkCD*1000000000 ){
            blinkTimer = System.nanoTime();
            float[] currentLocation = this.getLocation();
            float newX = Math.min( currentLocation[0]+blinkDistance, 970 );
            this.setLocation( newX, currentLocation[1], currentLocation[2], currentLocation[3] );
            return 0;
        }
        return -1;
    }

    public int action3(){
        //ultimate();
        return 0;
    }

    public int action4(){
        shoot();
        return 0;
    }

    public int ultimate(){
        pro.setFireRate( 200 );
        pro.setProjVel( 20 );
        moveSpeed[0] = 6.0f;
        blinkCD = 0.75f;
        setJump( new ChaseJumpable( blinkDistance, blinkCD ) );
        return 0;
    }

}
