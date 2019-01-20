package com.mariaiva.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.mariaiva.game.Ex1;
import com.mariaiva.game.MyInputProcessor;
import com.mariaiva.game.sprites.Helicopter;

public class Task2 extends State {
    private Helicopter heli1;

    private BitmapFont font;
    private GlyphLayout layout;

    public Task2(GameStateManager gsm) {
        super(gsm);
        System.out.printf("Task 2 is on!");
        heli1 = new Helicopter(100,100);

        MyInputProcessor inputProcessor = new MyInputProcessor(heli1);
        Gdx.input.setInputProcessor(inputProcessor);
        font = new BitmapFont();
        layout = new GlyphLayout(font, "Null", Color.GOLD, 80, Align.left, false);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        handleInput();
        heli1.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        float x = heli1.getPosition().x;
        float y = heli1.getPosition().y;
        sb.begin();
        sb.enableBlending(); // How to make pink background become transparent for the helicopter?
        sb.draw(heli1.getHeli1(), x, y);
        String s = String.valueOf(Math.round(x)) + ", " + String.valueOf(Math.round(y));
        layout.setText(font, s);
        font.draw(sb, layout, 10, Ex1.HEIGHT - 10);
        sb.end();
    }

    @Override
    public void dispose() {
        heli1.dispose(); // Does this do anything since I am using sheli?
    }

}
