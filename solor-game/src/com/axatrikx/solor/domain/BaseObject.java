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

	Vector2 bounds;

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
