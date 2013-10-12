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
 *   File: LevelScreen.java in solor-game
 */
package com.axatrikx.solor.view;

import com.axatrikx.solor.Solor;
import com.axatrikx.solor.controller.InputController;
import com.axatrikx.solor.domain.BasePlatform;
import com.axatrikx.solor.domain.Color;
import com.axatrikx.solor.domain.Player;
import com.axatrikx.solor.domain.PlayerState;
import com.axatrikx.solor.domain.Shape;
import com.axatrikx.solor.utils.GameProperties;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * @author Amal Bose
 * 
 */
public class LevelScreen extends AbstractScreen {

	private static final float MAX_VEL = 6000;
	private static final float MIN_VEL = 1500;
	private static float VEL_REDUCTION_FACTOR = 0.15f; // Factor by which fling velocity should be reduced.

	OrthographicCamera camera;
	public TextureAtlas atlas;
	Texture backgroundTexture;
	Texture backgroundTexture1;
	int textureW, textureH, texture1X, texture2X, texture1Y, texture2Y;
	Player player;
	Array<BasePlatform> platforms;
	private int tmp;
	private Texture backgroundTexture2;
	private Texture backgroundTexture3;

	/**
	 * @param game
	 */
	public LevelScreen(Solor game) {
		super(game);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, GameProperties.GAME_VIEWPORT_WIDTH, GameProperties.GAME_VIEWPORT_HEIGHT);
		Gdx.input.setInputProcessor(new GestureDetector(new InputController(this)));
		atlas = new TextureAtlas(Gdx.files.internal("images/solor.atlas"));
		initObjects();
	}

	/**
	 * 
	 */
	private void initObjects() {
		player = new Player(this, getPlayerSpawnPosition());
		platforms = new Array<BasePlatform>();

		// init platforms

		platforms.add(new BasePlatform(this, Shape.CIRCLE, Color.RED, new Vector2(120, 300)));
		platforms.add(new BasePlatform(this, Shape.TRIANGE, Color.GREEN, new Vector2(250, 100)));
		platforms.add(new BasePlatform(this, Shape.TRIANGE, Color.YELLOW, new Vector2(880, 100)));
		platforms.add(new BasePlatform(this, Shape.CIRCLE, Color.GREEN, new Vector2(180, 530)));
		platforms.add(new BasePlatform(this, Shape.CIRCLE, Color.RED, new Vector2(380, 300)));

		backgroundTexture = new Texture(Gdx.files.internal("images/background.png"));
		backgroundTexture1 = backgroundTexture;
		backgroundTexture2 = backgroundTexture;
		backgroundTexture3 = backgroundTexture;
		textureW = backgroundTexture.getWidth();
		textureH = backgroundTexture.getHeight();
		texture2X = texture1X + textureW;
		texture2Y = texture1Y + textureH;

	}

	/**
	 * Returns the spawn position of player
	 * 
	 * @return
	 */
	private Vector2 getPlayerSpawnPosition() {
		return new Vector2(GameProperties.GAME_VIEWPORT_WIDTH / 2 - 64 / 2, 20);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);

		player.update(delta);

		// Side Scroller
		if (player.bounds.x > camera.position.x + GameProperties.GAME_VIEWPORT_WIDTH / 2) {
			camera.position.x = camera.position.x + GameProperties.GAME_VIEWPORT_WIDTH;
		} else if (player.bounds.x < camera.position.x - GameProperties.GAME_VIEWPORT_WIDTH / 2) {
			camera.position.x = camera.position.x - GameProperties.GAME_VIEWPORT_WIDTH;
		}
		// Top Down scroller
		if (player.bounds.y > camera.position.y + GameProperties.GAME_VIEWPORT_HEIGHT / 2) {
			camera.position.y = camera.position.y + GameProperties.GAME_VIEWPORT_HEIGHT;
		} else if (player.bounds.y < camera.position.y - GameProperties.GAME_VIEWPORT_HEIGHT / 2) {
			camera.position.y = camera.position.y - GameProperties.GAME_VIEWPORT_HEIGHT;
		}

		for (BasePlatform platform : platforms) {
			if (player.state == PlayerState.MOVING
					&& Intersector.overlaps(platform.getCollisionCirle(), player.getRectangle())) {
				player.intersected(platform);
			}
		}

		// draw player
		batch.begin();

		// draw background
		// batch.draw(backgroundTexture, 0, 0, backgroundTexture.getWidth(), backgroundTexture.getHeight());

		if (camera.position.x - textureW / 2 > texture2X) {
			tmp = texture1X;
			texture1X = texture2X;
			texture2X = tmp + textureW;
		}
		if (camera.position.x - textureW / 2 < texture1X) {
			texture2X = texture1X;
			texture1X = texture1X - textureW;
		}
		if (camera.position.y - textureH / 2 > texture2Y) {
			tmp = texture1Y;
			texture1Y = texture2Y;
			texture2Y = tmp + textureH;
		}
		if (camera.position.y - textureW / 2 < texture1Y) {
			texture2Y = texture1Y;
			texture1Y = texture2Y - textureH;
		}

		System.out.println();
		
		batch.draw(backgroundTexture, texture1X, texture1Y, textureW, textureH);
		batch.draw(backgroundTexture1, texture2X, texture1Y, textureW, textureH);
		batch.draw(backgroundTexture2, texture1X, texture2Y, textureW, textureH);
		batch.draw(backgroundTexture3, texture2X, texture2Y, textureW, textureH);

		/*
		 * if (camera.position.x > textureX + textureW * 2) { // backgroundTexture1 is out of screen. textureX = textureX +
		 * textureW * 2; }
		 */

		// load platforms
		for (BasePlatform platform : platforms) {
			platform.render(batch);
		}

		// load others

		// load player at last.
		player.render(batch);
		batch.end();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#resize(int, int)
	 */
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#show()
	 */
	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#hide()
	 */
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#pause()
	 */
	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#resume()
	 */
	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	protected void flingHorizontal(float velocityX) {
		float modX = Math.abs(velocityX);
		float sign = modX / velocityX;
		if (modX > MAX_VEL) {
			velocityX = MAX_VEL * sign;
		}
		if (modX < MIN_VEL) {
			velocityX = MIN_VEL * sign;
		}
		player.velocity.y = 0;
		player.velocity.x = velocityX * VEL_REDUCTION_FACTOR;
	}

	protected void flingVertical(float velocityY) {
		float modY = Math.abs(velocityY);
		float sign = modY / velocityY;
		if (modY > MAX_VEL) {
			velocityY = MAX_VEL * sign;
		}
		if (modY < MIN_VEL) {
			velocityY = MIN_VEL * sign;
		}
		player.velocity.x = 0;
		player.velocity.y = -1 * velocityY * VEL_REDUCTION_FACTOR;
	}

	public boolean handleFling(float velocityX, float velocityY, int button) {
		if (Math.abs(velocityX) > Math.abs(velocityY)) {
			flingHorizontal(velocityX);
		} else if (Math.abs(velocityY) > Math.abs(velocityX)) {
			flingVertical(velocityY);
		}
		return false;
	}

	public void dispose() {
		super.dispose();
		atlas.dispose();
	}
}
