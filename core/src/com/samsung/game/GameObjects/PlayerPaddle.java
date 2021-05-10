package com.samsung.game.GameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.samsung.game.HelperClasses.BodyCreator;
import com.samsung.game.HelperClasses.ContactType;
import com.samsung.game.Screens.GameScreen;

import static com.samsung.game.HelperClasses.Constants.PPM;

public abstract class PlayerPaddle {//это ракетка всех ракеток, от нее наследуемся, чтобы создать другие типы ракеток

    protected Body body;
    protected float x, y, speed, velX;
    protected int width, height, score;
    protected Texture texture;
    protected GameScreen gameScreen;

    public PlayerPaddle(float x, float y, GameScreen gameScreen){
        this.x = x;
        this.y = y;
        this.gameScreen = gameScreen;
        this.speed = 56;
        this.width = 126;
        this.height = 42;
        this.texture = new Texture("dot.png");
        body = BodyCreator.createBody(x, y, width, height,false,10000, gameScreen.getWorld(), ContactType.PLAYER);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void update(){
        x = body.getPosition().x * PPM - (width/2);
        y = body.getPosition().y * PPM - (height/2);
        velX = 0;
    }

    public void render(SpriteBatch batch){//при вызове рисует ракетку
        batch.draw(texture, x, y , width, height);
    }

    public void score(){
        score ++;
    }
}
