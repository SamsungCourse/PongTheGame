package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.GameObjects.Paddles.PlayerPaddle;
import com.samsung.game.Screens.GameScreen;

import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveHeight;
import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveWidth;

public class AcceleratorButton extends AbstractButtonBox {

    public AcceleratorButton(float x, float y) {
        super(x, y);
        width = (int) adaptiveWidth(1000);
        height = (int) adaptiveHeight(250);
        this.x = x - width / 2f;
        this.y = y - height / 2f;
        textureUntouched = new Texture("buttons/settings/accelerometerOff.png");
        textureTouched = new Texture("buttons/settings/accelerometerOn.png");
    }
    public void update() throws InterruptedException {
        if (isButtonTouched() && !isTouched){
            isTouched = true;
            PlayerPaddle.isAccelerationMove = true;
            Thread.sleep(100);
        }
        if (isButtonTouched() && isTouched){
            isTouched = false;
            PlayerPaddle.isAccelerationMove = false;
            Thread.sleep(100);
        }
    }
}
