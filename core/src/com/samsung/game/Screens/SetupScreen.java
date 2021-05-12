package com.samsung.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.samsung.game.Boot;
import com.samsung.game.Screens.Buttons.ButtonUI;
import com.sun.org.apache.xpath.internal.operations.Or;

import static com.samsung.game.HelperClasses.Constants.SCREEN_HEIGHT;
import static com.samsung.game.HelperClasses.Constants.SCREEN_WIDTH;

public class SetupScreen extends ScreenAdapter {//класс стартового экрана, я завтра займусь им

    private Texture background;

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private ButtonUI buttonUI;

    private World world;

    public SetupScreen(Boot boot){
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
        background = new Texture("backgrounds/introBg.png");
        batch = new SpriteBatch();
        world = new World(new Vector2(0,0), false);
        buttonUI = new ButtonUI(480, 1700, boot);
    }

    public void update(){
        world.step(1 / 60f, 6,2);

        camera.update();
        buttonUI.update();

        batch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void render(float delta){
        update();

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(background, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        buttonUI.render(batch);
        batch.end();
    }
}
