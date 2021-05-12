package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.Screens.GameScreen;

public class ButtonUI extends AbstractButton{

    OrthographicCamera camera;

    public ButtonUI(float x, float y, Boot boot) {
        super(x, y, boot);
        textureDown = new Texture("buttons/uiGameBtnU.png");
        textureUp = new Texture("buttons/uiGameBtnD.png");
    }
    public void update(){
        if (isButtonTouched()){
            toSetScreen = true;
        }
        else {
            if (toSetScreen){
                boot.setScreen(new GameScreen(boot));
            }
        }
    }
}