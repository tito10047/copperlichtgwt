package com.mostka.cl3d.wraper.animator;

import com.google.gwt.core.client.JavaScriptObject;

public abstract class AnimatorAbs extends JavaScriptObject/* implements AnimatorInt*/ {
	
	protected AnimatorAbs() {}
	
	/**
	 * Creates an exact, deep copy of this animator
	 * 
	 * @param node
	 * @param scene
	 */
	public final native JavaScriptObject createClone(JavaScriptObject node, JavaScriptObject scene) /*-{
		return this.createClone(node, scene);
	}-*/;


	/**
	 * Event handler called by the engine so the animator can react to mouse and
	 * key input. Returns false if the event has not been processed.
	 * 
	 * @param event
	 */
	public final native JavaScriptObject onKeyDown(JavaScriptObject event) /*-{
		return this.onKeyDown(event);
	}-*/;

	/**
	 * Event handler called by the engine so the animator can react to mouse and
	 * key input Returns false if the event has not been processed.
	 * 
	 * @param event
	 */
	public final native JavaScriptObject onKeyUp(JavaScriptObject event) /*-{
		return this.onKeyUp(event);
	}-*/;

	/**
	 * Event handler called by the engine so the animator can react to mouse and
	 * key input
	 * 
	 * @param event
	 */
	public final native JavaScriptObject onMouseDown(JavaScriptObject event) /*-{
		return this.onMouseDown(event);
	}-*/;

	/**
	 * Event handler called by the engine so the animator can react to mouse and
	 * key input
	 * 
	 * @param event
	 */
	public final native JavaScriptObject onMouseMove(JavaScriptObject event) /*-{
		return this.onMouseMove(event);
	}-*/;

	/**
	 * Event handler called by the engine so the animator can react to mouse and
	 * key input
	 * 
	 * @param event
	 */
	public final native JavaScriptObject onMouseUp(JavaScriptObject event) /*-{
		return this.onMouseUp(event);
	}-*/;

	/**
	 * Event handler called by the engine so the animator can react to mouse and
	 * key input
	 * 
	 * @param delta
	 */
	public final native JavaScriptObject onMouseWheel(JavaScriptObject delta) /*-{
			return this.onMouseWheel(delta);
	}-*/;
}
