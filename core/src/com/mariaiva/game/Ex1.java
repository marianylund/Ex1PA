package com.mariaiva.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mariaiva.game.states.GameStateManager;
import com.mariaiva.game.states.Task1;
import com.mariaiva.game.states.Task2;
import com.mariaiva.game.states.Task3;

public class Ex1 extends ApplicationAdapter {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 300;

	public static final String TITLE = "Helicopter";
	private GameStateManager gsm;
	SpriteBatch batch;
	Texture img;

	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		gsm.push(new Task2(gsm));

		Gdx.gl.glClearColor(0, 0, 0.2f, 0.2f);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // wipes clean
		gsm.update(Gdx.graphics.getDeltaTime()); // Hvorfor trenger du differansen?
		gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
