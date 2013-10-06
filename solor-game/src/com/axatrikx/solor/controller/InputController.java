/**
 * 
 */
package com.axatrikx.solor.controller;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Input controller for handling input.
 * 
 * @author Amal Bose
 * 
 */
public class InputController extends ClickListener {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.scenes.scene2d.utils.ClickListener#clicked(com.badlogic.gdx.scenes.scene2d.InputEvent, float, float)
	 */
	@Override
	public void clicked(InputEvent event, float x, float y) {
		// TODO Auto-generated method stub
		super.clicked(event, x, y);
		System.out.println("clicked");
	}

}
