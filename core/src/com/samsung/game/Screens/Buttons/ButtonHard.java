package com.samsung.game.Screens.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.GameObjects.Ball;
import com.samsung.game.GameObjects.Paddles.UIPaddle;
import com.samsung.game.HelperClasses.Constants;
import com.samsung.game.HelperClasses.GameDifficulty;
import com.samsung.game.HelperClasses.ScreenTypePaddle;
import com.samsung.game.Screens.GameScreen;

import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveHeight;
import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveWidth;

public class ButtonHard extends AbstractButton {

    GameScreen gameScreen;

    public ButtonHard(float x, float y, Boot boot) {
        super(x, y, boot);
        textureDown = new Texture("buttons/difficulty/En/hardBtnD.png");
        textureUp = new Texture("buttons/difficulty/En/hardBtn.png");
    }

    public void update(){
        if (isButtonTouched()){
            toSetScreen = true;
        }
        else {
            if (toSetScreen){
                if (Boot.volume){
                    touch.play();
                }
                UIPaddle.type = ScreenTypePaddle.GAME_SCREEN;
                gameScreen = new GameScreen(boot);
                GameScreen.maxScore = 10;
                Ball.incSpeed = 8;
                Ball.SPEED = (int) adaptiveWidth((int) adaptiveHeight(48));
                gameScreen.getEnemy().speed = 40;
                GameScreen.gameDifficulty = GameDifficulty.HARD;
                boot.setScreen(gameScreen);
            }
        }
    }
}
