package com.axatrikx.solor.view;

import com.axatrikx.solor.Solor;
import com.axatrikx.solor.domain.Player;
import com.axatrikx.solor.utils.GameProperties;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Amal Bose
 * 
 */
public class LevelScreen extends BaseLevelScreen {

	Player player;

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
		player = new Player(this);
		player.bounds = getPlayerSpawnPosition();
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

		batch.begin();
		// draw player
		player.render(batch);
		batch.end();

		player.update();
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
}
