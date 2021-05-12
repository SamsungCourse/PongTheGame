package com.samsung.game.GameObjects.Paddles;

import com.samsung.game.Screens.GameScreen;

import static com.samsung.game.HelperClasses.Constants.PIXELS_PER_METRE;

public class UIPaddle extends AbstractPaddle {

    public int speed;
    public UIPaddle(float x, float y, GameScreen gameScreen) {
        super(x, y, gameScreen);
    }

    @Override
    public void update() {
        super.update();
        float ballX = (gameScreen.getBall().x)/ PIXELS_PER_METRE;
        float bodyPosX = body.getPosition().x;
        if (ballX > bodyPosX + 0.1f) {
            velX = 1;
        }
        if (ballX < bodyPosX - 0.1f) {
            velX = -1;
        }
        body.setLinearVelocity(velX * speed,0);
    }
}