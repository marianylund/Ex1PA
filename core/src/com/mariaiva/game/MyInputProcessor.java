package com.mariaiva.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.mariaiva.game.sprites.Helicopter;

public class MyInputProcessor implements InputProcessor {

    private Helicopter hel;

    public MyInputProcessor(Helicopter obj){
        this.hel = obj;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode)
        {
            case Input.Keys.LEFT:
                hel.left();
                break;
            case Input.Keys.RIGHT:
                hel.right();
                break;
            case Input.Keys.UP:
                hel.up();
                break;
            case Input.Keys.DOWN:
                hel.down();
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode)
        {
            case Input.Keys.LEFT:
                hel.stop();
                break;
            case Input.Keys.RIGHT:
                hel.stop();
                break;
            case Input.Keys.UP:
                hel.stop();
                break;
            case Input.Keys.DOWN:
                hel.stop();
                break;
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
