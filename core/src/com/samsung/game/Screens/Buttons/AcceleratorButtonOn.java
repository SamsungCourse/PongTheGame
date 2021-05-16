package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.GameObjects.Paddles.PlayerPaddle;
import com.samsung.game.Screens.GameScreen;

public class AcceleratorButtonOn extends AbstractButtonBox {

    public AcceleratorButtonOn(float x, float y) {
        super(x, y);
        width = 300;
        height = 300;
        this.x = x - width / 2f;
        this.y = y - height / 2f;
        textureUntouched = new Texture("buttons/settings/acileratorBtnOnA.png");
        textureTouched = new Texture("buttons/settings/acileratorBtnOn.png");
    }
    public void update(){
        PlayerPaddle.isAccelerationMove = isTouched;
    }
}
