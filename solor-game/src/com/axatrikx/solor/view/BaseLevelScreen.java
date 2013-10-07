package com.axatrikx.solor.view;

import com.axatrikx.solor.Solor;
import com.axatrikx.solor.controller.InputController;
import com.axatrikx.solor.utils.GameProperties;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.input.GestureDetector;

/**
 * The BaseLevel Screen which extends AbstractScreen. Along with initializations done by parent AbstractScreen, BaseLevelScreen
 * also declares and initializes the Orthographic camera which is updated on render.
 * 
 * @author Amal Bose
 * 
 */
public abstract class BaseLevelScreen extends AbstractScreen {

	public OrthographicCamera camera;
	public TextureAtlas atlas;

	public BaseLevelScreen(Solor game) {
		super(game);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, GameProperties.GAME_VIEWPORT_WIDTH, GameProperties.GAME_VIEWPORT_HEIGHT);
		Gdx.input.setInputProcessor(new GestureDetector(new InputController(this)));
		atlas = new TextureAtlas(Gdx.files.internal("images/solor.atlas"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#render(float)
	 */
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.86f, 0.85f, 0.71f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
	}

	/*
	 * Input Controller methods
	 */
	public boolean handleFling(float velocityX, float velocityY, int button) {
		if (Math.abs(velocityX) > Math.abs(velocityY)) {
			flingHorizontal(velocityX);
		} else if (Math.abs(velocityY) > Math.abs(velocityX)) {
			flingVertical(velocityY);
		}
		return false;
	}

	protected void flingHorizontal(float velocityX) {
	}

	protected void flingVertical(float velocityY) {
	}
}
