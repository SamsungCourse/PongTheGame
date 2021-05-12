package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.samsung.game.Boot;
import com.samsung.game.Screens.SetupScreen;

import static com.samsung.game.HelperClasses.Constants.PIXELS_PER_METRE;

public abstract class AbstractButton {
    protected Texture textureUp;
    protected Texture textureDown;
    protected float x, y;
    protected int width, height;
    protected Boot boot;


    public AbstractButton(float x, float y, Boot boot) {
        width = 800;
        height = 200;
        this.x = x - width/2f;
        this.y = y - height/2f;
        this.boot = boot;
    }

    public void render(SpriteBatch batch) {
        if (isButtonTouched()){
            batch.draw(textureUp, x, y, width, height);
        }
        if (!isButtonTouched()){
            batch.draw(textureDown, x, y, width, height);
        }
        }
    public Boolean isButtonTouched(){
        if (Gdx.input.isTouched()){
            float touchPosX = Gdx.input.getX();
            float touchPosY = Gdx.input.getY();
            System.out.println(touchPosX + "  " + touchPosY + "  " + x + "  " + y);
            return touchPosX >= x && touchPosX <= x + width && touchPosY >= y && touchPosY <= y + height;
        }
        return false;
    }
}