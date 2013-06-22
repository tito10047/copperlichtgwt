package com.mostka.cl3d.wraper.scene;

import com.google.gwt.core.client.JavaScriptObject;
import com.mostka.cl3d.wraper.util.Vect3d;

public class ParticleSystemSceneNode extends SceneNodeAbs {

	protected ParticleSystemSceneNode() {
	}

	/**
	 * A particle system is a simple way to simulate things like fire, smoke,
	 * rain, etc in your 3d scene.
	 */

	public static native ParticleSystemSceneNode create() /*-{
		return new $wnd.CL3D.ParticleSystemSceneNode();
	}-*/;

	/**
	 * Default direction the particles will be emitted to.
	 */
	public final native Vect3d getDirection() /*-{
		return this.Direction;
	}-*/;

	/**
	 * Default direction the particles will be emitted to.
	 */
	public final native void setDirection(Vect3d Direction) /*-{
		this.Direction = Direction;
	}-*/;

	/**
	 * Area the particles are emitted in. By default, this area has a size of 0,
	 * causing this to be a point emitter.
	 */
	public final native Vect3d getEmittArea() /*-{
		return this.EmittArea;
	}-*/;

	/**
	 * Area the particles are emitted in. By default, this area has a size of 0,
	 * causing this to be a point emitter.
	 */
	public final native void setEmittArea(Vect3d EmittArea) /*-{
		this.EmittArea = EmittArea;
	}-*/;

	/**
	 * Setting if the fade out affector is active, i.e. if particles should be
	 * faded out at the end of their lifetime
	 */
	public final native Boolean getFadeOutAffector() /*-{
		return this.FadeOutAffector;
	}-*/;

	/**
	 * Setting if the fade out affector is active, i.e. if particles should be
	 * faded out at the end of their lifetime
	 */
	public final native void setFadeOutAffector(Boolean FadeOutAffector) /*-{
		this.FadeOutAffector = FadeOutAffector;
	}-*/;

	/**
	 * If FadeOutAffector is true, this defines the target color of the fade out
	 * effect.
	 */
	public final native Number getFadeOutTime() /*-{
		return this.FadeOutTime;
	}-*/;

	/**
	 * If FadeOutAffector is true, this defines the target color of the fade out
	 * effect.
	 */
	public final native void setFadeOutTime(Number FadeOutTime) /*-{
		this.FadeOutTime = FadeOutTime;
	}-*/;

	/**
	 * If GravityAffector is true, this will define the gravity vector. A useful
	 * value would be (0,-0.03,0), for example.
	 */
	public final native Vect3d getGravity() /*-{
		return this.Gravity;
	}-*/;

	/**
	 * If GravityAffector is true, this will define the gravity vector. A useful
	 * value would be (0,-0.03,0), for example.
	 */
	public final native void setGravity(Vect3d Gravity) /*-{
		this.Gravity = Gravity;
	}-*/;

	/**
	 * If GravityAffector is true, this defines the time in milli seconds after
	 * the gravity will have affect
	 */
	public final native Number getGravityAffectingTime() /*-{
		return this.GravityAffectingTime;
	}-*/;

	/**
	 * If GravityAffector is true, this defines the time in milli seconds after
	 * the gravity will have affect
	 */
	public final native void setGravityAffectingTime(Number GravityAffectingTime) /*-{
		this.GravityAffectingTime = GravityAffectingTime;
	}-*/;

	/**
	 * Setting if the gravity affector is active, i.e. if should be affected by
	 * gravity during their lifetime.
	 */
	public final native Boolean getGravityAffector() /*-{
		return this.GravityAffector;
	}-*/;

	/**
	 * Setting if the gravity affector is active, i.e. if should be affected by
	 * gravity during their lifetime.
	 */
	public final native void setGravityAffector(Boolean GravityAffector) /*-{
		this.GravityAffector = GravityAffector;
	}-*/;

	/**
	 * Maximal amount of degrees the emitting direction is ignored
	 */
	public final native Number getMaxAngleDegrees() /*-{
		return this.MaxAngleDegrees;
	}-*/;

	/**
	 * Maximal amount of degrees the emitting direction is ignored
	 */
	public final native void setMaxAngleDegrees(Number MaxAngleDegrees) /*-{
		this.MaxAngleDegrees = MaxAngleDegrees;
	}-*/;

	/**
	 * Maximal life time of a particle in milli seconds
	 */
	public final native Number getMaxLifeTime() /*-{
		return this.MaxLifeTime;
	}-*/;

	/**
	 * Maximal life time of a particle in milli seconds
	 */
	public final native void setMaxLifeTime(Number MaxLifeTime) /*-{
		this.MaxLifeTime = MaxLifeTime;
	}-*/;

	/**
	 * Maximal amounts of particles in the system
	 */
	public final native Number getMaxParticles() /*-{
		return this.MaxParticles;
	}-*/;

	/**
	 * Maximal amounts of particles in the system
	 */
	public final native void setMaxParticles(Number MaxParticles) /*-{
		this.MaxParticles = MaxParticles;
	}-*/;

