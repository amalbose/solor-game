package com.axatrikx.solor;

import com.axatrikx.solor.view.MenuScreen;
import com.axatrikx.solor.view.SplashScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

/**
 * The Main Game class.
 * 
 * @author Amal Bose
 * 
 */
public class Solor extends Game {

	public static final boolean DEV_MODE = false;

	@Override
	public void create() {
		setScreen(getSplashScreen());
	}

	/**
	 * Returns the SplashScreen object.
	 * 
	 * @return
	 */
	private Screen getSplashScreen() {
		return new SplashScreen(this);
	}

	@Override
	public void render() {
		super.render();
	}

	public Screen getMenuScreen() {
		return new MenuScreen(this);
	}
}
