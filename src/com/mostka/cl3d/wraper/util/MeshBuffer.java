package com.mostka.cl3d.wraper.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;

public class MeshBuffer extends JavaScriptObject {

	protected MeshBuffer() {
	}

	/**
	 * A buffer containing a set of geometry with one material.
	 */

	public static native MeshBuffer create() /*-{
		return new $wnd.CL3D.MeshBuffer();
	}-*/;

	/**
	 * Axis aligned bounding box enclosing the geometry in this mesh buffer
	 */
	public final native JavaScriptObject getBox() /*-{
		return this.Box;
	}-*/;

	/**
	 * Axis aligned bounding box enclosing the geometry in this mesh buffer
	 */
	public final native void setBox(JavaScriptObject Box) /*-{
		this.Box = Box;
	}-*/;

	/**
	 * Array of Indices into the Vertices array. Each 3 indices in this array
	 * form a triangle to be rendered.
	 */
	public final native int[] getIndices() /*-{
		return this.Indices;
	}-*/;

	/**
	 * Array of Indices into the Vertices array. Each 3 indices in this array
	 * form a triangle to be rendered.
	 */
	public final native void setIndices(JsArrayNumber Indices) /*-{
		this.Indices = Indices;
	}-*/;

	/**
	 * Material of the geometry, of type Material.
	 */
	public final native Material getMat() /*-{
		return this.Mat;
	}-*/;

	/**
	 * Material of the geometry, of type Material.
	 */
	public final native void setMat(Material Mat) /*-{
		this.Mat = Mat;
	}-*/;

	/**
	 * Object for the renderer to store renderer created arrays for rendering
	 * the geometry.
	 */
	public final native JavaScriptObject getRendererNativeArray() /*-{
		return this.RendererNativeArray;
	}-*/;

	/**
	 * Object for the renderer to store renderer created arrays for rendering
	 * the geometry.
	 */
	public final native void setRendererNativeArray(JavaScriptObject RendererNativeArray) /*-{
		this.RendererNativeArray = RendererNativeArray;
	}-*/;

	/**
	 * Array of Vertices of this mesh buffer. The members of this array must all
	 * be of type Vertex3D.
	 */
	public final native JsArray<Vertex3D> getVertices() /*-{
		return this.Vertices;
	}-*/;
	public final native int getVerticesLength() /*-{
		return this.Vertices.length;
	}-*/;

	/**
	 * Array of Vertices of this mesh buffer. The members of this array must all
	 * be of type Vertex3D.
	 */
	public final native void setVertices(JsArray<Vertex3D> Vertices) /*-{
		this.Vertices = Vertices;
	}-*/;

	/**
	 * Clones this Mesh buffer, creating a copy of it
	 */
	public final native JavaScriptObject createClone() /*-{
		return this.createClone();
	}-*/;

	/**
	 * Recalculates the bounding box
	 */
	public final native JavaScriptObject recalculateBoundingBox() /*-{
		return this.recalculateBoundingBox();
	}-*/;

	/**
	 * Needs to be called when the Vertices or Indices have been changed so that
	 * the RendererNativeArray gets recreated.
	 * 
	 * @param onlyPositionsChanged
	 *            set to true if only the positions changed in the mesh buffer.
	 *            This will trigger a faster update then
	 * @param onlyUpdateBufferIfPossible
	 */
	public final native JavaScriptObject update(boolean onlyPositionsChanged, JavaScriptObject onlyUpdateBufferIfPossible) /*-{
		return this.update(onlyPositionsChanged, onlyUpdateBufferIfPossible);
	}-*/;

}