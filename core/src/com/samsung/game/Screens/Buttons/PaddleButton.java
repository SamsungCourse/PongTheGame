package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.Screens.GameScreen;

public class PaddleButton extends AbstractButtonBox {

    GameScreen gameScreen;

    public PaddleButton(float x, float y, Boot boot) {
        super(x, y, boot);
        isTouched = true;
        textureUntouched = new Texture("buttons/paddle.png");
        textureTouched = new Texture("buttons/paddleA.png");
        gameScreen = new GameScreen(boot);
    }
}
