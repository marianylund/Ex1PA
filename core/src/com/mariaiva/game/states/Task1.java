package com.mariaiva.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mariaiva.game.Ex1;
import com.mariaiva.game.sprites.Helicopter;

public class Task1 extends State {
    private Helicopter heli1;

    public Task1(GameStateManager gsm) {
        super(gsm);
        heli1 = new Helicopter(100,100);
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {
        if(heli1.getPosition().x + heli1.getHeli1().getWidth() > Ex1.WIDTH || heli1.getPosition().x < 0){
            heli1.changeDirection();
        }
        heli1.getPosition().x += heli1.getSpeed() * dt;
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.enableBlending(); // How to make pink background become transparent for the helicopter?
        sb.draw(heli1.getHeli1(),heli1.getPosition().x, heli1.getPosition().y);
        sb.end();
    }
    @Override
    public void dispose(){
       heli1.dispose(); // Does this do anything since I am using sheli?
    }
}
