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
 *   File: Shape.java in solor-game
 */
package com.axatrikx.solor.domain;

/**
 * 
 * Shape enum which defines each shape and checks if a shape can fall into a hole.
 * 
 * @author Amal Bose
 * 
 */
public enum Shape {

	TRIANGE(1), 		// Triangle Falls into all other shapes, so lowest point.
	CIRCLE(2), 			// Circle falls into Triange and Circle, so greater point than triange.
	SQUARE(3), 			// Square falls into Square and Rectange, so greater point than Circle.
	RECTANGE(4), 		// Rectange falls into Rectange alone
	SUPER(999); 		// Super doesnt fall into any shape. So max points.

	private int point;

	Shape(int point) {
		this.point = point;
	}

	private int getPoint() {
		return this.point;
	}

	/**
	 * Checks if a shape can fall into a hole of shape 'shapeOfHole'. Returns TRUE if it can call, FALSE otherwise.
	 * 
	 * @param shapeOfHole
	 *            shape of the hole the object can fall into.
	 * @return Returns TRUE if it can call, FALSE otherwise.
	 */
	public boolean fallIntoHole(Shape shapeOfHole) {
		return shapeOfHole.getPoint() > getPoint();
	}
}
