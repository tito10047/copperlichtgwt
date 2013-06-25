package com.mostka.cl3d.wraper.scene;

import com.google.gwt.core.client.JavaScriptObject;
import com.mostka.cl3d.wraper.util.Mesh;

public abstract class MeshSceneNodeAbs extends SceneNodeAbs {
	
	protected MeshSceneNodeAbs() {
		// TODO Auto-generated constructor stub
	}
	
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
	 * Returns the Mesh drawn by this scene node.
	 */
	public final native Mesh getMesh() /*-{
		return this.getMesh();
	}-*/;
	
	/**
	 * Sets the Mesh which should be drawn by this scene node.
	 * 
	 * @param m
	 *            the mesh to draw from now on
	 */
	public final native JavaScriptObject setMesh(Mesh m) /*-{
			return this.setMesh(m);
	}-*/;
}
