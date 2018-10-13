package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Rogue {
    private Texture text;
    private Vector2 position;
    private boolean isMoving;

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
        if (isMoving) text = new Texture("rogue/rogue_run.gif");
        else text = new Texture("rogue/rogue.png");
        if (position.x > Gdx.graphics.getWidth()-60) position.x = Gdx.graphics.getWidth()-60;
        if (position.x < -20) position.x = -20;
    }

    public void move() {
        if (Input.isClickedLeft()) {
            position.x--;
            isMoving = true;
        } else isMoving = false;
        if (Input.isClickedRight()) {
            position.x++;
            isMoving = true;
        } else isMoving = false;
    }
}
