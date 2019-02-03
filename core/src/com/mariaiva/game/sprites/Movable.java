package com.mariaiva.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mariaiva.game.Ex1;

public class Movable {

    public Vector2 direction;
    private Sprite obj;
    private Rectangle bounds;
    private Animation anim;
    private int counter;
    private boolean right;
    private String debugStr;

    public Movable(TextureAtlas ta, Animation anim){

        this.obj = ta.createSprite("movable");
        right = false;
        direction = newDirection();
        this.anim = anim;
        bounds = new Rectangle((int) getX(),(int) getY(),(int) getWidth(),(int) getHeight());
    }

    public Movable(String pathTexture, Animation anim){
        this.obj = new Sprite(new Texture(pathTexture));

        right = false;
        direction = newDirection();
        bounds = new Rectangle((int) getX(),(int) getY(),(int) getWidth(),(int) getHeight());
        this.anim = anim;
    }

    public void moveRandomly(int speed){
        debugStr = "";

        if(Math.random()>0.995f && counter > 100){
            direction = newDirection();
            counter = 0;
        }
        counter ++;
        float new_x = obj.getX() + speed * direction.x;
        float new_y = obj.getY() + speed * direction.y;


        if(insideScreenX(new_x, obj)){
            if(direction.x < 0.0f){
                right = false;
            } else {
                right = true;
            }
            setX(new_x);
        }else{
            direction.x *= -1;
            right = !right;
        }
        if(right != anim.isFlipX()){
            anim.flipX();
        }
        if(insideScreenY(new_y,obj)) {
            setY(new_y);
        }else{
            direction.y *= -1;
        }

    }

    public String getDebugStr(){
        return debugStr;
    }

    private boolean insideScreenX(float new_x, Sprite obj){
        return new_x >= 0 && new_x + getWidth() <= Ex1.WIDTH;
    }

    private boolean insideScreenY(float new_y, Sprite obj){
        return new_y >= 0 && new_y + getHeight() <= Ex1.HEIGHT;
    }

    private Vector2 newDirection(){
        double angle = Math.random() * Math.PI;
        return new Vector2((float)Math.sin(angle),(float)Math.cos(angle));
    }

    public void setXDirection(float x){
        direction.x = x;
    }
    public void setYDirection(float y){
        direction.y = y;
    }

    public Vector2 getDirection() {
        return direction;
    }

    public boolean collides(Rectangle obstacle){
        if(obstacle.overlaps(bounds)){
            System.out.println("Overlaps!");
        }
        return obstacle.overlaps(bounds);
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
    public Animation getAnim(){return anim;}
    public boolean getRight(){return right;}
}
