package com.samsung.game.HelperClasses;

import com.badlogic.gdx.Gdx;

public class AdaptiveMaker {
    public static float adaptiveWidth(int oldNum){
        return (int)(oldNum * (Gdx.graphics.getWidth()/1440f));
    }
    public static float adaptiveHeight(int oldNum){
        return (int)(oldNum * (Gdx.graphics.getHeight()/2700f));
    }
}
