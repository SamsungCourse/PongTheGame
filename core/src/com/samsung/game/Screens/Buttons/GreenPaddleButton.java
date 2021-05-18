package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.Screens.GameScreen;

public class GreenPaddleButton extends AbstractButtonBox{

    public GreenPaddleButton(float x, float y) {
        super(x, y);
        textureUntouched = new Texture("buttons/paddle_change/greenPaddle.png");
        textureTouched = new Texture("buttons/paddle_change/greenPaddleA.png");
    }
}
