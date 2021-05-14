package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.samsung.game.Boot;

import static com.samsung.game.HelperClasses.Constants.SCREEN_HEIGHT;

public class AbstractButtonBox {
    protected Texture textureUntouched;
    protected Texture textureTouched;
    protected float x, y;
    protected int width, height;
    protected Boot boot;
    public boolean isTouched = false;
    public boolean isOtherTouched = false;


    public AbstractButtonBox(float x, float y, Boot boot) {
        width = 800;
        height = 200;
        this.x = x - width/2f;
        this.y = y - height/2f;
        this.boot = boot;
    }

    public void render(SpriteBatch batch) {
        if (isTouched){
            batch.draw(textureTouched, x, y, width, height);
        }
        if (!isTouched){
            batch.draw(textureUntouched, x, y, width, height);
        }
    }
    public Boolean isButtonTouched(){
        if (Gdx.input.isTouched()){
            float touchPosX = Gdx.input.getX();
            float touchPosY = SCREEN_HEIGHT - Gdx.input.getY();
            System.out.println(touchPosX + "  " + touchPosY + "  " + x + "  " + y);
            return touchPosX >= x && touchPosX <= x + width && touchPosY >= y && touchPosY <= y + height;
        }
        return false;
    }
}
