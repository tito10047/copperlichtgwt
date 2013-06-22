package com.mostka.cl3d.wraper.util;

import com.google.gwt.core.client.JavaScriptObject;

public class Triangle3d extends JavaScriptObject {

	protected Triangle3d() {
	}

	/**
	 * 3d triangle class consisting of 3 points in space, formin a triangle
	 * 
	 * @param afirst
	 *            point of the triangle, can be null.
	 * @param bsecond
	 *            point of the triangle, can be null.
	 * @param cthird
	 *            point of the triangle, can be null.
	 */

	public static native Triangle3d create(Vect3d a, Vect3d b, Vect3d c) /*-{
		return new $wnd.CL3D.Triangle3d(a, b, c);
	}-*/;

	/**
	 * First point of the triangle
	 */
	public final native Vect3d getPointA() /*-{
		return this.pointA;
	}-*/;

	/**
	 * First point of the triangle
	 */
	public final native void setPointA(Vect3d pointA) /*-{
		this.pointA = pointA;
	}-*/;

	/**
	 * Second point of the triangle
	 */
	public final native Vect3d getPointB() /*-{
		return this.pointB;
	}-*/;

	/**
	 * Second point of the triangle
	 */
	public final native void setPointB(Vect3d pointB) /*-{
		this.pointB = pointB;
	}-*/;

	/**
	 * Third point of the triangle
	 */
	public final native Vect3d getPointC() /*-{
		return this.pointC;
	}-*/;

	/**
	 * Third point of the triangle
	 */
	public final native void setPointC(Vect3d pointC) /*-{
		this.pointC = pointC;
	}-*/;

	/**
	 * Creates a copy of this vector and returns it
	 */
	public final native JavaScriptObject clone() /*-{
		return this.clone();
	}-*/;

	/**
	 * Copies the content of this triangle to another triangle
	 * 
	 * @param tgt
	 *            Target vector
	 */
	public final native JavaScriptObject copyTo(Triangle3d tgt) /*-{
		return this.copyTo(tgt);
	}-*/;

	/**
	 * Returns the intersection of the plane described by this triangle and a
	 * line.
	 * 
	 * @param linePoint
	 *            point on the line
	 * @param lineVect
	 *            vector of the line
	 */
	public final native JavaScriptObject getIntersectionOfPlaneWithLine(Vect3d linePoint, Vect3d lineVect) /*-{
		return this.getIntersectionOfPlaneWithLine(linePoint, lineVect);
	}-*/;

	/**
	 * Returns the intersection of the triangle and a line.
	 * 
	 * @param linePoint
	 *            point on the line
	 * @param lineVect
	 *            vector of the line
	 */
	public final native JavaScriptObject getIntersectionWithLine(Vect3d linePoint, Vect3d lineVect) /*-{
		return this.getIntersectionWithLine(linePoint, lineVect);
	}-*/;

	/**
	 * Returns the normal of this triangle
	 */
	public final native JavaScriptObject getNormal() /*-{
		return this.getNormal();
	}-*/;

	/**
	 * Creates a 3d plane based on this triangle
	 */
	public final native JavaScriptObject getPlane() /*-{
		return this.getPlane();
	}-*/;

	/**
	 * Returns if a point is in this triangle using a slow method
	 * 
	 * @param p
	 *            point to test
	 */
	public final native JavaScriptObject isPointInside(Vect3d p) /*-{
		return this.isPointInside(p);
	}-*/;

	/**
	 * Returns if a point is in this triangle using a fast method
	 * 
	 * @param p
	 *            point to test
	 */
	public final native JavaScriptObject isPointInsideFast(Vect3d p) /*-{
		return this.isPointInsideFast(p);
	}-*/;

	/**
	 * Returns the the triangle is totally inside a box
	 * 
	 * @param box
	 */
	public final native JavaScriptObject isTotalInsideBox(Box3d box) /*-{
			return this.isTotalInsideBox(box);
	}-*/;

}