package com.samsung.game.GameObjects;

import com.samsung.game.Screens.GameScreen;

import static com.samsung.game.HelperClasses.Constants.PIXELS_PER_METRE;

public class EnemyUI extends PlayerPaddle {//интеллект врага предельно простой, он просто следует иксу мяча, в будущем я улучшу его пуская фантомный мяч, чтобы узнать, куда он реземлится и туда направлю платформу

    public EnemyUI(float x, float y, GameScreen gameScreen) {
        super(x, y, gameScreen);
    }

    @Override
    public void update() {
        super.update();
        float ballX = (gameScreen.getBall().x)/ PIXELS_PER_METRE;
        float bodyPosX = body.getPosition().x;
        if (ballX > bodyPosX + 0.5f) {
            velX = 1;
        }
        if (ballX < bodyPosX - 0.5f) {
            velX = -1;
        }
        body.setLinearVelocity(velX * speed,0);
    }
}