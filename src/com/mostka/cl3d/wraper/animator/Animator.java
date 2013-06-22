package com.mostka.cl3d.wraper.animator;

import com.google.gwt.core.client.JavaScriptObject;

public class Animator extends AnimatorAbs {

	protected Animator() {
	}

	/**
	 * An animator can be attached to a scene node and animates it.
	 */

	public static native Animator create() /*-{
		return new $wnd.CL3D.Animator();
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
	 * Returns the type of the animator. Usual values are 'none', 'camerafps',
	 * etc. See the concreate animator implementations for type strings.
	 */
	public final native JavaScriptObject getType() /*-{
		return this.getType();
	}-*/;

}