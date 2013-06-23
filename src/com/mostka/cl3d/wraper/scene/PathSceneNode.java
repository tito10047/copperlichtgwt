package com.mostka.cl3d.wraper.scene;

import com.google.gwt.core.client.JavaScriptObject;
import com.mostka.cl3d.wraper.util.Vect3d;

public class PathSceneNode extends SceneNodeAbs {

	protected PathSceneNode() {
	}

	/**
	 * A path scene node stores a 3d path which can be used for example by
	 */

	public static native PathSceneNode create() /*-{
		return new $wnd.CL3D.PathSceneNode();
	}-*/;

	/**
	 * Specifies if the path is a closed circle or a unclosed line.
	 */
	public final native Boolean getIsClosedCircle() /*-{
		return this.IsClosedCircle;
	}-*/;

	/**
	 * Specifies if the path is a closed circle or a unclosed line.
	 */
	public final native void setIsClosedCircle(Boolean IsClosedCircle) /*-{
		this.IsClosedCircle = IsClosedCircle;
	}-*/;

	/**
	 * Array of path nodes, of type Vect3d.
	 */
	public final native Vect3d[] getNodes() /*-{
		return this.Nodes;
	}-*/;

	/**
	 * Array of path nodes, of type Vect3d.
	 */
	public final native void setNodes(Vect3d[] Nodes) /*-{
		this.Nodes = Nodes;
	}-*/;

	/**
	 * Tightness of the spline, specifies how the line is interpolated between
	 * the path nodes. With this, you can create for example either cardinal
	 * splines (tightness != 0.5) or catmull-rom-splines (tightness == 0.5).
	 */
	public final native int getTightness() /*-{
		return this.Tightness;
	}-*/;

	/**
	 * Tightness of the spline, specifies how the line is interpolated between
	 * the path nodes. With this, you can create for example either cardinal
	 * splines (tightness != 0.5) or catmull-rom-splines (tightness == 0.5).
	 */
	public final native void setTightness(int Tightness) /*-{
		this.Tightness = Tightness;
	}-*/;

	/**
	 * Get the axis aligned, not transformed bounding box of this node. This
	 * means that if this node is an animated 3d character, moving in a room,
	 * the bounding box will always be around the origin. To get the box in real
	 * world coordinates, just transform it with the matrix you receive with
	 * getAbsoluteTransformation() or simply use getTransformedBoundingBox(),
	 * which does the same.
	 */
	public final native JavaScriptObject getBoundingBox() /*-{
		return this.getBoundingBox();
	}-*/;

	/**
	 * @param idx
	 *            Index of the path node
	 */
	public final native JavaScriptObject getPathNodePosition(int idx) /*-{
		return this.getPathNodePosition(idx);
	}-*/;

	/**
	 * @param posOnPath
	 *            Value between 0 and 1, meaning 0 is the start of the path and
	 *            1 is the end of the path.
	 * @param relative
	 *            set to true to get the position relative to the position of
	 *            the path scene node, set to false to receive the position in
	 *            absolute world space.
	 */
	public final native JavaScriptObject getPointOnPath(int posOnPath, Boolean relative) /*-{
		return this.getPointOnPath(posOnPath, relative);
	}-*/;

	/**
	 * Returns the type string of the scene node. Returns 'path' for the mesh
	 * scene node.
	 */
	public final native JavaScriptObject getType() /*-{
			return this.getType();
	}-*/;

}