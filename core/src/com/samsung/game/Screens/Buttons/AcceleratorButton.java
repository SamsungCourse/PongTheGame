package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.samsung.game.Boot;
import com.samsung.game.GameObjects.Paddles.PlayerPaddle;

import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveHeight;
import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveWidth;

public class AcceleratorButton extends AbstractButtonBox {

    public static boolean isTouched = false;

    public AcceleratorButton(float x, float y) {
        super(x, y);
        width = (int) adaptiveWidth(1000);
        height = (int) adaptiveHeight(250);
        this.x = x - width / 2f;
        this.y = y - height / 2f;
        if (Boot.eng){
            textureUp = new Texture("buttons/settings/En/accelerometerOff.png");
            textureDown = new Texture("buttons/settings/En/accelerometerOn.png");
        }
        else {
            textureUp = new Texture("buttons/settings/Ru/accelerometerOffRu.png");
            textureDown = new Texture("buttons/settings/Ru/accelerometerOnRu.png");
        }
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
    public void render(SpriteBatch batch) {
        if (isTouched) {
            batch.draw(textureDown, x, y, width, height);
        }
        if (!isTouched) {
            batch.draw(textureUp, x, y, width, height);
        }
    }
}
