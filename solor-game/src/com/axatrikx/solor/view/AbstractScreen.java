/**
 * 
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
