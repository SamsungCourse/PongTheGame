package com.samsung.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.samsung.game.Screens.GameScreen;
import com.samsung.game.Screens.SetupScreen;

import static com.samsung.game.HelperClasses.Constants.SCREEN_HEIGHT;
import static com.samsung.game.HelperClasses.Constants.SCREEN_WIDTH;

public class Boot extends Game {//игровой класс, который запускается первым, вызывая остальные экраны, также он передает GameScreen камеру, поэтому если будешь менять, не забудь про нее

	public static boolean volume = true;

	@Override
	public void create () {
		System.out.println(SCREEN_HEIGHT + " " + SCREEN_WIDTH);
		setScreen(new SetupScreen(this));
	}
}
