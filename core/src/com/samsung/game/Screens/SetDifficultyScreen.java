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

import static com.samsung.game.HelperClasses.Constants.BUTTON_HEIGHT;
import static com.samsung.game.HelperClasses.Constants.SCREEN_HEIGHT;
import static com.samsung.game.HelperClasses.Constants.SCREEN_WIDTH;

public class SetDifficultyScreen extends ScreenAdapter {

    private Texture background;

    private OrthographicCamera camera;
    private SpriteBatch batch;

    private ButtonHard buttonHard;
    private ButtonEasy buttonEasy;
    private ButtonNormal buttonNormal;

    private World world;

    public SetDifficultyScreen(Boot boot){
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
        camera.position.set(new Vector3(SCREEN_WIDTH/2f, SCREEN_HEIGHT/2f, 0));
        background = new Texture("backgrounds/difficultyBg.png");
        batch = new SpriteBatch();
        world = new World(new Vector2(0,0), false);
    }

    public void update(){
        world.step(1 / 60f, 6,2);

        camera.update();

        batch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(background, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        batch.end();
    }
}
