package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.Screens.GameScreen;

public class AcceleratorButton extends AbstractButtonBox{

    GameScreen gameScreen = new GameScreen(boot);

    public AcceleratorButton(float x, float y, Boot boot) {
        super(x, y, boot);
        textureUntouched = new Texture("buttons/acileratorButton.png");
        textureTouched = new Texture("buttons/acileratorButton.png");
        gameScreen = new GameScreen(boot);
    }
}
