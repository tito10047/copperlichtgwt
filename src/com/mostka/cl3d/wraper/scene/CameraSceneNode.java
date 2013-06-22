package com.mostka.cl3d.wraper.scene;

import com.google.gwt.core.client.JavaScriptObject;
import com.mostka.cl3d.wraper.util.Vect3d;

public class CameraSceneNode extends SceneNodeAbs {

	protected CameraSceneNode() {
	}

	/**
	 * Scene Node which is a (controlable) camera.
	 */

	public static native CameraSceneNode create() /*-{
		return new $wnd.CL3D.CameraSceneNode();
	}-*/;

	/**
	 * Creates a clone of the camera.
	 * 
	 * @param newparent
	 *            The new parent of the clone. Must be a scene node as well.
	 */
	public final native JavaScriptObject createClone(JavaScriptObject newparent) /*-{
		return this.createClone(newparent);
	}-*/;

	/**
	 * Gets the aspect ratio of the camera. The default is 4 / 3
	 */
	public final native JavaScriptObject getAspectRatio() /*-{
		return this.getAspectRatio();
	}-*/;

	/**
	 * Gets the value of the far plane of the camera. All geometry behind this
	 * plane is clipped away.
	 */
	public final native JavaScriptObject getFarValue() /*-{
		return this.getFarValue();
	}-*/;

	/**
	 * Gets the field of view of the camera. Field of view is measured in
	 * radians.
	 */
	public final native JavaScriptObject getFov() /*-{
		return this.getFov();
	}-*/;

	/**
	 * Gets the value of the near plane of the camera. All geometry before this
	 * plane is clipped away.
	 */
	public final native JavaScriptObject getNearValue() /*-{
		return this.getNearValue();
	}-*/;

	/**
	 * Sets target position of the camera.
	 */
	public final native Vect3d getTarget() /*-{
		return this.getTarget();
	}-*/;

	/**
	 * Returns the type string of the scene node. Returns 'camera' for the
	 * camera scene node.
	 */
	public final native JavaScriptObject getType() /*-{
		return this.getType();
	}-*/;

	/**
	 * Returns the up vector of the camera. The default is (0,1,0), pointing up.
	 */
	public final native JavaScriptObject getUpVector() /*-{
		return this.getUpVector();
	}-*/;

	/**
	 * Sets the aspect ratio of the camera. The default is 4 / 3
	 * 
	 * @param a
	 */
	public final native JavaScriptObject setAspectRatio(JavaScriptObject a) /*-{
		return this.setAspectRatio(a);
	}-*/;

	/**
	 * Sets the value of the far plane of the camera. All geometry behind this
	 * plane is clipped away.
	 * 
	 * @param nv
	 */
	public final native JavaScriptObject setFarValue(JavaScriptObject nv) /*-{
		return this.setFarValue(nv);
	}-*/;

	/**
	 * Sets the field of view of the camera. Field of view is measured in
	 * radians.
	 * 
	 * @param fov
	 */
	public final native JavaScriptObject setFov(JavaScriptObject fov) /*-{
		return this.setFov(fov);
	}-*/;

	/**
	 * Sets the value of the near plane of the camera. All geometry before this
	 * plane is clipped away.
	 * 
	 * @param nv
	 */
	public final native JavaScriptObject setNearValue(JavaScriptObject nv) /*-{
		return this.setNearValue(nv);
	}-*/;

	/**
	 * Sets target position of the camera.
	 * 
	 * @param target
	 *            new target position of the camera.
	 */
	public final native JavaScriptObject setTarget(Vect3d target) /*-{
		return this.setTarget(target);
	}-*/;

	/**
	 * Sets up vector of the camera, a direction pointing to where 'up' is.
	 * Default is (0,1,0)
	 * 
	 * @param upvector
	 *            new up vector of the camera.
	 */
	public final native JavaScriptObject setUpVector(Vect3d upvector) /*-{
		return this.setUpVector(upvector);
	}-*/;

	public final native JavaScriptObject getBoundingBox() /*-{
	return this.getBoundingBox();
}-*/;

}
