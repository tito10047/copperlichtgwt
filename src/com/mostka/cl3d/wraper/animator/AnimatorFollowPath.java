package com.mostka.cl3d.wraper.animator;

import com.google.gwt.core.client.JavaScriptObject;
import com.mostka.cl3d.wraper.scene.PathSceneNode;
import com.mostka.cl3d.wraper.scene.Scene;


public class AnimatorFollowPath extends AnimatorAbs {


	/**
	 * Constant for AnimatorFollowPath.EndMode, specifying to start the movement again when the end of the path has been reached.
	 */
	public static int EFPFEM_START_AGAIN = 0;
	/**
	 * Constant for AnimatorFollowPath.EndMode, specifying to start the movement again when the end of the path has been reached.
	 */
	public static int EFPFEM_STOP = 1;
	public static int EFPFEM_SWITCH_TO_CAMERA = 2;
	
	protected AnimatorFollowPath(){}

	/**
	 * Scene node animator making
	 * @param sceneThe scene the animator is in
	 */

	public static native AnimatorFollowPath create(Scene scene) /*-{
		return new $wnd.CL3D.AnimatorFollowPath(scene);
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
For the AnimatorFollowPath, this will return 'followpath'.
	 */
	public final native JavaScriptObject getType() /*-{
		return this.getType();
	}-*/;

	/**
	 * Sets the options for animating the node along the path
	 * @param endmode Mode specifying what should happen when the end of the path has been reached.
Can be
	 * @param timeNeeded Time in milliseconds needed for following the whole path, for example 10000 for 10 seconds.
	 * @param lookIntoMovementDirection true if the node should look into the movement direction or false 
if not.
	 */
	public final native JavaScriptObject setOptions(int endmode, int timeNeeded, boolean lookIntoMovementDirection) /*-{
		return this.setOptions(endmode, timeNeeded, lookIntoMovementDirection);
	}-*/;

	/**
	 * Define the path this animator should follow
	 * @param path scene node representing the path
	 */
	public final native JavaScriptObject setPathToFollow(PathSceneNode path) /*-{
		return this.setPathToFollow(path);
	}-*/;

}