package com.mostka.cl3d.wraper.util;

import com.google.gwt.core.client.JavaScriptObject;

public class Vect3d extends JavaScriptObject {

	protected Vect3d() {
	}

	/**
	 * 3d vector class with lots of operators and methods
	 * 
	 * @param xx
	 *            coordinate, can be null.
	 * @param yy
	 *            coordinate, can be null.
	 * @param zz
	 *            coordinate, can be null.
	 */

	public static native Vect3d create(double x, double y, double z) /*-{
		return new $wnd.CL3D.Vect3d(x, y, z);
	}-*/;

	/**
	 * X coordinate of the vector
	 */
	public final native int getX() /*-{
		return this.X;
	}-*/;

	/**
	 * X coordinate of the vector
	 */
	public final native void setX(int X) /*-{
		this.X = X;
	}-*/;

	/**
	 * Y coordinate of the vector
	 */
	public final native double getY() /*-{
		return this.Y;
	}-*/;

	/**
	 * Y coordinate of the vector
	 */
	public final native void setY(int Y) /*-{
		this.Y = Y;
	}-*/;

	/**
	 * Z coordinate of the vector
	 */
	public final native double getZ() /*-{
		return this.Z;
	}-*/;

	/**
	 * Z coordinate of the vector
	 */
	public final native void setZ(int Z) /*-{
		this.Z = Z;
	}-*/;

	/**
	 * Adds another vector to this vector and returns a new vector param other
	 * {Vect3d} other vector
	 * 
	 * @param other
	 */
	public final native Vect3d add(JavaScriptObject other) /*-{
		return this.add(other);
	}-*/;

	/**
	 * Adds another vector to this vector, modifying this vector param other
	 * {Vect3d} other vector
	 * 
	 * @param other
	 */
	public final native JavaScriptObject addToThis(JavaScriptObject other) /*-{
		return this.addToThis(other);
	}-*/;

	/**
	 * Creates a copy of this vector and returns it
	 */
	public final native JavaScriptObject clone() /*-{
		return this.clone();
	}-*/;

	/**
	 * Copies the content of this vector to another vector
	 * 
	 * @param tgt
	 *            Target vector
	 */
	public final native JavaScriptObject copyTo(Vect3d tgt) /*-{
		return this.copyTo(tgt);
	}-*/;

	/**
	 * returns the cross product of this vector with another vector as new
	 * vector.
	 * 
	 * @param p
	 */
	public final native JavaScriptObject crossProduct(JavaScriptObject p) /*-{
		return this.crossProduct(p);
	}-*/;

	/**
	 * Divides each coordinate with the coordinate of another vector, modifying
	 * this vector.
	 * 
	 * @param v
	 */
	public final native JavaScriptObject divideThisThroughVect(JavaScriptObject v) /*-{
		return this.divideThisThroughVect(v);
	}-*/;

	/**
	 * Divides each coordinate with the coordinate of another vector, returning
	 * the result as a new vector.
	 * 
	 * @param v
	 */
	public final native JavaScriptObject divideThroughVect(JavaScriptObject v) /*-{
		return this.divideThroughVect(v);
	}-*/;

	/**
	 * returns the dot procduct of this vector with another vector
	 * 
	 * @param other
	 */
	public final native JavaScriptObject dotProduct(JavaScriptObject other) /*-{
		return this.dotProduct(other);
	}-*/;

	/**
	 * Returns true if this vector equals another vector. Doesn't use the
	 * comparison operator but the CL3D.equals function.
	 * 
	 * @param other
	 *            other vector
	 */
	public final native boolean equals(Vect3d other) /*-{
		return this.equals(other);
	}-*/;

	/**
	 * Returns true if this vector equals x, y, and z given as argument. Doesn't
	 * use the comparison operator but the CL3D.equals function.
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public final native JavaScriptObject equalsByints(JavaScriptObject x, JavaScriptObject y, JavaScriptObject z) /*-{
		return this.equalsByints(x, y, z);
	}-*/;

	/**
	 * Returns true if this vector equals zero. Doesn't use the comparison
	 * operator but the CL3D.iszero function.
	 */
	public final native JavaScriptObject equalsZero() /*-{
		return this.equalsZero();
	}-*/;

	/**
	 * Returns the squared distance to another point
	 * 
	 * @param v
	 *            another point
	 */
	public final native JavaScriptObject getDistanceFromSQ(Vect3d v) /*-{
		return this.getDistanceFromSQ(v);
	}-*/;

	/**
	 * Returns the distance to another point
	 * 
	 * @param v
	 *            another point
	 */
	public final native JavaScriptObject getDistanceTo(Vect3d v) /*-{
		return this.getDistanceTo(v);
	}-*/;

