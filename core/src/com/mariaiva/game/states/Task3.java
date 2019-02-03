package com.mariaiva.game.states;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.mariaiva.game.sprites.Helicopter;
import com.mariaiva.game.sprites.Movable;

import java.util.ArrayList;


public class Task3 extends State{

    private ArrayList<Helicopter> helicopters;


    private BitmapFont font;
    private GlyphLayout layout;

    public Task3(GameStateManager gsm) {
        super(gsm);
        helicopters = new ArrayList<Helicopter>();

        helicopters.add(new Helicopter(100,30));
        helicopters.add(new Helicopter(100,20));
        helicopters.add(new Helicopter(100,10));

        font = new BitmapFont();
        layout = new GlyphLayout(font, "Null", Color.GOLD, 80, Align.left, false);
    }

    @Override
    protected void handleInput() {

    }

    public void move(Movable m, int speed){
        m.moveRandomly(speed);
        for(Helicopter he : helicopters){
            if(!m.equals(he) && m.collides(he.getBounds())){
                move(m, speed);
            }
        }
    }

    @Override
    public void update(float dt) {

        for(Helicopter h : helicopters){
            h.getHeliAnimation().update(dt);
            move(h, 4);


            /*
            h.moveRandomly(3);
            for(Helicopter he : helicopters){
                if(!h.equals(he) && h.collides(he.getBounds())){
                    if(sameDirection(h.getDirection().x, he.getDirection().x)){
                        h.setXDirection(h.getDirection().x*-1);
                    }
                    if(sameDirection(h.getDirection().y, he.getDirection().y)){
                        h.setYDirection(h.getDirection().y*-1);
                    }
                }
            }*/

        }
    }



    @Override
    public void render(SpriteBatch sb) {


        sb.begin();
        sb.enableBlending(); // How to make pink background become transparent for the helicopter?
        for(Helicopter h : helicopters){
            sb.draw(h.getAnim().getFrame(),h.getX(), h.getY());
        }


        /*
        float x = heli1.getX();
        float y = heli1.getY();
        String s = String.valueOf(Math.round(x)) + ", " + String.valueOf(Math.round(y)) + "; "
                + String.valueOf(heli1.direction.x) + ", " + String.valueOf(heli1.direction.y);
        layout.setText(font, s);
        font.draw(sb, layout, 10, Ex1.HEIGHT - 10);
        */
        sb.end();
    }

    @Override
    public void dispose(){
        for(Helicopter h : helicopters){
            h.dispose(); // Does this do anything since I am using sheli?
        }
    }

    public boolean sameDirection(float d1, float d2){
        return ((d1 < 0) == (d2 < 0 )) || ((d1 >= 0) == (d2 >= 0));
    }
}
