package com.samsung.game.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.samsung.game.screens.GameScreen;

import static com.samsung.game.helperClasses.Constants.PPM;
import static com.samsung.game.helperClasses.Constants.SCREEN_WIDTH;

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
