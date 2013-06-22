package com.mostka.cl3d.wraper.animator;

import com.google.gwt.core.client.JavaScriptObject;
import com.mostka.cl3d.wraper.selector.MetaTriangleSelector;
import com.mostka.cl3d.wraper.util.Vect3d;

public class AnimatorCollisionResponse extends AnimatorAbs {

	protected AnimatorCollisionResponse() {
	}

	/**
	 * Scene node animator making
	 * 
	 * @param radius3d
	 *            vector describing the radius of the scene node as ellipsoid.
	 * @param gravitySets
	 *            the gravity of the environment. A good example value would be
	 *            new $wnd.CL3D.Vect3d(0,-100.0,0) for letting gravity affect all
	 *            object to fall down. For bigger gravity, make increase the
	 *            length of the vector. You can disable gravity by setting it to
	 *            (0,0,0);
	 * @param translationSet
	 *            translation of the collision ellipsoid. By default, the
	 *            ellipsoid for collision detection is created around the center
	 *            of the scene node, which means that the ellipsoid surrounds it
	 *            completely. If this is not what you want, you may specify a
	 *            translation for the ellipsoid.
	 * @param worldRepresenting
	 *            the world, the collision geometry, represented by a
	 *            TriangleSelector.
	 * @param slidingspeed
	 *            (optional) A very small value, set to 0.0005 for example. This
	 *            affects how the ellipsoid is moved when colliding with a wall.
	 *            Affects movement smoothness and friction. If set to a too big
	 *            value, this will also may cause the ellipsoid to be stuck.
	 */

	public static native AnimatorCollisionResponse create(Vect3d radius, Vect3d gravity, Vect3d translation, MetaTriangleSelector world, int slidingspeed) /*-{
		return new $wnd.CL3D.AnimatorCollisionResponse(radius, gravity, translation,  world, slidingspeed);
	}-*/;
	public static native AnimatorCollisionResponse create(Vect3d radius, Vect3d gravity, Vect3d translation, MetaTriangleSelector world) /*-{
		return new $wnd.CL3D.AnimatorCollisionResponse(radius, gravity, translation, world);
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
	 * Returns the vector representing the gravity of the environment
	 */
	public final native JavaScriptObject getGravity() /*-{
		return this.getGravity();
	}-*/;

	/**
	 * Returns the type of the animator. For the AnimatorCollisionResponse, this
	 * will return 'collisionresponse'.
	 */
	public final native JavaScriptObject getType() /*-{
		return this.getType();
	}-*/;

	/**
	 * Returns the triangle selector representing the world collision data
	 */
	public final native JavaScriptObject getWorld() /*-{
		return this.getWorld();
	}-*/;

	/**
	 * Returns if the scene node attached to this animator is currently falling
	 */
	public final native JavaScriptObject isFalling() /*-{
		return this.isFalling();
	}-*/;

	/**
	 * Resets the collision system. Use this for example to make it possible to
	 * set a scene node postition while moving through walls: Simply change the
	 * position of the scene node and call reset() to this animator afterwards.
	 */
	public final native JavaScriptObject reset() /*-{
		return this.reset();
	}-*/;

	/**
	 * Sets the gravity of the environment. A good example value would be new
	 * CL3D.Vect3d(0,-100.0,0) for letting gravity affect all object to fall
	 * down. For bigger gravity, make increase the length of the vector. param g
	 * {Vect3d} gravity vector
	 * 
	 * @param g
	 */
	public final native JavaScriptObject setGravity(JavaScriptObject g) /*-{
			return this.setGravity(g);
	}-*/;

	/**
	 * Sets the triangle selector representing the world collision data
	 * 
	 * @param selector
	 */
	public final native JavaScriptObject setWorld(JavaScriptObject selector) /*-{
			return this.setWorld(selector);
	}-*/;

}