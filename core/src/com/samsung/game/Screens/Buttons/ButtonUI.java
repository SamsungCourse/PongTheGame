package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.Screens.GameScreen;
import com.samsung.game.Screens.SetDifficultyScreen;

public class ButtonUI extends AbstractButton{

    OrthographicCamera camera;

    public ButtonUI(float x, float y, Boot boot) {
        super(x, y, boot);
        width = 1000;
        height = 300;
        textureDown = new Texture("buttons/UIButtonU.png");
        textureUp = new Texture("buttons/UIButtonD.png");
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