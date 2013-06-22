package com.mostka.cl3d.wraper.animator;

import com.google.gwt.core.client.JavaScriptObject;

public interface AnimatorInt {
	
	/**
	 * Animates the scene node it is attached to and returns true if scene node
	 * was modified.
	 * 
	 * @param n
	 *            The Scene node which needs to be animated this frame.
	 * @param timeMs
	 *            The time in milliseconds since the start of the scene.
	 */
	public JavaScriptObject animateNode(JavaScriptObject n, JavaScriptObject timeMs);

	/**
	 * Returns the type of the animator. Usual values are 'none', 'camerafps',
	 * etc. See the concreate animator implementations for type strings.
	 */
	public JavaScriptObject getType();

}
