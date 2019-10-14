package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.game.input.Input;

public class MenuScreen implements Screen {

    final GameScreen gameClass;
    OrthographicCamera camera;
    public MenuScreen(final GameScreen gameClass) {
        this.gameClass = gameClass;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 870, 480);
    }


    public void show () {

    }

    public void render (float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (Input.isTouched()) {

        }
    }

    public void resize (int width, int height) {

    }

    public void pause () {

    }

    public void resume () {

    }

    public void hide () {

    }

    public void dispose () {

    }
}
