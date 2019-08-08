package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.physicalObjects.Knight;

public class MainGameClass extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	PhysicalObject knight;
	public static float stateTime;
	FileHandle music;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("country-platform.png");
		knight = new Knight(10, 25);
		stateTime = 0f;

		music = new FileHandle("soundtracks/3.wav");
		Gdx.audio.newMusic(music).play();
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 0, 0, 1);

		stateTime += Gdx.graphics.getDeltaTime();

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(img, 0, 0);
		knight.render(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	public void update() {
		knight.update();
	}
}
