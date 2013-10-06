package com.axatrikx.solor.domain;

import com.axatrikx.solor.beans.Shape;
import com.axatrikx.solor.view.LevelScreen;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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

	public Vector2 bounds;

	public Vector2 velocity;

	Sprite sprite;

	public boolean isPlayer;

	public boolean isAlive;

	public BaseObject(LevelScreen screen) {
		this.screen = screen;
		bounds = new Vector2();
		velocity = new Vector2();
		sprite = screen.atlas.createSprite("cGreen");
	}

	public void render(SpriteBatch batch) {
		System.out.println(bounds);
		batch.draw(sprite, bounds.x, bounds.y);
	}

	public void update(float delta) {
		bounds.x += velocity.x * delta;
		bounds.y += velocity.y * delta;
		// y += (speed_y - 0.5 * acceleration * delta_time) * delta_time;
		// speed_y -= acceleration * delta_time;
	}
}