	/**
	 * Get the rotations that would make a (0,0,1) direction vector point in the
	 * same direction as this direction vector. This utility method is very
	 * useful for orienting scene nodes towards specific targets. For example,
	 * if this vector represents the difference between two scene nodes, then
	 * applying the result of getHorizontalAngle() to one scene node will point
	 * it at the other one.
	 */
	public final native JavaScriptObject getHorizontalAngle() /*-{
		return this.getHorizontalAngle();
	}-*/;

	/**
	 * returns a new interpolated vector, between this and another vector.
	 * 
	 * @param other
	 *            another point or vector
	 * @param d
	 *            value between 0 and 1, specifying the interpolation
	 */
	public final native JavaScriptObject getInterpolated(Vect3d other, int d) /*-{
		return this.getInterpolated(other, d);
	}-*/;

	/**
	 * Returns the lenght of this vector
	 */
	public final native JavaScriptObject getLength() /*-{
		return this.getLength();
	}-*/;

	/**
	 * Returns the squared lenght of this vector, is faster than
	 * Vect3d.getLength.
	 */
	public final native JavaScriptObject getLengthSQ() /*-{
		return this.getLengthSQ();
	}-*/;

	/**
	 * Creates a new vector which is the normalized version of this vector (set
	 * to a length of 1) param other {Vect3d} other vector
	 */
	public final native JavaScriptObject getNormalized() /*-{
		return this.getNormalized();
	}-*/;

	/**
	 * Returns true if this vector == zero.
	 */
	public final native JavaScriptObject isZero() /*-{
		return this.isZero();
	}-*/;

	/**
	 * Multiplies this vector with a scalar value (= a int), modifying this
	 * vector
	 * 
	 * @param v
	 */
	public final native JavaScriptObject multiplyThisWithScal(JavaScriptObject v) /*-{
		return this.multiplyThisWithScal(v);
	}-*/;

	/**
	 * Multiplies each coordinate with the coordinate of another vector,
	 * modifying this vector.
	 * 
	 * @param v
	 */
	public final native JavaScriptObject multiplyThisWithVect(JavaScriptObject v) /*-{
		return this.multiplyThisWithVect(v);
	}-*/;

	/**
	 * Multiplies this vector with a scalar value (= a int) and returns the
	 * result as a new vector
	 * 
	 * @param v
	 */
	public final native JavaScriptObject multiplyWithScal(int v) /*-{
		return this.multiplyWithScal(v);
	}-*/;

	/**
	 * Multiplies each coordinate with the coordinate of another vector,
	 * returning the result as a new vector.
	 * 
	 * @param v
	 */
	public final native JavaScriptObject multiplyWithVect(JavaScriptObject v) /*-{
		return this.multiplyWithVect(v);
	}-*/;

	/**
	 * Normalizes this vector, setting it to a length of 1, modifying this
	 * vector
	 */
	public final native JavaScriptObject normalize() /*-{
		return this.normalize();
	}-*/;

	/**
	 * Rotates the vector around XY by a specic angle
	 * 
	 * @param degrees
	 */
	public final native JavaScriptObject rotateXYBy(JavaScriptObject degrees) /*-{
		return this.rotateXYBy(degrees);
	}-*/;

	/**
	 * Rotates the vector around XZ by a specic angle
	 * 
	 * @param degrees
	 */
	public final native JavaScriptObject rotateXZBy(JavaScriptObject degrees) /*-{
		return this.rotateXZBy(degrees);
	}-*/;

	/**
	 * Rotates the vector around YZ by a specic angle
	 * 
	 * @param degrees
	 */
	public final native JavaScriptObject rotateYZBy(JavaScriptObject degrees) /*-{
		return this.rotateYZBy(degrees);
	}-*/;

	/**
	 * Sets all 3 coordinates to new values
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public final native JavaScriptObject set(JavaScriptObject x, JavaScriptObject y, JavaScriptObject z) /*-{
		return this.set(x, y, z);
	}-*/;

	/**
	 * Sets the lengthh of this vector to the specified value
	 * 
	 * @param n
	 */
	public final native JavaScriptObject setLength(JavaScriptObject n) /*-{
		return this.setLength(n);
	}-*/;

	/**
	 * Sets all coordinates of this vector to the coordinates of the other
	 * vector
	 * 
	 * @param other
	 *            other vector
	 */
	public final native JavaScriptObject setTo(Vect3d other) /*-{
		return this.setTo(other);
	}-*/;

	/**
	 * Substracts another vector from this vector and returns a new vector param
	 * other {Vect3d} other vector
	 * 
	 * @param other
	 */
	public final native Vect3d substract(JavaScriptObject other) /*-{
		return this.substract(other);
	}-*/;

	/**
	 * Substracts another vector from this vector, modifying this vector param
	 * other {Vect3d} other vector
	 * 
	 * @param other
	 */
	public final native JavaScriptObject substractFromThis(JavaScriptObject other) /*-{
			return this.substractFromThis(other);
	}-*/;


}