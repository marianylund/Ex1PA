package com.mariaiva.game.sprites.Pong;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.mariaiva.game.Ex1;

public abstract class Moving {
    private Sprite obj;
    public enum MoveState {
        LEFT, RIGHT, STOP
    };

    private MoveState moveState = MoveState.STOP;
    private Rectangle bounds;

    public Moving(String pathTexture){
        this.obj = new Sprite(new Texture(pathTexture));
        bounds = new com.badlogic.gdx.math.Rectangle((int) getX(),(int) getY(),(int) getWidth(),(int) getHeight());
    }

    public abstract void update(float dt);

    public boolean collides(Rectangle obstacle){
        if(obstacle.overlaps(bounds)){
            System.out.println("Overlaps!");
        }
        return obstacle.overlaps(bounds);
    }

    private boolean insideScreenX(float new_x, Sprite obj){
        return new_x >= 0 && new_x + getWidth() <= Ex1.WIDTH; //TODO should be any screen, not only for computer applications
    }

    private boolean insideScreenY(float new_y, Sprite obj){
        return new_y >= 0 && new_y + getHeight() <= Ex1.HEIGHT; //TODO should be any screen, not only for computer applications
    }

    public void left(){
        setMoveState(MoveState.LEFT);
    }

    public void right() {
        setMoveState(MoveState.RIGHT);
    }

    public void stop() {
        setMoveState(MoveState.STOP);
    }

    public void dispose(){
        obj.getTexture().dispose();
    }

    //region Getters and setters

    public MoveState getMoveState() {
        return moveState;
    }

    public void setMoveState(MoveState moveState) {
        this.moveState = moveState;
    }

    public Sprite getObj() {
        return obj;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public float getX(){
        return obj.getX();
    }

    public float getY(){
        return obj.getY();
    }

    public float getHeight(){
        return obj.getHeight();
    }

    public float getWidth(){
        return obj.getWidth();
    }

    public void setX(float pX){
        obj.setX(pX);
        bounds.setX((int)pX);
    }
    public void setY(float pY){
        obj.setY(pY);
        bounds.setY((int)pY);
    }

    //endregion
}
