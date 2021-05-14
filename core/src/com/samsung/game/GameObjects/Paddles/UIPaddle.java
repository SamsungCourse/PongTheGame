package com.samsung.game.GameObjects.Paddles;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.HelperClasses.BodyCreator;
import com.samsung.game.Screens.GameScreen;

import static com.samsung.game.HelperClasses.Constants.PIXELS_PER_METRE;

public class UIPaddle extends AbstractPaddle {

    public int speed;
    public UIPaddle(float x, float y, GameScreen gameScreen) {
        super(x, y, gameScreen);
        texture = new Texture("dot.png");
        body = BodyCreator.createBody(x, y, width, height,false,1000000, gameScreen.getWorld(), contactType);
    }

    @Override
    public void update() {
        super.update();
        float ballX = (gameScreen.getBall().x)/ PIXELS_PER_METRE;
        float bodyPosX = body.getPosition().x;
        if (ballX > bodyPosX + 1f) {
            velX = 1;
        }
        else if (ballX < bodyPosX + 1f && ballX > bodyPosX) velX = 0.2f;
        if (ballX < bodyPosX - 1f) {
            velX = -1;
        }
        else if (ballX > bodyPosX - 1f && ballX < bodyPosX) velX = -0.2f;
        body.setLinearVelocity(velX * speed,0);
    }
}