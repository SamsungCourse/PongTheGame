package com.samsung.game.GameObjects.Paddles;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.HelperClasses.ContactType;
import com.samsung.game.Screens.GameScreen;

public class BluePlayerPaddle extends StandartPlayerPaddle {
    public BluePlayerPaddle(float x, float y, GameScreen gameScreen) {
        super(x, y, gameScreen);
        texture = new Texture("blueDot.png");
        contactType = ContactType.BLUE;
    }
}
