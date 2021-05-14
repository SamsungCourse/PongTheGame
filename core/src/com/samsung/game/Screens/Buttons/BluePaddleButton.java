package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.Screens.GameScreen;

public class BluePaddleButton extends AbstractButtonBox{

    GameScreen gameScreen;

    public BluePaddleButton(float x, float y, Boot boot) {
        super(x, y, boot);
        textureUntouched = new Texture("buttons/bluePaddle.png");
        textureTouched = new Texture("buttons/bluePaddleA.png");
        gameScreen = new GameScreen(boot);
    }
}
