package com.mariaiva.game.sprites;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Bird extends Movable {

    public Bird(int x, int y){
        super(new TextureAtlas("BirdA/birds.atlas"), new Animation(new TextureAtlas("BirdA/birds.atlas"), 4, 0.4f));
        this.setX(x);
        this.setY(y);
    }
}
