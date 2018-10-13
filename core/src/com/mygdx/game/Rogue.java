package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Rogue {
    private Texture text;
    private Vector2 position;

    public Rogue(int x, int y) {
        text = new Texture("rogue/rogue like idle_Animation 1_0.png");
        position = new Vector2(x, y);
    }

    public void render(SpriteBatch batch) {
        batch.draw(text, position.x, position.y);
    }

    public void update() {
        move();
        if (position.x > Gdx.graphics.getWidth()-60) position.x = Gdx.graphics.getWidth()-60;
        if (position.x < -20) position.x = -20;
    }

    public void move() {
        if (Input.isClickedA()) position.x--;
        if (Input.isClickedD()) {
            position.x++;
            text =
        }
    }
}
