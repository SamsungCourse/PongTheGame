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
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.samsung.game.Boot;
import com.samsung.game.GameObjects.Ball;
import com.samsung.game.GameObjects.Paddles.BluePlayerPaddle;
import com.samsung.game.GameObjects.Paddles.GreenPlayerPaddle;
import com.samsung.game.GameObjects.Paddles.RedPlayerPaddle;
import com.samsung.game.GameObjects.Paddles.UIPaddle;
import com.samsung.game.GameObjects.Paddles.StandartPlayerPaddle;
import com.samsung.game.GameObjects.Wall;
import com.samsung.game.HelperClasses.Constants;
import com.samsung.game.HelperClasses.GameCollision;
import com.samsung.game.Screens.Buttons.ButtonUI;

import static com.samsung.game.HelperClasses.Constants.NUMBERS_HEIGHT;
import static com.samsung.game.HelperClasses.Constants.NUMBERS_WIDTH;
import static com.samsung.game.HelperClasses.Constants.NUMBER_SPACE;
import static com.samsung.game.HelperClasses.Constants.PLAYER_Y;
import static com.samsung.game.HelperClasses.Constants.PIXELS_PER_METRE;
import static com.samsung.game.HelperClasses.Constants.SCORE_SPACE;
import static com.samsung.game.HelperClasses.Constants.SCREEN_HEIGHT;
import static com.samsung.game.HelperClasses.Constants.SCREEN_WIDTH;
import static com.samsung.game.HelperClasses.Constants.WALL_WIDTH;

public class GameScreen extends ScreenAdapter {//игровой экран, вызывается сетап скрином с нужными конфигурациями

    public OrthographicCamera camera;
    private SpriteBatch batch;
    private World world;
    private GameCollision gameCollision;

    //игровые обьекты
    private StandartPlayerPaddle player;
    private BluePlayerPaddle bluePlayer;
    private RedPlayerPaddle redPlayer;
    private GreenPlayerPaddle greenPlayer;
    private Ball ball;
    private Wall leftWall, rightWall;
    private UIPaddle enemy;

    private TextureRegion[] numbers;

    public OrthographicCamera getCamera() {
        return camera;
    }

    public GameScreen(Boot boot){
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
        camera.position.set(new Vector3(SCREEN_WIDTH / 2, Constants.SCREEN_HEIGHT / 2, 0));

        batch = new SpriteBatch();
        world = new World(new Vector2(0,0), false);
        gameCollision = new GameCollision(this);
        world.setContactListener(gameCollision);
        //все падлы
        player = new StandartPlayerPaddle(SCREEN_WIDTH/2f, PLAYER_Y, this);
        enemy = new UIPaddle(SCREEN_WIDTH/2f, SCREEN_HEIGHT - PLAYER_Y, this);
        bluePlayer = new BluePlayerPaddle(SCREEN_WIDTH/2f, PLAYER_Y, this);
        redPlayer = new RedPlayerPaddle(SCREEN_WIDTH/2f, PLAYER_Y, this);
        greenPlayer = new GreenPlayerPaddle(SCREEN_WIDTH/2f, PLAYER_Y, this);

        ball = new Ball(this);

        leftWall = new Wall(WALL_WIDTH/2f, this);
        rightWall = new Wall(SCREEN_WIDTH - WALL_WIDTH/2f, this);

        numbers = loadTextureSprite("numbers.png", 10);
    }

    private void drawNumbers(SpriteBatch batch, int number, float x, float y, float width, float height){
        if (number < 10){
            batch.draw(numbers[0], x - NUMBER_SPACE, y, width, height);
            batch.draw(numbers[number], x + NUMBER_SPACE, y, width, height);
        }
        else {
            batch.draw(numbers[Integer.parseInt((""+number).substring(0,1))], x - NUMBER_SPACE, y, width, height);
            batch.draw(numbers[Integer.parseInt((""+number).substring(1,2))], x + NUMBER_SPACE, y, width, height);
        }
    }

    private TextureRegion[] loadTextureSprite(String filename, int columns){
        Texture texture = new Texture(filename);
        return TextureRegion.split(texture, texture.getWidth() / columns, texture.getHeight())[0];
    }

    public UIPaddle getEnemy() {
        return enemy;
    }

    public StandartPlayerPaddle getPlayer() {
        return player;
    }

    public void update(){
        world.step(1 / 60f, 6,2);

        camera.update();
        enemy.update();
        player.update();
        ball.update();

        batch.setProjectionMatrix(camera.combined);
    }

    public World getWorld() {
        return world;
    }

    public Ball getBall() {
        return ball;
    }

    @Override
    public void render(float delta){
        update();

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        enemy.render(batch);
        player.render(batch);
        ball.render(batch);
        rightWall.render(batch);
        leftWall.render(batch);

        drawNumbers(batch, player.getScore(), SCREEN_WIDTH / 2f - SCORE_SPACE,  SCREEN_HEIGHT / 2f, NUMBERS_WIDTH, NUMBERS_HEIGHT);
        drawNumbers(batch, enemy.getScore(), SCREEN_WIDTH / 2f + SCORE_SPACE, SCREEN_HEIGHT / 2f, NUMBERS_WIDTH, NUMBERS_HEIGHT);

        batch.end();
    }
}
