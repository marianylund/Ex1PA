package com.mariaiva.game.sprites.Pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Ball extends Moving {
    private int speed = -70;

    public static final float ACCELERATION = 200f;
    //public static final float MAX_VELOCITY_X = 200f;

    private Vector2 velocity, acceleration, direction;
    float bounceAngle = 0.0f;
    private boolean bouncing = false;

    public Ball(String pathTexture) {
        super(pathTexture);
        velocity = new Vector2(20, 20);
        acceleration = new Vector2(0, 100f);
        direction = new Vector2(speed, speed); // TODO randomise

        setX(Gdx.graphics.getWidth()/2 - getObj().getWidth()/2);
        setY(Gdx.graphics.getHeight()/2 - getObj().getHeight()/2);
    }

    private void fly(float delta){
        setX(getX() + direction.cpy().scl(delta).x);
        setY(getY() + direction.cpy().scl(delta).y);
    }

    @Override
    public void update(float dt) {

        if ( (getX() + this.getWidth() < Gdx.graphics.getWidth() && getX() > 0) || bouncing)
        {
            fly(dt);

        } else {
            //bounceOff(null);
            bounceOffTheWall();
        }
    }

    public boolean insideWalls(){
        return getX() + this.getWidth() < Gdx.graphics.getWidth() && getX() > 0;
    }

    public void bounceOffTheWall(){
        if(!bouncing){
            direction.set(-direction.x, direction.y);
            bouncing = true;
            System.out.println("Direction from the wall: " + direction);
        }else{
            System.out.println("I am already bouncing my wall out of here!");
        }

    }

    public void bounceOffThePaddle(Moving paddle){
        if(paddle!=null && !bouncing) { // if bouncing off a paddle, do some math magic
            float ballCenterX = getX() + getWidth() / 2;
            float paddlePercentHit = (ballCenterX - paddle.getX()) / paddle.getWidth();
            bounceAngle = MathUtils.lerpAngle(150, 30, paddlePercentHit);
            direction.set(direction.x, -direction.y);
            bouncing = true;
            System.out.println("Direction from the paddle: " + direction);
        }else{
            System.out.println("I am already bouncing my paddle out of here!");
        }
    }

    public void bounceOff(Moving paddle){
        if(!bouncing){
            //velocity = new Vector2(0,0);
            float new_x = 0.0f;
            if(paddle!=null){ // if bouncing off a paddle, do some math magic
                float ballCenterX = getX() + getWidth()/2;
                float paddlePercentHit = (ballCenterX - paddle.getX()) / paddle.getWidth();
                bounceAngle = MathUtils.lerpAngle(150, 30, paddlePercentHit);
                new_x = bounceAngle;
            }else{
                new_x = -velocity.x;
            }
            if(getMoveState() == MoveState.LEFT){
                acceleration.set(new_x, -ACCELERATION);
                velocity.set(new_x, - ACCELERATION);
                setMoveState(MoveState.RIGHT);
            }else{
                acceleration.set(new_x, ACCELERATION);
                velocity.set(new_x, ACCELERATION);
                setMoveState(MoveState.LEFT);
            }
        }

        bouncing = true;
    }

    public boolean collides(Rectangle obstacle){
        return obstacle.overlaps(getBounds());
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public Vector2 getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vector2 acceleration) {
        this.acceleration = acceleration;
    }

    public boolean getBouncing(){
        return bouncing;
    }

    public void setBouncing(boolean b){
        bouncing = b;
    }
}
