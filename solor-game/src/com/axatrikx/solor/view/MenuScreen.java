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
 *   File: MenuScreen.java in solor-game
 */
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
			game.setScreen(new LevelScreen(game));
			dispose();
			}
			
		});
		table.add(startGameButton).size(300, 60).uniform().spaceBottom(10);
		table.row();

		// register the button "options"
		TextButton optionsButton = new TextButton("Options", getSkin());
		optionsButton.addListener(new ClickListener(){
			
			public void clicked (InputEvent event, float x, float y) {
			game.setScreen(new DummyLevelScreen(game));
			dispose();
			}
			
		});
		table.add(optionsButton).uniform().fill().spaceBottom(10);
		table.row();

		// register the button "high scores"
		TextButton highScoresButton = new TextButton("High Scores", getSkin());
		//highScoresButton.addListener(new DefaultActorListener());
		table.add(highScoresButton).uniform().fill();
	}

}
