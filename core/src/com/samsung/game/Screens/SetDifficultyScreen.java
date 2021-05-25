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
import com.samsung.game.HelperClasses.Constants;
import com.samsung.game.Screens.Buttons.ButtonEasy;
import com.samsung.game.Screens.Buttons.ButtonHard;
import com.samsung.game.Screens.Buttons.ButtonNormal;
import com.samsung.game.Screens.Buttons.ExitButton;

import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveHeight;
import static com.samsung.game.HelperClasses.Constants.BUTTON_HEIGHT;
import static com.samsung.game.HelperClasses.Constants.DIFFICULTY_BUTTON_Y;
import static com.samsung.game.HelperClasses.Constants.SCREEN_HEIGHT;
import static com.samsung.game.HelperClasses.Constants.SCREEN_WIDTH;

public class SetDifficultyScreen extends ScreenAdapter {

    private Texture background;

    private OrthographicCamera camera;
    private SpriteBatch batch;

    private ButtonHard buttonHard;
    private ButtonEasy buttonEasy;
    private ButtonNormal buttonNormal;
    public ExitButton exitButton;

    private World world;

    public SetDifficultyScreen(Boot boot){
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
        camera.position.set(new Vector3(SCREEN_WIDTH/2f, SCREEN_HEIGHT/2f, 0));
        if (Boot.eng){
            background = new Texture("backgrounds/En/difficultyBg.png");
        }
        else {
            background = new Texture("backgrounds/Ru/difficultyBgRu.png");
        }
        batch = new SpriteBatch();
        world = new World(new Vector2(0,0), false);
        buttonEasy = new ButtonEasy(SCREEN_WIDTH/2f, DIFFICULTY_BUTTON_Y, boot);
        buttonNormal = new ButtonNormal(SCREEN_WIDTH/2f, DIFFICULTY_BUTTON_Y - BUTTON_HEIGHT - 30, boot);
        buttonHard = new ButtonHard(SCREEN_WIDTH/2f, DIFFICULTY_BUTTON_Y - 2*BUTTON_HEIGHT - 60, boot);
        exitButton = new ExitButton(SCREEN_WIDTH/2f, adaptiveHeight(700), boot);
    }

    public void update() throws InterruptedException {
        world.step(1 / 60f, 6,2);

        camera.update();
        buttonEasy.update();
        buttonNormal.update();
        buttonHard.update();
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
        buttonEasy.render(batch);
        buttonNormal.render(batch);
        buttonHard.render(batch);
        exitButton.render(batch);
        batch.end();
    }
}
