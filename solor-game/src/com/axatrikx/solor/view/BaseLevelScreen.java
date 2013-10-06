/**
 * 
 */
package com.axatrikx.solor.view;

import com.axatrikx.solor.Solor;
import com.axatrikx.solor.controller.InputController;
import com.axatrikx.solor.utils.GameProperties;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector;

/**
 * The BaseLevel Screen which extends AbstractScreen. Along with initializations done by parent AbstractScreen, BaseLevelScreen
 * also declares and initializes the Orthographic camera which is updated on render.
 * 
 * @author Amal Bose
 * 
 */
public abstract class BaseLevelScreen extends AbstractScreen {

	OrthographicCamera camera;

	public BaseLevelScreen(Solor game) {
		super(game);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, GameProperties.GAME_VIEWPORT_WIDTH, GameProperties.GAME_VIEWPORT_HEIGHT);
		Gdx.input.setInputProcessor(new GestureDetector(new InputController(this)));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#render(float)
	 */
	@Override
	public void render(float delta) {
		// clear the screen with a dark blue color. The
		// arguments to glClearColor are the red, green
		// blue and alpha component in the range [0,1]
		// of the color to be used to clear the screen.
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		// tell the camera to update its matrices.
		camera.update();

		// tell the SpriteBatch to render in the
		// coordinate system specified by the camera.
		batch.setProjectionMatrix(camera.combined);
	}
}
