package com.mostka.cl3d.wraper.util;

import com.google.gwt.core.client.JavaScriptObject;

public class Plane3d extends JavaScriptObject{

	protected Plane3d(){}

	/**
	 * 3d plane class with lots of operators and methods
	 */

	public static native Plane3d create() /*-{
		return new $wnd.CL3D.Plane3d();
	}-*/;

	/**
	 * plane distance to origin
	 */
	public final native int getD() /*-{
		return this.D;
	}-*/;

	/**
	 * plane distance to origin
	 */
	public final native void setD(int D) /*-{
		this.D = D;
	}-*/;

	/**
	 * back plane relation, used in Plane3d.classifyPointRelation
	 */
	public static native Plane3d getISREL3D_BACK() /*-{
		return Plane3d.ISREL3D_BACK;
	}-*/;

	/**
	 * front plane relation, used in Plane3d.classifyPointRelation
	 */
	public static native Plane3d getISREL3D_FRONT() /*-{
		return Plane3d.ISREL3D_FRONT;
	}-*/;

	/**
	 * planar plane relation, used in Plane3d.classifyPointRelation
	 */
	public static native Plane3d getISREL3D_PLANAR() /*-{
		return Plane3d.ISREL3D_PLANAR;
	}-*/;

	/**
	 * plane normal
	 */
	public final native Vect3d getNormal() /*-{
		return this.Normal;
	}-*/;

	/**
	 * plane normal
	 */
	public final native void setNormal(Vect3d Normal) /*-{
		this.Normal = Normal;
	}-*/;

	/**
	 * Classifies the relation of a point to this plane.
	 * @param point Point to classify its relation.
	 */
	public final native JavaScriptObject classifyPointRelation(JavaScriptObject point) /*-{
		return this.classifyPointRelation(point);
	}-*/;

	/**
	 * Creates a clone of the plane
	 */
	public final native JavaScriptObject clone() /*-{
		return this.clone();
	}-*/;

	/**
	 * Get the distance to a point.
Note that this only works if the normal is normalized.
	 * @param point 
	 */
	public final native JavaScriptObject getDistanceTo(JavaScriptObject point) /*-{
		return this.getDistanceTo(point);
	}-*/;

	/**
	 * Get an intersection with a 3d line.
	 * @param lineVect Vector of the line to intersect with.
	 * @param linePoint Point of the line to intersect with.
	 * @param outIntersection Place to store the intersection point, if there is one.
	 */
	public final native JavaScriptObject getIntersectionWithLine(JavaScriptObject lineVect, JavaScriptObject linePoint, JavaScriptObject outIntersection) /*-{
		return this.getIntersectionWithLine(lineVect, linePoint,
				outIntersection);
	}-*/;

	/**
	 * Intersects this plane with another.
	 * @param other Other plane to intersect with.
	 * @param outLinePoint Base point of intersection line.
	 * @param outLineVect Vector of intersection.
	 */
	public final native JavaScriptObject getIntersectionWithPlane(JavaScriptObject other, JavaScriptObject outLinePoint, JavaScriptObject outLineVect) /*-{
		return this.getIntersectionWithPlane(other, outLinePoint, outLineVect);
	}-*/;

	/**
	 * Get the intersection point with two other planes if there is one.
	 * @param o1 
	 * @param o2 
	 * @param outPoint 
	 */
	public final native JavaScriptObject getIntersectionWithPlanes(JavaScriptObject o1, JavaScriptObject o2, JavaScriptObject outPoint) /*-{
		return this.getIntersectionWithPlanes(o1, o2, outPoint);
	}-*/;

	/**
	 * Gets a member point of the plane.
	 */
	public final native JavaScriptObject getMemberPoint() /*-{
		return this.getMemberPoint();
	}-*/;

	/**
	 * Returns true if the plane is frontfacing to the look direction.
	 * @param lookDirection look direction
	 */
	public final native JavaScriptObject isFrontFacing(Vect3d lookDirection) /*-{
		return this.isFrontFacing(lookDirection);
	}-*/;

	/**
	 * normalizes the plane
	 */
	public final native JavaScriptObject normalize() /*-{
		return this.normalize();
	}-*/;

	/**
	 * Recalculates the distance from origin by applying a new member point to the plane.
	 * @param mpoint 
	 */
	public final native JavaScriptObject recalculateD(JavaScriptObject mpoint) /*-{
		return this.recalculateD(mpoint);
	}-*/;

	/**
	 * Sets initial values
	 * @param point 
	 * @param nvector 
	 */
	public final native JavaScriptObject setPlane(JavaScriptObject point, JavaScriptObject nvector) /*-{
		return this.setPlane(point, nvector);
	}-*/;

	/**
	 * creates a plane from 3 points
	 * @param point1 
	 * @param point2 
	 * @param point3 
	 */
	public final native JavaScriptObject setPlaneFrom3Points(JavaScriptObject point1, JavaScriptObject point2, JavaScriptObject point3) /*-{
		return this.setPlaneFrom3Points(point1, point2, point3);
	}-*/;

}