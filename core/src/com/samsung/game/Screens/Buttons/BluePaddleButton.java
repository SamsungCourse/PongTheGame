package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BluePaddleButton extends AbstractButtonBox{

    public static boolean isTouched = false;

    public BluePaddleButton(float x, float y) {
        super(x, y);
        textureUp = new Texture("buttons/paddle_change/bluePaddle.png");
        textureDown = new Texture("buttons/paddle_change/bluePaddleA.png");
    }

    public void render(SpriteBatch batch) {
        if (isTouched){
            batch.draw(textureDown, x, y, width, height);
        }
        if (!isTouched){
            batch.draw(textureUp, x, y, width, height);
        }
    }
}
