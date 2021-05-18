package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.GameObjects.Paddles.UIPaddle;
import com.samsung.game.HelperClasses.ScreenTypePaddle;
import com.samsung.game.Screens.GameScreen;

import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveHeight;
import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveWidth;

public class WallButton extends AbstractButton {

    public WallButton(float x, float y, Boot boot) {
        super(x, y, boot);
        height = (int) adaptiveHeight(300);
        width = (int) adaptiveWidth(1100);
        this.x = x - width/2f;
        this.y = y - height/2f;
        textureUp = new Texture("buttons/setup/wallButtonU.png");
        textureDown = new Texture("buttons/setup/wallButton.png");
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
                UIPaddle.type = ScreenTypePaddle.WALL_SCREEN;
                boot.setScreen(new GameScreen(boot));
            }
        }
    }
}
