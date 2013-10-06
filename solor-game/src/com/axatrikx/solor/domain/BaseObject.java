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

	Sprite sprite;

	public boolean isPlayer;

	public boolean isAlive;

	public BaseObject(LevelScreen screen) {
		this.screen = screen;
		sprite = screen.atlas.createSprite("cGreen");
	}

	public void render(SpriteBatch batch) {
		batch.draw(sprite, bounds.x, bounds.y);
	}

	public abstract void update();
}
