package com.samsung.game.GameObjects.Paddles;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.HelperClasses.ContactType;
import com.samsung.game.Screens.GameScreen;

public class GreenPlayerPaddle extends StandartPlayerPaddle{
    public GreenPlayerPaddle(float x, float y, GameScreen gameScreen) {
        super(x, y, gameScreen);
        contactType = ContactType.GREEN;
        texture = new Texture("greenDot.png");
    }
}
