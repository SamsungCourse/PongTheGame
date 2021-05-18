package com.samsung.game.Screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.samsung.game.Boot;
import com.samsung.game.Screens.Buttons.AcceleratorButton;
import com.samsung.game.Screens.Buttons.ExitButton;
import com.samsung.game.Screens.Buttons.VolumeButton;

import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveHeight;
import static com.samsung.game.HelperClasses.Constants.SCREEN_HEIGHT;
import static com.samsung.game.HelperClasses.Constants.SCREEN_WIDTH;

public class SettingsScreen extends ScreenAdapter {
    Texture background;

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private AcceleratorButton acceleratorButton;
    private VolumeButton volumeButton;
    private ExitButton exitButton;

    private World world;

    public SettingsScreen(Boot boot){
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
        background = new Texture("backgrounds/settingsBg.png");
        batch = new SpriteBatch();
        world = new World(new Vector2(0,0), false);
        acceleratorButton = new AcceleratorButton(SCREEN_WIDTH/2f, adaptiveHeight(1000));
        volumeButton = new VolumeButton(SCREEN_WIDTH/2f, adaptiveHeight(1400));
        exitButton = new ExitButton(SCREEN_WIDTH/2f, adaptiveHeight(600), boot);
    }
    public void update() throws InterruptedException {
        world.step(1 / 60f, 6,2);

        camera.update();
        acceleratorButton.update();
        volumeButton.update();
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

        batch.begin();
        batch.draw(background, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        acceleratorButton.render(batch);
        volumeButton.render(batch);
        exitButton.render(batch);
        batch.end();
    }
}
