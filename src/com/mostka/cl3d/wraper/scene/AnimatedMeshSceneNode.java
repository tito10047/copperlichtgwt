package com.mostka.cl3d.wraper.scene;

import com.google.gwt.core.client.JavaScriptObject;

public class AnimatedMeshSceneNode extends SceneNodeAbs {

	protected AnimatedMeshSceneNode() {
	}

	/**
	 * A scene node displaying an animated Mesh, usually a skeletal animated
	 * character.
	 */

	public static native AnimatedMeshSceneNode create() /*-{
		return new $wnd.CL3D.AnimatedMeshSceneNode();
	}-*/;

	/**
	 * @param newparent
	 */
	public final native JavaScriptObject createClone(JavaScriptObject newparent) /*-{
		return this.createClone(newparent);
	}-*/;

	/**
	 * Get the axis aligned, not transformed bounding box of this node. This
	 * means that if this node is an animated 3d character, moving in a room,
	 * the bounding box will always be around the origin. To get the box in real
	 * world coordinates, just transform it with the matrix you receive with
	 * getAbsoluteTransformation() or simply use getTransformedBoundingBox(),
	 * which does the same.
	 */
	public final native JavaScriptObject getBoundingBox() /*-{
		return this.getBoundingBox();
	}-*/;

	/**
	 * Returns the currently displayed frame int.
	 */
	public final native JavaScriptObject getFrameNr() /*-{
		return this.getFrameNr();
	}-*/;

	/**
	 * Returns the amount of named animations in the animated mesh.
	 */
	public final native JavaScriptObject getNamedAnimationCount() /*-{
		return this.getNamedAnimationCount();
	}-*/;

	/**
	 * Returns information about a named animation in the animated mesh by index
	 * 
	 * @param idx
	 *            index of the animation. Must be a value >=0 and
	 */
	public final native JavaScriptObject getNamedAnimationInfo(Integer idx) /*-{
		return this.getNamedAnimationInfo(idx);
	}-*/;

	/**
	 * Returns the type string of the scene node. Returns 'animatedmesh' for the
	 * mesh scene node.
	 */
	public final native JavaScriptObject getType() /*-{
		return this.getType();
	}-*/;

	/**
	 * Sets the animation to a new one by name.
	 * 
	 * @param name
	 */
	public final native boolean setAnimation(String name) /*-{
		return this.setAnimation(name);
	}-*/;

	/**
	 * Sets the speed of the animation
	 * 
	 * @param speed
	 *            a floating point value specifying the frames per second to
	 *            display
	 */
	public final native JavaScriptObject setAnimationSpeed(Float speed) /*-{
		return this.setAnimationSpeed(speed);
	}-*/;

	/**
	 * Sets the current frame to display
	 * 
	 * @param frame
	 *            current frame to display
	 */
	public final native JavaScriptObject setCurrentFrame(Float frame) /*-{
		return this.setCurrentFrame(frame);
	}-*/;

	/**
	 * Sets the begin and end frame for a looped animation
	 * 
	 * @param begin
	 *            start frame of the loop
	 * @param end
	 *            end frame of the loop
	 */
	public final native JavaScriptObject setFrameLoop(Integer begin, Integer end) /*-{
		return this.setFrameLoop(begin, end);
	}-*/;

	/**
	 * Sets if the animation should be playbed back looped
	 * 
	 * @param loop
	 *            true to loop, false if not
	 */
	public final native JavaScriptObject setLoopMode(Boolean loop) /*-{
		return this.setLoopMode(loop);
	}-*/;

	/**
	 * Sets the minimal update delay. The animated mesh is only updated every
	 * few milliseconds, in order to increase performance. The default value is
	 * 60 milli seconds (= 16 frames per second). Set it to 0 to enable instant
	 * updates.
	 * 
	 * @param frame
	 *            current frame to display
	 */
	public final native JavaScriptObject setMinimalUpdateDelay(Float frame) /*-{
			return this.setMinimalUpdateDelay(frame);
	}-*/;

}