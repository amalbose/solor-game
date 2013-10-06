package com.axatrikx.solor.beans;

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
