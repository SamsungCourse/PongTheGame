package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.HelperClasses.Constants;
import com.samsung.game.Screens.GameScreen;

import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveHeight;

public class ButtonHard extends AbstractButton {

    GameScreen gameScreen;

    public ButtonHard(float x, float y, Boot boot) {
        super(x, y, boot);
        textureDown = new Texture("buttons/difficulty/hardBtnD.png");
        textureUp = new Texture("buttons/difficulty/hardBtn.png");
        gameScreen = new GameScreen(boot);
    }

    public void update(){
        if (isButtonTouched()){
            toSetScreen = true;
        }
        else {
            if (toSetScreen){
                if (Boot.volume){
                    touch.play();
                }
                gameScreen.getEnemy().speed = 60;
                boot.setScreen(gameScreen);
            }
        }
    }
}
