package com.mostka.cl3d.wraper.animator;

import com.google.gwt.core.client.JavaScriptObject;
import com.mostka.cl3d.wraper.CopperLicht;
import com.mostka.cl3d.wraper.scene.CameraSceneNode;
import com.mostka.cl3d.wraper.util.Vect3d;

public class AnimatorCameraFPS extends AnimatorAbs {

	protected AnimatorCameraFPS() {
	}

	/**
	 * Special scene node animator for first person shooter cameras.
	 * 
	 * @param caman
	 *            instance of a
	 * @param engineAn
	 *            instance of the CopperLicht 3d engine, for receiving the mouse
	 *            and keyboard input.
	 */

	public static native AnimatorCameraFPS create(CameraSceneNode cam, CopperLicht engine) /*-{
		return new $wnd.CL3D.AnimatorCameraFPS(cam, engine);
	}-*/;

	/**
	 * Maximal jump speed the user is able to jump with this camera.
	 */
	public final native int getJumpSpeed() /*-{
		return this.JumpSpeed;
	}-*/;

	/**
	 * Maximal jump speed the user is able to jump with this camera.
	 */
	public final native void setJumpSpeed(int JumpSpeed) /*-{
		this.JumpSpeed = JumpSpeed;
	}-*/;

	/**
	 * Maximal vertical angle the user is able to look.
	 */
	public final native int getMaxVerticalAngle() /*-{
		return this.MaxVerticalAngle;
	}-*/;

	/**
	 * Maximal vertical angle the user is able to look.
	 */
	public final native void setMaxVerticalAngle(int MaxVerticalAngle) /*-{
		this.MaxVerticalAngle = MaxVerticalAngle;
	}-*/;

	/**
	 * Defines if the animator may move the camera
	 */
	public final native Boolean getMayMove() /*-{
		return this.MayMove;
	}-*/;

	/**
	 * Defines if the animator may move the camera
	 */
	public final native void setMayMove(Boolean MayMove) /*-{
		this.MayMove = MayMove;
	}-*/;

	/**
	 * Defines if the animator may zoom the camera
	 */
	public final native Boolean getMayZoom() /*-{
		return this.MayZoom;
	}-*/;

	/**
	 * Defines if the animator may zoom the camera
	 */
	public final native void setMayZoom(Boolean MayZoom) /*-{
		this.MayZoom = MayZoom;
	}-*/;

	/**
	 * Maximal movment speed of the camera.
	 */
	public final native int getMoveSpeed() /*-{
		return this.MoveSpeed;
	}-*/;

	/**
	 * Maximal movment speed of the camera.
	 */
	public final native void setMoveSpeed(double MoveSpeed) /*-{
		this.MoveSpeed = MoveSpeed;
	}-*/;

	/**
	 * Defines if the animator may only move the camera horizontally
	 */
	public final native Boolean getNoVerticalMovement() /*-{
		return this.NoVerticalMovement;
	}-*/;

	/**
	 * Defines if the animator may only move the camera horizontally
	 */
	public final native void setNoVerticalMovement(Boolean NoVerticalMovement) /*-{
		this.NoVerticalMovement = NoVerticalMovement;
	}-*/;

	/**
	 * Maximal rotation speed the user is able to look.
	 */
	public final native int getRotateSpeed() /*-{
		return this.RotateSpeed;
	}-*/;

	/**
	 * Maximal rotation speed the user is able to look.
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
	 * Returns the type of the animator. For the AnimatorCameraFPS, this will
	 * return 'camerafps'.
	 */
	public final native JavaScriptObject getType() /*-{
		return this.getType();
	}-*/;

	/**
	 * Lets the camera look at the specified point.
	 * 
	 * @param target
	 *            target 3d position of type Vect3d.
	 */
	public final native JavaScriptObject lookAt(Vect3d target) /*-{
		return this.lookAt(target);
	}-*/;

	/**
	 * Sets if the camera look direction is moved by the cursor when the mouse
	 * is down or not
	 * 
	 * @param b
	 */
	public final native JavaScriptObject setLookByMouseDown(boolean b) /*-{
		return this.setLookByMouseDown(b);
	}-*/;

	/**
	 * Sets if the animator may move the camera
	 * 
	 * @param b
	 */
	public final native JavaScriptObject setMayMove(JavaScriptObject b) /*-{
			return this.setMayMove(b);
	}-*/;

}