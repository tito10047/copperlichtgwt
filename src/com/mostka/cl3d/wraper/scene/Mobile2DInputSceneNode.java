package com.mostka.cl3d.wraper.scene;

import com.google.gwt.core.client.JavaScriptObject;

public class Mobile2DInputSceneNode extends SceneNodeAbs {

	protected Mobile2DInputSceneNode() {
	}

	/**
	 * Scene Node which draws a 2d mobile input control
	 * 
	 * @param engine
	 * @param scene
	 */

	public static native Mobile2DInputSceneNode create(JavaScriptObject engine, JavaScriptObject scene) /*-{
		return new $wnd.CL3D.Mobile2DInputSceneNode(engine, scene);
	}-*/;

	/**
	 * Returns the type string of the scene node. Returns 'mobile2dinput' for
	 * the scene node.
	 */
	public final native JavaScriptObject getType() /*-{
		return this.getType();
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

}