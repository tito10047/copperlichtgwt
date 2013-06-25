package com.mostka.cl3d.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.mostka.cl3d.wraper.CL3D;
import com.mostka.cl3d.wraper.CopperLicht;
import com.mostka.cl3d.wraper.JsFunction;
import com.mostka.cl3d.wraper.animator.AnimatorCameraFPS;
import com.mostka.cl3d.wraper.scene.BillboardSceneNode;
import com.mostka.cl3d.wraper.scene.CameraSceneNode;
import com.mostka.cl3d.wraper.scene.Scene;
import com.mostka.cl3d.wraper.util.Material;
import com.mostka.cl3d.wraper.util.Vect2d;
import com.mostka.cl3d.wraper.util.Vect3d;

public class CL3DTut4 implements EntryPoint {
	
	private static CopperLicht engine;
	private Scene scene;
	public void onModuleLoad() {
		// create the 3d engine
		engine = CopperLicht.create("3darea");
		
		if (!engine.initRenderer()){
			Window.alert("this browser doesn't support WebGL");
			return;
		}
		
		scene = Scene.create();
		engine.addScene(scene);
		
		scene.setBackgroundColor(CL3D.createColor(1, 0, 0, 64));
		//scene.setRedrawMode(Scene.REDRAW_WHEN_SCENE_CHANGED);
		
		// add a transparent billboard scene node with a text sign
		for (int i=0; i<50; ++i){
			
			BillboardSceneNode billboard = BillboardSceneNode.create();
			billboard.setSize(30, 30);
			billboard.setPos(
					Math.random() * 80 - 40, 
					Math.random() * 80 - 40, 
					Math.random() * 80 - 40);
			billboard.getMaterial(0).setTex1( engine.getTextureManager().getTexture("images/particle.png", true));
			billboard.getMaterial(0).setType( Material.EMT_TRANSPARENT_ADD_COLOR );
			scene.getRootSceneNode().addChild(billboard);
			
		}
		
		CameraSceneNode cam = CameraSceneNode.create();
		cam.setPos(50, 20);
		
		AnimatorCameraFPS animator = AnimatorCameraFPS.create(cam, engine);
		cam.addAnimator(animator);
		animator.lookAt(Vect3d.create(0, 20, 0));
		
		scene.getRootSceneNode().addChild(cam);
		scene.setActiveCamera(cam);
		
		// draw handler
		final Vect3d pos3d = Vect3d.create(0, 0, 0);
		
		engine.setOnAnimate(new JsFunction() {
			public JavaScriptObject execute(JavaScriptObject args) {

				Element element = DOM.getElementById("originlabel");
				if (element!=null){
					
					// set the position of the label to the 2d position of the 3d point
					
					Vect2d pos2d = engine.get2DPositionFrom3DPosition(pos3d);
					boolean hide = false;
					
					if (pos2d!=null){

						element.getStyle().setPropertyPx("left", (int) pos2d.getX());
						element.getStyle().setPropertyPx("top", (int) pos2d.getY());
						
						// hide if outside of the border
						hide = pos2d.getX() < 0 || pos2d.getY() < 0 ||
								pos2d.getX() > engine.getRenderer().getWidth() - 60 ||
								pos2d.getY() > engine.getRenderer().getHeight() - 20;
						
					}else{
						hide=true;
					}
					
					element.getStyle().setDisplay( (hide ? Display.NONE : Display.BLOCK) );
					
				}
				return null;
			}
		});
		
	}

}
