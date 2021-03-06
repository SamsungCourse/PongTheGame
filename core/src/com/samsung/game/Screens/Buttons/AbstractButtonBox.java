package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.samsung.game.Boot;

import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveHeight;
import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveWidth;
import static com.samsung.game.HelperClasses.Constants.SCREEN_HEIGHT;

public class AbstractButtonBox {
    protected Texture textureUp;
    protected Texture textureDown;
    protected float x, y;
    protected int width, height;


    public AbstractButtonBox(float x, float y) {
        width = (int) adaptiveWidth(800);
        height = (int) adaptiveHeight(200);
        this.x = x - width/2f;
        this.y = y - height/2f;
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
