package com.samsung.game.GameObjects.Paddles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.HelperClasses.PaddleType;
import com.samsung.game.Screens.GameScreen;

import static com.samsung.game.HelperClasses.Constants.PADDLE_WIDTH;
import static com.samsung.game.HelperClasses.Constants.PIXELS_PER_METRE;

public class PlayerPaddle extends AbstractPaddle {

    public PaddleType paddleType;

    public PlayerPaddle(float x, float y, GameScreen gameScreen) {
        super(x, y, gameScreen);
        if (paddleType == PaddleType.WHITE){
            texture = new Texture("dot.png");
        }
        if (paddleType == PaddleType.RED){
            texture = new Texture("redDot.png");
            width = PADDLE_WIDTH*2;
        }
    }

    @Override
    public void update() {
        super.update();
        move();
    }

    private void move(){
        if(Gdx.input.isTouched()) {
            float bodyPosX = body.getPosition().x;
            float touchPosX = (Gdx.input.getX()) / PIXELS_PER_METRE;
            if (touchPosX > bodyPosX + 0.5) {
                velX = 1;
            }
            if (touchPosX < bodyPosX - 0.5) {
                velX = -1;
            }
        }
        body.setLinearVelocity(velX * speed, 0);
    }
}
