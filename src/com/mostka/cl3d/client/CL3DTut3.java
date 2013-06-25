package com.mostka.cl3d.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.mostka.cl3d.wraper.CL3D;
import com.mostka.cl3d.wraper.CopperLicht;
import com.mostka.cl3d.wraper.animator.AnimatorCameraFPS;
import com.mostka.cl3d.wraper.animator.AnimatorRotation;
import com.mostka.cl3d.wraper.scene.BillboardSceneNode;
import com.mostka.cl3d.wraper.scene.CameraSceneNode;
import com.mostka.cl3d.wraper.scene.Scene;
import com.mostka.cl3d.wraper.util.Material;
import com.mostka.cl3d.wraper.util.Vect3d;



/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CL3DTut3 implements EntryPoint {
	
	private static CopperLicht engine;
	private Scene scene;
	private MySceneNode mynode;
	
	public static native void debugObject(String name, Object obj) /*-{
		if (!$wnd.debugGWT){
			$wnd.debugGWT = {};
		}
		$wnd.debugGWT[name]=obj
	}-*/;
	public static native void log(Object obj) /*-{
		$wnd.temp = obj;
		console.log(obj)
	}-*/;
	public static native void log(int obj) /*-{
	$wnd.temp = obj;
	console.log(obj)
}-*/;
	
	public void onModuleLoad() {
		engine = CopperLicht.create("3darea");
		
		if (!engine.initRenderer()){
			Window.alert("this browser doesn't support WebGL");
			return;
		}
		
		scene = Scene.create();
		engine.addScene(scene);
		
		scene.setBackgroundColor(CL3D.createColor(1, 0, 0, 64));
		
		mynode = new MySceneNode(engine);
		
		debugObject("engine", engine);
		debugObject("scene", scene);
		debugObject("mynodeScene", mynode.getSceneNode());
		debugObject("mynode", mynode);
		debugObject("mesh", mynode.myMesh);
		
		scene.getRootSceneNode().addChild(mynode.getSceneNode());
		mynode.getSceneNode().addAnimator(AnimatorRotation.create(Vect3d.create(0, 0.6, 0.8)));
		
		BillboardSceneNode billboard = BillboardSceneNode.create();
		billboard.setSize(20,20);
		billboard.getPos().setY(30);
		billboard.getMaterial(0).setTex1(engine.getTextureManager().getTexture("images/actionsign.jpg", true));
		billboard.getMaterial(0).setType(Material.EMT_TRANSPARENT_ADD_COLOR);
		scene.getRootSceneNode().addChild(billboard);
		
		CameraSceneNode cam = CameraSceneNode.create();
		cam.setPos(50, 20);
		
		AnimatorCameraFPS animator = AnimatorCameraFPS.create(cam, engine);
		cam.addAnimator(animator);
		animator.lookAt(Vect3d.create(0,20,0));
		
		scene.getRootSceneNode().addChild(cam);
		scene.setActiveCamera(cam);		
	}
}
