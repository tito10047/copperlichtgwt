package com.mostka.cl3d.wraper;

import com.google.gwt.core.client.JavaScriptObject;
import com.mostka.cl3d.wraper.util.ColorF;
import com.mostka.cl3d.wraper.util.Vect3d;

public class Light extends JavaScriptObject {

	protected Light() {
	}

	/**
	 * A class holding the data of a point light.
	 */

	public static native Light create() /*-{
		return new $wnd.CL3D.Light();
	}-*/;

	/**
	 * Attenuation of the light. Default is 1 / 100.
	 */
	public final native Number getAttenuation() /*-{
		return this.Attenuation;
	}-*/;

	/**
	 * Attenuation of the light. Default is 1 / 100.
	 */
	public final native void setAttenuation(Number Attenuation) /*-{
		this.Attenuation = Attenuation;
	}-*/;

	/**
	 * Color of the light
	 */
	public final native ColorF getColor() /*-{
		return this.Color;
	}-*/;

	/**
	 * Color of the light
	 */
	public final native void setColor(ColorF Color) /*-{
		this.Color = Color;
	}-*/;

	/**
	 * 3D Position of the light
	 */
	public final native Vect3d getPosition() /*-{
		return this.Position;
	}-*/;

	/**
	 * 3D Position of the light
	 */
	public final native void setPosition(Vect3d Position) /*-{
		this.Position = Position;
	}-*/;

	/**
	 * Radius of the light. Currently ignored.
	 */
	public final native Number getRadius() /*-{
		return this.Radius;
	}-*/;

	/**
	 * Radius of the light. Currently ignored.
	 */
	public final native void setRadius(Number Radius) /*-{
		this.Radius = Radius;
	}-*/;

	/**
	 * Creates an exact copy of this light data
	 */
	public final native JavaScriptObject clone() /*-{
		return this.clone();
	}-*/;

}