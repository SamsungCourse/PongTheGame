package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.Screens.GameScreen;

public class RedPaddleButton extends AbstractButtonBox{

    GameScreen gameScreen;

    public RedPaddleButton(float x, float y, Boot boot) {
        super(x, y, boot);
        textureUntouched = new Texture("buttons/redPaddle.png");
        textureTouched = new Texture("buttons/redPaddleA.png");
        gameScreen = new GameScreen(boot);
    }
}
