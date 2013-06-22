package com.mostka.cl3d.wraper.util;

import com.google.gwt.core.client.JavaScriptObject;

public class Line3d extends JavaScriptObject{

	protected Line3d(){}

	/**
	 * 3d line class, decribing a line between two 3d points
	 */

	public static native Line3d create() /*-{
			return new $wnd.CL3D.Line3d();
	}-*/;

	/**
	 * End point of the line
	 */
	public final native Vect3d getEnd() /*-{
			return this.End;
	}-*/;

	/**
	 * End point of the line
	 */
	public final native void setEnd(Vect3d End) /*-{
			this.End=End;
	}-*/;

	/**
	 * Start point of the line
	 */
	public final native Vect3d getStart() /*-{
			return this.Start;
	}-*/;

	/**
	 * Start point of the line
	 */
	public final native void setStart(Vect3d Start) /*-{
			this.Start=Start;
	}-*/;

	/**
	 * Returns the length of the line
	 */
	public final native JavaScriptObject getLength() /*-{
			return this.getLength();
	}-*/;

	/**
	 * Returns the vector representing the line
	 */
	public final native JavaScriptObject getVector() /*-{
			return this.getVector();
	}-*/;

}