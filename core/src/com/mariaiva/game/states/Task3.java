package com.mariaiva.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mariaiva.game.Ex1;
import com.mariaiva.game.sprites.Helicopter;

import sun.java2d.marlin.FloatMath;

public class Task3 extends State{

    private Helicopter heli1;

    public Task3(GameStateManager gsm) {
        super(gsm);
        heli1 = new Helicopter(100,100);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        if(heli1.getPosition().x + heli1.getHeli1().getWidth() > Ex1.WIDTH || heli1.getPosition().x < 0){
            heli1.changeDirection();
        }
        double angle = Math.random() * Math.PI;
        Vector2 direction = new Vector2((float)Math.cos(angle),(float)Math.sin(angle));
        float new_x = heli1.getPosition().x + heli1.getSpeed() * direction.x;
        float new_y = heli1.getPosition().y + heli1.getSpeed() * direction.y;
        if(new_x < 0 || new_x + heli1.getHeli1().getWidth() > Ex1.WIDTH)
        heli1.getPosition().x = new_x;
        heli1.getPosition().y = new_y;

    }

    public static double getRandomNumber(){
        double x = Math.random();
        return x;
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
