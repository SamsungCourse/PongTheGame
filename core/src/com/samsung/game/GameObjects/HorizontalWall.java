package com.samsung.game.GameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.samsung.game.HelperClasses.BodyCreator;
import com.samsung.game.HelperClasses.ContactType;
import com.samsung.game.Screens.GameScreen;

import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveHeight;
import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveWidth;
import static com.samsung.game.HelperClasses.Constants.SCREEN_HEIGHT;
import static com.samsung.game.HelperClasses.Constants.SCREEN_WIDTH;
import static com.samsung.game.HelperClasses.Constants.WALL_WIDTH;

public class HorizontalWall {

    private Body body;
    private float x, y;
    private int width, height;
    private Texture texture;

    public HorizontalWall(GameScreen gameScreen){
        x = SCREEN_WIDTH/2f;
        y = SCREEN_HEIGHT - adaptiveWidth(64);
        height = (int) (adaptiveHeight(64));
        width = SCREEN_WIDTH;

        texture = new Texture("dot.png");
        body = BodyCreator.createBody(x, y, width, height, true, 0, gameScreen.getWorld(), ContactType.ENEMY);
    }

    public void render(SpriteBatch batch){
        batch.draw(texture, x - (width/2), y - (height/2), width, height);
    }
}
