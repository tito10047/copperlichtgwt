package com.mostka.cl3d.wraper.scene;

import com.google.gwt.core.client.JavaScriptObject;
import com.mostka.cl3d.wraper.Light;

public class LightSceneNode extends SceneNodeAbs {

	protected LightSceneNode() {
	}

	/**
	 * Returns the type string of the scene node. For example 'camera' if this
	 * is a camera, or 'mesh' if it is a mesh scene node.
	 */
	public final native JavaScriptObject getType() /*-{
		return this.getType();
	}-*/;
	/**
	 * @param size
	 */
	public static native LightSceneNode create(JavaScriptObject size) /*-{
		return new $wnd.CL3D.LightSceneNode(size);
	}-*/;

	/**
	 * Radius, Position, Color and Attenuation of the light
	 */
	public final native Light getLightData() /*-{
		return this.LightData;
	}-*/;

	/**
	 * Radius, Position, Color and Attenuation of the light
	 */
	public final native void setLightData(Light LightData) /*-{
		this.LightData = LightData;
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
