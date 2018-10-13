package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Rogue {
    private Texture text;
    private Vector2 position;
    private boolean isMoving;
    private boolean space;

    public Rogue(int x, int y) {
        text = new Texture("rogue/rogue.png");
        position = new Vector2(x, y);
        isMoving = false;
    }

    public void render(SpriteBatch batch) {
        batch.draw(text, position.x, position.y);
    }

    public void update() {
        move();
        if (position.x > Gdx.graphics.getWidth()-50) position.x = Gdx.graphics.getWidth()-50;
        if (position.x < -18) position.x = -18;
    }

    public void move() {
        if (Input.isClickedLeft())
            position.x--;
        if (Input.isClickedRight())
            position.x++;
    }
}
