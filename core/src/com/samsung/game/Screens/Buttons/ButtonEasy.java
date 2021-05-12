package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.Screens.GameScreen;

public class ButtonEasy extends AbstractButton {

    public ButtonEasy(float x, float y, Boot boot) {
        super(x, y, boot);
        textureUp = new Texture("buttons/easyBtnD.png");
        textureDown = new Texture("buttons/easyBtn.png");
    }
    public void update(){
        if (isButtonTouched()){
            toSetScreen = true;
        }
        else {
            if (toSetScreen){
                System.out.println("BRUH");
                boot.setScreen(new GameScreen(boot));
            }
        }
    }
}
