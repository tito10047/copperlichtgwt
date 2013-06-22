package com.mostka.cl3d.wraper.animator;

import com.google.gwt.core.client.JavaScriptObject;
import com.mostka.cl3d.wraper.util.Vect3d;


public class AnimatorRotation extends AnimatorAbs {

	protected AnimatorRotation(){}

	/**
	 * Scene node animator making
	 * @param speedvector defining the RotationSpeed in each direction
	 */

	public static native AnimatorRotation create(Vect3d speed) /*-{
			return new $wnd.CL3D.AnimatorRotation(speed);
	}-*/;

	/**
	 * Animates the scene node it is attached to and returns true if scene node was modified.
	 * @param n The Scene node which needs to be animated this frame.
	 * @param timeMs: The time in milliseconds since the start of the scene.
	 */
	public final native JavaScriptObject animateNode(JavaScriptObject n, JavaScriptObject timeMs) /*-{
			return this.animateNode(n, timeMs);
	}-*/;

	/**
	 * Returns the type of the animator.For the AnimatorRotation, this will return 'rotation'.
	 */
	public final native JavaScriptObject getType() /*-{
			return this.getType();
	}-*/;

}