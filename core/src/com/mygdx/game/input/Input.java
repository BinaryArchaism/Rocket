package com.mygdx.game.input;

import com.badlogic.gdx.Gdx;

public class Input {
    public static boolean isClickedLeft() {
        return Gdx.input.isKeyPressed(29)||Gdx.input.isKeyPressed(21);
    }
    public static boolean isClickedRight() {
        return Gdx.input.isKeyPressed(32)||Gdx.input.isKeyPressed(22);
    }
    public static boolean isClickedSpace() {
        return Gdx.input.isKeyPressed(62)||Gdx.input.isKeyPressed(19);
    }
    public static boolean isTouched() { return Gdx.input.isKeyPressed(-1); }
}
