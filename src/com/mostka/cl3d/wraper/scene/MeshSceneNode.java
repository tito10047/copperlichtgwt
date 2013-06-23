package com.mostka.cl3d.wraper.scene;

import com.google.gwt.core.client.JavaScriptObject;

public class MeshSceneNode extends MeshSceneNodeAbs {

	protected MeshSceneNode() {
	}

	/**
	 * A scene node displaying a static Mesh.
	 */

	public static native MeshSceneNode create() /*-{
		return new $wnd.CL3D.MeshSceneNode();
	}-*/;


	/**
	 * Returns the type string of the scene node. Returns 'mesh' for the mesh
	 * scene node.
	 */
	public final native JavaScriptObject getType() /*-{
		return this.getType();
	}-*/;



}