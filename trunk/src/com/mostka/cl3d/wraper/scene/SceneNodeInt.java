package com.mostka.cl3d.wraper.scene;

import com.google.gwt.core.client.JavaScriptObject;

public interface SceneNodeInt {
	/**
	 * Get the axis aligned, not transformed bounding box of this node. This
	 * means that if this node is an animated 3d character, moving in a room,
	 * the bounding box will always be around the origin. To get the box in real
	 * world coordinates, just transform it with the matrix you receive with
	 * getAbsoluteTransformation() or simply use getTransformedBoundingBox(),
	 * which does the same.
	 */
	public JavaScriptObject getBoundingBox();
	/**
	 * Returns the type string of the scene node. For example 'camera' if this
	 * is a camera, or 'mesh' if it is a mesh scene node.
	 */
	public JavaScriptObject getType();
}
