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
 *   File: InputController.java in solor-game
 */
package com.axatrikx.solor.controller;

import com.axatrikx.solor.view.LevelScreen;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

/**
 * Input controller for handling input in game levels.
 * 
 * @author Amal Bose
 * 
 */
public class InputController implements GestureListener {

	LevelScreen screen;

	public InputController(LevelScreen screen) {
		this.screen = screen;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.input.GestureDetector.GestureListener#touchDown(float, float, int, int)
	 */
	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.input.GestureDetector.GestureListener#tap(float, float, int, int)
	 */
	@Override
	public boolean tap(float x, float y, int count, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.input.GestureDetector.GestureListener#longPress(float, float)
	 */
	@Override
	public boolean longPress(float x, float y) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.input.GestureDetector.GestureListener#fling(float, float, int)
	 */
	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		return screen.handleFling(velocityX, velocityY, button);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.input.GestureDetector.GestureListener#pan(float, float, float, float)
	 */
	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.input.GestureDetector.GestureListener#panStop(float, float, int, int)
	 */
	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.input.GestureDetector.GestureListener#zoom(float, float)
	 */
	@Override
	public boolean zoom(float initialDistance, float distance) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.input.GestureDetector.GestureListener#pinch(com.badlogic.gdx.math.Vector2,
	 * com.badlogic.gdx.math.Vector2, com.badlogic.gdx.math.Vector2, com.badlogic.gdx.math.Vector2)
	 */
	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
		// TODO Auto-generated method stub
		return false;
	}

}
