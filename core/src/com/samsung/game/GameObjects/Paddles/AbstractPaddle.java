package com.samsung.game.GameObjects.Paddles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.samsung.game.HelperClasses.BodyCreator;
import com.samsung.game.HelperClasses.ContactType;
import com.samsung.game.Screens.GameScreen;

import static com.samsung.game.HelperClasses.Constants.PADDLE_SPEED;
import static com.samsung.game.HelperClasses.Constants.PIXELS_PER_METRE;
import static com.samsung.game.HelperClasses.Constants.PUDDLE_HEIGHT;
import static com.samsung.game.HelperClasses.Constants.PUDDLE_WIDTH;

public abstract class AbstractPaddle {//это ракетка всех ракеток, от нее наследуемся, чтобы создать другие типы ракеток

    protected Body body;
    protected float x, y, speed, velX;
    protected int width, height, score;
    protected Texture texture;
    protected GameScreen gameScreen;
    protected ContactType contactType;

    public AbstractPaddle(float x, float y, GameScreen gameScreen){
        contactType = ContactType.PLAYER;
        this.x = x;
        this.y = y;
        this.gameScreen = gameScreen;
        speed = PADDLE_SPEED;
        width = PUDDLE_WIDTH;
        height = PUDDLE_HEIGHT;
        texture = new Texture("dot.png");
        body = BodyCreator.createBody(x, y, width, height,false,10000, gameScreen.getWorld(), contactType);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void update(){
        x = body.getPosition().x * PIXELS_PER_METRE - (width/2f);
        y = body.getPosition().y * PIXELS_PER_METRE - (height/2f);
        velX = 0;
    }

    public void render(SpriteBatch batch){//при вызове рисует ракетку
        batch.draw(texture, x, y , width, height);
    }

    public void score(){
        score ++;
    }
}
