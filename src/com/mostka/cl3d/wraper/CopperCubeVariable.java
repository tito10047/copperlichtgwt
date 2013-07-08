package com.mostka.cl3d.wraper;

import com.google.gwt.core.client.JavaScriptObject;
import com.mostka.cl3d.wraper.scene.Scene;

public class CopperCubeVariable extends JavaScriptObject{

	protected CopperCubeVariable(){}

	/**
	 * Interface class for accessing CopperCube variables
	 */

	public static native CopperCubeVariable create() /*-{
			return new $wnd.CL3D.CopperCubeVariable();
	}-*/;

	/**
	 * Returns the name of the variable
	 */
	public final native JavaScriptObject getName() /*-{
			return this.getName();
	}-*/;

	/**
	 * Returns the value of the variable as float
	 */
	public final native JavaScriptObject getValueAsFloat() /*-{
			return this.getValueAsFloat();
	}-*/;

	/**
	 * Returns the value of the variable as int
	 */
	public final native JavaScriptObject getValueAsInt() /*-{
			return this.getValueAsInt();
	}-*/;

	/**
	 * Returns the value of the variable as string
	 */
	public final native JavaScriptObject getValueAsString() /*-{
			return this.getValueAsString();
	}-*/;

	/**
	 * Static function, returns the instance of an existing CopperCube variable or creates one if not existing.
	 * @param n Name of the variable
	 * @param createIfNotExisting if the variable is not found, it will be created if this is set to true.
	 * @param scene The current scene. This parameter is optional, this can be 0. It is used for getting runtime variables such as #player1.health
	 */
	public static native JavaScriptObject getVariable(String n, boolean createIfNotExisting, Scene scene) /*-{
			return CopperCubeVariable.getVariable(n, createIfNotExisting, scene);
	}-*/;

	/**
	 * Returns if this variable is a float value
	 */
	public final native JavaScriptObject isFloat() /*-{
			return this.isFloat();
	}-*/;

	/**
	 * Returns if this variable is an int value
	 */
	public final native JavaScriptObject isInt() /*-{
			return this.isInt();
	}-*/;

	/**
	 * Returns if this variable is a string
	 */
	public final native JavaScriptObject isString() /*-{
			return this.isString();
	}-*/;

	/**
	 * Sets the name of the variable
	 * @param n Name
	 */
	public final native JavaScriptObject setName(JavaScriptObject n) /*-{
			return this.setName(n);
	}-*/;

	/**
	 * Sets the value of the variable as float
	 * @param v the new value
	 */
	public final native JavaScriptObject setValueAsFloat(JavaScriptObject v) /*-{
			return this.setValueAsFloat(v);
	}-*/;

	/**
	 * Sets the value of the variable as int
	 * @param v the new value
	 */
	public final native JavaScriptObject setValueAsInt(JavaScriptObject v) /*-{
			return this.setValueAsInt(v);
	}-*/;

	/**
	 * Sets the value of the variable as string
	 * @param v the new value
	 */
	public final native JavaScriptObject setValueAsString(JavaScriptObject v) /*-{
			return this.setValueAsString(v);
	}-*/;

}