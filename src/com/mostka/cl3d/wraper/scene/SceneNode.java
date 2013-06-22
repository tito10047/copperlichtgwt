package com.mostka.cl3d.wraper.scene;

import com.google.gwt.core.client.JavaScriptObject;

public class SceneNode extends SceneNodeAbs {

	protected SceneNode() {
	}

	/**
	 * The base class for scene nodes, a node in the hierarchical 3d scene
	 * rendering graph.
	 */

	public static native SceneNode create() /*-{
		return new $wnd.CL3D.SceneNode();
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
	 * Returns the type string of the scene node. For example 'camera' if this
	 * is a camera, or 'mesh' if it is a mesh scene node.
	 */
	public final native JavaScriptObject getType() /*-{
		return this.getType();
	}-*/;
}