package com.samsung.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.samsung.game.GameObjects.Ball;
import com.samsung.game.GameObjects.EnemyUI;
import com.samsung.game.GameObjects.Player;
import com.samsung.game.GameObjects.Wall;
import com.samsung.game.helperClasses.Constants;
import com.samsung.game.helperClasses.GameCollision;

import static com.samsung.game.helperClasses.Constants.PLAYER_Y;
import static com.samsung.game.helperClasses.Constants.PPM;
import static com.samsung.game.helperClasses.Constants.SCREEN_HEIGHT;
import static com.samsung.game.helperClasses.Constants.SCREEN_WIDTH;
import static com.samsung.game.helperClasses.Constants.WALL_WIDTH;

public class GameScreen extends ScreenAdapter {//игровой экран, вызывается сетап скрином с нужными конфигурациями

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private World world;
    private Box2DDebugRenderer box2DDebugRenderer;
    private GameCollision gameCollision;

    //игровые обьекты
    private Player player;
    private Ball ball;
    private Wall leftWall, rightWall;
    private EnemyUI enemy;

    public GameScreen(OrthographicCamera camera){
        this.camera = camera;
        this.camera.position.set(new Vector3(SCREEN_WIDTH / 2, Constants.SCREEN_HEIGHT / 2, 0));
        batch = new SpriteBatch();
        world = new World(new Vector2(0,0), false);
        box2DDebugRenderer = new Box2DDebugRenderer();
        gameCollision = new GameCollision(this);
        world.setContactListener(gameCollision);

        player = new Player(SCREEN_WIDTH/2, PLAYER_Y, this);
        enemy = new EnemyUI(SCREEN_WIDTH/2, SCREEN_HEIGHT - PLAYER_Y, this);
        ball = new Ball(this);
        leftWall = new Wall(WALL_WIDTH / 2, this);
        rightWall = new Wall(SCREEN_WIDTH - WALL_WIDTH / 2, this);
    }

    public EnemyUI getEnemy() {
        return enemy;
    }

    public Player getPlayer() {
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
        batch.end();

        box2DDebugRenderer.render(world, camera.combined.scl(PPM));
    }
}
