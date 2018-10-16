package com.mygdx.game.screens;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.game.MainGameClass;

public class MenuScreen implements Screen {

    final MainGameClass gameClass;
    OrthographicCamera camera;
    public MenuScreen(final MainGameClass gameClass) {
        this.gameClass = gameClass;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 870, 480);
    }

    public void show () {

    }

    public void render (float delta) {

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
