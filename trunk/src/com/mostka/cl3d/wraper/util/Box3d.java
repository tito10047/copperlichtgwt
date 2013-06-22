package com.mostka.cl3d.wraper.util;

import com.google.gwt.core.client.JavaScriptObject;

public class Box3d extends JavaScriptObject{

	protected Box3d(){}

	/**
	 * Axis aligned bounding box.
	 */

	public static native Box3d create() /*-{
			return new $wnd.CL3D.Box3d();
	}-*/;

	/**
	 * Maximal Edge of the bounding box
	 */
	public final native Vect3d getMaxEdge() /*-{
			return this.MaxEdge;
	}-*/;

	/**
	 * Maximal Edge of the bounding box
	 */
	public final native void setMaxEdge(Vect3d MaxEdge) /*-{
			this.MaxEdge=MaxEdge;
	}-*/;

	/**
	 * Minimal Edge of the bounding box
	 */
	public final native Vect3d getMinEdge() /*-{
			return this.MinEdge;
	}-*/;

	/**
	 * Minimal Edge of the bounding box
	 */
	public final native void setMinEdge(Vect3d MinEdge) /*-{
			this.MinEdge=MinEdge;
	}-*/;

	/**
	 * Adds a point to the bounding box, increasing the box if the point is outside of the box
	 * @param x 
	 * @param y 
	 * @param z 
	 */
	public final native JavaScriptObject addInternalPoint(JavaScriptObject x, JavaScriptObject y, JavaScriptObject z) /*-{
			return this.addInternalPoint(x, y, z);
	}-*/;

	/**
	 * Adds a point to the bounding box, increasing the box if the point is outside of the box
	 * @param v 3d vector representing the point
	 */
	public final native JavaScriptObject addInternalPointByVector(Vect3d v) /*-{
			return this.addInternalPointByVector(v);
	}-*/;

	/**
	 * Creates a clone of the box
	 */
	public final native JavaScriptObject clone() /*-{
			return this.clone();
	}-*/;

	/**
	 * Returns the center of the box
	 */
	public final native JavaScriptObject getCenter() /*-{
			return this.getCenter();
	}-*/;

	/**
	 * Returns all 8 edges of the bounding box
	 */
	public final native JavaScriptObject getEdges() /*-{
			return this.getEdges();
	}-*/;

	/**
	 * Returns the extent (or size) of the box
	 */
	public final native JavaScriptObject getExtent() /*-{
			return this.getExtent();
	}-*/;

	/**
	 * Returns if the box intersects with another box
	 * @param box other box
	 */
	public final native JavaScriptObject intersectsWithBox(Box3d box) /*-{
			return this.intersectsWithBox(box);
	}-*/;

	/**
	 * Returns if the box intersects with a line
	 * @param lineStart start of the line
	 * @param lineEnd end of the line
	 */
	public final native JavaScriptObject intersectsWithLine(Vect3d lineStart, Vect3d lineEnd) /*-{
			return this.intersectsWithLine(lineStart, lineEnd);
	}-*/;

	/**
	 * Returns if a point is inside this box
	 * @param p point to test
	 */
	public final native JavaScriptObject isPointInside(Vect3d p) /*-{
			return this.isPointInside(p);
	}-*/;

	/**
	 * Resets the bounding box
	 * @param x 
	 * @param y 
	 * @param z 
	 */
	public final native JavaScriptObject reset(JavaScriptObject x, JavaScriptObject y, JavaScriptObject z) /*-{
			return this.reset(x, y, z);
	}-*/;

}