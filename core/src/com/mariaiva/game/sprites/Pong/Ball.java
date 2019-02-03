package com.mariaiva.game.sprites.Pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Ball extends Moving {
    private int speed = -110;

    private Vector2 direction;
    private boolean bouncing = false;

    public Ball(String pathTexture) {
        super(pathTexture);
        direction = new Vector2(speed, speed);

        restartPosition();
    }

    public void restartPosition(){
        setX(Gdx.graphics.getWidth()/2.0f - getObj().getWidth()/2);
        setY(Gdx.graphics.getHeight()/2.0f - getObj().getHeight()/2);
    }

    private void fly(float delta){
        setX(getX() + direction.cpy().scl(delta).x);
        setY(getY() + direction.cpy().scl(delta).y);
    }

    @Override
    public void update(float dt) {
        if (insideWalls() || bouncing)
            fly(dt);

        else
            bounceOffTheWall();
    }

    public boolean insideWalls(){
        return getX() + this.getWidth() < Gdx.graphics.getWidth() && getX() > 0;
    }

    public boolean flewOut(){
        return getY() + this.getHeight() > Gdx.graphics.getHeight() || getY() < 0;
    }

    public void bounceOffTheWall(){
        if(!bouncing) {
            direction.set(-direction.x, direction.y);
            bouncing = true;
        }

    }

    public void bounceOffThePaddle(Moving paddle){
        if(paddle!=null && !bouncing) {
            direction.set(direction.x, -direction.y);
            bouncing = true;
        }
    }

    public boolean collides(Rectangle obstacle){
        return obstacle.overlaps(getBounds());
    }

    public boolean getBouncing(){
        return bouncing;
    }

    public void setBouncing(boolean b){
        bouncing = b;
    }
}
