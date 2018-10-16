package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

abstract public class PhysicalObject {
    abstract public void render(SpriteBatch batch);
    abstract public void update();
}
