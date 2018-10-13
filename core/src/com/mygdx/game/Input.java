package com.mygdx.game;

import com.badlogic.gdx.Gdx;

public class Input {
    public static boolean isClickedA() {
        return Gdx.input.isKeyPressed(29);
    }
    public static boolean isClickedD() {
        return Gdx.input.isKeyPressed(32);
    }
}
