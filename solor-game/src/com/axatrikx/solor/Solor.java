/**
 *   Copyright 2013 Amal Bose (axatrikx)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *	 You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 *   File: Solor.java in solor-game
 */
package com.axatrikx.solor;

import com.axatrikx.solor.view.LevelScreen;
import com.axatrikx.solor.view.MenuScreen;
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
		return new LevelScreen(this); // FIXME change to SplashScreen.
	}

	@Override
	public void render() {
		super.render();
	}

	public Screen getMenuScreen() {
		return new MenuScreen(this);
	}
}
