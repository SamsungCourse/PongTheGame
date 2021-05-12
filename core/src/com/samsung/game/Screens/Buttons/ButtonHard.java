package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.Screens.GameScreen;

public class ButtonHard extends AbstractButton {

    GameScreen gameScreen;

    public ButtonHard(float x, float y, Boot boot) {
        super(x, y, boot);

        textureUp = new Texture("buttons/hardBtnD.png");
        textureDown = new Texture("buttons/hardBtn.png");
        gameScreen = new GameScreen(boot);
    }

    public void update(){
        if (isButtonTouched()){
            toSetScreen = true;
        }
        else {
            if (toSetScreen){
                gameScreen.getEnemy().speed = 50;
                boot.setScreen(gameScreen);
            }
        }
    }
}