package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.samsung.game.Boot;
import com.samsung.game.Screens.GameScreen;

public class BluePaddleButton extends AbstractButtonBox{

    public static boolean isTouched = false;

    public BluePaddleButton(float x, float y) {
        super(x, y);
        textureUntouched = new Texture("buttons/paddle_change/bluePaddle.png");
        textureTouched = new Texture("buttons/paddle_change/bluePaddleA.png");
    }

    public void render(SpriteBatch batch) {
        if (isTouched){
            batch.draw(textureTouched, x, y, width, height);
        }
        if (!isTouched){
            batch.draw(textureUntouched, x, y, width, height);
        }
    }
}
