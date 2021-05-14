package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.Screens.PaddleChangeScreen;

public class PaddleChangeButton extends AbstractButton {

    public PaddleChangeButton(float x, float y, Boot boot) {
        super(x, y, boot);
        height = 300;
        width = 1000;
        this.x = x - 1000/2f;
        textureUp = new Texture("buttons/paddleButtonU.png");
        textureDown = new Texture("buttons/paddleButtonD.png");
    }

    public void update(){
        if (isButtonTouched()){
            toSetScreen = true;
        }
        else {
            if (toSetScreen){
                boot.setScreen(new PaddleChangeScreen(boot));
            }
        }
    }
}