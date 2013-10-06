package com.axatrikx.solor.view;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.delay;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.axatrikx.solor.Solor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;

/**
 * Splash Screen class which will be shown up before the game.
 * 
 * @author Amal Bose
 * 
 */
public class SplashScreen extends AbstractUIScreen {

	private Image splashImage;

	public SplashScreen(Solor game) {
		super(game);
	}

	@Override
	public void show() {
		super.show();

		// start playing the menu music
		// game.getMusicManager().play(SolorMusic.MENU);

		TextureRegion splashRegion = new TextureRegion(new Texture("images/splash.png"), 0, 0, 512, 301);
		Drawable splashDrawable = new TextureRegionDrawable(splashRegion);

		// here we create the splash image actor; its size is set when the
		// resize() method gets called
		splashImage = new Image(splashDrawable, Scaling.stretch);
		splashImage.setFillParent(true);

		// this is needed for the fade-in effect to work correctly; we're just
		// making the image completely transparent
		splashImage.getColor().a = 0f;

		// configure the fade-in/out effect on the splash image
		splashImage.addAction(sequence(fadeIn(0.75f), delay(1.75f, fadeOut(0.75f)), new Action() {
			@Override
			public boolean act(float delta) {
				// the last action will move to the next screen
				game.setScreen(game.getMenuScreen());
				return true;
			}
		}));

		// and finally we add the actor to the stage
		stage.addActor(splashImage);
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);

		// resize the splash image
		splashImage.setWidth(width);
		splashImage.setHeight(height);

		// we need a complete redraw
		splashImage.invalidateHierarchy();
	}

	@Override
	public void dispose() {
		super.dispose();
	}
}
