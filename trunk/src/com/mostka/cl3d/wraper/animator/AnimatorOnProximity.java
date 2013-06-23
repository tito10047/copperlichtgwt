package com.mostka.cl3d.wraper.animator;

import com.google.gwt.core.client.JavaScriptObject;
import com.mostka.cl3d.wraper.scene.Scene;


public class AnimatorOnProximity extends AnimatorAbs {

	protected AnimatorOnProximity(){}

	/**
	 * Scene node animator which invokes a callback function when the scene node gets near another scene node.
	 * @param scenethe current scene
	 * @param radiusthe proximity radius to use
	 * @param idOfSceneNodeThe unique id (see CL3D.SceneNode.id of the scene node which will trigger this
	 * @param functionToCalla function which should be called when the scene node has been clicked
	 * @param triggerOnLeaveset to false to let this trigger when the radius is entered, to true if when the radius is left
	 */

	public static native AnimatorOnProximity create(Scene scene, int radius, int idOfSceneNode, JavaScriptObject functionToCall, Boolean triggerOnLeave) /*-{
			return new $wnd.CL3D.AnimatorOnProximity(scene, radius, idOfSceneNode, functionToCall, triggerOnLeave);
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
For the AnimatorOnProximity, this will return 'oncollide'.
	 */
	public final native JavaScriptObject getType() /*-{
			return this.getType();
	}-*/;

}