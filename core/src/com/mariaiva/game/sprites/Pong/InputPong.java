package com.mariaiva.game.sprites.Pong;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class InputPong implements InputProcessor {

    private Paddle obj1;
    private Paddle obj2;

    public InputPong(Paddle obj1, Paddle obj2){
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.A:
                obj1.left();
                break;
            case Input.Keys.D:
                obj1.right();
                break;
            case Input.Keys.LEFT:
                obj2.left();
                break;
            case Input.Keys.RIGHT:
                obj2.right();
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.A:
                obj1.stop();
                break;
            case Input.Keys.D:
                obj1.stop();
                break;
            case Input.Keys.LEFT:
                obj2.stop();
                break;
            case Input.Keys.RIGHT:
                obj2.stop();
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
