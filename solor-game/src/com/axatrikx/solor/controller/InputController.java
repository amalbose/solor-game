/**
 * 
 */
package com.axatrikx.solor.controller;

import com.axatrikx.solor.view.BaseLevelScreen;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

/**
 * Input controller for handling input.
 * 
 * @author Amal Bose
 * 
 */
public class InputController implements GestureListener {

	BaseLevelScreen screen;

	public InputController(BaseLevelScreen screen) {
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
		// TODO Auto-generated method stub
		System.out.println(velocityX);
		return false;
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
