package com.samsung.game.GameObjects.Paddles;

import com.badlogic.gdx.graphics.Texture;
import com.samsung.game.Boot;
import com.samsung.game.HelperClasses.AdaptiveMaker;
import com.samsung.game.HelperClasses.BodyCreator;
import com.samsung.game.HelperClasses.ContactType;
import com.samsung.game.HelperClasses.ScreenTypePaddle;
import com.samsung.game.Screens.GameScreen;
import com.samsung.game.Screens.SetupScreen;

import static com.samsung.game.HelperClasses.Constants.PIXELS_PER_METRE;
import static com.samsung.game.HelperClasses.Constants.SCREEN_HEIGHT;
import static com.samsung.game.HelperClasses.Constants.SCREEN_WIDTH;
import static com.samsung.game.HelperClasses.Constants.WALL_WIDTH;

public class UIPaddle extends AbstractPaddle {

    public static ScreenTypePaddle type = ScreenTypePaddle.GAME_SCREEN;
    public int speed;
    private float velY;
    private Boot boot;

    public UIPaddle(float x, float y, GameScreen gameScreen, Boot boot) {
        super(x, y, gameScreen);
        this.gameScreen = gameScreen;
        this.boot = boot;
        if (type == ScreenTypePaddle.WALL_SCREEN){
            this.width = SCREEN_WIDTH - WALL_WIDTH*2;
            this.height = (int) AdaptiveMaker.adaptiveHeight(64);
            this.y = y - height/2f;
        }
        texture = new Texture("dot.png");
        body = BodyCreator.createBody(x, y, width, height,false,1000000, gameScreen.getWorld(), ContactType.ENEMY);
    }

    @Override
    public void update() {
        super.update();
        if (type == ScreenTypePaddle.GAME_SCREEN){
            move();
        }
        if (type == ScreenTypePaddle.WALL_SCREEN){
            this.gameScreen.getBall().speed = 40;
            if(body.getPosition().y*PIXELS_PER_METRE > SCREEN_HEIGHT - 800){
                System.out.println(body.getPosition().y*PIXELS_PER_METRE + "  " + (SCREEN_HEIGHT - 800));
                velY = -0.5f;
            }
            else{
                boot.setScreen(new SetupScreen(boot));
            }
            body.setLinearVelocity(0, velY);
            velY = 0;
        }
    }
    public void move(){
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