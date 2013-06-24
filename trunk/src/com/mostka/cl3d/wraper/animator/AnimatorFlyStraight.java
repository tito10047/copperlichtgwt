package com.mostka.cl3d.wraper.animator;

import com.google.gwt.core.client.JavaScriptObject;
import com.mostka.cl3d.wraper.util.Vect3d;


public class AnimatorFlyStraight extends AnimatorAbs {

	protected AnimatorFlyStraight(){}

	/**
	 * Scene node animator making
	 * @param startStart 3d position of the line
	 * @param endEnd 3d position of the line
	 * @param timeForWayTime for moving along the whole line in milliseconds. For example 2000 for 2 seconds.
	 * @param loopset to true for looping along the line, false for stopping movement when the end has been reached.
	 * @param deleteMeAfterEndReachedset to true if the animator should delete itself after the end has been reached.
	 * @param animateCameraTargetInsteadOfPositionif the animated node is a camera, set to true to animate the camera target instead of the position of the camera.
	 */

	public static native AnimatorFlyStraight create(Vect3d start, Vect3d end, int timeForWay, boolean loop, boolean deleteMeAfterEndReached, boolean animateCameraTargetInsteadOfPosition) /*-{
			return new $wnd.CL3D.AnimatorFlyStraight(start, end, timeForWay, loop, deleteMeAfterEndReached, animateCameraTargetInsteadOfPosition);
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
For the AnimatorFlyStraight, this will return 'flystraight'.
	 */
	public final native JavaScriptObject getType() /*-{
			return this.getType();
	}-*/;

}