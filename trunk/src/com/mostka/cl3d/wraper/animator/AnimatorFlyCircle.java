package com.mostka.cl3d.wraper.animator;

import com.google.gwt.core.client.JavaScriptObject;
import com.mostka.cl3d.wraper.util.Vect3d;

public class AnimatorFlyCircle extends AnimatorAbs {

	protected AnimatorFlyCircle(){}

	/**
	 * Scene node animator making
	 * @param center3d position of the center of the circle
	 * @param radiusradius of the circle
	 * @param directiondirection of the circle. For example (0,1,0) for up.
	 * @param speedmovement speed, for example 0.01
	 */

	public static native AnimatorFlyCircle create(Vect3d center, Number radius, Vect3d direction, Number speed) /*-{
			return new $wnd.CL3D.AnimatorFlyCircle(center, radius, direction, speed);
	}-*/;

	/**
	 * Animates the scene node it is attached to and returns true if scene node was modified.
	 * @param n The Scene node which needs to be animated this frame.
	 * @param timeMs The time in milliseconds since the start of the scene.
	 */
	public final native JavaScriptObject animateNode(JavaScriptObject n, JavaScriptObject timeMs) /*-{
			return this.animateNode(n, timeMs);
	}-*/;

	/**
	 * Returns the type of the animator.
For the AnimatorFlyCircle, this will return 'flycircle'.
	 */
	public final native JavaScriptObject getType() /*-{
			return this.getType();
	}-*/;

	/**
	 */
	public final native JavaScriptObject init() /*-{
			return this.init();
	}-*/;

}