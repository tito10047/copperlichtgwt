package com.mostka.cl3d.wraper;

import com.google.gwt.core.client.JavaScriptObject;

public class CL3D extends JavaScriptObject {

	protected CL3D() {
	}

	/**
	 * The main namespace for CopperLicht
	 */

	public static native CL3D create() /*-{
		return new $wnd.CL3D.CL3D();
	}-*/;

	
	/**
	 * Low tolerance value deciding which floating point values are considered
	 * equal.
	 */
	public static native CL3D getTOLERANCE() /*-{
		return $wnd.CL3D.TOLERANCE;
	}-*/;

	/**
	 * Returns a new value which is clamped between low and high.
	 * 
	 * @param n
	 * @param low
	 * @param high
	 */
	public static native JavaScriptObject clamp(JavaScriptObject n, JavaScriptObject low, JavaScriptObject high) /*-{
		return $wnd.CL3D.clamp(n, low, high);
	}-*/;

	/**
	 * Creates a 32bit value representing a color
	 * 
	 * @param a
	 *            Alpha component of the color (value between 0 and 255)
	 * @param r
	 *            Red component of the color (value between 0 and 255)
	 * @param g
	 *            Green component of the color (value between 0 and 255)
	 * @param b
	 *            Blue component of the color (value between 0 and 255)
	 */
	public static native int createColor(Number a, Number r, Number g, Number b) /*-{
		return $wnd.CL3D.createColor(a, r, g, b);
	}-*/;

	/**
	 * Converts an angle from degrees to radians.
	 * 
	 * @param deg
	 */
	public static native JavaScriptObject degToRad(JavaScriptObject deg) /*-{
		return $wnd.CL3D.degToRad(deg);
	}-*/;

	/**
	 * Returns if two floating point values are considered similar, depending on
	 * TOLERANCE.
	 * 
	 * @param a
	 * @param b
	 */
	public static native JavaScriptObject equals(JavaScriptObject a, JavaScriptObject b) /*-{
		return $wnd.CL3D.equals(a, b);
	}-*/;

	/**
	 * Returns the fraction part of a floating point value. Given for example
	 * 6.788, this would return 0.788.
	 * 
	 * @param n
	 */
	public static native JavaScriptObject fract(JavaScriptObject n) /*-{
		return $wnd.CL3D.fract(n);
	}-*/;

	/**
	 * Returns the alpha component of a color compressed into one 32bit integer
	 * value
	 * 
	 * @param clr
	 *            color
	 */
	public static native JavaScriptObject getAlpha(Number clr) /*-{
		return $wnd.CL3D.getAlpha(clr);
	}-*/;

	/**
	 * Returns the blue component of a color compressed into one 32bit integer
	 * value
	 * 
	 * @param clr
	 *            32 bit color
	 */
	public static native JavaScriptObject getBlue(Number clr) /*-{
		return $wnd.CL3D.getBlue(clr);
	}-*/;

	/**
	 * Returns the green component of a color compressed into one 32bit integer
	 * value
	 * 
	 * @param clr
	 *            color
	 */
	public static native JavaScriptObject getGreen(Number clr) /*-{
		return $wnd.CL3D.getGreen(clr);
	}-*/;

	/**
	 * Returns the red component of a color compressed into one 32bit integer
	 * value
	 * 
	 * @param clr
	 *            color
	 */
	public static native JavaScriptObject getRed(Number clr) /*-{
		return $wnd.CL3D.getRed(clr);
	}-*/;

	/**
	 * Returns if a floating point value is considered similar to 0, depending
	 * on TOLERANCE.
	 * 
	 * @param a
	 */
	public static native JavaScriptObject isone(JavaScriptObject a) /*-{
		return $wnd.CL3D.isone(a);
	}-*/;

	/**
	 * Returns if a floating point value is considered similar to 0, depending
	 * on TOLERANCE.
	 * 
	 * @param a
	 */
	public static native JavaScriptObject iszero(JavaScriptObject a) /*-{
		return $wnd.CL3D.iszero(a);
	}-*/;

	/**
	 * Returns the maximum value of 3 input values.
	 * 
	 * @param a
	 * @param b
	 * @param c
	 */
	public static native JavaScriptObject max3(JavaScriptObject a, JavaScriptObject b, JavaScriptObject c) /*-{
		return $wnd.CL3D.max3(a, b, c);
	}-*/;

	/**
	 * Returns the minimum of 3 input values.
	 * 
	 * @param a
	 * @param b
	 * @param c
	 */
	public static native JavaScriptObject min3(JavaScriptObject a, JavaScriptObject b, JavaScriptObject c) /*-{
		return $wnd.CL3D.min3(a, b, c);
	}-*/;

	/**
	 * Converts an angle from radians to degrees.
	 * 
	 * @param radians
	 */
	public static native JavaScriptObject radToDeg(JavaScriptObject radians) /*-{
			return $wnd.CL3D.radToDeg(radians);
	}-*/;

}
