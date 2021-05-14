package com.samsung.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;
import com.samsung.game.Boot;
import com.samsung.game.GameObjects.Paddles.PlayerPaddle;
import com.samsung.game.HelperClasses.PaddleType;
import com.samsung.game.Screens.Buttons.BluePaddleButton;
import com.samsung.game.Screens.Buttons.ExitButton;
import com.samsung.game.Screens.Buttons.GreenPaddleButton;
import com.samsung.game.Screens.Buttons.PaddleButton;
import com.samsung.game.Screens.Buttons.RedPaddleButton;

import static com.samsung.game.HelperClasses.Constants.BUTTON_HEIGHT;
import static com.samsung.game.HelperClasses.Constants.PADDLE_BUTTON_Y;
import static com.samsung.game.HelperClasses.Constants.SCREEN_HEIGHT;
import static com.samsung.game.HelperClasses.Constants.SCREEN_WIDTH;

public class PaddleChangeScreen extends ScreenAdapter {

    private Texture background;

    private OrthographicCamera camera;
    private SpriteBatch batch;

    public BluePaddleButton bluePaddleButton;
    public RedPaddleButton redPaddleButton;
    public PaddleButton paddleButton;
    public GreenPaddleButton greenPaddleButton;
    private ExitButton exitButton;
    public GameScreen gameScreen;

    private World world;

    public PaddleChangeScreen(Boot boot){
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
        camera.position.set(new Vector3(SCREEN_WIDTH/2f, SCREEN_HEIGHT/2f, 0));
        background = new Texture("backgrounds/paddleBg.png");
        batch = new SpriteBatch();
        world = new World(new Vector2(0,0), false);
        gameScreen = new GameScreen(boot);

        redPaddleButton = new RedPaddleButton(SCREEN_WIDTH/2f, PADDLE_BUTTON_Y, boot);
        bluePaddleButton = new BluePaddleButton(SCREEN_WIDTH/2f, PADDLE_BUTTON_Y - BUTTON_HEIGHT - 30, boot);
        greenPaddleButton = new GreenPaddleButton(SCREEN_WIDTH/2f, PADDLE_BUTTON_Y - 2*BUTTON_HEIGHT - 60, boot);
        paddleButton = new PaddleButton(SCREEN_WIDTH/2f, PADDLE_BUTTON_Y - 3*BUTTON_HEIGHT - 90, boot);
        exitButton = new ExitButton(SCREEN_WIDTH/2f, 550, boot);
    }

    public void update() throws InterruptedException {
        world.step(1 / 60f, 6,2);
        if (redPaddleButton.isButtonTouched()){
            gameScreen.player.paddleType = PaddleType.RED;
            redPaddleButton.isTouched = true;
            bluePaddleButton.isTouched = false;
            greenPaddleButton.isTouched = false;
            paddleButton.isTouched = false;
        }
        if (bluePaddleButton.isButtonTouched()){
            bluePaddleButton.isTouched = true;
            redPaddleButton.isTouched = false;
            greenPaddleButton.isTouched = false;
            paddleButton.isTouched = false;
        }
        if (paddleButton.isButtonTouched()){
            gameScreen.player.paddleType = PaddleType.WHITE;
            paddleButton.isTouched = true;
            bluePaddleButton.isTouched = false;
            redPaddleButton.isTouched = false;
            greenPaddleButton.isTouched = false;
        }
        if (greenPaddleButton.isButtonTouched()) {
            greenPaddleButton.isTouched = true;
            paddleButton.isTouched = false;
            bluePaddleButton.isTouched = false;
            redPaddleButton.isTouched = false;
        }
        camera.update();
        exitButton.update();

        batch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        try {
            update();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(background, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        redPaddleButton.render(batch);
        bluePaddleButton.render(batch);
        paddleButton.render(batch);
        greenPaddleButton.render(batch);
        exitButton.render(batch);
        batch.end();
    }
}
