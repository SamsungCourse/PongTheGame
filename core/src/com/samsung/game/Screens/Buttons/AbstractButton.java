package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.samsung.game.Boot;

import static com.samsung.game.HelperClasses.Constants.BUTTON_HEIGHT;
import static com.samsung.game.HelperClasses.Constants.BUTTON_WIDTH;
import static com.samsung.game.HelperClasses.Constants.SCREEN_HEIGHT;

public abstract class AbstractButton {
    protected Texture textureDown;
    protected Texture textureUp;
    protected float x, y;
    protected int width, height;
    protected Boot boot;
    protected boolean toSetScreen = false;
    protected Sound touch = Gdx.audio.newSound(Gdx.files.internal("sounds/beat.mp3"));
    protected boolean toSoundPlay = true;


    public AbstractButton(float x, float y, Boot boot) {
        width = BUTTON_WIDTH;
        height = BUTTON_HEIGHT;
        this.x = x - width/2f;
        this.y = y - height/2f;
        this.boot = boot;
    }

    public void render(SpriteBatch batch) {
        if (isButtonTouched()) {
            batch.draw(textureDown, x, y, width, height);
        }
        if (!isButtonTouched()) {
            batch.draw(textureUp, x, y, width, height);
        }
    }
    public Boolean isButtonTouched(){
        if (Gdx.input.isTouched()){
            float touchPosX = Gdx.input.getX();
            float touchPosY = SCREEN_HEIGHT - Gdx.input.getY();
            return touchPosX >= x && touchPosX <= x + width && touchPosY >= y && touchPosY <= y + height;
        }
        return false;
    }
}