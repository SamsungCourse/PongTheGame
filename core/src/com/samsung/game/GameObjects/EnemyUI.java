package com.samsung.game.GameObjects;

import com.samsung.game.screens.GameScreen;

public class EnemyUI extends PlayerPaddle{//интеллект врага предельно простой, он просто следует иксу мяча, в будущем я улучшу его пуская фантомный мяч, чтобы узнать, куда он реземлится и туда направлю платформу
    public EnemyUI(float x, float y, GameScreen gameScreen) {
        super(x, y, gameScreen);
    }

    @Override
    public void update() {
        super.update();
        Ball ball = gameScreen.getBall();
        if (ball.x + 10 > x && ball.x - 10 > x){
            velX = 1;
        }
        if (ball.x + 10 < x && ball.x - 10 < x){
            velX = -1;
        }
        body.setLinearVelocity(velX*speed, 0);
    }
}
