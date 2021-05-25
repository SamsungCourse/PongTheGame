package com.samsung.game.Screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.samsung.game.Boot;
import com.samsung.game.HelperClasses.GameDifficulty;
import com.samsung.game.Screens.Buttons.AcceleratorButton;
import com.samsung.game.Screens.Buttons.ExitButton;
import com.samsung.game.Screens.Buttons.VolumeButton;

import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveHeight;
import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveWidth;
import static com.samsung.game.HelperClasses.Constants.NUMBERS_HEIGHT;
import static com.samsung.game.HelperClasses.Constants.NUMBERS_WIDTH;
import static com.samsung.game.HelperClasses.Constants.NUMBER_SPACE;
import static com.samsung.game.HelperClasses.Constants.SCORE_SPACE;
import static com.samsung.game.HelperClasses.Constants.SCREEN_HEIGHT;
import static com.samsung.game.HelperClasses.Constants.SCREEN_WIDTH;

public class GameOverScreen extends ScreenAdapter {

    Texture background;

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private ExitButton exitButton;
    private int score;
    private short mlt = 1;

    private World world;

    private GameScreen gameScreen;

    private TextureRegion[] numbers;

    public GameOverScreen(GameScreen gameScreen, Boot boot){
        this.gameScreen = gameScreen;
        if (Boot.eng){
            background = new Texture("backgrounds/En/game_over.png");
        }
        else {
            background = new Texture("backgrounds/Ru/game_overRu.png");
        }
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
        batch = new SpriteBatch();
        world = new World(new Vector2(0,0), false);

        exitButton = new ExitButton(SCREEN_WIDTH/2f, adaptiveHeight(600), boot);
        numbers = loadTextureSprite("numbers.png", 10);

        if (GameScreen.gameDifficulty == GameDifficulty.EASY) mlt = 1;
        if (GameScreen.gameDifficulty == GameDifficulty.NORMAL) mlt = 2;
        if (GameScreen.gameDifficulty == GameDifficulty.HARD) mlt = 3;

        score = Math.max(gameScreen.getPlayer().getScore() - gameScreen.getEnemy().getScore(), 0) * mlt;
    }

    private TextureRegion[] loadTextureSprite(String filename, int columns){
        Texture texture = new Texture(filename);
        return TextureRegion.split(texture, texture.getWidth() / columns, texture.getHeight())[0];
    }

    private void drawNumbers(SpriteBatch batch, int number, float x, float y, float width, float height){
        if (number < 10){
            batch.draw(numbers[0], x - adaptiveWidth(150), y, width, height);
            batch.draw(numbers[number], x + adaptiveWidth(150), y, width, height);
        }
        else {
            batch.draw(numbers[Integer.parseInt((""+number).substring(0,1))], x - adaptiveWidth(150), y, width, height);
            batch.draw(numbers[Integer.parseInt((""+number).substring(1,2))], x + adaptiveWidth(150), y, width, height);
        }
    }

    public void update(){
        world.step(1 / 60f, 6,2);

        camera.update();
        exitButton.update();

        batch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();

        batch.begin();
        batch.draw(background, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        exitButton.render(batch);
        drawNumbers(batch, score, SCREEN_WIDTH / 2f - adaptiveWidth(150), SCREEN_HEIGHT / 2f - adaptiveHeight(210),adaptiveHeight(300), adaptiveHeight(420));
        batch.end();
    }
}
