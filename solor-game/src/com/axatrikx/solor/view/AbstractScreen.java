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
 *   File: AbstractScreen.java in solor-game
 */
package com.axatrikx.solor.view;

import com.axatrikx.solor.Solor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * The AbstractScreen class will be extended by all screen classes. It initializes SpriteBatch and BitmapFont.
 * 
 * @author Amal Bose
 * 
 */
public abstract class AbstractScreen implements Screen {

	protected final Solor game;

	protected BitmapFont font;
	protected SpriteBatch batch;

	public AbstractScreen(Solor game) {
		this.game = game;
		batch = new SpriteBatch();
		font = new BitmapFont();
	}

	protected String getName() {
		return getClass().getSimpleName();
	}

	protected boolean isGameScreen() {
		return false;
	}

	public BitmapFont getFont() {
		if (font == null) {
			font = new BitmapFont();
		}
		return font;
	}

	public SpriteBatch getBatch() {
		if (batch == null) {
			batch = new SpriteBatch();
		}
		return batch;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#dispose()
	 */
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		disposeUI();
		if (batch != null)
			batch.dispose();
	}

	/**
	 * batch not disposed for UI screens.
	 */
	public void disposeUI() {
		if (font != null)
			font.dispose();
	}

}
