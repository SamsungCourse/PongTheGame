package com.samsung.game.GameObjects.Paddles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.GameObjects.Ball;
import com.samsung.game.HelperClasses.BodyCreator;
import com.samsung.game.HelperClasses.GameCollision;
import com.samsung.game.HelperClasses.PaddleType;
import com.samsung.game.Screens.GameScreen;

import static com.samsung.game.HelperClasses.Constants.PADDLE_SPEED;
import static com.samsung.game.HelperClasses.Constants.PADDLE_WIDTH;
import static com.samsung.game.HelperClasses.Constants.PIXELS_PER_METRE;

public class PlayerPaddle extends AbstractPaddle {

    public static PaddleType paddleType = PaddleType.WHITE;
    public static boolean isAccelerationMove = false;
    public static int angle = 0;

    public PlayerPaddle(float x, float y, GameScreen gameScreen) {
        super(x, y, gameScreen);
        if (paddleType == PaddleType.WHITE){
            texture = new Texture("dot.png");
        }
        if (paddleType == PaddleType.RED){
            texture = new Texture("redDot.png");
            speed = PADDLE_SPEED - 15;
            width = (int) (PADDLE_WIDTH*1.5);

        }
        if (paddleType == PaddleType.BLUE){
            texture = new Texture("blueDot.png");
            width = (int) (PADDLE_WIDTH*0.9);
            speed = PADDLE_SPEED + 10;
        }
        if (paddleType == PaddleType.GREEN){
            texture = new Texture("greenDot.png");
        }
        body = BodyCreator.createBody(x, y, width, height,false,1000000, gameScreen.getWorld(), contactType);
    }

    @Override
    public void update() {
        super.update();
        move();
    }

    private void move(){
        if (!isAccelerationMove || !available) {
            if (Gdx.input.isTouched()) {
                float bodyPosX = body.getPosition().x;
                float touchPosX = (Gdx.input.getX()) / PIXELS_PER_METRE;
                if (touchPosX > bodyPosX + 0.5) {
                    velX = 1;
                }
                if (touchPosX < bodyPosX - 0.5) {
                    velX = -1;
                }
            }
        }
        if (isAccelerationMove && available) {
            float accelX = Gdx.input.getAccelerometerX();
            System.out.println(accelX);
            if (accelX >= 1){
                velX = -1;
            }
            if (accelX <= -1){
                velX = 1;
            }
        }
        body.setLinearVelocity(velX * speed, 0);
    }
}
