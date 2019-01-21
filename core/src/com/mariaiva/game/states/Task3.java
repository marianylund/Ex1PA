package com.mariaiva.game.states;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.mariaiva.game.Ex1;
import com.mariaiva.game.sprites.Helicopter;


public class Task3 extends State{

    private Helicopter heli1;


    private BitmapFont font;
    private GlyphLayout layout;

    public Task3(GameStateManager gsm) {
        super(gsm);
        heli1 = new Helicopter(100,30);

        font = new BitmapFont();
        layout = new GlyphLayout(font, "Null", Color.GOLD, 80, Align.left, false);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        heli1.getAnim().update(dt);
        heli1.moveRandomly(3);
    }



    @Override
    public void render(SpriteBatch sb) {
        float x = heli1.getX();
        float y = heli1.getY();

        sb.begin();
        sb.enableBlending(); // How to make pink background become transparent for the helicopter?
        sb.draw(heli1.getAnim().getFrame(),x, y);

        String s = String.valueOf(Math.round(x)) + ", " + String.valueOf(Math.round(y)) + "; "
                + String.valueOf(heli1.direction.x) + ", " + String.valueOf(heli1.direction.y);
        layout.setText(font, s);
        font.draw(sb, layout, 10, Ex1.HEIGHT - 10);
        sb.end();
    }

    @Override
    public void dispose(){
        heli1.dispose(); // Does this do anything since I am using sheli?
    }
}
