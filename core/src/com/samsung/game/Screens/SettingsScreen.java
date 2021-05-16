package com.samsung.game.Screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.samsung.game.Screens.Buttons.AcceleratorButtonOff;
import com.samsung.game.Screens.Buttons.AcceleratorButtonOn;
import com.samsung.game.Screens.Buttons.ButtonUI;
import com.samsung.game.Screens.Buttons.PaddleChangeButton;

import static com.samsung.game.HelperClasses.Constants.SCREEN_HEIGHT;
import static com.samsung.game.HelperClasses.Constants.SCREEN_WIDTH;

public class SettingsScreen extends ScreenAdapter {
    Texture background;

    private OrthographicCamera camera;
    private SpriteBatch batch;
    AcceleratorButtonOff acceleratorButtonOff;
    AcceleratorButtonOn acceleratorButtonOn;

    private World world;

    public SettingsScreen(){
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
        background = new Texture("backgrounds/settingsBg.png");
        batch = new SpriteBatch();
        world = new World(new Vector2(0,0), false);
        acceleratorButtonOff = new AcceleratorButtonOff(SCREEN_WIDTH/2f, 500);
        acceleratorButtonOn = new AcceleratorButtonOn(SCREEN_WIDTH/2f + 300, 500);
    }
    public void update(){
        world.step(1 / 60f, 6,2);

        camera.update();
        acceleratorButtonOn.update();

        batch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        batch.begin();
        batch.draw(background, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        acceleratorButtonOn.render(batch);
        acceleratorButtonOff.render(batch);
        batch.end();
    }
}
