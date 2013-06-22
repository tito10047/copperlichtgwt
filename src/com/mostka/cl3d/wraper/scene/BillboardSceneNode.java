package com.mostka.cl3d.wraper.scene;

import com.google.gwt.core.client.JavaScriptObject;

public class BillboardSceneNode extends SceneNodeAbs {

	protected BillboardSceneNode() {
	}

	/**
	 * A billboard is like a 3d sprite: A 2d element, which always looks to the
	 * camera.
	 */

	public static native BillboardSceneNode create() /*-{
		return new $wnd.CL3D.BillboardSceneNode();
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
	 * gets the size of the billboard
	 */
	public final native JavaScriptObject getSize() /*-{
		return this.getSize();
	}-*/;

	/**
	 * Returns the type string of the scene node. Returns 'billboard' for the
	 * mesh scene node.
	 */
	public final native JavaScriptObject getType() /*-{
		return this.getType();
	}-*/;

	/**
	 * sets the size of the billboard
	 * 
	 * @param x
	 * @param y
	 */
	public final native JavaScriptObject setSize(int x, int y) /*-{
		return this.setSize(x, y);
	}-*/;

}