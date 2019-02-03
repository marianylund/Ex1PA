package com.mariaiva.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mariaiva.game.states.GameStateManager;
import com.mariaiva.game.states.Task4;

public class Ex1 extends ApplicationAdapter {

	public OrthographicCamera camera;

	public static final int WIDTH = 400;
	public static final int HEIGHT = 600;

	public Viewport viewport;

	public static final String TITLE = "Helicopter";
	private GameStateManager gsm;
	SpriteBatch batch;
	Texture img;


	@Override
	public void create () {
		float aspectRatio = (float)Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth();
		camera = new OrthographicCamera(WIDTH * aspectRatio, Gdx.graphics.getHeight());
		viewport = new FillViewport(WIDTH * aspectRatio, Gdx.graphics.getHeight());
		viewport.apply();
		camera.translate(WIDTH/2.0f,  HEIGHT/2.0f);

		batch = new SpriteBatch();
		gsm = new GameStateManager();
		gsm.push(new Task4(gsm));

		Gdx.gl.glClearColor(0, 0, 0.2f, 0.2f);
	}

	@Override
	public void resize(int width, int height){
		viewport.update(width, height);
		camera.position.set(WIDTH/2.0f, HEIGHT/2.0f,0);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // wipes clean
		camera.update();
		gsm.update(Gdx.graphics.getDeltaTime()); // Hvorfor trenger du differansen?
		batch.setProjectionMatrix(camera.combined);
		gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
