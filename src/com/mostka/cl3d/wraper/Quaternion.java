package com.mostka.cl3d.wraper;

import com.google.gwt.core.client.JavaScriptObject;
import com.mostka.cl3d.wraper.util.Vect3d;

public class Quaternion extends JavaScriptObject {

	protected Quaternion() {
	}

	/**
	 * Quaternion class for representing rotations
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 */

	public static native Quaternion create(JavaScriptObject x, JavaScriptObject y, JavaScriptObject z, JavaScriptObject w) /*-{
		return new $wnd.CL3D.Quaternion(x, y, z, w);
	}-*/;

	/**
	 * W component of the Quaternion
	 */
	public final native int getW() /*-{
		return this.W;
	}-*/;

	/**
	 * W component of the Quaternion
	 */
	public final native void setW(int W) /*-{
		this.W = W;
	}-*/;

	/**
	 * X component of the Quaternion
	 */
	public final native int getX() /*-{
		return this.X;
	}-*/;

	/**
	 * X component of the Quaternion
	 */
	public final native void setX(int X) /*-{
		this.X = X;
	}-*/;

	/**
	 * Y component of the Quaternion
	 */
	public final native int getY() /*-{
		return this.Y;
	}-*/;

	/**
	 * Y component of the Quaternion
	 */
	public final native void setY(int Y) /*-{
		this.Y = Y;
	}-*/;

	/**
	 * Z component of the Quaternion
	 */
	public final native int getZ() /*-{
		return this.Z;
	}-*/;

	/**
	 * Z component of the Quaternion
	 */
	public final native void setZ(int Z) /*-{
		this.Z = Z;
	}-*/;

	/**
	 * Addition operator, adds another quaternion to this one
	 * 
	 * @param b
	 */
	public final native JavaScriptObject addToThis(JavaScriptObject b) /*-{
		return this.addToThis(b);
	}-*/;

	/**
	 * Creates a clone of this Quaternion
	 */
	public final native JavaScriptObject clone() /*-{
		return this.clone();
	}-*/;

	/**
	 * Copies the content of this Quaternion to a target Quaternion
	 * 
	 * @param tgt
	 */
	public final native JavaScriptObject copyTo(JavaScriptObject tgt) /*-{
		return this.copyTo(tgt);
	}-*/;

	/**
	 * calculates to dot product with another quaternion
	 * 
	 * @param q2
	 */
	public final native JavaScriptObject dotProduct(JavaScriptObject q2) /*-{
		return this.dotProduct(q2);
	}-*/;

	/**
	 * Creates a matrix from this quaternion
	 */
	public final native JavaScriptObject getMatrix() /*-{
		return this.getMatrix();
	}-*/;

	/**
	 * Multiplication operator, multiplies with a float (scalar).
	 * 
	 * @param s
	 */
	public final native JavaScriptObject multiplyWith(JavaScriptObject s) /*-{
		return this.multiplyWith(s);
	}-*/;

	/**
	 */
	public final native JavaScriptObject normalize() /*-{
		return this.normalize();
	}-*/;

	/**
	 * Sets the quaternion from euler coordinates
	 * 
	 * @param dest
	 *            3d vector to be filled with the euler coordinates
	 * @param y
	 * @param z
	 */
	public final native JavaScriptObject setFromEuler(Vect3d dest, JavaScriptObject y, JavaScriptObject z) /*-{
		return this.setFromEuler(dest, y, z);
	}-*/;

	/**
	 * set this quaternion to the result of the interpolation between two
	 * quaternions. Time is a float between 0 and 1
	 * 
	 * @param q1
	 * @param q2
	 * @param time
	 */
	public final native JavaScriptObject slerp(JavaScriptObject q1, JavaScriptObject q2, JavaScriptObject time) /*-{
		return this.slerp(q1, q2, time);
	}-*/;

	/**
	 * Fills a 3D vector with euler coodinates representing this quaternion
	 * 
	 * @param dest
	 *            3d vector to be filled with the euler coordinates
	 */
	public final native JavaScriptObject toEuler(Vect3d dest) /*-{
			return this.toEuler(dest);
	}-*/;

}