package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.GameObjects.Ball;
import com.samsung.game.GameObjects.Paddles.UIPaddle;
import com.samsung.game.HelperClasses.GameDifficulty;
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
        if (Boot.eng){
            textureUp = new Texture("buttons/setup/En/wallButtonU.png");
            textureDown = new Texture("buttons/setup/En/wallButtonD.png");
        }
        else{
            textureUp = new Texture("buttons/setup/Ru/wallButtonRuU.png");
            textureDown = new Texture("buttons/setup/Ru/wallButtonRuD.png");
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
                GameScreen.maxScore = 99;
                UIPaddle.type = ScreenTypePaddle.WALL_SCREEN;
                GameScreen.gameDifficulty = GameDifficulty.EASY;
                GameScreen gameScreen = new GameScreen(boot);
                Ball.SPEED = (int) adaptiveWidth((int) adaptiveHeight(48));
                Ball.incSpeed = 2;
                boot.setScreen(gameScreen);
            }
        }
    }
}
