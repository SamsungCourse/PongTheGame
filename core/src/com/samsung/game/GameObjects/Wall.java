package com.samsung.game.GameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.samsung.game.helperClasses.BodyCreator;
import com.samsung.game.helperClasses.ContactType;
import com.samsung.game.screens.GameScreen;

import static com.samsung.game.helperClasses.Constants.SCREEN_HEIGHT;
import static com.samsung.game.helperClasses.Constants.WALL_WIDTH;

public class Wall {//стены по бокам

    private Body body;
    private float x, y;
    private int width, height;
    private Texture texture;

    public Wall(float x, GameScreen gameScreen){
        y = SCREEN_HEIGHT/2;
        this.x = x;
        height = SCREEN_HEIGHT;
        width = WALL_WIDTH;

        texture = new Texture("dot.png");
        body = BodyCreator.createBody(x, y, width, height, true, 0, gameScreen.getWorld(), ContactType.WALL);
    }

    public void render(SpriteBatch batch){
        batch.draw(texture, x - (width/2), y - (height/2), width, height);
    }
}
