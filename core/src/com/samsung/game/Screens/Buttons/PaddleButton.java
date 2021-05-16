package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.Screens.GameScreen;

public class PaddleButton extends AbstractButtonBox {

    public PaddleButton(float x, float y, Boot boot) {
        super(x, y);
        textureUntouched = new Texture("buttons/paddle_change/paddle.png");
        textureTouched = new Texture("buttons/paddle_change/paddleA.png");
        isTouched = true;
    }
}
