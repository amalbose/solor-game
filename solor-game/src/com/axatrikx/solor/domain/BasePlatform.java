package com.axatrikx.solor.domain;

import com.axatrikx.solor.view.LevelScreen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class BasePlatform extends BaseObject {

	Circle collisionCircle;

	public BasePlatform(LevelScreen screen, Vector2 bounds, String textureName) {
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
