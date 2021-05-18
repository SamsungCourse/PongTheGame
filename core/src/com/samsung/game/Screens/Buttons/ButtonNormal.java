package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.HelperClasses.Constants;
import com.samsung.game.Screens.GameScreen;

import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveHeight;

public class ButtonNormal extends AbstractButton {

    GameScreen gameScreen;

    public ButtonNormal(float x, float y, Boot boot) {
        super(x, y, boot);
        gameScreen = new GameScreen(boot);
        textureUp = new Texture("buttons/difficulty/normalBtn.png");
        textureDown = new Texture("buttons/difficulty/normalBtnD.png");
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
                gameScreen.getEnemy().speed = 50;
                boot.setScreen(gameScreen);
            }
        }
    }
}
