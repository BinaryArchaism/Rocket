package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class PhysicalObject {
    public Vector2 gravity = new Vector2(0, 0); //y = -1
    public Vector2 position;

    public PhysicalObject(int x, int y) {
        position = new Vector2(x, y);
    }
    public void render(SpriteBatch batch){

    }
    public void update() {
        gravitation();
        move();
    }
    public void gravitation() {
        position.add(gravity);
    }
    protected void move() {}
}
