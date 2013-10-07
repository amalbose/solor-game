package com.axatrikx.solor.view;

import com.axatrikx.solor.Solor;
import com.axatrikx.solor.domain.BasePlatform;
import com.axatrikx.solor.domain.Player;
import com.axatrikx.solor.utils.GameProperties;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * @author Amal Bose
 * 
 */
public class LevelScreen extends BaseLevelScreen {

	private static final float MAX_VEL = 6000;
	private static final float MIN_VEL = 1500;
	private static float VEL_REDUCTION_FACTOR = 0.1f; // Factor by which fling velocity should be reduced.

	Player player;
	Array<BasePlatform> platforms;

	/**
	 * @param game
	 */
	public LevelScreen(Solor game) {
		super(game);
		initObjects();
	}

	/**
	 * 
	 */
	private void initObjects() {
		player = new Player(this, getPlayerSpawnPosition());
		platforms = new Array<BasePlatform>();

		// init platforms

		platforms.add(new BasePlatform(this, "pRed", new Vector2(130, 300)));
		platforms.add(new BasePlatform(this, "pGreen", new Vector2(230, 100)));
		platforms.add(new BasePlatform(this, "pYellow", new Vector2(880, 100)));
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
		super.render(delta);

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
			if (player.platforming == 0 && Intersector.overlaps(platform.getCollisionCirle(), player.getRectangle())) {
				player.intersected(platform);
			}
		}

		// draw player
		batch.begin();
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

	@Override
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

	@Override
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
}
