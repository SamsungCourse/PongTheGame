package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.Screens.SetupScreen;

public class ExitButton extends AbstractButton{

    public ExitButton(float x, float y, Boot boot) {
        super(x, y, boot);
        textureUp = new Texture("buttons/exitBtn.png");
        textureDown = new Texture("buttons/exitBtnD.png");
    }
    public void update(){
        if (isButtonTouched()){
            if (toSoundPlay){
                if (Boot.volume){
                    touch.play();
                }
                toSoundPlay = false;
            }
            toSetScreen = true;
        }
        else {
            if (toSetScreen){
                boot.setScreen(new SetupScreen(boot));
            }
        }
    }
}
