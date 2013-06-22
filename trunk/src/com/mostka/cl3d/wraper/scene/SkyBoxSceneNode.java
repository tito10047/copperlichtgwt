package com.mostka.cl3d.wraper.scene;

import com.google.gwt.core.client.JavaScriptObject;

public class SkyBoxSceneNode extends MeshSceneNodeAbs {

	protected SkyBoxSceneNode() {
	}

	/**
	 * A class rendering a sky box around the whole scene.
	 */

	public static native SkyBoxSceneNode create() /*-{
		return new $wnd.CL3D.SkyBoxSceneNode();
	}-*/;

	/**
	 * Returns the type string of the scene node. Returns 'sky' for the mesh
	 * scene node.
	 */
	public final native JavaScriptObject getType() /*-{
		return this.getType();
	}-*/;

}