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
 *   File: AbstractUIScreen.java in solor-game
 */
package com.axatrikx.solor.view;

import com.axatrikx.solor.Solor;
import com.axatrikx.solor.utils.GameProperties;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * The UI abstract screen class which will be extended by all UI screen classes. It initializes Stage, Table, Skin and
 * TextureAtlas for use in UI screens.
 * 
 * @author Amal Bose
 * 
 */
public abstract class AbstractUIScreen extends AbstractScreen {

	protected final Stage stage;

	private Skin skin;
	private Table table;
	private TextureAtlas atlas;

	public AbstractUIScreen(Solor game) {
		super(game);
		int width = GameProperties.GAME_VIEWPORT_WIDTH;
		int height = GameProperties.GAME_VIEWPORT_HEIGHT;
		this.stage = new Stage(width, height, true);
	}

	public TextureAtlas getAtlas() {
		if (atlas == null) {
			atlas = new TextureAtlas(Gdx.files.internal("image-atlases/pages.atlas"));
		}
		return atlas;
	}

	protected Skin getSkin() {
		if (skin == null) {
			FileHandle skinFile = Gdx.files.internal("skin/uiskin.json");
			skin = new Skin(skinFile);
		}
		return skin;
	}

	protected Table getTable() {
		if (table == null) {
			table = new Table(getSkin());
			table.setFillParent(true);
			if (Solor.DEV_MODE) {
				table.debug();
			}
			stage.addActor(table);
		}
		return table;
	}

	@Override
	public void show() {
		// set the stage as the input processor
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void resize(int width, int height) {
		stage.setViewport(width, height, true);
	}

	@Override
	public void render(float delta) {
		stage.act(delta);
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		super.disposeUI();
		// as the collaborators are lazily loaded, they may be null
		if (skin != null)
			skin.dispose();
		if (atlas != null)
			atlas.dispose();
	}
}
