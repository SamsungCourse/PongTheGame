package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.samsung.game.Boot;

public class PaddleButton extends AbstractButtonBox {

    public static boolean isTouched = true;

    public PaddleButton(float x, float y, Boot boot) {
        super(x, y);
        textureUp = new Texture("buttons/paddle_change/paddle.png");
        textureDown = new Texture("buttons/paddle_change/paddleA.png");
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
