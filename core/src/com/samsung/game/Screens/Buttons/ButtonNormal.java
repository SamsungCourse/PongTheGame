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

public class ButtonNormal extends AbstractButton {

    GameScreen gameScreen;

    public ButtonNormal(float x, float y, Boot boot) {
        super(x, y, boot);
        gameScreen = new GameScreen(boot);
        if (Boot.eng){
            textureUp = new Texture("buttons/difficulty/En/normalBtn.png");
            textureDown = new Texture("buttons/difficulty/En/normalBtnD.png");
        }
        else {
            textureUp = new Texture("buttons/difficulty/Ru/normalBtnRu.png");
            textureDown = new Texture("buttons/difficulty/Ru/normalBtnRuD.png");
        }
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
                Ball.incSpeed = (int) adaptiveWidth((int) adaptiveHeight(22));
                Ball.SPEED = (int) adaptiveWidth((int) adaptiveHeight(38));
                gameScreen.getEnemy().speed = (int) adaptiveWidth(36);
                GameScreen.gameDifficulty = GameDifficulty.NORMAL;
                boot.setScreen(gameScreen);
            }
        }
    }
}
