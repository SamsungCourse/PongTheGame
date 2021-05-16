package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.Screens.SetDifficultyScreen;

public class ButtonUI extends AbstractButton{

    public ButtonUI(float x, float y, Boot boot) {
        super(x, y, boot);
        height = 300;
        width = 1100;
        this.x = x - width/2f;
        this.y = y - height/2f;
        textureUp = new Texture("buttons/setup/UIButtonU.png");
        textureDown = new Texture("buttons/setup/UIButtonD.png");
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