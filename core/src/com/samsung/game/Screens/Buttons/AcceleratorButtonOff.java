package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.GameObjects.Paddles.PlayerPaddle;

public class AcceleratorButtonOff extends AbstractButtonBox{
    public AcceleratorButtonOff(float x, float y) {
        super(x, y);
        width = 300;
        height = 300;
        this.x = x - width/2f;
        this.y = y - height/2f;
        textureUntouched = new Texture("buttons/settings/acileratorBtnOff.png");
        textureTouched = new Texture("buttons/settings/acileratorBtnOffA.png");
    }
}