	/**
	 * Maximal amounts of particles emitted per second
	 */
	public final native Number getMaxParticlesPerSecond() /*-{
		return this.MaxParticlesPerSecond;
	}-*/;

	/**
	 * Maximal amounts of particles emitted per second
	 */
	public final native void setMaxParticlesPerSecond(Number MaxParticlesPerSecond) /*-{
		this.MaxParticlesPerSecond = MaxParticlesPerSecond;
	}-*/;

	/**
	 * Maximal color of a particle when starting. Set to 0xffffffff to make it
	 * white.
	 */
	public final native Number getMaxStartColor() /*-{
		return this.MaxStartColor;
	}-*/;

	/**
	 * Maximal color of a particle when starting. Set to 0xffffffff to make it
	 * white.
	 */
	public final native void setMaxStartColor(Number MaxStartColor) /*-{
		this.MaxStartColor = MaxStartColor;
	}-*/;

	/**
	 * Maximal width of a particle when starting
	 */
	public final native Number getMaxStartSizeX() /*-{
		return this.MaxStartSizeX;
	}-*/;

	/**
	 * Maximal width of a particle when starting
	 */
	public final native void setMaxStartSizeX(Number MaxStartSizeX) /*-{
		this.MaxStartSizeX = MaxStartSizeX;
	}-*/;

	/**
	 * Maximal height of a particle when starting
	 */
	public final native Number getMaxStartSizeY() /*-{
		return this.MaxStartSizeY;
	}-*/;

	/**
	 * Maximal height of a particle when starting
	 */
	public final native void setMaxStartSizeY(Number MaxStartSizeY) /*-{
		this.MaxStartSizeY = MaxStartSizeY;
	}-*/;

	/**
	 * Minimal life time of a particle in milli seconds
	 */
	public final native Number getMinLifeTime() /*-{
		return this.MinLifeTime;
	}-*/;

	/**
	 * Minimal life time of a particle in milli seconds
	 */
	public final native void setMinLifeTime(Number MinLifeTime) /*-{
		this.MinLifeTime = MinLifeTime;
	}-*/;

	/**
	 * Minimal amounts of particles emitted per second
	 */
	public final native Number getMinParticlesPerSecond() /*-{
		return this.MinParticlesPerSecond;
	}-*/;

	/**
	 * Minimal amounts of particles emitted per second
	 */
	public final native void setMinParticlesPerSecond(Number MinParticlesPerSecond) /*-{
		this.MinParticlesPerSecond = MinParticlesPerSecond;
	}-*/;

	/**
	 * Minimal color of a particle when starting. Set to 0xffffffff to make it
	 * white.
	 */
	public final native Number getMinStartColor() /*-{
		return this.MinStartColor;
	}-*/;

	/**
	 * Minimal color of a particle when starting. Set to 0xffffffff to make it
	 * white.
	 */
	public final native void setMinStartColor(Number MinStartColor) /*-{
		this.MinStartColor = MinStartColor;
	}-*/;

	/**
	 * Minimal width of a particle when starting
	 */
	public final native Number getMinStartSizeX() /*-{
		return this.MinStartSizeX;
	}-*/;

	/**
	 * Minimal width of a particle when starting
	 */
	public final native void setMinStartSizeX(Number MinStartSizeX) /*-{
		this.MinStartSizeX = MinStartSizeX;
	}-*/;

	/**
	 * Minimal height of a particle when starting
	 */
	public final native Number getMinStartSizeY() /*-{
		return this.MinStartSizeY;
	}-*/;

	/**
	 * Minimal height of a particle when starting
	 */
	public final native void setMinStartSizeY(Number MinStartSizeY) /*-{
		this.MinStartSizeY = MinStartSizeY;
	}-*/;

	/**
	 * Setting if the scale affector is active, i.e. if should be scaled their
	 * lifetime.
	 */
	public final native Boolean getScaleAffector() /*-{
		return this.ScaleAffector;
	}-*/;

	/**
	 * Setting if the scale affector is active, i.e. if should be scaled their
	 * lifetime.
	 */
	public final native void setScaleAffector(Boolean ScaleAffector) /*-{
		this.ScaleAffector = ScaleAffector;
	}-*/;

	/**
	 * If ScaleAffector is true, this defines the target scale X value.
	 */
	public final native Number getScaleToX() /*-{
		return this.ScaleToX;
	}-*/;

	/**
	 * If ScaleAffector is true, this defines the target scale X value.
	 */
	public final native void setScaleToX(Number ScaleToX) /*-{
		this.ScaleToX = ScaleToX;
	}-*/;

	/**
	 * If ScaleAffector is true, this defines the target scale Y value.
	 */
	public final native Number getScaleToY() /*-{
		return this.ScaleToY;
	}-*/;

	/**
	 * If ScaleAffector is true, this defines the target scale Y value.
	 */
	public final native void setScaleToY(Number ScaleToY) /*-{
		this.ScaleToY = ScaleToY;
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
	 * Returns the type string of the scene node. Returns 'billboard' for the
	 * mesh scene node.
	 */
	public final native JavaScriptObject getType() /*-{
		return this.getType();
	}-*/;

}