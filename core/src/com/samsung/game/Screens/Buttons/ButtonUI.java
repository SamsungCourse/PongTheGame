package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.Screens.SetDifficultyScreen;

public class ButtonUI extends AbstractButton{

    public ButtonUI(float x, float y, Boot boot) {
        super(x, y, boot);
        height = 300;
        width = 1000;
        this.x = x - 1000/2f;
        textureUp = new Texture("buttons/UIButtonU.png");
        textureDown = new Texture("buttons/UIButtonD.png");
    }

    public void update(){
        if (isButtonTouched()){
            toSetScreen = true;
        }
        else {
            if (toSetScreen){
                boot.setScreen(new SetDifficultyScreen(boot));
            }
        }
    }
}