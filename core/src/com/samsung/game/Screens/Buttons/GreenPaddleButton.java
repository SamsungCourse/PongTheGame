package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.samsung.game.Boot;
import com.samsung.game.Screens.GameScreen;

public class GreenPaddleButton extends AbstractButtonBox{

    public static boolean isTouched = false;

    public GreenPaddleButton(float x, float y) {
        super(x, y);
        textureUntouched = new Texture("buttons/paddle_change/greenPaddle.png");
        textureTouched = new Texture("buttons/paddle_change/greenPaddleA.png");
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
