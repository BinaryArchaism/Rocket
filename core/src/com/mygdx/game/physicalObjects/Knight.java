package com.mygdx.game.physicalObjects;

/**
 *  Напрявления в этом классе:
 *  true - вправо
 *  false - влево
 */

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Input;
import com.mygdx.game.MainGameClass;
import com.mygdx.game.PhysicalObject;

public class Knight extends PhysicalObject{
    //Текстуры
    Texture stayRight;
    Texture stayLeft;
    Texture walkRight;
    Texture walkLeft;
    Texture attackR;
    Texture attack1;

    //Анимация
    private Animation animation;

    //Текущая текстура
    private TextureRegion currantFrame;

    //Определяет куда смотрит герой. true - смотрит вправо, false - смотрит влево.
    private boolean isWatchingRight = true;

    public Knight(int x, int y) {
        super(x, y);
        uploadTextures();
        stay(true);
        currantFrame = (TextureRegion) animation.getKeyFrame(MainGameClass.stateTime/4f, true);
    }
    public void render(SpriteBatch batch) {
        batch.draw(currantFrame, position.x, position.y);
        currantFrame = (TextureRegion) animation.getKeyFrame(MainGameClass.stateTime/1.5f, true);
    }
    //Все, что связано с движением
    protected void move() {
        if (Input.isClickedLeft() && !Input.isClickedSpace()) {
            position.x--;
            isWatchingRight = false;
            walk(false);
            currantFrame = (TextureRegion) animation.getKeyFrame(MainGameClass.stateTime/1.5f, true);
        }
        if (Input.isClickedRight() && !Input.isClickedSpace()) {
            position.x++;
            isWatchingRight = true;
            walk(true);
            currantFrame = (TextureRegion) animation.getKeyFrame(MainGameClass.stateTime/1.5f, true);
        }
        if (isWatchingRight) stay(true);
        else stay(false);
        if (position.x > 360) position.x = -50;
        if (position.x < -50) position.x = 360;
        if (Input.isClickedSpace()) {
            attack();
            currantFrame = (TextureRegion) animation.getKeyFrame(MainGameClass.stateTime/1.5f, true);
        }
    }
    private void stay(boolean right) {
        if (right) {
            doAnimation(stayRight, 4, true, 0.15f);
        } else {
            doAnimation(stayLeft, 4, false, 0.15f);
        }
    }
    private void walk(boolean right) {
        if (right) {
            doAnimation(walkRight, 8, true, 0.07f);
        } else {
            doAnimation(walkLeft, 8, false, 0.07f);
        }
    }
    private void attack() {
        if (isWatchingRight) {
            doAnimation(attackR, 10, true, 0.07f);
        } else { //исключение: чтобы анимация атаки влево работала правильно, занчение true менять не нужно
            doAnimation(attack1, 10, true, 0.07f);
        }
    }
    private void doAnimation(Texture texture, int n, boolean right, float speed) {
        TextureRegion[] frames;
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
    private void uploadTextures() {
        stayRight = new Texture("Knight/stayRight.png");
        stayLeft = new Texture("Knight/stayLeft.png");
        walkRight = new Texture("Knight/walkRight.png");
        walkLeft = new Texture("Knight/walkLeft.png");
        attackR = new Texture("Knight/attackR.png");
        attack1 = new Texture("Knight/attack1.png");
    }
}
