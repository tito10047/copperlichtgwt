package com.mostka.cl3d.wraper.util;

import com.google.gwt.core.client.JavaScriptObject;

public class Mesh extends JavaScriptObject {

	protected Mesh() {
	}

	/**
	 * Class which holds the geometry of an object
	 */

	public static native Mesh create() /*-{
		return new $wnd.CL3D.Mesh();
	}-*/;

	/**
	 * Adds a MeshBuffer to a mesh.
	 * 
	 * @param m
	 */
	public final native JavaScriptObject AddMeshBuffer(MeshBuffer m) /*-{
		return this.AddMeshBuffer(m);
	}-*/;

	/**
	 * Creates a clone of this mesh, a copy
	 */
	public final native JavaScriptObject createClone() /*-{
		return this.createClone();
	}-*/;

	/**
	 * Returns an Array of all MeshBuffers in this mesh.
	 */
	public final native JavaScriptObject GetMeshBuffers() /*-{
		return this.GetMeshBuffers();
	}-*/;

	/**
	 * Returns the amount of polygons in the mesh
	 */
	public final native JavaScriptObject GetPolyCount() /*-{
		return this.GetPolyCount();
	}-*/;

}