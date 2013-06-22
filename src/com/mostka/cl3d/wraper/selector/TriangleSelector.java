package com.mostka.cl3d.wraper.selector;

import com.google.gwt.core.client.JavaScriptObject;
import com.mostka.cl3d.wraper.util.Box3d;
import com.mostka.cl3d.wraper.util.Matrix4;
import com.mostka.cl3d.wraper.util.Triangle3d;
import com.mostka.cl3d.wraper.util.Vect3d;

public class TriangleSelector extends JavaScriptObject /*implements TriangleSelectorInt*/ {

	protected TriangleSelector() {
	}

	/**
	 * Returns the scenenode this selector is for
	 */
	public final native JavaScriptObject getRelatedSceneNode() /*-{
		return this.getRelatedSceneNode();
	}-*/;
	
	/**
	 * Interface to return triangles with specific properties, useful for
	 * collision detection.
	 */

	public static native TriangleSelector create() /*-{
		return new $wnd.CL3D.TriangleSelector();
	}-*/;

	/**
	 * Returns all triangles for the scene node associated with this selector
	 * 
	 * @param transform
	 *            a transformation matrix which transforms all triangles before
	 *            returning them
	 * @param outArray
	 *            output array of the triangles
	 */
	public final native JavaScriptObject getAllTriangles(Matrix4 transform, Triangle3d[] outArray) /*-{
		return this.getAllTriangles(transform, outArray);
	}-*/;

	/**
	 * Returns the collision 3d point of a 3d line with the 3d geometry in this
	 * triangle selector.
	 * 
	 * @param start
	 *            3d point representing the start of the 3d line
	 * @param end
	 *            3d point representing the end of the 3d line
	 * @param bIgnoreBackFaces
	 *            if set to true, this will ignore back faced polygons, making
	 *            the query twice as fast
	 * @param outTriangle
	 *            if set to a triangle, this will contain the 3d triangle with
	 *            which the line collided
	 * @param ignoreInvisibleItems
	 *            set to true to ignore invisible scene nodes for collision test
	 */
	public final native JavaScriptObject getCollisionPointWithLine(Vect3d start, Vect3d end, Boolean bIgnoreBackFaces, Triangle3d outTriangle, Boolean ignoreInvisibleItems) /*-{
		return this.getCollisionPointWithLine(start, end, bIgnoreBackFaces,
				outTriangle, ignoreInvisibleItems);
	}-*/;

	/**
	 * Returns all triangles inside a bounding box, for the scene node
	 * associated with this selector. This method will return at least the
	 * triangles that intersect the box, but may return other triangles as well.
	 * 
	 * @param box
	 * @param transform
	 *            a transformation matrix which transforms all triangles before
	 *            returning them
	 * @param outArray
	 *            output array of the triangles
	 */
	public final native JavaScriptObject getTrianglesInBox(Box3d box, Matrix4 transform, Triangle3d[] outArray) /*-{
		return this.getTrianglesInBox(box, transform, outArray);
	}-*/;

	/**
	 * If there are multiple scene nodes in this selector, it is possible to let
	 * it ignore one specific node, for example to prevent colliding it against
	 * itself.
	 * 
	 * @param n
	 */
	public final native JavaScriptObject setNodeToIgnore(JavaScriptObject n) /*-{
			return this.setNodeToIgnore(n);
	}-*/;

}