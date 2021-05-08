package com.samsung.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.samsung.game.screens.GameScreen;

import static com.samsung.game.helperClasses.Constants.SCREEN_HEIGHT;
import static com.samsung.game.helperClasses.Constants.SCREEN_WIDTH;

public class Boot extends Game {//игровой класс, который запускается первым, вызывая остальные экраны, также он передает GameScreen камеру, поэтому если будешь менять, не забудь про нее

	private OrthographicCamera camera;

	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
		setScreen(new GameScreen(camera));
	}
}
