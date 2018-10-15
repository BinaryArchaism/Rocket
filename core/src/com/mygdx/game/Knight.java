package com.mygdx.game;

/**
 *  Напрявления в этом классе:
 *  true - вправо
 *  false - влево
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Knight {

    //Анимация
    private Animation animation;
    private Texture texture;
    private TextureRegion[] frames;

    //Текущая текстура
    private TextureRegion currantFrame;

    private Vector2 position;

    //Определяет куда смотрит герой. true - смотрит вправо, false - смотрит влево.
    private boolean isWatchingRight = true;

    public Knight(int x, int y) {
        stay(true);
        position = new Vector2(x, y);
        currantFrame = (TextureRegion) animation.getKeyFrame(MainGameClass.stateTime/4f, true);
    }

    public void render(SpriteBatch batch) {
        batch.draw(currantFrame, position.x, position.y);
        currantFrame = (TextureRegion) animation.getKeyFrame(MainGameClass.stateTime/1.5f, true);
    }

    public void update() {
        move();
        combat();
    }
    //Все, что связано с движением
    private void move() {
        if (Input.isClickedLeft()) {
            position.x--;
            isWatchingRight = false;
            walk(false);
            currantFrame = (TextureRegion) animation.getKeyFrame(MainGameClass.stateTime/1.5f, true);
        }
        if (Input.isClickedRight()) {
            position.x++;
            isWatchingRight = true;
            walk(true);
            currantFrame = (TextureRegion) animation.getKeyFrame(MainGameClass.stateTime/1.5f, true);
        }
        if (isWatchingRight) stay(true);
        else stay(false);
        if (position.x > 340) position.x = 340;
        if (position.x < -18) position.x = -18;
    }
    private void combat() {
        if (Input.isClickedSpace()) {
            attack();
            currantFrame = (TextureRegion) animation.getKeyFrame(MainGameClass.stateTime/1.5f, true);
        }
    }
    private void stay(boolean right) {
        if (right) {
            doAnimation("Knight/stayRight.png", 4, true, 0.15f);
        } else {
            doAnimation("Knight/stayLeft.png", 4, false, 0.15f);
        }
    }
    private void walk(boolean right) {
        if (right) {
            doAnimation("Knight/walkRight.png", 8, true, 0.07f);
        } else {
            doAnimation("Knight/walkLeft.png", 8, false, 0.07f);
        }
    }
    private void attack() {
        if (isWatchingRight) {
            doAnimation("Knight/attackR.png", 10, true, 0.07f);
        } else { //исключение: чтобы анимация атаки влево работала правильно, занчение true менять не нужно
            doAnimation("Knight/attack1.png", 10, true, 0.07f);
        }
    }
    private void doAnimation(String file, int n, boolean right, float speed) {
        texture = new Texture(file);
        TextureRegion[][] tmp = TextureRegion.split(texture, texture.getWidth() / n, texture.getHeight());
        frames = new TextureRegion[n];
        int index = 0;
        if (right) {
            for (int i = 0; i < n; i++) {
                frames[index++] = tmp[0][i];
            }
        } else {
            for (int i = n-1; i >= 0; i--) {
                frames[index++] = tmp[0][i];
            }
        }
        animation = new Animation(speed, frames);
    }
}
