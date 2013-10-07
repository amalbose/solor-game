package com.axatrikx.solor.domain;

import com.axatrikx.solor.utils.GameProperties;
import com.axatrikx.solor.view.LevelScreen;
import com.badlogic.gdx.math.Vector2;

public class Player extends BaseObject {

	public Vector2 velocity;

	float captureSpeed = 8000;

	public boolean isAlive;
	float angle, pHeight, pWidth, plHeight, plWidth;

	// platforming variable checks if the player is attracted to platform. If attracting, it will have a value -1, and once done,
	// it will change to 1. Upon any action from player, it will return to 0.
	public int platforming;

	public BasePlatform attractingPlatform;

	public Player(LevelScreen screen, Vector2 bounds) {
		super(screen, "cGreen", bounds, true);
		platforming = 0;
		velocity = new Vector2();
	}

	public void update(float delta) {
		// Outside platform reach
		if (platforming != -1) {
			bounds.x += velocity.x * delta;
			bounds.y += velocity.y * delta;

			if (bounds.x < 0) {
				bounds.x = 0;
				velocity.x = 0;
			}/* else if (bounds.x > GameProperties.GAME_VIEWPORT_WIDTH - sprite.getHeight()) {
				bounds.x = GameProperties.GAME_VIEWPORT_WIDTH - sprite.getWidth();
				velocity.x = 0;
			}*/
			if (bounds.y < 0) {
				bounds.y = 0;
				velocity.y = 0;
			} else if (bounds.y > GameProperties.GAME_VIEWPORT_HEIGHT - sprite.getHeight()) {
				bounds.y = GameProperties.GAME_VIEWPORT_HEIGHT - sprite.getHeight();
				velocity.y = 0;
			}

			if (platforming == 1) {
				// inside platform. when it goes outside, resets platforming to 0
				if (Math.abs(bounds.x + pWidth / 2 - attractingPlatform.bounds.x - plWidth / 2) > 100
						|| Math.abs(bounds.y + pHeight / 2 - attractingPlatform.bounds.y - plHeight / 2) > 100) {
					platforming = 0;
				}
			}
		} else {
			// attracted by platform
			// setting player height and width
			pHeight = sprite.getHeight();
			pWidth = sprite.getWidth();
			plHeight = attractingPlatform.sprite.getHeight();
			plWidth = attractingPlatform.sprite.getWidth();

			angle = (float) Math.atan2(attractingPlatform.bounds.y + plHeight / 2 - bounds.y - pHeight / 2,
					attractingPlatform.bounds.x + plWidth / 2 - bounds.x - pWidth / 2);
			bounds.x += velocity.x * delta;
			bounds.y += velocity.y * delta;
			velocity.set((float) Math.cos(angle) * captureSpeed * delta, (float) Math.sin(angle) * captureSpeed * delta);
			// If somewhat inside, stopping player.
			if (Math.abs(bounds.x + pWidth / 2 - attractingPlatform.bounds.x - plWidth / 2) < 1
					&& Math.abs(bounds.y + pHeight / 2 - attractingPlatform.bounds.y - plHeight / 2) < 1) {
				platforming = 1;
				velocity.x = 0;
				velocity.y = 0;
			}
		}
	}

	public void intersected(BasePlatform platform) {
		platforming = -1;
		attractingPlatform = platform;
	}
}
