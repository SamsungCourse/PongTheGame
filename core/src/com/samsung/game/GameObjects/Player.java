package com.samsung.game.GameObjects;

import com.badlogic.gdx.Gdx;
import com.samsung.game.Screens.GameScreen;

import static com.samsung.game.HelperClasses.Constants.PPM;

public class Player extends PlayerPaddle {
    public Player(float x, float y, GameScreen gameScreen) {
        super(x, y, gameScreen);
    }

    @Override
    public void update() {
        super.update();
        if(Gdx.input.isTouched()) {
            float bodyPosX = body.getPosition().x;
            float touchPosX = (Gdx.input.getX()) / PPM;
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
