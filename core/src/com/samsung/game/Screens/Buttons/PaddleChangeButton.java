package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.Screens.PaddleChangeScreen;

import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveHeight;
import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveWidth;

public class PaddleChangeButton extends AbstractButton {

    public PaddleChangeButton(float x, float y, Boot boot) {
        super(x, y, boot);
        height = (int) adaptiveHeight(300);
        width = (int) adaptiveWidth(525);
        this.x = x - width/2f;
        this.y = y - height/2f;
        if (Boot.eng){
            textureUp = new Texture("buttons/setup/En/paddleButtonU.png");
            textureDown = new Texture("buttons/setup/En/paddleButtonD.png");
        }
        else {
            textureUp = new Texture("buttons/setup/Ru/paddleButtonRuU.png");
            textureDown = new Texture("buttons/setup/Ru/paddleButtonRuD.png");
        }
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
                boot.setScreen(new PaddleChangeScreen(boot));
            }
        }
    }
}