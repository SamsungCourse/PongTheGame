package com.samsung.game.GameObjects.Paddles;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.HelperClasses.ContactType;
import com.samsung.game.Screens.GameScreen;

public class RedPlayerPaddle extends StandartPlayerPaddle{
    public RedPlayerPaddle(float x, float y, GameScreen gameScreen) {
        super(x, y, gameScreen);
        texture = new Texture("redDot.png");
        contactType = ContactType.RED;
    }
}
