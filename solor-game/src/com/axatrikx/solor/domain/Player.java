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
 *   File: Player.java in solor-game
 */
package com.axatrikx.solor.domain;

import com.axatrikx.solor.view.LevelScreen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * The player class.
 * 
 * @author Amal Bose
 * 
 */
public class Player extends BaseObject {

	float captureSpeed = 8000;

	public PlayerState state;
	public Vector2 velocity;
	float angle, pHeight, pWidth, plHeight, plWidth;
	public BasePlatform attractingPlatform;

	public Player(LevelScreen screen, Vector2 bounds) {
		super(screen, Shape.CIRCLE, Color.GREEN, bounds, ObjectType.PLAYER);
		state = PlayerState.MOVING;
		velocity = new Vector2();
	}

	public void update(float delta) {
		// Outside platform reach
		if (state != PlayerState.ATTRACTED) {
			bounds.x += velocity.x * delta;
			bounds.y += velocity.y * delta;

			if (bounds.x < 0) {
				bounds.x = 0;
				velocity.x = 0;
			}
			if (bounds.y < 0) {
				bounds.y = 0;
				velocity.y = 0;
			}

			if (state == PlayerState.PLATFORMED) {
				// inside platform. when it goes outside, resets platforming to 0
				if (Math.abs(bounds.x + pWidth / 2 - attractingPlatform.bounds.x - plWidth / 2) > 100
						|| Math.abs(bounds.y + pHeight / 2 - attractingPlatform.bounds.y - plHeight / 2) > 100) {
					state = PlayerState.MOVING;
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
				state = PlayerState.PLATFORMED;
				velocity.x = 0;
				velocity.y = 0;
				processChangeForm();
			}
		}
	}

	public void render(SpriteBatch batch) {
		batch.draw(sprite, bounds.x, bounds.y);
	}

	/**
	 * 
	 */
	private void processChangeForm() {
		changeForm();
		attractingPlatform.changeForm();
	}

	public void intersected(BasePlatform platform) {
		state = PlayerState.ATTRACTED;
		attractingPlatform = platform;
	}
}