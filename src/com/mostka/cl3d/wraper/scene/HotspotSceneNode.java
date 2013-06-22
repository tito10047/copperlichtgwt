package com.mostka.cl3d.wraper.scene;

public class HotspotSceneNode extends SceneNode {

	protected HotspotSceneNode() {
	}

	public static native HotspotSceneNode create() /*-{
		return new $wnd.CL3D.HotspotSceneNode();
	}-*/;

}