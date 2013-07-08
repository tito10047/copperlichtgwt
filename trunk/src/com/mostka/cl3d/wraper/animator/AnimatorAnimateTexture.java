package com.mostka.cl3d.wraper.animator;


import com.google.gwt.core.client.JavaScriptObject;
import com.mostka.cl3d.wraper.Texture;

public class AnimatorAnimateTexture extends AnimatorAbs {

	protected AnimatorAnimateTexture() {
	}

	/**
	 * Scene node animator changing the texture of SceneNodes so that they
	 * appear animated.
	 * 
	 * @param texturesarray
	 *            of Textures to set
	 * @param timeperframetime
	 *            to switch to the next texture in the texture array, in
	 *            milliseconds. For example 500 for half a second per frame.
	 * @param donotloopif
	 *            set to true, the animation will only be played once
	 */

	public static native AnimatorAnimateTexture create(Texture[] textures, int timeperframe, boolean donotloop) /*-{
		return new $wnd.CL3D.AnimatorAnimateTexture(textures, timeperframe,
				donotloop);
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
	 * Returns the type of the animator. For the AnimatorAnimateTexture, this
	 * will return 'animatetexture'.
	 */
	public final native JavaScriptObject getType() /*-{
			return this.getType();
	}-*/;

}