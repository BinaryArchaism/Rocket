package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Rogue {
    private Animation runAnimation;
    private Texture rogueTexture;
    private TextureRegion[] runFrame;
    private TextureRegion currantFrame;

    private Vector2 position;

    private boolean isMoving = false;

    public Rogue(int x, int y) {
        rogueTexture = new Texture("axe bandit run.png");
        TextureRegion[][] tmp = TextureRegion.split(rogueTexture, rogueTexture.getWidth()/8, rogueTexture.getHeight());
        runFrame = new TextureRegion[8];
        int index = 0;
        for (int i = 0; i < 8; i++) {
            runFrame[index++] = tmp[0][i];
        }
        runAnimation = new Animation(0.07f, runFrame);

        position = new Vector2(x, y);
        currantFrame = (TextureRegion) runAnimation.getKeyFrame(0);
    }

    public void render(SpriteBatch batch) {

        batch.draw(currantFrame, position.x, position.y);
    }

    public void update() {
        move();
        if (position.x > 200) position.x = 200;
        if (position.x < -18) position.x = -18;
        if (isMoving)  currantFrame = (TextureRegion) runAnimation.getKeyFrame(MainGameClass.stateTime, true);
        isMoving = false;
    }

    public void move() {
        if (Input.isClickedLeft()) {
            position.x--;
            isMoving = true;
        }
        if (Input.isClickedRight()) {
            position.x++;
            isMoving = true;
        }
    }
}
