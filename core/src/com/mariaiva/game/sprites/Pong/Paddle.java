package com.mariaiva.game.sprites.Pong;

import com.badlogic.gdx.Gdx;
import com.mariaiva.game.Ex1;

public class Paddle extends Moving {

    public float speed = 4.0f;

    public Paddle(String pathTexture, int y) {
        super(pathTexture);

        setX(Gdx.graphics.getWidth()/2 - getObj().getWidth()/2);
        setY(y);
    }

    public void update(float dt){

        if(getMoveState() == MoveState.LEFT ){
            if(getX() > speed){
                setX(getX()-speed);
            }else{
                setX(0.0f);
                stop();
            }
        }
        if(getMoveState() == MoveState.RIGHT ){
            if(getX() + this.getWidth() + speed < Ex1.WIDTH){
                setX(getX() + speed);
            }else{
                setX(Ex1.WIDTH - this.getWidth());
                stop();
            }
        }
    }

}
