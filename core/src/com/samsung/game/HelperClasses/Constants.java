package com.samsung.game.HelperClasses;

import com.badlogic.gdx.Gdx;

import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveHeight;
import static com.samsung.game.HelperClasses.AdaptiveMaker.adaptiveWidth;

public class Constants {//все инты хранятся здесь
    public static final int SCREEN_WIDTH = Gdx.graphics.getWidth();
    public static final int SCREEN_HEIGHT = Gdx.graphics.getHeight();
    public static final float PIXELS_PER_METRE = 32;
    public static final int WALL_WIDTH = (int) adaptiveWidth(64);
    public static final int PLAYER_Y = (int) adaptiveHeight(600);
    public static final int PADDLE_HEIGHT = (int) adaptiveHeight(42);
    public static final int PADDLE_WIDTH = (int) adaptiveWidth(126);
    public static final int BALL_HEIGHT = (int) adaptiveHeight(32);
    public static final int BALL_WIDTH = (int) adaptiveWidth(32);
    public static final int NUMBERS_HEIGHT = (int) adaptiveHeight(140);
    public static final int NUMBERS_WIDTH = (int) adaptiveWidth(100);
    public static final int NUMBER_SPACE = (int) adaptiveWidth(50);
    public static final int SCORE_SPACE = (int) adaptiveWidth(200);
    public static final int PADDLE_SPEED = (int) adaptiveWidth(56);
    public static final int BALL_SPEED = (int) adaptiveWidth((int) adaptiveHeight(26));
    public static final int BUTTON_HEIGHT = (int) adaptiveHeight(200);
    public static final int BUTTON_WIDTH = (int) adaptiveWidth(800);
    public static final int PADDLE_BUTTON_Y = (int) adaptiveHeight(1700);
    public static final int DIFFICULTY_BUTTON_Y = (int) adaptiveHeight(1600);
}
