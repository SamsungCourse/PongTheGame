package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.Screens.GameScreen;
import com.samsung.game.Screens.SetupScreen;

public class ButtonUI extends AbstractButton{

    boolean toSetScreen = false;
    OrthographicCamera camera;

    public ButtonUI(float x, float y, Boot boot) {
        super(x, y, boot);
        this.camera = camera;
        textureDown = new Texture("uiGameBtnU.png");
        textureUp = new Texture("uiGameBtnD.png");
    }
    public void update(){
        if (isButtonTouched()){
            toSetScreen = true;
        }
        else {
            if (toSetScreen){
                boot.setScreen(new GameScreen());
            }
        }
    }
}
