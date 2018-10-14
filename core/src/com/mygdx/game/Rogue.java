package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Rogue {

    //Анимация на месте
    private Animation stayAnimation;
    private Texture stayTexture;
    private TextureRegion[] stayFrame;

    //Анимация бег
    private Animation runAnimation;
    private Texture runTexture;
    private TextureRegion[] runFrame;

    private TextureRegion currantFrame;

    private Vector2 position;

    public Rogue(int x, int y) {
        rogueStay();
        rogueRun();
        position = new Vector2(x, y);
        currantFrame = (TextureRegion) stayAnimation.getKeyFrame(MainGameClass.stateTime/4f, true);
    }

    public void render(SpriteBatch batch) {
        batch.draw(currantFrame, position.x, position.y);
        currantFrame = (TextureRegion) stayAnimation.getKeyFrame(MainGameClass.stateTime/1.5f, true);
    }

    public void update() {
        move();
        if (position.x > 340) position.x = 340;
        if (position.x < -18) position.x = -18;
    }

    public void move() {
        if (Input.isClickedLeft()) {
            position.x--;
            currantFrame = (TextureRegion) runAnimation.getKeyFrame(MainGameClass.stateTime/1.5f, true);
        }
        if (Input.isClickedRight()) {
            position.x++;
            currantFrame = (TextureRegion) runAnimation.getKeyFrame(MainGameClass.stateTime/1.5f, true);
        }
    }
    public void rogueStay() {
        stayTexture = new Texture("knightStay.png");
        TextureRegion[][] tmp = TextureRegion.split(stayTexture, stayTexture.getWidth()/2, stayTexture.getHeight());
        stayFrame = new TextureRegion[2];
        int index = 0;
        for (int i = 0; i < 2; i++) {
            stayFrame[index++] = tmp[0][i];
        }
        stayAnimation = new Animation(0.25f, stayFrame);
    }
    public void rogueRun() {
        runTexture = new Texture("axe bandit run.png");
        TextureRegion[][] tmp = TextureRegion.split(runTexture, runTexture.getWidth()/8, runTexture.getHeight());
        runFrame = new TextureRegion[8];
        int index = 0;
        for (int i = 0; i < 8; i++) {
            runFrame[index++] = tmp[0][i];
        }
        runAnimation = new Animation(0.07f, runFrame);
    }
}
