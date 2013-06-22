package com.mostka.cl3d.wraper.util;

import com.google.gwt.core.client.JavaScriptObject;

public class Vect2d extends JavaScriptObject {

	protected Vect2d() {
	}

	/**
	 * 2d vector class, used for example for texture coordinates.
	 * 
	 * @param xx
	 *            coordinate. Can be null.
	 * @param yy
	 *            coordinate.
	 */

	public static native Vect2d create(Number x, Number y) /*-{
		return new $wnd.CL3D.Vect2d(x, y);
	}-*/;

	/**
	 * X coordinate of the vector
	 */
	public final native Number getX() /*-{
		return this.X;
	}-*/;

	/**
	 * X coordinate of the vector
	 */
	public final native void setX(Number X) /*-{
		this.X = X;
	}-*/;

	/**
	 * Y coordinate of the vector
	 */
	public final native Number getY() /*-{
		return this.Y;
	}-*/;

	/**
	 * Y coordinate of the vector
	 */
	public final native void setY(Number Y) /*-{
			this.Y=Y;
	}-*/;

}