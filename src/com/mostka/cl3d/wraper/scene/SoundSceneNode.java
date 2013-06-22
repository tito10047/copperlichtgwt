package com.mostka.cl3d.wraper.scene;

import com.google.gwt.core.client.JavaScriptObject;

public class SoundSceneNode extends SceneNodeAbs {

	protected SoundSceneNode() {
	}

	/**
	 * A sound scene node represents and plays a 3d sound
	 */

	public static native SoundSceneNode create() /*-{
		return new $wnd.CL3D.SoundSceneNode();
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
	 * Returns the type string of the scene node. Returns 'sound' for the mesh
	 * scene node.
	 */
	public final native JavaScriptObject getType() /*-{
		return this.getType();
	}-*/;

}