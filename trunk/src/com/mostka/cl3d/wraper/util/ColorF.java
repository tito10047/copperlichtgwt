package com.mostka.cl3d.wraper.util;

import com.google.gwt.core.client.JavaScriptObject;

public class ColorF extends JavaScriptObject{

	protected ColorF(){}

	/**
	 * A class holding a floating point color, consisting of four Numbers, for r, g, b and alpha
	 */

	public static native ColorF create() /*-{
			return new $wnd.CL3D.ColorF();
	}-*/;

	/**
	 * alpha value of the color
	 */
	public final native Number getA() /*-{
			return this.A;
	}-*/;

	/**
	 * alpha value of the color
	 */
	public final native void setA(Number A) /*-{
			this.A=A;
	}-*/;

	/**
	 * blue value of the color
	 */
	public final native Number getB() /*-{
			return this.B;
	}-*/;

	/**
	 * blue value of the color
	 */
	public final native void setB(Number B) /*-{
			this.B=B;
	}-*/;

	/**
	 * green value of the color
	 */
	public final native Number getG() /*-{
			return this.G;
	}-*/;

	/**
	 * green value of the color
	 */
	public final native void setG(Number G) /*-{
			this.G=G;
	}-*/;

	/**
	 * red value of the color
	 */
	public final native Number getR() /*-{
			return this.R;
	}-*/;

	/**
	 * red value of the color
	 */
	public final native void setR(Number R) /*-{
			this.R=R;
	}-*/;

	/**
	 * Creates a copy of this color
	 */
	public final native JavaScriptObject clone() /*-{
			return this.clone();
	}-*/;

}
