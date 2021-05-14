package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.Screens.GameScreen;

public class GreenPaddleButton extends AbstractButtonBox{

    GameScreen gameScreen;

    public GreenPaddleButton(float x, float y, Boot boot) {
        super(x, y, boot);
        textureUntouched = new Texture("buttons/greenPaddle.png");
        textureTouched = new Texture("buttons/greenPaddleA.png");
        gameScreen = new GameScreen(boot);
    }
}
