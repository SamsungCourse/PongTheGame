package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.Screens.SetDifficultyScreen;

import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveHeight;
import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveWidth;
import static com.samsung.game.HelperClasses.Constants.SCREEN_HEIGHT;
import static com.samsung.game.HelperClasses.Constants.SCREEN_WIDTH;

public class ButtonUI extends AbstractButton{

    public ButtonUI(float x, float y, Boot boot) {
        super(x, y, boot);
        height = (int) adaptiveHeight(300);
        width = (int) adaptiveWidth(1100);
        this.x = x - width/2f;
        this.y = y - height/2f;
        textureUp = new Texture("buttons/setup/UIButtonU.png");
        textureDown = new Texture("buttons/setup/UIButtonD.png");
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
                boot.setScreen(new SetDifficultyScreen(boot));
            }
        }
    }
}