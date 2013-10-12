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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 
 * Shape enum which defines each shape and checks if a shape can fall into a hole.
 * 
 * @author Amal Bose
 * 
 */
public enum Shape {

	TRIANGE(1, "t"), // Triangle Falls into all other shapes, so lowest point.
	CIRCLE(2, "c"); // Circle falls into Triangle and Circle, so greater point than triangle.
	//SQUARE(3, "s"), // Square falls into Square and Rectangle, so greater point than Circle.
	//RECTANGE(4, "r"), // Rectangle falls into Rectangle alone
	//SUPER(999, "x"); // Super doesn't fall into any shape. So max points.
	public String suffix;
	public int point;

	Shape(int point, String suffix) {
		this.point = point;
		this.suffix = suffix;
	}

	/**
	 * Checks if a shape can fall into a hole of shape 'shapeOfHole'. Returns TRUE if it can call, FALSE otherwise.
	 * 
	 * @param shapeOfHole
	 *            shape of the hole the object can fall into.
	 * @return Returns TRUE if it can call, FALSE otherwise.
	 */
	public boolean fallIntoHole(Shape shapeOfHole) {
		return shapeOfHole.point > point;
	}

	private static final List<Shape> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();

	public static Shape randomShape() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
}