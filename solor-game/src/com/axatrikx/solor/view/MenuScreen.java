package com.axatrikx.solor.view;

import com.axatrikx.solor.Solor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Menu screen which displays the menu keys: Start Game, Options, High Scores.
 * 
 * @author Amal Bose
 * 
 */
public class MenuScreen extends AbstractUIScreen {

	/**
	 * @param game
	 */
	public MenuScreen(Solor game) {
		super(game);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.axatrikx.solor.screen.AbstractScreen#show()
	 */
	@Override
	public void show() {
		super.show();

		Table table = super.getTable();

		// register the button "start game"
		TextButton startGameButton = new TextButton("Start game", getSkin());
		startGameButton.addListener(new ClickListener(){
			
			public void clicked (InputEvent event, float x, float y) {
			game.setScreen(new DummyLevelScreen(game));
			dispose();
			}
			
		});
		table.add(startGameButton).size(300, 60).uniform().spaceBottom(10);
		table.row();

		// register the button "options"
		TextButton optionsButton = new TextButton("Options", getSkin());
		//optionsButton.addListener(new DefaultActorListener());
		table.add(optionsButton).uniform().fill().spaceBottom(10);
		table.row();

		// register the button "high scores"
		TextButton highScoresButton = new TextButton("High Scores", getSkin());
		//highScoresButton.addListener(new DefaultActorListener());
		table.add(highScoresButton).uniform().fill();
	}

}
