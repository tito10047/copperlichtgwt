package com.mostka.cl3d.wraper.util;

import com.google.gwt.core.client.JavaScriptObject;

public class Vertex3D extends JavaScriptObject {

	protected Vertex3D() {
	}

	/**
	 * A 3d vertex, ususally used in MeshBuffers
	 * 
	 * @param initset
	 *            to true to let the vertex members (Position, Normal etc) be
	 *            initialized with instances of classes, false if not.
	 */

	public static native Vertex3D create(boolean init) /*-{
		return new $wnd.CL3D.Vertex3D(init);
	}-*/;

	/**
	 * Color of the vertex
	 */
	public final native int getColor() /*-{
		return this.Color;
	}-*/;

	/**
	 * Color of the vertex
	 */
	public final native void setColor(int Color) /*-{
		this.Color = Color;
	}-*/;

	/**
	 * Normal of the vertex
	 */
	public final native Vertex3D getNormal() /*-{
		return this.Normal;
	}-*/;

	/**
	 * Normal of the vertex
	 */
	public final native void setNormal(Vertex3D Normal) /*-{
		this.Normal = Normal;
	}-*/;

	/**
	 * 3D Position of the vertex
	 */
	public final native Vect3d getPos() /*-{
		return this.Pos;
	}-*/;
	public final native void setPosX(int x) /*-{
		this.Pos.X=x;
	}-*/;
	public final native void setPosY(int y) /*-{
		this.Pos.Y=y;
	}-*/;
	public final native void setPosZ(int z) /*-{
		this.Pos.Z=z;
	}-*/;


	/**
	 * 3D Position of the vertex
	 */
	public final native void setPos(Vect3d Pos) /*-{
		this.Pos = Pos;
	}-*/;

	/**
	 * Texture coordinate 1 of the vertex
	 */
	public final native Vect2d getTCoords() /*-{
		return this.TCoords;
	}-*/;
	public final native void setTCoordsX(int x) /*-{
		this.TCoords.X=x;
	}-*/;
	public final native void setTCoordsY(int y) /*-{
		this.TCoords.Y=y;
	}-*/;

	/**
	 * Texture coordinate 1 of the vertex
	 */
	public final native void setTCoords(Vect2d TCoords) /*-{
		this.TCoords = TCoords;
	}-*/;

	/**
	 * Texture coordinate 2 of the vertex
	 */
	public final native Vertex3D getTCoords2() /*-{
		return this.TCoords2;
	}-*/;

	/**
	 * Texture coordinate 2 of the vertex
	 */
	public final native void setTCoords2(Vertex3D TCoords2) /*-{
		this.TCoords2 = TCoords2;
	}-*/;

}
