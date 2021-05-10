package com.samsung.game.HelperClasses;

import com.badlogic.gdx.Gdx;

public class Constants {//все инты хранятся здесь
    public static final int SCREEN_WIDTH = Gdx.graphics.getWidth();
    public static final int SCREEN_HEIGHT = Gdx.graphics.getHeight();
    public static final float PIXELS_PER_METRE = 32;
    public static final int WALL_WIDTH = (int) (SCREEN_WIDTH/22.5f); // = 1440/64p это величины, адаптированные под разные девайсы, 64p тут это иначальный размер спрайта
    public static final int PLAYER_Y = (int) (SCREEN_HEIGHT/10.546875f); // = 2700/256p
    public static final int PUDDLE_HEIGHT = (int) (SCREEN_HEIGHT / 64.28571429f);// = 2700/42p
    public static final int PUDDLE_WIDTH = (int) (SCREEN_WIDTH / 11.42857143f);// = 1440/126p
    public static final int BALL_HEIGHT = (int) (SCREEN_HEIGHT / 84.375f);// = 2700/32p
    public static final int BALL_WIDTH = (int) (SCREEN_WIDTH / 45f);// = 1440/45p
    public static final int NUMBERS_HEIGHT = (int) (SCREEN_HEIGHT / 19.28571429f);// = 2700/140p
    public static final int NUMBERS_WIDTH = (int) (SCREEN_WIDTH / 14.4f);// = 1440/100p
    public static final int NUMBER_SPACE = (int) (SCREEN_WIDTH / 28.8f);// = 1440/50p
    public static final int SCORE_SPACE = (int) (SCREEN_WIDTH / 7.2f);// = 1440/200p
    public static final int PADDLE_SPEED = (int) (SCREEN_WIDTH / 34.28571429f);// = 1440/42p
    public static final int BALL_SPEED = (int) ((SCREEN_HEIGHT/SCREEN_WIDTH) / 0.07211538f);// = 1.875/26p
}
