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
 *   File: BasePlatform.java in solor-game
 */
package com.axatrikx.solor.domain;

import com.axatrikx.solor.view.LevelScreen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class BasePlatform extends BaseObject {

	Circle collisionCircle;

	public BasePlatform(LevelScreen screen, String textureName, Vector2 bounds) {
		super(screen, textureName, bounds, false);
		collisionCircle = new Circle(bounds.x + sprite.getWidth() / 2, bounds.y + sprite.getHeight() / 2,
				sprite.getWidth() / 2);
	}

	public void render(SpriteBatch batch) {
		super.render(batch);
	}

	public Circle getCollisionCirle() {
		collisionCircle.x = bounds.x + sprite.getWidth() / 2;
		collisionCircle.y = bounds.y + sprite.getHeight() / 2;
		collisionCircle.radius = sprite.getWidth() / 2;
		return collisionCircle;
	}
}
