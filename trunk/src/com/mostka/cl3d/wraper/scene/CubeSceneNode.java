package com.mostka.cl3d.wraper.scene;

public class CubeSceneNode extends MeshSceneNode {

	protected CubeSceneNode() {
	}

	/**
	 * A class rendering a simple cube of default size 10 with one material.
	 * 
	 * @param sizeSize
	 *            of the cube, default this is 10.
	 */

	public static native CubeSceneNode create(int size) /*-{
		return new $wnd.CL3D.CubeSceneNode(size);
	}-*/;

	public static native CubeSceneNode create() /*-{
		return new $wnd.CL3D.CubeSceneNode();
	}-*/;

}