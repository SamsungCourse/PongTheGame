package com.samsung.game.GameObjects.Paddles;

import com.badlogic.gdx.Gdx;
import com.samsung.game.Screens.GameScreen;

import static com.samsung.game.HelperClasses.Constants.PIXELS_PER_METRE;

public class StandartPlayerPaddle extends AbstractPaddle {
    public StandartPlayerPaddle(float x, float y, GameScreen gameScreen) {
        super(x, y, gameScreen);
    }

    @Override
    public void update() {
        super.update();
        if(Gdx.input.isTouched()) {
            float bodyPosX = body.getPosition().x;
            float touchPosX = (Gdx.input.getX()) / PIXELS_PER_METRE;
            if (touchPosX > bodyPosX + 1) {
                velX = 1;
            }
            if (touchPosX < bodyPosX - 1) {
                velX = -1;
            }
        }
        body.setLinearVelocity(velX * speed, 0);
    }
}
