package com.mariaiva.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.mariaiva.game.Ex1;

import java.io.Console;

import sun.rmi.runtime.Log;
import sun.security.ssl.Debug;

public class Helicopter {
    private int speed = -70;

    public static final float ACCELERATION = 200f;
    //public static final float MAX_VELOCITY_X = 200f;

    private Texture heli1;
    private Sprite sheli1;

    private Vector2 velocity, acceleration, position;

    public Vector2 getAcceleration() {
        return acceleration;
    }

    public MoveState getMovestate() {
        return movestate;
    }

    public enum MoveState {
        UP, DOWN, LEFT, RIGHT, STOP
    };

    private MoveState movestate = MoveState.STOP;

    public Helicopter(int x, int y){
        heli1 = new Texture("heli1.png");
        sheli1 = new Sprite(heli1);

        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 0);
    }

    private void fly(float delta){
        velocity.add(acceleration.cpy().scl(delta));
        position.add(velocity.cpy().scl(delta));
    }

    public void update(float delta){
        if (       movestate == MoveState.LEFT && position.x > 0
                || movestate == MoveState.RIGHT && position.x + heli1.getWidth() < Ex1.WIDTH
                || movestate == MoveState.UP &&  position.y + heli1.getHeight() < Ex1.HEIGHT
                || movestate == MoveState.DOWN && position.y > 0)
        {
            fly(delta);
        } else {
            movestate = MoveState.STOP;
            velocity = new Vector2(0,0);
        }
        // Was moving right, decelerate to a stop
        if (movestate == MoveState.STOP && velocity.x > 0) {
            velocity.x += -ACCELERATION * delta;
        }
        // Was moving left, decelerate to a stop
        if (movestate == MoveState.STOP && velocity.x < 0) {
            velocity.x += ACCELERATION * delta;
        }
        // Was moving down, decelerate to a stop
        if (movestate == MoveState.STOP && velocity.y < 0) {
            velocity.y += ACCELERATION * delta;
        }
        // Was moving up, decelerate to a stop
        if (movestate == MoveState.STOP && velocity.y > 0) {
            velocity.y += -ACCELERATION * delta;
        }
    }


    public Sprite getHeli1() {
        return sheli1;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void changeDirection(){
        speed *= -1;
        sheli1.flip(true,false);
    }

    public int getSpeed() {
        return speed;
    }

    public void dispose(){
        heli1.dispose();
    }

    public void left(){
        sheli1.setFlip(false, false);
        movestate = MoveState.LEFT;
        acceleration.set(-ACCELERATION, 0);

    }

    public void right(){
        sheli1.setFlip(true, false);
        movestate = MoveState.RIGHT;
        acceleration.set(ACCELERATION, 0);
    }

    public void up(){
        movestate = MoveState.UP;
        acceleration.set(0, ACCELERATION);
    }

    public void down(){
        movestate = MoveState.DOWN;
        acceleration.set(0, -ACCELERATION);
    }

    public void stop(){
        movestate = MoveState.STOP;
    }

}
