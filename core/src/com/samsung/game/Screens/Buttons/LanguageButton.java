package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.samsung.game.Boot;

import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveHeight;
import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveWidth;

public class LanguageButton extends AbstractButtonBox{

    public static boolean isTouched = false;

    public LanguageButton(float x, float y) {
        super(x, y);
        width = (int) adaptiveWidth(250);
        height = (int) adaptiveHeight(250);
        this.x = x - width / 2f;
        this.y = y - height / 2f;
        textureUp = new Texture("buttons/setup/En.png");
        textureDown = new Texture("buttons/setup/Ru.png");
    }
    public void update() throws InterruptedException {
        if (isButtonTouched() && !isTouched){
            isTouched = true;
            Boot.eng = true;
            Thread.sleep(100);
        }
        if (isButtonTouched() && isTouched){
            isTouched = false;
            Boot.eng = false;
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
