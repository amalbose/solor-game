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
 *   File: BaseObject.java in solor-game
 */
package com.axatrikx.solor.domain;

import com.axatrikx.solor.view.LevelScreen;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * The base class for objects(player, platforms, holes) on screen.
 * 
 * @author Amal Bose
 * 
 */
public abstract class BaseObject {

	LevelScreen screen;

	public Shape shape;
	
	public String color;

	public Vector2 bounds;

	private Rectangle rectange;

	Sprite sprite;

	public boolean isPlayer;

	public BaseObject(LevelScreen screen, String spriteName, Vector2 bounds, boolean isPlayer) {
		this.screen = screen;
		this.isPlayer = isPlayer;
		this.bounds = bounds;
		sprite = screen.atlas.createSprite(spriteName);
		rectange = new Rectangle(bounds.x, bounds.y, sprite.getWidth(), sprite.getHeight());
	}

	public void render(SpriteBatch batch) {
		batch.draw(sprite, bounds.x, bounds.y);
	}

	public void setBounds(float x, float y) {
		bounds.x = x;
		bounds.y = y;
	}

	public Rectangle getRectangle() {
		rectange.x = bounds.x;
		rectange.y = bounds.y;
		return rectange;
	}
}
