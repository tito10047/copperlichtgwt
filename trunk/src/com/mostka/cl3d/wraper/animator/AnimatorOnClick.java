package com.mostka.cl3d.wraper.animator;

import com.google.gwt.core.client.JavaScriptObject;
import com.mostka.cl3d.wraper.CopperLicht;
import com.mostka.cl3d.wraper.scene.Scene;


public class AnimatorOnClick extends AnimatorAbs {

	protected AnimatorOnClick(){}

	/**
	 * Scene node animator which invokes a callback function when the scene node has been clicked.
	 * @param sceneThe scene of the animator.
	 * @param enginean instance of the 3d engine
	 * @param functionToCalla function which should be called when the scene node has been clicked
	 * @param register(optional) set to true to prevent registering at the scene using registerSceneNodeAnimatorForEvents
	 */

	public static native AnimatorOnClick create(Scene scene, CopperLicht engine, JavaScriptObject functionToCall, boolean register) /*-{
			return new $wnd.CL3D.AnimatorOnClick(scene, engine, functionToCall, register);
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
	 * Returns the type of the animator.For the AnimatorOnClick, this will return 'onclick'.
	 */
	public final native JavaScriptObject getType() /*-{
			return this.getType();
	}-*/;

}