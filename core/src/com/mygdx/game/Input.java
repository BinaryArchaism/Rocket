package com.mygdx.game;

import com.badlogic.gdx.Gdx;

public class Input {
    public static boolean isClickedLeft() {
        return Gdx.input.isKeyPressed(29)||Gdx.input.isKeyPressed(21);
    }
    public static boolean isClickedRight() {
        return Gdx.input.isKeyPressed(32)||Gdx.input.isKeyPressed(22);
    }
    public static boolean isClickedSpace() {
        return Gdx.input.isKeyPressed(62);
    }
    public static boolean isClickedUp() {
        return Gdx.input.isKeyPressed(19);
    }
}
