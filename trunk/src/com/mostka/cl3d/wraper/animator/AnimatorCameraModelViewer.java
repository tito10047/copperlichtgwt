package com.mostka.cl3d.wraper.animator;

import com.google.gwt.core.client.JavaScriptObject;

public class AnimatorCameraModelViewer extends AnimatorAbs {

	protected AnimatorCameraModelViewer() {
	}

	/**
	 * Special scene node animator for model viewer cameras.
	 * 
	 * @param caman instance of a
	 * @param engineAn instance of the
	 */

	public static native AnimatorCameraModelViewer create(JavaScriptObject cam, JavaScriptObject engine) /*-{
		return new $wnd.CL3D.AnimatorCameraModelViewer(cam, engine);
	}-*/;

	/**
	 * Defines if the animator may only move the camera horizontally
	 */
	public final native boolean getNoVerticalMovement() /*-{
		return this.NoVerticalMovement;
	}-*/;

	/**
	 * Defines if the animator may only move the camera horizontally
	 */
	public final native void setNoVerticalMovement(boolean NoVerticalMovement) /*-{
		this.NoVerticalMovement = NoVerticalMovement;
	}-*/;

	/**
	 * Radius of the camera
	 */
	public final native int getRadius() /*-{
		return this.Radius;
	}-*/;

	/**
	 * Radius of the camera
	 */
	public final native void setRadius(int Radius) /*-{
		this.Radius = Radius;
	}-*/;

	/**
	 * Rotation speed of the camera
	 */
	public final native int getRotateSpeed() /*-{
		return this.RotateSpeed;
	}-*/;

	/**
	 * Rotation speed of the camera
	 */
	public final native void setRotateSpeed(int RotateSpeed) /*-{
		this.RotateSpeed = RotateSpeed;
	}-*/;

	/**
	 * Animates the scene node it is attached to and returns true if scene node
	 * was modified.
	 * 
	 * @param n
	 *            The Scene node which needs to be animated this frame.
	 * @param timeMs
	 *            The time in milliseconds since the start of the scene.
	 */
	public final native JavaScriptObject animateNode(JavaScriptObject n, JavaScriptObject timeMs) /*-{
		return this.animateNode(n, timeMs);
	}-*/;

	/**
	 * Returns the type of the animator. For the AnimatorCameraModelViewer, this
	 * will return 'cameramodelviewer'.
	 */
	public final native JavaScriptObject getType() /*-{
			return this.getType();
	}-*/;

}
