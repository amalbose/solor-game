package com.axatrikx.solor;

import com.axatrikx.solor.screen.SplashScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

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
		// TODO Auto-generated method stub
		return null;
	}
}
