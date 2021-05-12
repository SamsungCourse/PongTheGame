package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.Screens.GameScreen;

public class ButtonNormal extends AbstractButton {

    GameScreen gameScreen;

    public ButtonNormal(float x, float y, Boot boot) {
        super(x, y, boot);

        gameScreen = new GameScreen(boot);
        textureDown = new Texture("buttons/normalBtn.png");
        textureUp = new Texture("buttons/normalBtn.png");
    }

    public void update(){
        if (isButtonTouched()){
            toSetScreen = true;
        }
        else {
            if (toSetScreen){
                gameScreen.getEnemy().speed = 35;
                boot.setScreen(gameScreen);
            }
        }
    }
}
