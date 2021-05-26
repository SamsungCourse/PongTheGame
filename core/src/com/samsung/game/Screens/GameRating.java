package com.samsung.game.Screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.samsung.game.Boot;
import com.samsung.game.Screens.Buttons.ExitButton;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveHeight;
import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveWidth;
import static com.samsung.game.HelperClasses.Constants.NUMBERS_WIDTH;
import static com.samsung.game.HelperClasses.Constants.SCREEN_HEIGHT;
import static com.samsung.game.HelperClasses.Constants.SCREEN_WIDTH;

public class GameRating extends ScreenAdapter {
    Texture background;

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private ExitButton exitButton;
    private TextureRegion[] numbers;
    private int[] score;
    private String get;
    private String[] req;

    private World world;

    public GameRating(Boot boot){
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
        background = new Texture("backgrounds/rating.png");
        batch = new SpriteBatch();
        world = new World(new Vector2(0,0), false);
        exitButton = new ExitButton(SCREEN_WIDTH/2f, SCREEN_HEIGHT - adaptiveHeight(100), boot);
        numbers = loadTextureSprite("numbers.png", 10);
        score = new int[]{GameOverScreen.score, 21, 15, 6, 3, 0};

        String url = "https://pong-the-game.herokuapp.com/rating/get-top";

        try{
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            get = response.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        req = get.split("\"");
        for (int i = 0; i < req.length; i++) {
        }
    }
    public void update() throws InterruptedException {
        world.step(1 / 60f, 6,2);

        camera.update();
        exitButton.update();

        batch.setProjectionMatrix(camera.combined);
    }

    private TextureRegion[] loadTextureSprite(String filename, int columns){
        Texture texture = new Texture(filename);
        return TextureRegion.split(texture, texture.getWidth() / columns, texture.getHeight())[0];
    }

    private void drawNumbers(SpriteBatch batch, int number, float x, float y, float width, float height){
        if (number < 10){
            batch.draw(numbers[0], x - adaptiveWidth(70), y, width, height);
            batch.draw(numbers[number], x + adaptiveWidth(70), y, width, height);
        }
        else {
            batch.draw(numbers[Integer.parseInt((""+number).substring(0,1))], x - adaptiveWidth(70), y, width, height);
            batch.draw(numbers[Integer.parseInt((""+number).substring(1,2))], x + adaptiveWidth(70), y, width, height);
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        try {
            update();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        batch.begin();
        batch.draw(background, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        exitButton.render(batch);
        drawNumbers(batch, score[0], SCREEN_WIDTH / 2f - NUMBERS_WIDTH / 2f + adaptiveWidth(200), adaptiveHeight(400) / 2f, adaptiveWidth(150), adaptiveHeight(210));
        drawNumbers(batch, score[1], SCREEN_WIDTH / 2f - NUMBERS_WIDTH / 2f + adaptiveWidth(200), adaptiveHeight(730), adaptiveWidth(150), adaptiveHeight(210));
        drawNumbers(batch, score[2], SCREEN_WIDTH / 2f - NUMBERS_WIDTH / 2f + adaptiveWidth(200), adaptiveHeight(1030), adaptiveWidth(150), adaptiveHeight(210));
        drawNumbers(batch, score[3], SCREEN_WIDTH / 2f - NUMBERS_WIDTH / 2f + adaptiveWidth(200), 1330, adaptiveWidth(150), adaptiveHeight(210));
        drawNumbers(batch, score[4], SCREEN_WIDTH / 2f - NUMBERS_WIDTH / 2f + adaptiveWidth(200), 1630, adaptiveWidth(150), adaptiveHeight(210));
        drawNumbers(batch, score[5], SCREEN_WIDTH / 2f - NUMBERS_WIDTH / 2f + adaptiveWidth(200), 1930, adaptiveWidth(150), adaptiveHeight(210));
        batch.end();
    }
}