package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.Screens.GameScreen;

public class ButtonEasy extends AbstractButton {

    GameScreen gameScreen;

    public ButtonEasy(float x, float y, Boot boot) {
        super(x, y, boot);
        textureDown = new Texture("buttons/difficulty/easyBtnD.png");
        textureUp = new Texture("buttons/difficulty/easyBtn.png");
        gameScreen = new GameScreen(boot);
    }

    public void update(){
        if (isButtonTouched()){
            toSetScreen = true;
        }
        else {
            if (toSetScreen){
                gameScreen.getEnemy().speed = 30;
                boot.setScreen(gameScreen);
            }
        }
    }
}
