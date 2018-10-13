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

    public Rogue(int x, int y) {
        rogueTexture = new Texture("rogue/rogue like run.png");
        TextureRegion[][] tmp = TextureRegion.split(rogueTexture, rogueTexture.getWidth()/6, rogueTexture.getHeight());
        runFrame = new TextureRegion[6];
        int index = 0;
        for (int i = 0; i < 6; i++) {
            runFrame[index++] = tmp[0][i];
        }
        runAnimation = new Animation(0.25f, runFrame);

        position = new Vector2(x, y);
    }

    public void render(SpriteBatch batch) {
        currantFrame = (TextureRegion) runAnimation.getKeyFrame(MainGameClass.stateTime, true);
        batch.draw(currantFrame, position.x, position.y);
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
